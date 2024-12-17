import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Vending_Machine {
    Scanner sc = new Scanner(System.in);
    Inventory inventory = null;
    HashMap<Integer, Item> items;

    public void logic() {
        try {
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
                if(inventory == null) {
                    System.out.println("Sorry. Currently we don't have any items in the vending Machine. Please come again Later");
                    break;
                }
                int cost = 0;
                ArrayList<Integer> cart = new ArrayList<>();
                while(true) {
                    inventory.display();
                    System.out.print("Enter the ID for the item that you need : ");
                    int id = Integer.parseInt(sc.nextLine());
                    if(!items.containsKey(id)) {
                        System.out.println("Enter the Correct ID for the product");
                        continue;
                    }
                    String itemName = items.get(id).getName();
                    int itemQuantity = items.get(id).getQuantity();
                    int itemCost = items.get(id).getCost();
                    if(itemQuantity <= 0) {
                        System.out.println("Sorry! We don't have the " + itemName + " right now.");
                        continue;
                    }
                    System.out.print("Enter the number of quantity you need for " + itemName + " : ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    if((itemQuantity < quantity)) {
                        System.out.println("Sorry! We don't have " + quantity + " " + itemName + 
                        "\nWe have only " + itemQuantity + " Please continue with shopping!");
                        continue;
                    }
                    if(quantity <= 0) {
                        continue;
                    }
                    cost += (quantity * itemCost);
                    cart.add(id);
                    System.out.println(itemName + " has been added to the cart");
                    inventory.updateItem(id, quantity);
                    if(cart.size() == 0) {
                        System.out.println("Your cart is empty");
                    }
                    else {
                        System.out.println("Your Cart : ");
                        String strFormat = "%1$-60s%2$-10s\n";
                        System.out.format(strFormat, "Name", "Cost");
                        for(int i=0 ; i<cart.size() ; i++) {
                            String cartItemName = items.get(cart.get(i)).getName();
                            int cartItemCost = items.get(cart.get(i)).getCost();
                            System.out.format(strFormat, cartItemName, cartItemCost);
                        }
                    }
                    System.out.print("If you want to continue, Press any from (1-9) \nIf you want to leave, Press 0 ");
                    int temp = Integer.parseInt(sc.nextLine());
                    if(temp == 0)
                        break;
                }
                System.out.println("Please Pay " + cost + " rupees");
                if(!(isPaid(cost))) {
                    System.out.println("Please Pay the amount correctly!");
                    continue;
                }
                System.out.println("The items has been dispatched");
            }
        }
        catch(Exception e) {
            System.out.println("Some error has happened. Returned out of Vending Machine. Re-run it.");
            return;
        }
    }
    public boolean isPaid(int cost) {
        return true;
    }
}
