import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void showHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
        System.out.println();
    }

    public int calculateHandValue() {
        int value = 0;
        for (Card card : hand) {
            Rank rank = card.getRank();
            if (rank == Rank.ACE) {
                value += 11;
            } else if (rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
                value += 10;
            } else {
                value += rank.ordinal() + 1;
            }
        }
        return value;
    }


    public String getName() {
        return name;
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }
}