
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Offer> offers = new ArrayList<>();

        items.add(new Item("Keyboard", 800));
        items.add(new Item("Headphones", 1500));

        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("================================");
        System.out.println("       Welcome to ReLoop");
        System.out.println("================================");

        do {
            System.out.println("\n===== ReLoop Menu =====");
            System.out.println("1. View Items");
            System.out.println("2. Add Item");
            System.out.println("3. Make an Offer");
            System.out.println("4. Review Offers");
            System.out.println("5. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1:
                    if (items.isEmpty()) {
                        System.out.println("No items available.");
                    } else {
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println("\nItem #" + (i + 1));
                            items.get(i).displayDetails();
                        }
                    }
                    break;

                case 2:
                    String name;

                    do {
                        System.out.print("Enter item name: ");
                        name = sc.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println(
                                    "Item name cannot be empty. Try again."
                            );
                        }
                    } while (name.isEmpty());

                    double price;

                    do {
                        price = readDouble(sc, "Enter asking price: ");

                        if (price <= 0) {
                            System.out.println(
                                    "Price must be greater than zero. Try again."
                            );
                        }
                    } while (price <= 0);

                    items.add(new Item(name, price));
                    System.out.println("Item added successfully!");
                    break;

                case 3:
                    if (items.isEmpty()) {
                        System.out.println("No items available.");
                        break;
                    }

                    for (int i = 0; i < items.size(); i++) {
                        System.out.println("\nItem #" + (i + 1));
                        items.get(i).displayDetails();
                    }

                    int itemChoice;

                    do {
                        itemChoice = readInt(sc, "Select item number: ");

                        if (itemChoice < 1 || itemChoice > items.size()) {
                            System.out.println(
                                    "Invalid item selection. Try again."
                            );
                        }
                    } while (
                            itemChoice < 1 || itemChoice > items.size()
                    );

                    Item selectedItem = items.get(itemChoice - 1);

                    double offerPrice;

                    do {
                        offerPrice = readDouble(
                                sc, "Enter your offer price: "
                        );

                        if (offerPrice <= 0) {
                            System.out.println(
                                    "Offer must be greater than zero. Try again."
                            );
                        }
                    } while (offerPrice <= 0);

                    offers.add(new Offer(selectedItem, offerPrice));
                    System.out.println("Offer submitted successfully!");
                    break;

                case 4:
                    if (offers.isEmpty()) {
                        System.out.println("No offers to review.");
                        break;
                    }

                    for (int i = 0; i < offers.size(); i++) {
                        System.out.println("\nOffer #" + (i + 1));
                        offers.get(i).displayDetails();
                    }

                    int offerChoice;

                    do {
                        offerChoice = readInt(
                                sc, "Select offer number: "
                        );

                        if (offerChoice < 1 || offerChoice > offers.size()) {
                            System.out.println(
                                    "Invalid offer selection. Try again."
                            );
                        }
                    } while (
                            offerChoice < 1 || offerChoice > offers.size()
                    );

                    Offer selectedOffer = offers.get(offerChoice - 1);

                    if (!selectedOffer.status.equals("Pending")) {
                        System.out.println(
                                "This offer has already been processed."
                        );
                        break;
                    }

                    System.out.println("\n1. Accept");
                    System.out.println("2. Reject");
                    System.out.println("3. Counteroffer");

                    int action;

                    do {
                        action = readInt(sc, "Choose seller action: ");

                        if (action < 1 || action > 3) {
                            System.out.println(
                                    "Invalid action. Enter 1, 2, or 3."
                            );
                        }
                    } while (action < 1 || action > 3);

                    switch (action) {
                        case 1:
                            selectedOffer.status = "Accepted";
                            System.out.println("Offer accepted!");
                            break;

                        case 2:
                            selectedOffer.status = "Rejected";
                            System.out.println("Offer rejected.");
                            break;

                        case 3:
                            double counter;

                            do {
                                counter = readDouble(
                                        sc, "Enter counteroffer price: "
                                );

                                if (counter <= 0) {
                                    System.out.println(
                                            "Price must be greater than zero. Try again."
                                    );
                                }
                            } while (counter <= 0);

                            selectedOffer.counterPrice = counter;
                            selectedOffer.status = "Countered";

                            System.out.println("Counteroffer submitted!");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using ReLoop!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please enter 1 to 5."
                    );
            }

        } while (choice != 5);

        sc.close();
    }

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid whole number."
                );
            }
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            try {
                double value = Double.parseDouble(sc.nextLine().trim());

                if (!Double.isFinite(value)) {
                    System.out.println(
                            "Please enter a finite numeric amount."
                    );
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid numeric amount."
                );
            }
        }
    }
}
