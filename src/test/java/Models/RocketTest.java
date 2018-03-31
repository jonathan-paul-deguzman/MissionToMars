package test.java.Models;

import main.java.Models.Item;
import main.java.Models.Rocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RocketTest {

    private long rocketCost = 100000000;

    private int rocketWeight = 10000;

    private int rocketMaxWeight = 18000;

    private Rocket rocket;

    private Item itemToCarry;

    @BeforeEach
    public void createRocket() {
        rocket = new Rocket(rocketCost, rocketWeight, rocketMaxWeight);
        itemToCarry = new Item("Food", 4000);
    }

    @Test
    public void Given_ItemWeightThatDoesNotExceedCapacity_When_VerifyingIfRocketCanCarryItem_Then_ReturnTrue() {
        rocket.setCurrentRocketWeight(12000);
        assertTrue(rocket.canCarry(itemToCarry));
    }

    @Test
    public void Given_ItemWeightThatExceedsCapacity_When_VerifyingIfRocketCanCarryItem_Then_ReturnFalse() {
        rocket.setCurrentRocketWeight(16000);
        assertFalse(rocket.canCarry(itemToCarry));
    }

    @Test
    public void Given_ItemHasNegativeWeight_When_VerifyingIfRocketCanCarryItem_Then_ReturnFalse() {
        assertFalse(rocket.canCarry(new Item("Food", -2000)));
    }

    @Test
    public void Given_ItemWeightIsBeyondTheSizeOfAnInteger_When_VerifyingIfRocketCanCarryItem_Then_ReturnFalse() {
        assertFalse(rocket.canCarry(new Item("Food", 999999999)));
    }

    @Test
    public void Given_NullItem_When_VerifyingIfRocketCanCarryItem_Then_ReturnFalse() {
        assertFalse(rocket.canCarry(null));
    }

    @Test
    public void Given_Item_WhenAddingItemWeightToCurrentWeight_Then_UpdateCurrentRocketWeightAndItemWeight() {
        rocket.carry(itemToCarry);
        assertAll(
                () -> assertEquals(14000, rocket.getCurrentRocketWeight()),
                () -> assertEquals(4000, rocket.getItemWeightCarried())
        );
    }

    @Test
    public void Given_NullItem_WhenAddingItemWeightToCurrentWeight_Then_DoNotUpdateRocketValues() {
        rocket.carry(null);
        assertAll(
                () -> assertEquals(10000, rocket.getCurrentRocketWeight()),
                () -> assertEquals(0, rocket.getItemWeightCarried())
        );
    }
}
