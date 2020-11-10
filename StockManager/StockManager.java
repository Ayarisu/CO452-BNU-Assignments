import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Luis Silva) 
 * @version (8/11/2020)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Checks to  see if the product id provided is eqeal to one in stock.
     * @param id The ID of the product.
     * @param product the product in the stock.
     */
    public boolean checkID(Product product, int id)
    {
        if (product.getID() == id)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Delete referenced item
     */
    public void removeProduct (int id)
    {
        for(Product product : stock)
        {
            if (product.id == id)
            {
                stock.remove(product);
                return;
            }
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        for(Product product : stock)
        {
            if (checkID(product,id) == true)
            {
                System.out.println ("Recieved " + amount + " of " + product.name + " " +product.getID());
                product.increaseQuantity(amount);
            }
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if (product.id == id)
            {
                return product;
            }
        }
        return null;
    }
    
     public void sale(int id, int amount)
    {
        for(Product product : stock)
        {
            if (product.id == id)
            {
                System.out.println ("Sold " + amount + " of " + product.name + " " +product.getID());
                product.sellQuantity(amount);
            }
        }
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        for(Product product : stock)
        {
            if (product.id == id)
            {
                return product.getQuantity();
            }
        }
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        System.out.println ("=============");
        System.out.println ("Current Stock");
        System.out.println ("=============");
            for(Product product : stock)
            {
                {
                 System.out.println (product.toString());
                }
            }
        
    }
    /**
     * Prints a list of products low in stock.
     */
    public void  printLowStockProducts()
    {
        for(Product product : stock)
        {
            {
                if (product.quantity <  2)
                {
                System.out.println (product.toString());
                }
            }
        }
        
    }
    
    /**
     * Locate items by their name.
     */
    public void getProductByName(String searchstring)
    {
        for(Product product  : stock) 
        {
            if (product.name.contains (searchstring)) 
            {
                System.out.println (product.toString());
            }
        }  
    }
    
    /**
     * Rename a product.
     */
    public void renameProduct(int id, String newName)
    {
        for(Product product  : stock) 
        {
            if (product.id == (id)) 
            {
                product.name = (newName);
            }
        }  
    }
}
