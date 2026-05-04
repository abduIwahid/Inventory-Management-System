package project;
import java.util.*;
public class Inventory_Management_System {
    public static void main(String[] args) {
        Manager mgr = new Manager("Iftikhar Barqi", 101, "Head - Inventory");
        InventorySystem system = new InventorySystem(mgr);

        Warehouse main = new Warehouse("Main Warehouse");
        Warehouse overflow = new Warehouse("Overflow Warehouse");

        
        main.addProduct(new Product("SKU1001", "Laptop", "Electronics", 10, 75000.00));
        main.addProduct(new Product("SKU1002", "Mouse", "Electronics", 150, 500.00));
        main.addProduct(new Product("SKU1003", "Keyboard", "Electronics", 120, 1200.00));

        overflow.addProduct(new Product("SKU2001", "Office Chair", "Furniture", 25, 4500.00));
        overflow.addProduct(new Product("SKU2002", "Desk", "Furniture", 10, 12000.00));

        
        system.addWarehouse(main);
        system.addWarehouse(overflow);

        system.addSupplier(new Supplier("Tech Distributors", "tech@suppliers.com"));
        system.addSupplier(new Supplier("Office Goods Co.", "office@suppliers.com"));

        Scanner sc = new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("""
                               1. Show Inventory
                               2. Issue Product
                               3. Receive Stock
                               4. Search Product
                               5. Exit""");
            System.out.print("Enter Choice : ");
            int ch = -1;
            try {
                ch = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                ch = -1;
            }
            switch (ch) {
                case 1:
                    system.showInventory();
                    break;

                case 2: {
                    System.out.print("Warehouse name: ");
                    String wname = sc.nextLine().trim();
                    System.out.print("SKU to issue: ");
                    String sku = sc.nextLine().trim();
                    System.out.print("Quantity: ");
                    int q = Integer.parseInt(sc.nextLine().trim());
                    boolean ok = system.issueProduct(wname, sku, q);
                    System.out.println(ok ? "Issued successfully." : "Issue failed (not found / insufficient stock).");
                    break;
                }

                case 3: {
                    System.out.print("Warehouse name: ");
                    String wname = sc.nextLine().trim();
                    System.out.print("SKU to receive: ");
                    String sku = sc.nextLine().trim();
                    System.out.print("Quantity: ");
                    int q = Integer.parseInt(sc.nextLine().trim());
                    system.receiveStock(wname, sku, q);
                    System.out.println("Stock updated (if SKU existed).");
                    break;
                }

                case 4:
                    System.out.print("Search term (name): ");
                    String term = sc.nextLine().trim();
                    List<Warehouse> warehouseList = Arrays.asList(main, overflow);

                    for (int i = 0; i < warehouseList.size(); i++) {
                        Warehouse w = warehouseList.get(i);
                        List<Product> found = w.searchByName(term);
                        if (!found.isEmpty()) {
                            System.out.println("\nFound in " + w.getWarehouseName() + ":");

                            for (int j = 0; j < found.size(); j++) {
                                Product p = found.get(j);
                                p.display();
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting. Goodbye.");
                    break OUTER;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
