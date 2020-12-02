import java.util.ArrayList;
/**
 * Write a description of class StockManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StockManager
{
    // Creates an array to contain products
    private ArrayList<Product> stock;
    private Product product;

    /**
     * Initialise the stock manager
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }
    
    /**
     * Get the current size of the stock list (how many products are in the stock list)
     */
    public int getStockSize()
    {
        return stock.size();
    }
    
    /**
     * Tests whether the ID entered already exists in the stock array
     */
    public boolean checkID(int inputID)
    {
        for(Product product : stock)
        {
            int chosenID = product.getID();
            if (chosenID == inputID)
            {
                return true;
            }
        }
        return false;
    }  
    
    /**
     * Tests if the input name is empty, if so it returns an error message.
     */
    public boolean nameChecker(String inputName)
    {
        if (inputName.isEmpty() == true)
        {
            System.out.println("The name " + inputName + " is available.");
        }
        
        if (inputName.isEmpty() == false)
        {
            System.out.println("The name " + inputName + " is already taken.");
        }
        return false;
    }
    
    /**
     * Adds a new product to stock.
     */
    public void addProduct(Product item)
    {
        boolean checkID = checkID(item.id);
        boolean checkName = nameChecker(item.name);
        if(checkID == false && checkName == false)
        {
            System.out.println("Product with ID: " + item.id + " name: " + item.name + " has been added!");
            stock.add(item);
        }
        if(checkID == true)
        {
            System.out.println("Product with ID: " + item.id + " has already been found. Product has not been added.");
        }
        if(checkName == true)
        {
            System.out.println("You have entered an empty name. Please re-enter");
        }
    }
    
    /**
     * Removes a product from stock based on ID.
     */
    public void removeProduct(int inputID)
    {
        boolean checkID = checkID(inputID);
        if(checkID == true)
        {
            for(Product product : stock)
            {
                if(product.id == inputID)
                {
                    System.out.println("Product with ID: " + inputID + " has been removed from the stock list.");
                    stock.remove(product);
                    break;
                }
            }
        }
        if(checkID == false)
        {
            System.out.println("Product with ID: " + inputID + " could not be found.");
        }
    }
    
    /**
     * Checks the stock list and prints out products that are currently low on stock (input amount)
     */
    public void checkStockLevels(int inputValue)
    {
        if(inputValue > 0)
        {
            for(Product product : stock)
            {
                if(product.quantity <= inputValue)
                {
                    System.out.println("You are running low on ID: " + product.id + ", " + product.name + ". There are currently " + product.quantity + " remaning.");
                    product.toString();
                    System.out.println("");
                }
            }
        }
        if(inputValue <= 0)
        {
            System.out.println("You have entered an invalid number. Please enter a number above zero");
        }
    }
    
    /**
     * Simulates accepting a delivery for a particular product of a given amount based on ID.
     */
    public void acceptDelivery(int inputID, int deliveryAmount)
    {
        boolean testID = checkID(inputID);
        if(testID = true && deliveryAmount > 0)
        {
            for(Product product : stock)
            {
                if(product.id == inputID)
                {
                    System.out.println(deliveryAmount + " of product ID: " + inputID + " have been added.");
                    product.quantity = product.quantity + deliveryAmount;
                    break;
                }
            }
        }
        if(testID = false)
        {
            System.out.println("Product with ID: " + inputID + " could not be found.");
        }
        if(deliveryAmount <= 0)
        {
            System.out.println("You have entered an invalid amount to deliver. Please enter a positive number");
        }
    }
    
    /**
     * Simulates the sale of a product of a particular product of a given amount based on ID
     */
    public void sellProduct(int inputID, int sellAmount)
    {
        for(Product product : stock)
        {
            if(product.id == inputID)
            {
                if(product.quantity - sellAmount < 0)
                {
                    System.out.println("You are trying to sell more " + product.name + " than are left in stock. There are " + product.quantity + " remaining.");
                }
                if(product.quantity - sellAmount > 0)
                {
                    System.out.println(sellAmount + " of product ID: " + inputID + " have been sold.");
                    product.quantity = product.quantity - sellAmount;
                }
                break;
            }
        }
    }
    
    /**
     * Restock products that are low, user inputs the inputValue which is the bar for what is considered low in stock
     * they then inputs an increaseValue which sets the low stock item's quantities to this value
     */
    public void restockLowProduct(int inputValue, int increaseValue)
    {
        if(inputValue > 0 && increaseValue > 0)
        {
            for(Product product : stock)
            {
                if(product.quantity < inputValue)
                {
                    System.out.println("Product with ID: " + product.id + " has been restocked to " + increaseValue + ".");
                    product.quantity = increaseValue;
                }
            }
        }
        if(inputValue <= 0)
        {
            System.out.println("You have entered an invalid number. Please enter a number above zero.");
        }
        if(increaseValue <= 0)
        {
            System.out.println("You have enterned an invalid increase amount. Please enter a number above zero.");
        }
    }
    
    /**
     * Find a product or multiple products in the stock list based on 
     * a part of their name
     */
    public void printPartialProductName(String inputName)
    {
        System.out.println("Products with names matching '" + inputName + "'.");
        
        for(Product product : stock)
        {
            if(product.name.contains(inputName))
            {
                System.out.println(product.toString());
            }
        }
    }
    
    /**
     * Print the stock list
     */
    public void printStockList()
    {
        System.out.println("       Luis' stock list       ");
        System.out.println("ID" + " | " + "Product Name" + " | " + "Quantity");
        System.out.println("------------------------");
        
        for(Product product : stock)
        {
            System.out.println(product.toString());
        }
    }
}
