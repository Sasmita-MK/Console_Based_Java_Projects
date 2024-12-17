import java.util.ArrayList;
import java.util.Scanner;

public class Ticket_booking {
    private Scanner sc;
    private Admin admin;
    private int noOfBus;
    public Ticket_booking() {
        sc = new Scanner(System.in);
        noOfBus = 0;
    }

    public void logic() {
        while(true) {
            System.out.print("Enter user/admin \n For user press '0' \n for admin press '1");
            int userOrAdmin = Integer.parseInt(sc.nextLine());
            if(userOrAdmin == 1) {
                admin = new Admin();
                System.out.print("Enter the password for Admin : ");
                String password = sc.nextLine();
                if(!(admin.getPassword().equals(password))) {
                    System.out.println("The password that you have entered is wrong. Please try again!");
                    continue;
                }
                while(true) {
                    System.out.println("What to do ? \n To register a bus press'0' \n To delete a bus press '1");
                    int registerOrDelete = Integer.parseInt(sc.nextLine());
                    if(registerOrDelete == 0) {
                        System.out.print("Enter the details of the bus \n Enter the bus name : ");
                        String name = sc.nextLine();
                        System.out.println("Enter the Registration Number of the bus : ");
                        String regNo = sc.nextLine();
                        noOfBus++;
                        Bus bus = new Bus(5, 7, "venkatesan", "balaji", name, regNo, noOfBus);
                        admin.registerBus(bus);
                    }
                    System.out.print("If you want to continue to register/delete Press '1' else press any other number");
                    int wantToContinue = Integer.parseInt(sc.nextLine());
                    if(wantToContinue == 1) continue;
                    else break;
                }
                continue;
            }
            else if(userOrAdmin == 0) {
                System.out.print("Enter username : ");
                String userName = sc.nextLine();
                User user = new User(userName, 1);
                ArrayList<Bus> buses = admin.getBuses();
                displayBuses(buses);
                System.out.print("Enter the bus id which you want to travel : ");
                int id = Integer.parseInt(sc.nextLine());
                Bus toBook = null;
                for(int i=0 ; i<noOfBus ; i++) {
                    toBook = buses.get(i);
                    if(toBook.getId() == id)
                        break;
                }       
                if(toBook == null) {
                    System.out.println("No bus available for the given id. Please try again");
                    continue;
                }
                int temp = toBook.bookBus();
                if(temp == -1) {
                    System.out.println("Booking unsuccessful");
                }
                else    
                    System.out.println("Booking Successful");
                System.out.print("If you want to continue booking press '1' else any other number");
                int wantToContinue = Integer.parseInt(sc.nextLine());
                if(wantToContinue == 1) continue;
                else break;
            }
        }
    }

    public void displayBuses(ArrayList<Bus> buses) {
        for(int i=0 ; i<noOfBus ; i++) {
            Bus crntBus = buses.get(i);
            crntBus.displayBus();
        }
    }
}
