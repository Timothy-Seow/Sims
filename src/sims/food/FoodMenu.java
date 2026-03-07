package sims.food;

import sims.actions.*;
import sims.entity.SimProfile;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class FoodMenu {
    private List<SimAction> foodOptions;

    public FoodMenu() {
        this.foodOptions = new ArrayList<>();
        initializeFoodOptions();
    }

    private void initializeFoodOptions() {
        foodOptions.add(new EatAction(new Burger()));
        foodOptions.add(new EatAction(new Pizza()));
        // Add more food types here later
    }

    public void displayFoodOptions() {
        System.out.println("\n--- Available Food ---");
        for (int i = 0; i < foodOptions.size(); i++) {
            System.out.println((i + 1) + ". " + foodOptions.get(i).getDescription());
        }
    }

    public boolean selectFood(SimProfile currentSim, Scanner scanner) {
        displayFoodOptions();
        System.out.print("Choose food: ");
        String foodChoice = scanner.nextLine();

        try {
            int foodIndex = Integer.parseInt(foodChoice) - 1;
            if (foodIndex >= 0 && foodIndex < foodOptions.size()) {
                SimAction selectedFood = foodOptions.get(foodIndex);
                selectedFood.execute(currentSim);
                System.out.println("You are now back in the kitchen.");
                return true; // Stay in current room
            } else {
                System.out.println("Invalid food selection. Try again.");
                return true; // Stay in current room
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return true; // Stay in current room
        }
    }

    public void addFood(SimAction foodAction) {
        foodOptions.add(foodAction);
    }
    
}
