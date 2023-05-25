import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FoodDeliverySystem deliverySystem = new FoodDeliverySystem();
        Scanner scanner = new Scanner(System.in);
        
        // Adding food items to the menu
        // Adding drinks to the menu
        deliverySystem.addToMenu(new Drink("Cola", 2.99, "Regular"));
        deliverySystem.addToMenu(new Drink("Pepsi", 2.99, "Regular"));
        deliverySystem.addToMenu(new Drink("Sprite", 2.99, "Regular"));
        deliverySystem.addToMenu(new Drink("Mirinda", 2.99, "Regular"));
        deliverySystem.addToMenu(new Drink("Fanta", 2.99, "Regular"));
        deliverySystem.addToMenu(new Drink("Lemon Mint", 3.99, "Large"));

        // Adding pizza to the menu
        deliverySystem.addToMenu(new Pizza("Margherita", 10.99, "Large"));
        deliverySystem.addToMenu(new Pizza("Pepperoni", 12.99, "Medium"));
        deliverySystem.addToMenu(new Pizza("Hawaiian", 11.99, "Medium"));
        deliverySystem.addToMenu(new Pizza("Mushroom", 10.99, "Large"));
        deliverySystem.addToMenu(new Pizza("Chicken BBQ", 13.99, "Large"));
        deliverySystem.addToMenu(new Pizza("Meat Lover", 14.99, "Medium"));
        deliverySystem.addToMenu(new Pizza("Vegetarian", 11.99, "Medium"));
        deliverySystem.addToMenu(new Pizza("Supreme", 13.99, "Large"));

        
        System.out.println("\n****Food Delivery System****\n");
        int choice = 0;
        while (choice != 5) {
            System.out.println("User Menu:");
            System.out.println("1. Add new food item");
            System.out.println("2. Remove food item");
            System.out.println("3. Show all food items");
            System.out.println("4. Order food");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter which food item you want to add:(Pizza or Drink) ");
                    String name = scanner.next();
                    System.out.print("Enter the food item name:");
                    String name_f = scanner.next();
                    System.out.print("Enter the price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter the size: ");
                    String size = scanner.next();
                    
                    // Create and add the new food item to the menu
                    if (name.equalsIgnoreCase("pizza")) {
                        deliverySystem.addToMenu(new Pizza(name_f, price, size));
                        System.out.println("Food item 'Pizza' added successfully!");
                    } else if (name.equalsIgnoreCase("drink"))  {
                        deliverySystem.addToMenu(new Drink(name_f, price, size));
                        System.out.println("Food item 'Drink' added successfully!");
                    }else {
                    	System.out.println("Invalid Item!(Only have Pizza and Drink)");
                    }
                    
                    break;
                case 2:
                	deliverySystem.showMenu();
                    System.out.print("Enter the index of the food item to remove: ");
                    int index = scanner.nextInt();
                    
                    // Remove the food item from the menu
                    boolean removed = deliverySystem.removeFromMenu(index);
                    if (removed) {
                        System.out.println("Food item removed successfully!");
                    } else {
                        System.out.println("Invalid index. Food item removal failed!");
                    }
                    break;
                case 3:
                    // Show all food items in the menu
                    deliverySystem.showMenu();
                    break;
                case 4:
                	deliverySystem.showMenu();
                    System.out.print("\nEnter the index of the food item to order: ");
                    int orderIndex = scanner.nextInt();
                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String cname = scanner.nextLine();
                    System.out.print("Enter the customer address: ");
                    String address = scanner.nextLine();
                    
                    
                    // Place an order for the selected food item
                    try {
                        Food foodItem = deliverySystem.getMenu().get(orderIndex);
                        double totalCost = deliverySystem.placeOrder(foodItem, quantity);
                        Customer c = new Customer(cname,address);
                        System.out.print("\nCustomer Details\n");
                        System.out.print(c.toString()+"\n");
                        System.out.println("Total cost: $" + totalCost);
                        System.out.println("\n-----------------------------------------------\n");
                    } catch (InvalidQuantityException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index. Order placement failed!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
        
        scanner.close();
    }
}