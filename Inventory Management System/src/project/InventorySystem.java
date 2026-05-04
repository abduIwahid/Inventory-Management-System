package project;
import java.util.*;
class InventorySystem {
    private final String company = AppConstants.ims;
    private Manager manager;
    private Map<String, Warehouse> warehouses;
    private List<Supplier> suppliers;

    public InventorySystem(Manager manager) {
        this.manager = manager;
        this.warehouses = new LinkedHashMap<>();
        this.suppliers = new ArrayList<>();
    }

    public void addWarehouse(Warehouse w){
        warehouses.put(w.getWarehouseName(), w);
    }
    public Warehouse getWarehouse(String name){
        return warehouses.get(name);
    }
    public void addSupplier(Supplier s){
        suppliers.add(s);}

    public void showInventory(){
        System.out.println(company);
        manager.displayInfo();
        manager.auditInventory();
        System.out.println("--------------------------------------");
        for (Warehouse w : warehouses.values()) w.listAllProducts();
    }

    public boolean issueProduct(String warehouseName, String sku, int qty){
        Warehouse w = warehouses.get(warehouseName);
        if (w == null)
            return false;
        Product p = w.findProduct(sku);
        if (p == null)
            return false;
        if (p.getQuantity() < qty)
            return false;
        p.setQuantity(p.getQuantity() - qty);
            return true;
    }

    public void receiveStock(String warehouseName, String sku, int qty){
        Warehouse w = warehouses.get(warehouseName);
        if (w == null)
            return;
        Product p = w.findProduct(sku);
        if (p != null)
            p.setQuantity(p.getQuantity() + qty);
    }
}
