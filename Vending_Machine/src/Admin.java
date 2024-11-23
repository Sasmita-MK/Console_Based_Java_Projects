import java.util.HashMap;

public class Admin {
    private String pin = "12345";
    
    public boolean checkPin(String enteredPin) {
        if(pin.equals(enteredPin)) {
            return true;
        }
        return false;
    }
    
    public HashMap<Integer, Item> setItemsInVendingMachine() {
        HashMap<Integer, Item> items = new HashMap<>();
        items.put(1, new Item("Kit Kat", 25, 10));
        items.put(2, new Item("Munch", 20, 10));
        items.put(3, new Item("Five Star", 10, 10));
        items.put(4, new Item("Snickers", 50, 10));
        items.put(5, new Item("Dairy Milk", 45, 10));
        items.put(6, new Item("Kurkure Masala Crunch", 20, 10));
        items.put(7, new Item("Kurkure Solid Masti", 25, 10));
        items.put(8, new Item("Kurkure Namkeen Masaka Munch", 20, 10));
        items.put(9, new Item("Kurkure Naughty Tomato", 19, 10));
        items.put(10, new Item("Kurkure Sizzlin' Hot Crisps", 20, 10));
        items.put(11, new Item("Lay's India's Magic Masala Potato Chips", 20, 10));
        items.put(12, new Item("Lay's American Style Cream & Onion Chips", 20, 10));
        items.put(13, new Item("Lay's Crispz Herb 7 Onion", 20, 10));
        items.put(14, new Item("Lay's Classic Salted Chips", 20, 10));
        items.put(15, new Item("Lay's Hot N Sweet Chilli Potato Chips", 20, 10));
        items.put(16, new Item("Sting Energy Drink (250 ml)", 20, 10));
        items.put(17, new Item("Mountain Dew (750 ml)", 35, 10));
        items.put(18, new Item("Diet Coke (300 ml)", 40, 10));
        items.put(19, new Item("Thums Up Soft Drink (250 ml)", 20, 10));
        items.put(20, new Item("Fanta Grape Flavoured Drink (320 ml)", 90, 10));
        items.put(21, new Item("Britannia Winkin Cow Chocolate Thick Milkshake (180 ml)", 35, 10));
        items.put(22, new Item("Britannia Winkin Cow Badam Milkshake (180 ml)", 35, 10));
        items.put(23, new Item("Milky Mist Milk Shake Strawberry (220 ml)", 35, 10));
        items.put(24, new Item("Hersheys Milk Shake Vanilla Ice Cream Flavour (180 ml)", 45, 10));
        items.put(25, new Item("Sunfeast Dark Fantasy Café Mocha Milk Shake (300 ml)", 50, 10));
        return items;
    }
}
