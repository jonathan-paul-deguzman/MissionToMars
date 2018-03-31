package main.java;

import main.java.Models.Item;
import main.java.Models.Rocket;
import main.java.Models.U1;
import main.java.Models.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Rocket> loadU1Rockets(ArrayList<Item> itemsForLoading) {
        ArrayList<Rocket> filledU1Rockets = new ArrayList<>();
        Rocket rocket = new U1();
        for (Item item : itemsForLoading) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                filledU1Rockets.add(rocket);
                // Create new main.java.Models.U1 rocket and add our excess item to it
                rocket = new U1();
                rocket.carry(item);
            }
        }
        // Add the last rocket (containing our final items) to the list
        if (rocket.getCurrentRocketWeight() > rocket.getRocketWeight()) {
            filledU1Rockets.add(rocket);
        }
        return filledU1Rockets;
    }

    public ArrayList<Rocket> loadU2Rockets(ArrayList<Item> itemsForLoading) {
        ArrayList<Rocket> filledU2Rockets = new ArrayList<>();
        Rocket rocket = new U2();
        for (Item item : itemsForLoading) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                filledU2Rockets.add(rocket);
                // Create a new main.java.Models.U2 rocket and add our excess item to it
                rocket = new U2();
                rocket.carry(item);
            }
        }
        // Add the last rocket (containing our final items) to the list
        if (rocket.getCurrentRocketWeight() > rocket.getRocketWeight()) {
            filledU2Rockets.add(rocket);
        }
        return filledU2Rockets;
    }

    public ArrayList<Item> loadItems(File file) throws FileNotFoundException, NumberFormatException {
        ArrayList<Item> items = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] itemAndWeightPair = line.split("=");
            String itemName = itemAndWeightPair[0];
            int itemWeight = Integer.parseInt(itemAndWeightPair[1]);
            items.add(new Item(itemName, itemWeight));
        }
        return items;
    }

    public int runSimulation(ArrayList<Rocket> rocketsForSimulation) {
        int totalBudget = 0;
        for (Rocket rocket : rocketsForSimulation) {
            // Loop until current rocket successfully launches AND lands
            while (true) {
                if (rocket.launch() && rocket.land()) {
                    totalBudget += rocket.getRocketCost();
                    break;
                }
                totalBudget += rocket.getRocketCost();
            }
        }
        return totalBudget;
    }

}
