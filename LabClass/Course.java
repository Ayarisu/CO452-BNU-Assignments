
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    // course ID
    public static String courseID = "G400";
    // name of the course
    public static String courseName = "Computing";

  /**
   * Assigns a course ID and course name
  */
    public Course()
    {
        courseID = "G400";
        courseName = "Computing";
    }
    
  /**
   * Returns the course ID and name
  */
  public String getCourse()
   {
       return courseID + " " + courseName;
   }
}