package sprint1;

import main.GameUnit;

public class ID3 {
    public static void main(String[] args) {
        // Create a player with an avatar (GameUnit)
        GameUnit avatar = new GameUnit("Player Avatar", 20, 5);
        
        System.out.println("Initial Health: " + avatar.getHealth()); // Expected: 20

        // Simulate taking damage
        avatar.takeDamage(5);
        System.out.println("Health after taking 5 damage: " + avatar.getHealth()); // Expected: 15

        // Simulate healing
        avatar.heal(3);
        System.out.println("Health after healing 3: " + avatar.getHealth()); // Expected: 18

        // Simulate health reaching 0
        avatar.takeDamage(18);
        System.out.println("Is avatar alive? " + avatar.isAlive()); // Expected: false
    }
}

