public class Electronics extends Item {
    private int warrantyMonths;

    public Electronics(int id, String name, int quantity, double price, int warrantyMonths) {
        super(id, name, quantity, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public double calculateValue() {
        return quantity * price * 1.1; // 10% markup for electronics
    }

    @Override
    public boolean needsSpecialHandling() {
        return true; // Electronics need careful handling
    }

    public int getWarrantyMonths() { return warrantyMonths; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Warranty: %d months", warrantyMonths);
    }
}