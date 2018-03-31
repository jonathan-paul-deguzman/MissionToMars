package main.java.Models;

import main.java.Interfaces.SpaceShip;

public class Rocket implements SpaceShip {

    private long rocketCost;

    private int rocketWeight;

    private int rocketMaxWeightWithItems;

    private int itemWeightCarried;

    private int itemWeightLimit;

    private int currentRocketWeight;


    public Rocket(long rocketCost, int rocketWeight, int rocketMaxWeightWithItems) {
        this.rocketCost = rocketCost;
        this.rocketWeight = rocketWeight;
        this.rocketMaxWeightWithItems = rocketMaxWeightWithItems;
        itemWeightCarried = 0;
        itemWeightLimit = this.rocketMaxWeightWithItems - this.rocketWeight;
        currentRocketWeight = this.rocketWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (item == null || item.getWeight() < 0) return false;
        int potentialRocketWeight = currentRocketWeight + item.getWeight();
        return potentialRocketWeight <= rocketMaxWeightWithItems;
    }

    @Override
    public void carry(Item item) {
        if (item == null) return;
        currentRocketWeight += item.getWeight();
        itemWeightCarried += item.getWeight();
    }

    public long getRocketCost() {
        return rocketCost;
    }

    public void setRocketCost(long rocketCost) {
        this.rocketCost = rocketCost;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public void setRocketWeight(int rocketWeight) {
        this.rocketWeight = rocketWeight;
    }

    public int getRocketMaxWeightWithItems() {
        return rocketMaxWeightWithItems;
    }

    public void setRocketMaxWeightWithItems(int rocketMaxWeightWithItems) {
        this.rocketMaxWeightWithItems = rocketMaxWeightWithItems;
    }

    public int getItemWeightCarried() {
        return itemWeightCarried;
    }

    public void setItemWeightCarried(int itemWeightCarried) {
        this.itemWeightCarried = itemWeightCarried;
    }

    public int getItemWeightLimit() {
        return itemWeightLimit;
    }

    public void setItemWeightLimit(int itemWeightLimit) {
        this.itemWeightLimit = itemWeightLimit;
    }

    public int getCurrentRocketWeight() {
        return currentRocketWeight;
    }

    public void setCurrentRocketWeight(int currentRocketWeight) {
        this.currentRocketWeight = currentRocketWeight;
    }
}
