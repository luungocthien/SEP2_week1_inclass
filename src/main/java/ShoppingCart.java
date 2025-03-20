import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {
    public static double calculateItem(int amount, double price) {
        double totalItem = amount * price;
        return totalItem;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a language: ");
        System.out.println("1: English");
        System.out.println("2: Swedish");
        System.out.println("3: Finnish");
        System.out.println("4: Japanese");

        int choice = scanner.nextInt();
        Locale locale = null;

        switch (choice) {
            case 1:
                locale = new Locale("en","EN");
                break;
            case 2:
                locale = new Locale("sv","SE");
                break;
            case 3:
                locale = new Locale("fi","FI");
                break;
            default:
                locale = new Locale("ja", "JP");
                break;
        };

        ResourceBundle rb;
        try {
            rb= ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid language is not on the list");
            rb = ResourceBundle.getBundle("message", new Locale("en", "US"));
        };

        // Prompt the user to enter the number of items they want to purchase.
        System.out.println(rb.getString("totalType"));
        int type = scanner.nextInt();

        double totalCart =0;

        // For each item, ask the user for the price and quantity.
        for (int i = 0; i < type; i++) {

            System.out.println(rb.getString("amount"));
            int amount = scanner.nextInt();

            System.out.println(rb.getString("price"));
            double price = scanner.nextDouble();

            totalCart = totalCart + calculateItem(amount, price);
        }

        // Display the total cost of the shopping cart to the user.
        System.out.printf(rb.getString("totalCart") , totalCart);

        scanner.close();
    };
}
