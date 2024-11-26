import java.util.HashMap;
import java.util.Scanner;

public class Vending_Machine {
    Scanner sc = new Scanner(System.in);
    Inventory inventory;
    HashMap<Integer, Item> items;

    public void logic() {
        while(true) {
            System.out.print("Please specify that you are User/Admin \nIf User Enter '0' else Admin Enter '1' : ");
            int userOrAdmin = Integer.parseInt(sc.nextLine());
            //Admin
            if(userOrAdmin == 1) {
                Admin admin = new Admin();
                System.out.print("Enter the PIN : ");
                String enteredPin = sc.nextLine();
                if(admin.checkPin(enteredPin)) {
                    items = admin.setItemsInVendingMachine();
                    inventory = new Inventory(items);
                    System.out.println("The Items has been Stocked!");
                }
                else {
                    System.out.println("The PIN that you entered was wrong.");
                }
                continue;
            }
            inventory.display();
            System.out.print("Enter the ID for the item that you need : ");
            int id = Integer.parseInt(sc.nextLine());
            if(!items.containsKey(id)) {
                System.out.println("Enter the Correct ID for the product");
            }
            if(items.get(id).getQuantity() <= 0) {
                System.out.println("Sorry! We don't have the " + items.get(id).getName() + " right now.");
                continue;
            }
            System.out.print("Enter the number of quantity you need for " + items.get(id).getName() + " : ");
            int quantity = Integer.parseInt(sc.nextLine());
            if(!(items.get(id).getQuantity() >= quantity)) {
                System.out.println("Sorry! We don't have " + quantity + " " + items.get(id).getName() + 
                "\nPlease try with another item");
                continue;
            }
            int cost = (quantity * items.get(id).getCost());
            System.out.println("Please Pay " + cost + " rupees");
            inventory.updateItem(id, quantity);
            if(!(isPaid(cost))) {
                System.out.println("Please Pay the amount correctly!");
                continue;
            }
            System.out.println("The item has been dispatched");
        }
    }
    public boolean isPaid(int cost) {
        return true;
    }
}
