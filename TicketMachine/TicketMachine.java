import java.util.*;
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input. 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Luis Silva
 */
public class TicketMachine
{
            
    // The price of a ticket from this machine.
    private int cost;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //Accesses the Ticket class.
    private Ticket ticket;
    // The chosen ticket
    private Ticket chosenTicket;
    
    //Constants set for the destinations listed.
    public static final Ticket AYLESBURY_TICKET = new Ticket("Aylesbury", 220);
    public static final Ticket AMERSHAM_TICKET = new Ticket("Amersham", 300);
    public static final Ticket HIGHWYCOMBE_TICKET = new Ticket("High Wycombe", 330);
    
    /**
     * Makes a machine who issues the selected tickets.
     */
     public TicketMachine()
    {
        balance = 0;
        total = 0;
        chosenTicket = null;
    }
    
    /**
     * @Return The price of a ticket.
     */
    public int getCost()
    {
        return chosenTicket.cost;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertCoin(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    
    /**
     * Chooses destination to Aylesbury
     */
    public void chooseAylesburyTicket()
    {
        chosenTicket = AYLESBURY_TICKET;
    }
    
    /**
     * Chooses destination to Amersham.
     */
    public void chooseAmershamTicket()
    {
        chosenTicket = AMERSHAM_TICKET;
    }
    
    /**
     * Chooses destination to High Wycombe.
     */
    public void chooseHighWycombe()
    {
        chosenTicket = HIGHWYCOMBE_TICKET;
    }
    
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= cost) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket to " + chosenTicket.destination + " Ticket");
            System.out.println("# " + chosenTicket.cost + " cents.");
            System.out.println("# " + chosenTicket.todayDate);
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + chosenTicket.cost;
            // Reduce the balance by the price.
            balance = balance - chosenTicket.cost;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (chosenTicket.cost - balance) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
