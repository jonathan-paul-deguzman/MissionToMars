package test.java;

import main.java.Models.Item;
import main.java.Models.Rocket;
import main.java.Models.U1;
import main.java.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    private Simulation simulation;

    private File file;

    private ArrayList<Item> itemsLoadedFromFile;

    private String validFileName = "assets/space_challenge_phase_1.txt";

    private String sampleDataTestFileName = "assets/test_values_sample_data.txt";

    private String invalidFormatTestFileName = "assets/test_values_invalid_format.txt";

    private String emptyFileTestFileName = "assets/test_values_empty_file.txt";

    @BeforeEach
    public void createFile() throws FileNotFoundException {
        simulation = new Simulation();
        file = new File(validFileName);
        itemsLoadedFromFile = simulation.loadItems(file);
    }

    @Test
    public void Given_ValidFile_When_LoadingItemsFromTextFile_Then_ReturnArrayListOfItems() {
        assertNotNull(itemsLoadedFromFile);
        assertTrue(itemsLoadedFromFile.size() > 0);
    }

    @Test
    public void Given_InvalidFileName_When_LoadingItemsFromTextFile_Then_ThrowFileNotFoundException() {
        Executable invalidFileNameArgumentClosure = () -> simulation.loadItems(new File("space_challenge"));
        assertThrows(FileNotFoundException.class, invalidFileNameArgumentClosure);
    }

    @Test
    public void Given_InvalidDataFromFile_When_LoadingItemsFromTextFile_Then_ThrowNumberFormatException() {
        Executable invalidNumberFormatArgumentClosure = () -> simulation.loadItems(new File(invalidFormatTestFileName));
        assertThrows(NumberFormatException.class, invalidNumberFormatArgumentClosure);
    }

    @Test
    public void Given_SampleItemsForLoading_When_CreatingListOfU1Rockets_Then_ReturnTwoU1Rockets() throws FileNotFoundException {
        itemsLoadedFromFile = simulation.loadItems(new File(sampleDataTestFileName));
        ArrayList<Rocket> listOfU1Rockets = simulation.loadU1Rockets(itemsLoadedFromFile);
        assertEquals(2, listOfU1Rockets.size());
    }

    @Test
    public void Given_ItemListIsEmpty_When_CreatingListOfU1Rockets_Then_ReturnEmptyArrayListOfU1Rockets() throws FileNotFoundException {
        itemsLoadedFromFile = simulation.loadItems(new File(emptyFileTestFileName));
        assertEquals(0, simulation.loadU1Rockets(itemsLoadedFromFile).size());
    }

    @Test
    public void Given_SampleItemsForLoading_When_CreatingListOfU2Rockets_Then_ReturnOneU2Rocket() throws FileNotFoundException {
        itemsLoadedFromFile = simulation.loadItems(new File(sampleDataTestFileName));
        ArrayList<Rocket> listOfU1Rockets = simulation.loadU2Rockets(itemsLoadedFromFile);
        assertEquals(1, listOfU1Rockets.size());
    }

    @Test
    public void Given_ItemListIsEmpty_When_CreatingListOfU2Rockets_Then_ReturnEmptyArrayListOfU2Rockets() throws FileNotFoundException {
        itemsLoadedFromFile = simulation.loadItems(new File(emptyFileTestFileName));
        assertEquals(0, simulation.loadU2Rockets(itemsLoadedFromFile).size());
    }

    @Test
    public void Given_ListOfU1Rockets_When_RunningSimulation_Then_ReturnTotalBudgetOfSendingRockets() {
        int totalBudget = simulation.runSimulation(createListOfRockets());
        assertTrue(totalBudget >= 400000000);
    }

    private ArrayList<Rocket> createListOfRockets() {
        Rocket rocket1 = new U1();
        rocket1.setItemWeightCarried(5000);
        Rocket rocket2 = new U1();
        rocket2.setItemWeightCarried(4000);
        Rocket rocket3 = new U1();
        rocket3.setItemWeightCarried(5000);
        Rocket rocket4 = new U1();
        rocket4.setItemWeightCarried(6000);
        ArrayList<Rocket> listOfU1Rockets = new ArrayList<>();
        listOfU1Rockets.add(rocket1);
        listOfU1Rockets.add(rocket2);
        listOfU1Rockets.add(rocket3);
        listOfU1Rockets.add(rocket4);
        return listOfU1Rockets;
    }
}
