package project;
class Manager extends Person {
    private String role;

    public Manager(String name, int id){
        this(name, id, "Inventory Manager");
    }

    public Manager(String name, int id, String role){
        super(name, id);
        this.role = role;
    }

    public String getRole(){
        return role;
    }
    public final void auditInventory() {
        System.out.println("Manager " + name + " performed an inventory audit.");
    }

    public void displayInfo() {
        System.out.println("Manager: " + name + " | ID: " + id + " | Role: " + role);
    }
}
