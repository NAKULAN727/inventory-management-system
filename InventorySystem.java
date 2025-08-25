import java.util.Scanner;
import java.time.LocalDate;

public class InventorySystem {
    private static InventoryManager manager = new InventoryManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SMART INVENTORY MANAGEMENT SYSTEM ===");
        
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addProductMenu(); break;
                case 2: manager.viewAllProducts(); break;
                case 3: manager.showLowStockAlerts(); break;
                case 4: manager.calculateTotalValue(); break;
                case 5: updateQuantity(); break;
                case 6: searchProduct(); break;
                case 7: 
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("\n1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Low Stock Alerts");
        System.out.println("4. Calculate Total Value");
        System.out.println("5. Update Quantity");
        System.out.println("6. Search Product");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addProductMenu() {
        System.out.println("\nSelect product type:");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Food");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        
        switch (type) {
            case 1:
                System.out.print("Enter warranty months: ");
                int warranty = scanner.nextInt();
                manager.addElectronics(name, quantity, price, warranty);
                break;
            case 2:
                System.out.print("Enter size: ");
                String size = scanner.nextLine();
                manager.addClothing(name, quantity, price, size);
                break;
            case 3:
                System.out.print("Enter expiry date (YYYY-MM-DD): ");
                String dateStr = scanner.nextLine();
                LocalDate expiry = LocalDate.parse(dateStr);
                manager.addFood(name, quantity, price, expiry);
                break;
            default:
                System.out.println("Invalid product type!");
        }
    }

    private static void updateQuantity() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        manager.updateQuantity(id, quantity);
    }



    private static void searchProduct() {
        System.out.print("Enter product ID to search: ");
        int id = scanner.nextInt();
        manager.searchProduct(id);
    }
}