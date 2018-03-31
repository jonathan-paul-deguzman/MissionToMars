package main.java;

import main.java.Models.Item;
import main.java.Models.Rocket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Simulation phaseOneSimulation = new Simulation();
        ArrayList<Item> phaseOneItems = phaseOneSimulation.loadItems(new File("assets/space_challenge_phase_1.txt"));
        ArrayList<Rocket> phaseOneU1Rockets = phaseOneSimulation.loadU1Rockets(phaseOneItems);
        int phaseOneTotalBudgetForU1Rockets = phaseOneSimulation.runSimulation(phaseOneU1Rockets);
        ArrayList<Rocket> phaseOneU2Rockets = phaseOneSimulation.loadU2Rockets(phaseOneItems);
        int phaseOneTotalBudgetForU2Rockets = phaseOneSimulation.runSimulation(phaseOneU2Rockets);
        System.out.printf("PHASE 1: The total budget for using U1 rockets is: $%d\n", phaseOneTotalBudgetForU1Rockets);
        System.out.printf("PHASE 1: The total budget for using U2 rockets is: $%d\n", phaseOneTotalBudgetForU2Rockets);

        Simulation phaseTwoSimulation = new Simulation();
        ArrayList<Item> phaseTwoItems = phaseTwoSimulation.loadItems(new File("assets/space_challenge_phase_2.txt"));
        ArrayList<Rocket> phaseTwoU1Rockets = phaseTwoSimulation.loadU1Rockets(phaseTwoItems);
        int phaseTwoTotalBudgetForU1Rockets = phaseTwoSimulation.runSimulation(phaseTwoU1Rockets);
        ArrayList<Rocket> phaseTwoU2Rockets = phaseTwoSimulation.loadU2Rockets(phaseTwoItems);
        int phaseTwoTotalBudgetForU2Rockets = phaseTwoSimulation.runSimulation(phaseTwoU2Rockets);
        System.out.printf("PHASE 2: The total budget for using U1 rockets is: $%d\n", phaseTwoTotalBudgetForU1Rockets);
        System.out.printf("PHASE 2: The total budget for using U2 rockets is: $%d\n", phaseTwoTotalBudgetForU2Rockets);

        String phaseOneBestRocket = (phaseOneTotalBudgetForU1Rockets < phaseOneTotalBudgetForU2Rockets) ? "U1" : "U2";
        String phaseTwoBestRocket = (phaseTwoTotalBudgetForU1Rockets < phaseTwoTotalBudgetForU2Rockets) ? "U1" : "U2";
        System.out.println("\nJourney Plan:");
        System.out.printf("PHASE 1: We will be using %s rockets\n", phaseOneBestRocket);
        System.out.printf("PHASE 2: We will be using %s rockets\n", phaseTwoBestRocket);
    }
}
