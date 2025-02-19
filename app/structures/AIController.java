package structures;

import akka.actor.ActorRef;
import events.EndTurnClicked;
import structures.basic.Card;
import structures.basic.Player;

import java.util.ArrayList;
import java.util.List;

import structures.basic.Unit;
import utils.OrderedCardLoader;
import commands.BasicCommands; // Import the BasicCommands

public class AIController extends Player {
    private List<Card> hand;  // Cards that the AI can play
    private List<Card> deck;  // All available cards
    private int health; // AI's health
    private Unit avatar;
    private ActorRef out;

    public AIController(int health, int mana, ActorRef out) {
        super(health, mana);
        this.hand = new ArrayList<>();
        this.deck = OrderedCardLoader.getPlayer2Cards(1);
        this.health = health;
        this.out = out;
    }

    //Getter method to retrieve health of AI
    public int getHealth() {
        return health;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setAvatar(Unit unit) {
        this.avatar = unit;
    }

    public Unit getAvatar() {
        return avatar;
    }

    public void drawInitialHand() {
        for (int i = 0; i < 3; i++) {
            drawCard();
        }
    }

    // The AI draws a card from its deck and adds it to the hand. No need to show on UI
    public void drawCard() {
        if (hand.size() < 6 && !deck.isEmpty()) { // Ensure there's space and deck is not empty
            Card newCard = deck.remove(0); // Draw the first card from the deck
            hand.add(newCard);
        }

    }

    public void playCard(ActorRef out, GameState gameState) {
        //implement AI logic for playing a card


        // Trigger the "End Turn" event after the AI plays its card
        EndTurnClicked endTurnEvent = new EndTurnClicked();
        endTurnEvent.processEvent(out, gameState, null);  // Passing 'null' since the AI isn't clicking, it's automatic
    }

    //Method to deal damage to the AI
    public void takeDamage(int damage, ActorRef out) {
        this.health -= damage;
        BasicCommands.setPlayer2Health(out, this); // **Update UI with new health using BasicCommands**

        if (health <= 0) {
            // Trigger "Victory" screen and stop AI actions
            BasicCommands.addPlayer1Notification(out, "YOU WIN!", 5);
        }
    }
}
