// Abstract class representing a food item
abstract class Food {
    private String name;
    private double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method to calculate the total cost of the food item
    public abstract double calculateTotalCost(int quantity);
}