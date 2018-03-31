package main.java.Models;

public class U2 extends Rocket {

    private static final long U2_ROCKET_COST = 120000000;

    private static final int U2_ROCKET_WEIGHT_IN_KG = 18000;

    private static final int U2_ROCKET_MAX_WEIGHT_IN_KG = 29000;

    public U2() {
        super(U2_ROCKET_COST, U2_ROCKET_WEIGHT_IN_KG, U2_ROCKET_MAX_WEIGHT_IN_KG);
    }

    @Override
    public boolean launch() {
        double simulatedExplosionNumber = (Math.random() * 1) + 0.01;
        double explosionProbability = 0.04 * (getItemWeightCarried() / getItemWeightLimit());
        return simulatedExplosionNumber > explosionProbability;
    }

    @Override
    public boolean land() {
        double simulatedCrashNumber = (Math.random() * 1) + 0.01;
        double crashProbability = 0.08 * (getItemWeightCarried() / getItemWeightLimit());
        return simulatedCrashNumber > crashProbability;
    }
}
