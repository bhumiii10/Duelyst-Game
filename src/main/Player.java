package main;

public abstract class Player {
    protected String name;
    protected GameUnit avatar;
    protected int mana;

    private static final int MAX_MANA = 9;

    public Player(String name) {
        this.name = name;
        this.avatar = new GameUnit(name + " Avatar", 20, 5); // Default health: 20, Attack: 5
        this.mana = 2; // Players start with 2 mana
    }

    // Get Player Name
    public String getName() {
        return name;
    }

    // Health Management
    public int getHealth() {
        return avatar.getHealth();
    }

    public void takeDamage(int damage) {
        avatar.takeDamage(damage);
        if (!avatar.isAlive()) {
            System.out.println(name + " has lost the game!");
        }
    }

    public void heal(int amount) {
        avatar.heal(amount);
    }

    // Mana Management
    public int getMana() {
        return mana;
    }

    public boolean useMana(int cost) {
        if (mana >= cost) {
            mana -= cost;
            return true;
        }
        System.out.println(name + " does not have enough mana!");
        return false;
    }

    public void regenerateMana(int turnNumber) {
        mana = Math.min(turnNumber + 1, MAX_MANA); // Regenerate mana based on turn number
    }
}
