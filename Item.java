public abstract class Item {
    protected int id;
    protected String name;
    protected int quantity;
    protected double price;
    protected static final int LOW_STOCK_THRESHOLD = 5;

    public Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public abstract String getCategory();
    public abstract double calculateValue();
    public abstract boolean needsSpecialHandling();

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    public boolean isLowStock() {
        return quantity <= LOW_STOCK_THRESHOLD;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | Qty: %d | Price: $%.2f | Value: $%.2f%s", 
                           id, name, quantity, price, calculateValue(),
                           isLowStock() ? " [LOW STOCK]" : "");
    }
}