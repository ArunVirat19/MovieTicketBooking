import java.util.*;
class TicketBooker {
    Scanner s=new Scanner(System.in);
    String movieName="Avengers Endgame",moviePrice="$50",movieTime="10 AM";
    ArrayList<Movie> movies=new ArrayList<>();
    ArrayList<Ticket> tickets=new ArrayList<>();

    public void getChoice() {
        System.out.println("1.Show Movies");
        System.out.println("2.Book ticket");
        System.out.println("3.View ticket");
        System.out.println("4.Cancel ticket");
        System.out.println("5.Exit");
        int choice=s.nextInt();
        switch (choice) {
            case 1: {
                movies.add(new Movie(movieName,moviePrice,movieTime));
                Movie movie2=new Movie("Inception","$50","1 PM");
                movies.add(movie2);
                Movie movie3=new Movie("Interstellar","$50","4 PM");
                movies.add(movie3);
                for(Movie x:movies) {
                    x.showMovie();
                } 
                getChoice();
                break;
            }
            case 2: {
                s.nextLine();
                System.out.println("Enter movie name: ");
                String mn=s.nextLine();
                String mt="";
                String price="";
                int noftic=0;
                int loc=0;
                for(Movie x:movies) {
                    if(x.movieName.equalsIgnoreCase(mn)) {
                        mn=x.movieName;
                        mt=x.movieTime;
                        price=x.moviePrice;
                        noftic=x.noftic;
                        int[] seats=x.book();
                        movies.set(loc,x);
                        int id=tickets.size();
                        tickets.add(new Ticket(id,mn,price,mt,x.noftic,seats));
                        System.out.println("Ypur ticket id is "+id);
                        System.out.println("Seats are "+Arrays.toString(seats));
                    }
                    loc++;
                }
                getChoice();
                break;
            }
            case 3: {
                s.nextLine();
                System.out.println("Enter ticket id: ");
                int id=s.nextInt();
                Ticket t=tickets.get(id);
                t.showTicket();
                getChoice();
                break;
            }
            case 4: {
                s.nextLine();
                System.out.println("Enter ticket id: ");
                int id=s.nextInt();
                Ticket t=tickets.get(id);
                int loc1=0;
                for(Movie x:movies) {
                    if((x.movieName).equalsIgnoreCase(t.movieName)) {
                        for(int sn:t.bookseats) {
                            int ids=1;
                            for(int i=0;i<10;i++) {
                                for(int j=0;j<10;j++) {
                                    if(ids==sn) {
                                        x.seats[i][j]=ids;
                                    }
                                    ids++;
                                }
                            }
                        }
                        movies.set(loc1,x);
                    }
                    loc1++;
                }
                tickets.remove(t);
                System.out.println("Tickets cancelled successfully");
                getChoice();
                break;
            }
            case 5: {
                System.out.println("Thank you for using our application");
                return;
            }
            default:
                System.out.println("Sorry invalid option");
                getChoice();
                break;
        }
    }

    public static void main(String[] args) {
        TicketBooker tb=new TicketBooker();
        tb.getChoice();
    }
}
