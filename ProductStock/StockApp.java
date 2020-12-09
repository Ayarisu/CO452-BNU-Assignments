
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    // Use to get user input
    private InputReader input;
    private StockManager manager;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
    }

    /**
     * 
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * 
     */
    public void getMenuChoice()
    {
        boolean finished = false;
        printMenuChoices();
        
        while(!finished)
        {
            String choice = input.getInput();
            
            if (choice.equalsIgnoreCase("Add"))
            { 
                addProduct();
            }
            
            else if (choice.equalsIgnoreCase("Remove"))
            {
                removeProduct();
            }
            
            else if (choice.equalsIgnoreCase("Print"))
            {
                manager.printStockList();
                System.out.println("");
                printMenuChoices();
            }
            
            else if (choice.equalsIgnoreCase("Delivery"))
            {
                addDelivery();
            }
            
            else if (choice.equalsIgnoreCase("Sell"))
            {
                sellAmount();
            }
            
            else if (choice.equalsIgnoreCase("Search"))
            {
                searchProduct();
            }
            
            else if (choice.equalsIgnoreCase("Low Stock"))
            {
                printLowStock();
            }
            
            else if (choice.equalsIgnoreCase("Restock"))
            {
                restockLowProduct();
            }
            
            else if (choice.equalsIgnoreCase("Quit"))
            {
                System.out.println("Thanks for using the program.");
                finished = true;
            }
            else
            {
                System.out.println("Invalid command.");
            }
        }
    }
    
     /**
     * Lets the user add a product with user input
     */
    private void addProduct()
    {
        // Prompt to inform the user what they need to input
        System.out.println("Input the product ID: ");
        // Get an input from the user and assign to variable
        String inputID = input.getInput();
        // Prompt to inform the user what they need to input
        System.out.println("Input the product name: ");
        String inputName = input.getInput();
        System.out.println("");
        // Convert the String input to an integer
        int convertID = Integer.parseInt(inputID);
        // Add the product
        manager.addProduct(new Product(convertID, inputName));
        printMenuChoices();
    }
    
    /**
     * Lets the user remove a product with user input
     */
    private void removeProduct()
    {
        // Print the stock list first to show all of the items with their IDs
        manager.printStockList();
        System.out.println("");
        // Prompt to inform the user what they need to input
        System.out.println("Enter the ID of the product you want to remove: ");
        // Get an input from the user and assign to variable
        String inputID = input.getInput();
        // Convert the String input to an integer
        int convertID = Integer.parseInt(inputID);
        // Remove the product
        manager.removeProduct(convertID);
        printMenuChoices();
    }
    
    /**
     * Lets the user accept a delivery with user input
     */
    private void addDelivery()
    {
        // Inform the user what the need to input
        System.out.println("Enter the ID of the product you want to increase the quantity of: ");
        // Get user input for ID
        String inputID = input.getInput();
        // Convert the inputID to an int from a String
        int convertID = Integer.parseInt(inputID);
        // Inform the user what the need to input
        System.out.println("Enter the amount of product ID: " + convertID + " you want to increase the quantity of.");
        // Get user input for Quantity
        String inputQuantity = input.getInput();
        // Convert the inputQuantity to int from String
        int convertQuantity = Integer.parseInt(inputQuantity);
        // Accept delivery adds the quantity to the product with that ID.
        manager.acceptDelivery(convertID, convertQuantity);
        printMenuChoices();
    }
    
    /**
     * Lets the user sell an amount of product with user input
     */
    private void sellAmount()
    {
        // Inform the user what they need to input
        System.out.println("Enter the ID of the product you want to sell: ");
        // Get user input for ID
        String inputID = input.getInput();
        // Convert inputID to int from String
        int convertID = Integer.parseInt(inputID);
        // Inform the user what they need to input
        System.out.println("Enter the amount of product ID: " + convertID + " you want to sell.");
        // Get user input for Quantity
        String inputQuantity = input.getInput();
        // Convert inputQuantity to int from String
        int convertQuantity = Integer.parseInt(inputQuantity);
        // Sell product removes quantity from the product with that ID
        manager.sellProduct(convertID, convertQuantity);
        printMenuChoices();
    }
    
    /**
     * Lets the user search from products with user input
     */
    private void searchProduct()
    {
        // Inform the user what they need to input
        System.out.println("Enter the name of a product you would like to find");
        // Get user input for name
        String inputName = input.getInput();
        // Prints all products that contain the String entered
        manager.printPartialProductName(inputName);
        printMenuChoices();
    }
    
    /**
     * Lets the user print products low in stock with user input
     */
    private void printLowStock()
    {
        // Inform the user of what they need to input
        System.out.println("Enter a number. Any products with a quantity equal to or below this amount will be printed.");
        // Get user input for upper value
        String inputAmount = input.getInput();
        // Convert inputAmount to int from String
        int convertAmount = Integer.parseInt(inputAmount);
        // Prints all products with a quantity below the value entered
        manager.checkStockLevels(convertAmount);
        printMenuChoices();
    }
    
    /**
     * Lets the user restock products low in stock with user input
     */
    private void restockLowProduct()
    {
        // Inform the user of what they need to input
        System.out.println("Enter a number. Any products with a quantity equal to or below this amount will be increased.");
        // Get user input for upper limit
        String inputLowStock = input.getInput();
        // Convert inputLowStock to int from String
        int convertLowStock = Integer.parseInt(inputLowStock);
        // Inform the user of what they need to input
        System.out.println("To what amount would you like to set the low product's quantity to?");
        // Get user input for what they want to increase low stock items to
        String inputIncreaseValue = input.getInput();
        // Convert inputIncreaseValue to int from String
        int convertIncreaseValue = Integer.parseInt(inputIncreaseValue);
        // Restocks low products
        manager.restockLowProduct(convertLowStock, convertIncreaseValue);
        printMenuChoices();
    }
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:   Print all products");
        System.out.println("    Delivery:   Accept a delivery");
        System.out.println("    Sell:   Sell product");
        System.out.println("    Search:   Search for products from part of their name");
        System.out.println("    Low:   Print all products low in stock");
        System.out.println("    Restock:   Restock products low in stock");
        System.out.println("    Quit:       Quit the program");
        System.out.println();       
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Luis Silva");
        System.out.println("******************************");
    }
}
