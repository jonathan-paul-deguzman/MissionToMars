package main.java.Interfaces;

import main.java.Models.Item;

public interface SpaceShip {

    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);
}
