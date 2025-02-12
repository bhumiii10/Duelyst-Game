package main;

public class TurnManager {
    private int turnNumber;
    private final HumanPlayer player;
    private final ResourceManager resourceManager;

    public TurnManager(HumanPlayer player, ResourceManager resourceManager) {
        this.turnNumber = 1; // Game starts at Turn 1
        this.player = player;
        this.resourceManager = resourceManager;
    }

    public void startNewTurn() {
        System.out.println("\n--- Turn " + turnNumber + " ---");
        System.out.println(player.getName() + "'s turn");

        // Regenerate mana based on turn number (ensuring it doesn't exceed the max limit)
        resourceManager.regenerateMana(player, turnNumber);

        // Reset movement and attack actions for player's units (not needed in Sprint 1)
        resetUnitActions();

        // Move to next turn
        turnNumber++;
    }

    private void resetUnitActions() {
        System.out.println("Resetting unit actions for " + player.getName());
        // Later, loop through player units and reset movement/attack flags
        // Example:
        // for (GameUnit unit : player.getUnits()) {
        //     unit.resetActions();
        // }
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public HumanPlayer getPlayer() {
        return player;
    }
}


