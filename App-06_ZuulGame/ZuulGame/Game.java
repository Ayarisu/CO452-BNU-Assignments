/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Luis Silva
 */

 public class Game 
 {
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private Items labKey, crowbar, glassShard, escapeKey, note, photo, ring, bag;
    private Room escape, pub, hallway1, hallway2, hall, theatre, backstage, lab, storage, toilet, office, outside;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        createPlayer();
        createItems();
        createRooms();
        play();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
            if(player.getEnergy() <= 0)
            {
                System.out.println("You have ran out of energy...");
                player.setScore(-player.getScore());
                finished = true;
            }
        }
        System.out.println("Your final score was: " + player.getScore() + ", thank you for playing.  Goodbye.");
    }
   
    /**
     * method to initialise the player
     */
    private void createPlayer()
    {
        player = new Player(30, 5);
    }
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // create the rooms
        outside = new Room("the outdoor area");
        hall = new Room("the hall to theatre");
        theatre = new Room("the main theatre");
        pub = new Room("the pub");
        hallway1 = new Room("the hallway to lab");
        lab = new Room("the science lab");
        hallway2 = new Room("the hallway to office");
        office = new Room("the admin office");
        toilet = new Room("the pub's restroom");
        storage = new Room("the lab's storage");
        backstage = new Room("the theatre backstage");
        escape = new Room("the escape room");
        

        // initialise room exits
        outside.setExit("east", hall);
        outside.setExit("south", hallway1);
        outside.setExit("north", pub);
        outside.setExit("west", hallway2);
        
        hall.setExit("west", outside);
        hall.setExit("east", theatre);

        theatre.setExit("west", hall);
        theatre.setExit("east", backstage);
        
        backstage.setExit("west",theatre);

        pub.setExit("south", outside);
        pub.setExit("east", toilet);
        
        toilet.setExit("west", pub);
        
        hallway1.setExit("north", outside);
        hallway1.setExit("south", lab);
        
        lab.setExit("north", hallway1);
        lab.setExit("east", storage);
        
        storage.setExit("west", lab);
        
        hallway2.setExit("west", office);
        hallway2.setExit("east", outside);
        
        office.setExit("east", hallway2);
        office.setExit("north", escape);

        currentRoom = outside;  // start game outside
        
        //sets items to said rooms
        hall.addItemToRoom(photo);
        toilet.addItemToRoom(labKey);
        backstage.addItemToRoom(crowbar);
        pub.addItemToRoom(glassShard);
        storage.addItemToRoom(escapeKey);
        office.addItemToRoom(note);
        hallway1.addItemToRoom(ring);
        outside.addItemToRoom(bag);
        
        lab.setLock(true);
        pub.setLock(true);
        storage.setLock(true);
        escape.setLock(true);
    }

    /**
    * Initialises game items
    */
    private void createItems()
    {
        labKey = new Items("LabKey", "This key says it belonged to a researcher.", 1, 15);
        crowbar = new Items("Crowbar", "A robust crowbar, it'll probably come in handy.", 5, 10);
        glassShard = new Items("GlassShard", "Best be careful not to get cut.", 2, 20);
        escapeKey = new Items("ShinyKey", "This key looks important... I'll hold on to it.", 1, 50);
        note = new Items("Note", "Note has what looks like a drawing on it, but it's damp, can't see it well.", 1, 70);
        ring = new Items("Ring", "This ring is familiar... where could I have seen it before?", 1, 80);
        photo = new Items("Photo", "This is a photo of some sort of group... who might it belong to?", 1, 30);
        bag = new Items("Bag", "A small bag that increases your storage", 1, 20);
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("You are trying to escape a small research facility after it has been evacuated");
        System.out.println("Due to the leakage of a very hazardous gas.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case ESCAPE:
                wantToQuit = escape(command);
                break;

            case GET:
                getItem(command);
                break;

            case DROP:
                dropItem(command);
                break;

            case INVENTORY:
                getInventory();
                break;

            case EXAMINE:
                examineCommand();
                break;

            case USE:
                useItem(command);
                break;
              
            case REST:
                player.setEnergy(2);
                break;
                
         }
         return wantToQuit;
    }
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Everyone has abandoned you for their own safety.");
        System.out.println("Escape before you run out of time.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * allows the user to use certain items
     * @param command
     */
    private void useItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Use what?");
            return;
        }

        String itemString = command.getSecondWord();

        if(command.hasSecondWord() && player.hasItem(itemString))
        {
            if(itemString.equals("Note"))
            {
                System.out.println("Looking at this drawing is filling you with determination. +5 energy.");
                player.removeItemFromInv(player.getItem(itemString));
                player.setEnergy(5);
            }
            if(itemString.equals("Bag"))
            {
                System.out.println("You equip the bag (max weight + 20).");
                player.setMaxWeight(20);
            }
            if(itemString.equals("LabKey"))
            {
                System.out.println("The lab is now open.");
                lab.setLock(false);
            }
            if(itemString.equals("Crowbar"))
            {
                System.out.println("The boards have been pried open.");
                pub.setLock(false);
            }
            if(itemString.equals("GlassShard"))
            {
                System.out.println("You have cut the rope, you can now go in.");
                storage.setLock(false);
            }
            if(itemString.equals("ShinyKey"))
            {
                System.out.println("You can now escape.");
                escape.setLock(false);
            }
        }
        else
        {
            System.out.println("You don't have this item...");
        }
    }

    
    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("You can't exit through there.");
        }
        if(nextRoom != null) {
            if (nextRoom.getLockStatus()) {
                System.out.println("This room is locked you need to use a key...");
            }
            if (!nextRoom.getLockStatus()) {
                player.setEnergy(-1);
                System.out.println("Energy: " + player.getEnergy());
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
    }
    
    /**
     * command to let player get an item in a room
     * @param command
     */
    private void getItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Get what?");
            return;
        }

        String itemString = command.getSecondWord();

        if(command.hasSecondWord() && currentRoom.hasItem(itemString))
        {
            player.addItemToInv(currentRoom.getItem(itemString));
            currentRoom.removeItemFromRoom(currentRoom.getItem(itemString));
        }
        else
        {
            System.out.println("Item not found...");
        }
    }
    
    /**
     * command to let player drop an item from their inventory
     * @param command
     */
    private void dropItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Drop what?");
            return;
        }

        String itemString = command.getSecondWord();

        if(command.hasSecondWord() && player.hasItem(itemString))
        {
            currentRoom.addItemToRoom(player.getItem(itemString));
            player.removeItemFromInv(player.getItem(itemString));
        }
        else
        {
            System.out.println("Item not found...");
        }
    }
    
    /**
     * command for player to look around active room for items
     */
    private void examineCommand()
    {
        currentRoom.lookAround();
    }
    
    /**
     * command to let the player escape and finish the game
     */
    private boolean escape(Command command)
    {
        boolean output = false;

        // is the player's room the front exit
        if(currentRoom == office)
        {
            // if player is under energy threshold for escape
            if(player.getEnergy() < 20)
            {
                System.out.println("You need to rest for a bit.");
                output = false;
            }
            // if player meets energy threshold for escape
            if(player.getEnergy() >= 20)
            {
                System.out.println("You managed to escape!");
                output = true;
            }

        }
        return output;
    }
    
    /**
     * command to print the inventory of the player
     */
    private void getInventory()
    {
        player.printInv();
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}