package structures;

import commands.BasicCommands;
import structures.basic.*;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

import java.util.*;

/**
 * This class can be used to hold information about the on-going game.
 * Its created with the GameActor.
 * 
 * @author Dr. Richard McCreadie
 *
 */
public class GameState {
    private int currentTurn;
    private HumanPlayer player1;
    private AIController player2;
    private boolean isHumanTurn;
    private boolean gameInitialized;
    private Board board;
    private Set<Tile> highlightedTiles;  // Track highlighted tiles


    public GameState() {
        this.currentTurn = 1;
        this.isHumanTurn = true; //start with player's turn
        this.gameInitialized = false; //needs to be initialised
        highlightedTiles = new HashSet<>();
    }

    public void initializePlayers(HumanPlayer player1, AIController player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1.setAvatar(BasicObjectBuilders.loadUnit(StaticConfFiles.humanAvatar, 1, Unit.class));
        this.player2.setAvatar(BasicObjectBuilders.loadUnit(StaticConfFiles.aiAvatar, 2, Unit.class));
    }

    public void setBoard(Board board) {
        this.board = board;
        board.placeUnitOnTile(player1.getAvatar(), board.getTile(1, 2));
        board.placeUnitOnTile(player2.getAvatar(), board.getTile(7, 2));
    }

    public void nextTurn() {
        this.isHumanTurn = !this.isHumanTurn;
        if (!isHumanTurn) {
            this.currentTurn++;
        }
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public Player getCurrentPlayer() {
        return isHumanTurn ? player1 : player2;
    }

    public Player getOpponentPlayer() {
        return isHumanTurn ? player2 : player1;
    }

    public void setGameInitialized(boolean initialized) {
        this.gameInitialized = initialized;
    }

    public Board getBoard() {
        return board;
    }

    public void addHighlightedTile(Tile tile) {
        highlightedTiles.add(tile);
    }

    public void clearHighlightedTiles() {
        highlightedTiles.clear();
    }

    public Set<Tile> getHighlightedTiles() {
        return highlightedTiles;
    }

    public boolean isHighlightedTile(Tile tile) {
        return highlightedTiles.contains(tile);
    }

}
