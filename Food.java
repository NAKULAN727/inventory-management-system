import java.time.LocalDate;

public class Food extends Item {
    private LocalDate expiryDate;

    public Food(int id, String name, int quantity, double price, LocalDate expiryDate) {
        super(id, name, quantity, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getCategory() {
        return "Food";
    }

    @Override
    public double calculateValue() {
        if (isExpiringSoon()) {
            return quantity * price * 0.5; // 50% discount for expiring food
        }
        return quantity * price;
    }

    @Override
    public boolean needsSpecialHandling() {
        return isExpiringSoon(); // Expiring food needs special handling
    }

    public boolean isExpiringSoon() {
        return expiryDate.isBefore(LocalDate.now().plusDays(7));
    }

    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Expires: %s%s", 
                                              expiryDate, 
                                              isExpiringSoon() ? " [EXPIRING SOON]" : "");
    }
}