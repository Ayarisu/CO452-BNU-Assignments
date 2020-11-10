/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager stockManager)
    {
        manager = stockManager;
        manager.addProduct(new Product(132, "Clock Radio"));
        manager.addProduct(new Product(37,  "Mobile Phone"));
        manager.addProduct(new Product(23,  "Microwave Oven"));
        manager.addProduct(new Product(210, "Laptop"));
        manager.addProduct(new Product(91, "Table"));
        manager.addProduct(new Product(56, "Mousepad"));
        manager.addProduct(new Product(43, "Mouse"));
        manager.addProduct(new Product(302, "Television"));
        manager.addProduct(new Product(110, "Silverware"));
        manager.addProduct(new Product(1, "Mug"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
        public void demo()
    {
        // Show details of all of the products.
        manager.printProductDetails();
        // Take delivery of items.
        manager.delivery(132, 9);
        manager.delivery(37, 2);
        manager.delivery(91, 7);
        manager.delivery(43, 6);
        // Show details of all of the products.
        manager.printProductDetails();
        // Sale of products.
        System.out.println ("=============");
        System.out.println ("Sale of stock");
        System.out.println ("=============");
        manager.sale(132, 3);
        manager.sale(37, 1);
        manager.sale(91, 3);
        manager.sale(43, 4);
        manager.printProductDetails();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
