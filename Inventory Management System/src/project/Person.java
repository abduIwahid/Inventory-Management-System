package project;
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;}
    public int getId(){
        return id;
    }
    public void setName(String name){ 
        this.name = name; 
    }
}
