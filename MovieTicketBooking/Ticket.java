import java.util.*;
public class Ticket {
    int ticketID;
    String movieName;
    String moviePrice;
    String movieTime;
    int totalNumberOfPersons;
    int[] bookseats;
    Ticket(int ticketID,String movieName,String moviePrice,String movieTime,int totalNumberOfPersons,int[] bookseats) {
        this.ticketID=ticketID;
        this.movieName=movieName;
        this.moviePrice=moviePrice;
        this.movieTime=movieTime;
        this.totalNumberOfPersons=totalNumberOfPersons;
        this.bookseats=bookseats;
    }
    public void showTicket() {
        System.out.println("-----------------------------------------");
        System.out.println("Movie Name: "+movieName);
        System.out.println("Movie Time: "+movieTime);
        System.out.println("Movie Price: "+moviePrice);
        System.out.println("Total number of Persons: "+totalNumberOfPersons);
        System.out.println("Booked seats are: "+Arrays.toString(bookseats));
        System.out.println("-----------------------------------------");
    }
}
