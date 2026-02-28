package sims.actions;

import java.util.Scanner;
import sims.entity.*;
import sims.needs.*;

public class Sleep implements SimAction{

    @Override
    public void execute(SimProfile currentSim){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1. Sleep");
        System.out.println("2. Nap");
        String sleepType = scanner.nextLine();

        Needs needs = currentSim.getNeeds();

        switch(sleepType){
            case "1":
                needs.setEnergy(needs.getEnergy() + 70);
                System.out.println(currentSim.getName() + " had a blissful sleep. (+70 Energy)");
                break;
            case "2":
                needs.setEnergy(needs.getEnergy() + 55);
                System.out.println(currentSim.getName() + " took a short nap. (+55 Energy)");
                break;
            default:
                System.out.println("Please enter a valid number: ");
                sleepType = ""; // declare sleepType to be empty so the loop starts again
        }
    }
}
