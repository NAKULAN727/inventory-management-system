import java.util.*;
import java.time.LocalDate;

public class InventoryManager {
    private Map<Integer, Item> inventory = new HashMap<>();
    private int nextId = 1;

    public void addElectronics(String name, int quantity, double price, int warranty) {
        Item item = new Electronics(nextId++, name, quantity, price, warranty);
        inventory.put(item.getId(), item);
        System.out.println("Electronics added successfully!");
    }

    public void addClothing(String name, int quantity, double price, String size) {
        Item item = new Clothing(nextId++, name, quantity, price, size);
        inventory.put(item.getId(), item);
        System.out.println("Clothing added successfully!");
    }

    public void addFood(String name, int quantity, double price, LocalDate expiry) {
        Item item = new Food(nextId++, name, quantity, price, expiry);
        inventory.put(item.getId(), item);
        System.out.println("Food item added successfully!");
    }

    public void viewAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        System.out.println("\n--- INVENTORY ---");
        for (Item item : inventory.values()) {
            System.out.println(item.getCategory() + ": " + item);
        }
    }

    public void showLowStockAlerts() {
        System.out.println("\n--- LOW STOCK ALERTS ---");
        boolean hasLowStock = false;
        for (Item item : inventory.values()) {
            if (item.isLowStock()) {
                System.out.println("⚠️  " + item);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("No low stock items.");
        }
    }

    public void calculateTotalValue() {
        double total = inventory.values().stream()
                      .mapToDouble(Item::calculateValue)
                      .sum();
        System.out.printf("\nTotal Inventory Value: $%.2f\n", total);
    }

    public void updateQuantity(int id, int newQuantity) {
        Item item = inventory.get(id);
        if (item != null) {
            item.setQuantity(newQuantity);
            System.out.println("Quantity updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void searchProduct(int id) {
        Item item = inventory.get(id);
        if (item != null) {
            System.out.println(item.getCategory() + ": " + item);
        } else {
            System.out.println("Product not found!");
        }
    }
}