public class Item {
    private String name;
    private int cost, quantity;
    
    public Item(String name, int cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public void displayItem(String strFormat, int id) {
        System.out.format(strFormat, id, this.name, this.cost, this.quantity);
    }
    public int getQuantity() {
        return this.quantity;
    }
    public String getName() {
        return this.name;
    }
    public int getCost() {
        return this.cost;
    }
    public void updateQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
