package sprint1;

import main.HumanPlayer;
import main.ResourceManager;
import main.TurnManager;

public class ID5 {
    public static void main(String[] args) {
        // Initialize player and resource manager
        
        HumanPlayer player = new HumanPlayer("Player1");
        ResourceManager resourceManager = new ResourceManager();
        TurnManager turnManager = new TurnManager(player, resourceManager);

        // Show initial mana
        System.out.println("Initial Mana: " + player.getMana()); // Expected: 2

        // Start new turns and check mana increase
        turnManager.startNewTurn();
        System.out.println("Mana after turn 2: " + player.getMana()); // Expected: 3

        turnManager.startNewTurn();
        System.out.println("Mana after turn 3: " + player.getMana()); // Expected: 4
    }
}

