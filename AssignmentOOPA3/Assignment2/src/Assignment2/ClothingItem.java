package Assignment2;

class ClothingItem {
    String brand;
    String color;
    String size;
    double price;
    int quantity;
    boolean discount;

    public ClothingItem(String brand, String color, String size, double price, int quantity, boolean discount) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public double getTotal() {
        double total = price * quantity;
        return discount ? total * 0.6 : total;
    }
}
