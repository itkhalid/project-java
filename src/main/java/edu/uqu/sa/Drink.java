// Concrete class representing a drink
class Drink extends Food {
    private String size;

    public Drink(String name, double price, String size) {
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
        return "Drink Name= " + getName() + ", size= " + size + ", price= " + getPrice();
    }
}