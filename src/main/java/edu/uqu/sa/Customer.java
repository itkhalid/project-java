public class Customer {
    private int id;
    private String name;
    private String address;
    
    public Customer(String name, String address) {
    	this.name = name;
        this.address = address;
    }

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer Id= " + id + ", name= " + name +", address= " + address;
    }
}
