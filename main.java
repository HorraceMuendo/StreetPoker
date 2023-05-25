import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

enum Suit {
    SPADES,
    HEARTS,
    DIAMONDS,
    CLUBS
}

enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(cards.size() - 1);
    }
}

class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void showHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}

public class CodeStreetPoker {
    private static final int NUM_CARDS_PER_HAND = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create deck
        Deck deck = new Deck();

        // Get player names
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter the name of Player " + i + ": ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }

        // Deal cards to players
        for (int i = 0; i < NUM_CARDS_PER_HAND; i++) {
            for (Player player : players) {
                Card card = deck.drawCard();
                player.addCardToHand(card);
            }
        }

        // Show hands of all players
        for (Player player : players) {
            player.showHand();
        }
    }
}
