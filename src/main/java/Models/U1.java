package main.java.Models;

public class U1 extends Rocket {

    private static final long U1_ROCKET_COST = 100000000;

    private static final int U1_ROCKET_WEIGHT_IN_KG = 10000;

    private static final int U1_ROCKET_MAX_WEIGHT_IN_KG = 18000;

    public U1() {
        super(U1_ROCKET_COST, U1_ROCKET_WEIGHT_IN_KG, U1_ROCKET_MAX_WEIGHT_IN_KG);
    }

    @Override
    public boolean launch() {
        double simulatedExplosionNumber = (Math.random() * 1) + 0.01;
        double explosionProbability = 0.05 *  ((double) getItemWeightCarried() / getItemWeightLimit());
        return simulatedExplosionNumber > explosionProbability;
    }

    @Override
    public boolean land() {
        double simulatedCrashNumber = (Math.random() * 1) + 0.01;
        double crashProbability = 0.01 * ((double) getItemWeightCarried() / getItemWeightLimit());
        return simulatedCrashNumber > crashProbability;
    }
}
