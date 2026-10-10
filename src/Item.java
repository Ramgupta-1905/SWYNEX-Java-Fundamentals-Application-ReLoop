
public class Item {
    String itemName;
    double askingPrice;

    public Item(String itemName, double askingPrice) {
        this.itemName = itemName;
        this.askingPrice = askingPrice;
    }

    public void displayDetails() {
        System.out.println("Item: " + itemName);
        System.out.printf("Asking Price: Rs. %.2f%n", askingPrice);
    }
}
