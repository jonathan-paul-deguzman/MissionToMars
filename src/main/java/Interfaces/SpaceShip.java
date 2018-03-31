package main.java.Interfaces;

import main.java.Models.Item;

public interface SpaceShip {

    /**
     * Determines the probability of successfully launching the Space Ship. Implementations of this method should
     * calculate the probability of a successful launch.
     *
     * @return true or false based on the success of the launching
     */
    boolean launch();

    /**
     * Determines the probability of successfully landing the Space Ship. Implementations of this method should
     * calculate the probability of a successful landing.
     *
     * @return true or false based on the success of the landing
     */
    boolean land();

    /**
     * Determines if the specified item can be added on to the Space Ship or not. Implementations of this method should
     * determine the max amount of item weight the Space Ship can hold.
     *
     * @param item the item to potentially add as cargo
     * @return true or false based on if adding the item can fit as cargo on the Space Ship
     */
    boolean canCarry(Item item);

    /**
     * Adds the specified item to the Space Ship.
     *
     * @param item the item to add as cargo
     */
    void carry(Item item);
}
