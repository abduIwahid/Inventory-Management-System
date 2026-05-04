package project;
import java.util.*;
class Warehouse {
    private String warehouseName;
    private Map<String, Product> products;

    public Warehouse(String warehouseName) {
        this.warehouseName = warehouseName;
        this.products = new LinkedHashMap<>();
    }

    public String getWarehouseName() { return warehouseName; }

    public void addProduct(Product p) { products.put(p.getSku(), p); }
    public Product removeProduct(String sku) { return products.remove(sku); }
    public Product findProduct(String sku) { return products.get(sku); }

    public List<Product> searchByName(String namePart) {
        List<Product> res = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getName().toLowerCase().contains(namePart.toLowerCase())) res.add(p);
        }
        return res;
    }

    public void listAllProducts() {
        System.out.println("\nWarehouse: " + warehouseName);
        for (Product p : products.values()) p.display();
    }
}
