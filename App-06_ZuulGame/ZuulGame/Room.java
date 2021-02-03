import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    // String is the key to a room in that direction
    // east would be an exit that goes to the Room
    private HashMap<String, Room> exits;
    private ArrayList<Items> roomInventory;
    private Room room;
    private Items item;
    private boolean locked;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        roomInventory = new ArrayList<Items>();
        locked = false;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String output = "";
        if(roomInventory.size() > 0)
        {
            output = "You are in " + description + ". Maybe I should examine the room. " + ".\n" + getExitString();
        }
        else
        {
            output = "You are " + description + ".\n" + getExitString();
        }
        return output;
    }

    /**
     * method to run on command so player can search a room for items
     */
    public void lookAround()
    {
        System.out.println("You look around and see ");
        System.out.println(printRoomInv());
        System.out.println(getExitString());
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * adds an item to the room inventory.
     * @param item the item that will be added
     */
    public void addItemToRoom(Items item)
    {
        roomInventory.add(item);
    }

    /**
     * removes an item from the room inventory.
     * @param item the item that will be removed
     */
    public void removeItemFromRoom(Items item)
    {
        roomInventory.remove(item);
    }

    /**
     * loops through the room inventory and prints the name of each item.
     * @return a string containing all items in the room inventory
     */
    public String printRoomInv()
    {
        String output = "";
        for (Items items : roomInventory)
        {
            output += items.getName() + " ";
        }
        return output;
    }

    /**
     * check to see if an item is in the room
     * @param itemName the name of the item being compared
     * @return boolean
     */
    public boolean hasItem(String itemName)
    {
        boolean output = false;

        for(int i = 0; i < roomInventory.size(); i++)
        {
            if(roomInventory.get(i).getName().equals(itemName))
            {
                output = true;
            }
        }
        return output;
    }

    /**
     * sets the locked status of a room
     * @param input = locked status
     */
    public void setLock(boolean input)
    {
        locked = input;
    }

    /**
     * @return locked status of room
     */
    public boolean getLockStatus()
    {
        return locked;
    }

    /**
     * returns the compared item
     * @param itemName the name of the item being located
     * @return ITEM
     */
    public Items getItem(String itemName)
    {
        for(int i = 0; i < roomInventory.size(); i++)
        {
            if(roomInventory.get(i).getName().equals(itemName))
            {
                return roomInventory.get(i);
            }
        }
        return null;
    }
}