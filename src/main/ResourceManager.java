package main;

import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    private final Map<Player, Integer> manaPool = new HashMap<>();
    private static final int MAX_MANA = 9;

    public void setMana(Player player, int amount) {
        manaPool.put(player, Math.min(amount, MAX_MANA));
    }

    public int getMana(Player player) {
        return manaPool.getOrDefault(player, 0);
    }

    public boolean useMana(Player player, int cost) {
        int currentMana = getMana(player);
        if (currentMana >= cost) {
            manaPool.put(player, currentMana - cost);
            return true;
        }
        return false;
    }

    public void regenerateMana(Player player, int turnNumber) {
        int newMana = Math.min(turnNumber + 1, MAX_MANA);
        manaPool.put(player, newMana);
    }
}

