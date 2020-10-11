import java.util.*;
/**
 * Student class holds the information of the students present in this system. 
 *
 * @author Luís Silva
 * @version 06/10/2020
 */
public class Students
{
    // student's name
    private String name;
    // student's ID
    private String id;
    // student's credits
    private int credits;
    // students course
    Course getCourse = new Course();

    /**
    * New student name and ID.
    */
    public Students(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }
    
    /**
    * Adds the course to the student.
    */
    public String getCourse()
    {
        return Course.courseID + ", " + Course.courseName;
    }
    
    /**
    * Return the full name of the student.
    */
    public String getName()
    {
        return name;
    }
    
    /**
    * Change the student's name.
    */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }
    
    /**
     * Return the student's ID.
     */
    public String getStudentID()
    {
        return id;
    }
    
    /**
    * Add credits to the student.
    */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }
    
    /**
     * Display the student's name and ID.
     */
    public void print()
    {
        System.out.println(name + " ,student ID: " + id + ", Credits: " + credits);
    }
}
