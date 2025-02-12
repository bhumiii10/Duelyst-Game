package main;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    public void displayStats() {
        System.out.println(name + " - Health: " + getHealth() + ", Mana: " + getMana());
    }
}
