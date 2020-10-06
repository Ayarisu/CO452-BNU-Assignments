import java.util.*;

/**
 * Write a description of class LabClass here.
 *
 * @author Luis Silva
 * @version 06/10/2020
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    
    private ArrayList<Students> students;
    private int capacity;
    
    /**
     * Create a new LabClass and set the maximum capacity.
     */
    public LabClass(int maxNumberOfStudents)
    {
        instructor = "TBD";
        room = "TBD";
        timeAndDay = "TBD";
        
        students = new ArrayList<Students>();
        capacity = maxNumberOfStudents;
    }

    /**
     * Add a student to this class.
     */
    public void enrollStudent(Students newStudent)
    {
        if(students.size() == capacity) 
        {
            System.out.println("The class is full.");
        }
        else 
        {
            students.add(newStudent);
        }
    }
    
    /**
     * Number of students in this class.
     */
    public int numberOfStudents()
    {
        return students.size();
    }
    
    /**
     * Set the room number for this class.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }
    
    /**
    * Set the instructor for this class.
    */
    public void setInstructor(String nameOfInstructor)
    {
        instructor = nameOfInstructor;
    }
    
    /**
     * Set the time and day for this class.
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }
    
    /**
     * Print detailed information about the class.
     */
    public void printList()
    {
        System.out.println("Lab class " + timeAndDay);
        System.out.println("Instructor: " + instructor + "   Room: " + room);
        System.out.println("Class list:");
        
        for(Students student : students) 
        {
            student.print();
        }
        
        System.out.println("Number of students: " + numberOfStudents());
    }
}
