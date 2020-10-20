import java.util.Date;
/**
 * Reads the tickets chosen in TicketMachine and formats them to be printed here.
 *
 * @author (Luis Silva)
 * @version (a version number or a date)
 */
public class Ticket
{
    // Displays the destination chosen.
    public String destination;
    // Displays current date.
    public Date todayDate;
    // Displays the cost for the chosen ticket.
    public int cost;
    
    /**
     * Displays set destination, the cost and the date of purchase.
     */
    public Ticket(String destination, int cost)
    {
        this.destination = destination;
        this.cost = cost;
        todayDate = new Date();
    }
    
    public void printTicket()
    {
        System.out.println("Destination: " + destination);
        System.out.println("Cost: " + cost + " cents.");
        System.out.println("Time of purchase: " + todayDate);
    }
}
