
/**
 * Write a description of class Course here.
 *
 * @author (Luis Silva)
 * @version (28/10/2020)
 */
public class Course
{
    // Course's name
    private String courseName;
    // Course's ID
    private String courseID;
    // Total mark for that course
    private int totalMark;
    // Final Grade
    public String finalGrade;
    
    // Calling modules from the Module class.
    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;

    public Course(String courseName, String courseID)
    {
        this.courseName = courseName;
        this.courseID = courseID;
        totalMark = 0;
        finalGrade = null;
    }
    
    /**
    * Assign 4 modules to  a course
    */
    public void assignModules(Module module1, Module module2, Module module3, Module module4)
    {
        this.module1 = module1;
        this.module2 = module2;
        this.module3 = module3;
        this.module4 = module4;
    }
    
    /**
    * Change the module marks
    */
    public void changeModuleMark(int changeMark1, int changeMark2, int changeMark3, int changeMark4)
    {
        module1.moduleMark = changeMark1;
        module2.moduleMark = changeMark2;
        module3.moduleMark = changeMark3;
        module4.moduleMark = changeMark4;
    }
    
    /**
    * Method to calculate the final grade by adding the total and dividing my amount of modules
    */
    public void calculateFinalGrade(Module module1, Module module2, Module module3, Module module4)
    {
        totalMark = ((module1.moduleMark + module2.moduleMark + module3.moduleMark + module4.moduleMark) / 4);
    }
    
    /**
    * Using if and else if to figure out what mark to give as final grade. Not sure if I could have done
    * it in a better way.
    */
    public String getFinalGrade()
    {
        if (totalMark <= 39)
        {
            {finalGrade = "F";}
        } 
        else if (totalMark >=40 && totalMark <= 49) 
        {
            {finalGrade = "D";}
        }
        else if (totalMark >=50 && totalMark <=59)
        {
            {finalGrade = "C";}
        }
        else if (totalMark >=60 && totalMark <=69)
        {
            {finalGrade = "B";}
        }
        else if (totalMark >=70 && totalMark <=100)
        {
            {finalGrade = "A";}
        }
        
        return finalGrade;
    }
    
    /**
    * Print everything related to the course, including modules. 
    */
    public void printCourseDetails()
    {
        System.out.println("Course: " + courseID + ", " + courseName);
        System.out.println("Course Modules: ");
        module1.printModule();
        module2.printModule();
        module3.printModule();
        module4.printModule();
    }
    
}
