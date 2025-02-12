package main;

public class GameUnit {
    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    public String getName() {
        return name;
    }

    private int health;
    @SuppressWarnings({"unused", "FieldMayBeFinal"})
    private int attack;

    public GameUnit(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public void heal(int amount) {
        health += amount;
    }

    public boolean isAlive() {
        return health > 0;
    }
}

