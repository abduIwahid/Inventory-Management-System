package project;
class Product {
    private final String sku;
    private String name;
    private String category;
    private int quantity;
    private double price;

    public Product(String sku, String name, String category, int quantity, double price) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    public void display() {
        System.out.printf("SKU: %s | %s | Cat: %s | Qty: %d | Price: %.2f\n", sku, name, category, quantity, price);
    }
}
