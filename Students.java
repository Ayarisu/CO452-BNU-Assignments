import java.util.*;

/**
 * Student class holds the information of the students present in this system. 
 *
 * @author Luís Silva
 * @version 06/10/2020
 */
public class Students
{
    private String name;
    private String id;

    /**
     * New student name and ID.
     */
    public Students(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
    }

    /**
     * Return the full name of the student.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the student's ID.
     */
    public String getStudentID()
    {
        return id;
    }
    
    /**
     * Display the student's name and ID.
     */
    public void print()
    {
        System.out.println(name + " ,student ID: " + id);
    }
}
