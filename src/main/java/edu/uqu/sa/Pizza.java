// Concrete class representing a pizza
class Pizza extends Food {
    private String size;

    public Pizza(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double calculateTotalCost(int quantity) {
        return getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Pizza Name= " + getName() + ", size= " + size + ", price= " + getPrice();
    }
}