import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Item> items;
    private int totNoOfItems = 25;

    public Inventory(HashMap<Integer, Item> items) {
        this.items = items;
    }

    public void display() {
        String strFormat = "%1$-5s%2$-60s%3$-7s%4$-10s\n";
        System.out.format(strFormat, "ID", "Name", "Cost", "Quantity");
        for(int i=1 ; i<=totNoOfItems ; i++) {
            Item item = items.get(i);
            item.displayItem(strFormat, i);
        }
    }
    public void updateItem(int id, int quantity) {
        Item item = items.get(id);
        item.updateQuantity(quantity);
    }
}
