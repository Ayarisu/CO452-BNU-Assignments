import java.util.ArrayList;

/**
 * This class represents the player and contains the players inventory
 */
public class Player
{
    private int energy;
    private Items item;
    private ArrayList<Items> playerInventory;
    private int maxWeight;
    private int currentWeight;
    private int score;

    /**
     * Creates a player with energy and an inventory
     * @param energy player's energy - reduced by moving room to room
     */
    public Player(int energy, int maxWeight)
    {
        this.energy = energy;
        this.maxWeight = maxWeight;
        playerInventory = new ArrayList<Items>();
        currentWeight = 0;
    }

    /**
     * @return player's current energy
     */
    public int getEnergy()
    {
        return energy;
    }

    /**
     * adds an item to the player's inventory.
     * @param item the item that will be added
     */
    public void addItemToInv(Items item)
    {
        if(currentWeight + item.getWeight() > maxWeight)
        {
            System.out.println("Failed to pick up " + item.getName() + " ( " + item.getWeight() + "kg). You don't have enough space." );
        }
        else
        {
            playerInventory.add(item);
            currentWeight += item.getWeight();
            System.out.println("You have picked up " + item.getName() + " (" + item.getWeight() + "kg). You are now carrying " + currentWeight + "kg.");
        }
    }

    /**
     * @return max player weight
     */
    public int getMaxWeight()
    {
        return maxWeight;
    }

    /**
     * set player max weight
     */
    public void setMaxWeight(int input)
    {
        maxWeight += input;
    }

    /**
     * @return current player weight
     */
    public int getCurrentWeight()
    {
        return currentWeight;
    }

    /**
     * removes an item from the player's inventory.
     * @param item the item that will be removed
     */
    public void removeItemFromInv(Items item)
    {
        playerInventory.remove(item);
        currentWeight = currentWeight -= item.getWeight();
        System.out.println("You have dropped " + item.getName() + ".");
    }

    /**
     * Prints all of the items in the players inventory
     */
    public void printInv()
    {
        for(Items item : playerInventory)
        {
            System.out.println(item.getNameDescription());
        }
        System.out.println("You're currently carrying " + currentWeight + "kg. " + "You can carry " + (maxWeight - currentWeight) + " kg more.");
    }

    /**
     * check to see if player has an item
     * @param itemName the name of the item being compared
     * @return boolean
     */
    public boolean hasItem(String itemName)
    {
        boolean output = false;

        for(int i = 0; i < playerInventory.size(); i++)
        {
            if(playerInventory.get(i).getName().equals(itemName))
            {
                output = true;
            }
        }
        return output;
    }

    /**
     * returns the compared item
     * @param itemName the name of the item being located
     * @return ITEM
     */
    public Items getItem(String itemName)
    {
        for(int i = 0; i < playerInventory.size(); i++)
        {
            if(playerInventory.get(i).getName().equals(itemName))
            {
                return playerInventory.get(i);
            }
        }
        return null;
    }

    /**
     * sets the players energy, used to change energy when the player moves
     * @param input
     */
    public void setEnergy(int input)
    {
        energy += input;
    }

    /**
     * sets the players score
     */
    public void setScore(int input)
    {
        score = input;
    }

    /**
     * gets the current score
     * @return score
     */
    public int getScore()
    {
        for(Items item : playerInventory)
        {
            score += item.getScore();
        }
        return score;
    }
}