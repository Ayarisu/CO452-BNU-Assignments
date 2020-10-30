
/**
 * Write a description of class Module here.
 *
 * @author (Luis Silva)
 * @version (28/10/2020)
 */
public class Module
{
    // Module name
    private String moduleTitle;
    // Module id
    private String moduleID;
    // Module mark
    public int moduleMark;
    
    /**
    * Assigns initial values to a module
    */
    public Module(String moduleTitle, String moduleID)
    {
        this.moduleTitle = moduleTitle;
        this.moduleID = moduleID;
        moduleMark = 0;
    }
    
    /**
    * Print the information for this module
    */
    public void printModule()
    {
        System.out.println("Module: " + moduleID + ", " + moduleTitle + ". Current mark: " + moduleMark);
    }
}

