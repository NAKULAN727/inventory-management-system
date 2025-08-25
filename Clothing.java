public class Clothing extends Item {
    private String size;

    public Clothing(int id, String name, int quantity, double price, String size) {
        super(id, name, quantity, price);
        this.size = size;
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    @Override
    public double calculateValue() {
        return quantity * price; // Standard value calculation
    }

    @Override
    public boolean needsSpecialHandling() {
        return false; // Clothing doesn't need special handling
    }

    public String getSize() { return size; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Size: %s", size);
    }
}