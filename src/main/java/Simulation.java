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

    /**
     * Loads the items from a text file. Each line contains the item name, followed by a '=', and its weight in Kgs.
     *
     * @param file the text file provided by the user
     * @return items the ArrayList of {@link Item} objects
     * @throws FileNotFoundException if the File is misspelled, not found, or invalid
     * @throws NumberFormatException if the File contains lines that aren't of the format 'String=Integer'
     */
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

    /**
     * Creates U1 rockets by trying to fill up 1 rocket with as many items as possible before creating a new rocket
     * object and filling that one until all items are loaded.
     *
     * @param itemsForLoading the ArrayList of items returned from the loadItems method
     * @return filledU1Rockets the ArrayList of {@link U1} rocket objects that are fully loaded
     */
    public ArrayList<Rocket> loadU1Rockets(ArrayList<Item> itemsForLoading) {
        ArrayList<Rocket> filledU1Rockets = new ArrayList<>();
        Rocket rocket = new U1();
        for (Item item : itemsForLoading) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                filledU1Rockets.add(rocket);
                // Create new U1 rocket and add our excess item to it
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

    /**
     * Creates U2 rockets by trying to fill up 1 rocket with as many items as possible before creating a new rocket
     * object and filling that one until all items are loaded.
     *
     * @param itemsForLoading the ArrayList of items returned from the loadItems method
     * @return filledU1Rockets the ArrayList of {@link U2} rocket objects that are fully loaded
     */
    public ArrayList<Rocket> loadU2Rockets(ArrayList<Item> itemsForLoading) {
        ArrayList<Rocket> filledU2Rockets = new ArrayList<>();
        Rocket rocket = new U2();
        for (Item item : itemsForLoading) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                filledU2Rockets.add(rocket);
                // Create a new U2 rocket and add our excess item to it
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

    /**
     * Simulates launching and landing the rockets; every time a rocket explodes or crashes it must be sent again.
     *
     * @param rocketsForSimulation the ArrayList of {@link Rocket} objects returned from loadU1Rockets or loadU2Rockets
     * @return totalBudget the total budget required to send each rocket safely to Mars
     */
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
