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
