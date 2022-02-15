import java.util.*;
public class Movie {
    String movieName;
    String movieTime;
    String moviePrice;
    int availableTicket=100;
    int noftic;
    int[][] seats=new int[10][10];
    Scanner s=new Scanner(System.in);
    Movie(String movieName,String moviePrice,String movieTime) {
        this.movieName=movieName;
        this.moviePrice=moviePrice;
        this.movieTime=movieTime;
        int seatNo=1;
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++)
                seats[i][j]=seatNo++;
        }
    }
    public void showMovie() {
        System.out.println("-----------------------------------");
        System.out.println("Movie Name: "+movieName);
        System.out.println("Movie Price: "+moviePrice);
        System.out.println("Movie Time: "+movieTime);
        System.out.println("-----------------------------------");
    }
    public int[] book() {
        System.out.println("Enter number of tickets you want to book: ");
        noftic=s.nextInt();
        viewSeat();
        int[] bookseat=new int[noftic];
        for(int i=0;i<noftic;i++) {
            System.out.println("Enter seat number for person "+(i+1));
            int seatNumber=s.nextInt();
            for(int j=0;j<10;j++) {
                for(int k=0;k<10;k++) {
                    if(seats[j][k]==seatNumber) {
                        seats[j][k]=-1;
                        bookseat[i]=seatNumber;
                    }
                }
            }
            System.out.println("Seat number "+seatNumber+" is booked");
        }
        return bookseat;
    }
    public void viewSeat() {
        System.out.println("--------------------------------------------------");
		System.out.println("----------------------SCREEN----------------------");
		System.out.println("--------------------------------------------------");
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				System.out.print(" | "+seats[i][j]);
			}
			System.out.println("\n-------------------------------------------------");
		}
		System.out.println("\n-1 means seat is booked..\n");
    }
}