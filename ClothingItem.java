package Assignment2;

public class ClothingItem {
    protected String brand, color, size;
    protected double price;
    protected int quantity;
    protected boolean discount;

    public ClothingItem(String brand, String color, String size, double price, int quantity, boolean discount) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public double getTotal() {
        double subtotal = price * quantity;
        if (discount) {
            subtotal *= 0.6; // 40% off
        }
        return subtotal;
    }

    // Overloaded method
    public double getTotal(boolean includeTax) {
        double total = getTotal();
        if (includeTax) {
            total *= 1.06; // 6% tax
        }
        return total;
    }

    public String getType() {
        return "Generic Clothing";
    }
}
