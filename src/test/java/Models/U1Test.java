package test.java.Models;

import main.java.Models.Rocket;
import main.java.Models.U1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class U1Test {

    private Rocket rocket;

    @BeforeEach
    public void createRocket() {
        rocket = new U1();
    }

    @Test
    public void Given_ValidItemWeightAndItemWeightLimit_When_LaunchingTheRocket_Then_ReturnTrue() {
        rocket.setItemWeightCarried(1000);
        rocket.setItemWeightLimit(8000);
        assertTrue(rocket.launch());
    }

    @Test
    public void Given_ExplosionProbabilityExceeds100Percent_When_LaunchingTheRocket_Then_ReturnFalse() {
        rocket.setItemWeightCarried(5000);
        rocket.setItemWeightLimit(1);
        assertFalse(rocket.launch());
    }

    @Test
    public void Given_ValidItemWeightAndItemWeightLimit_When_LandingTheRocket_Then_ReturnTrue() {
        rocket.setItemWeightCarried(1000);
        rocket.setItemWeightLimit(8000);
        assertTrue(rocket.land());
    }

    @Test
    public void Given_CrashProbabilityExceeds100Percent_When_LandingTheRocket_Then_ReturnFalse() {
        rocket.setItemWeightCarried(5000);
        rocket.setItemWeightLimit(1);
        assertFalse(rocket.land());
    }
}
