
public class Offer {
    Item item;
    double offerPrice;
    String status;
    double counterPrice;

    public Offer(Item item, double offerPrice) {
        this.item = item;
        this.offerPrice = offerPrice;
        this.status = "Pending";
    }

    public void displayDetails() {
        item.displayDetails();
        System.out.printf("Buyer Offer: Rs. %.2f%n", offerPrice);
        System.out.println("Status: " + status);

        if (status.equals("Countered")) {
            System.out.printf(
                    "Seller Counteroffer: Rs. %.2f%n",
                    counterPrice
            );
        }
    }
}
