import java.util.ArrayList;
import java.util.List;

// Class representing the food delivery system
class FoodDeliverySystem {
    private List<Food> menu;

    public FoodDeliverySystem() {
        menu = new ArrayList<>();
    }

    public List<Food> getMenu() {
		return menu;
	}

	public void addToMenu(Food item) {
        menu.add(item);
    }

    public void showMenu() {
        System.out.println("Menu:");
        int count = 0;
        for (Food item : menu) {
            System.out.println("Index = "+count+" :" +item);
            count++;
        }
    }

    public double placeOrder(Food item, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity should be greater than zero.");
        }

        double totalCost = item.calculateTotalCost(quantity);
        System.out.println("\n-----------------------------------------------\n");
        System.out.println("Order placed: " + item.getName() + " x " + quantity);
        System.out.println("Cost: $" + totalCost);

        return totalCost;
    }

    public boolean removeFromMenu(int index) {
        if (index >= 0 && index < menu.size()) {
            menu.remove(index);
            return true;
        }
        return false;
    }
    
}