import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessLogic {
    private Deck deck;
    private List<Player> players;

    public BusinessLogic() {
        deck = new Deck();
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {

        players.add(player);
    }

    public void startGame() {
        deck.shuffle();
        dealCards();
        showHands();
        determineWinner();
    }

    private void dealCards() {
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                Card card = deck.drawCard();
                if (card != null) {
                    player.drawCard(card);
                }
            }
        }
    }

    private void showHands() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand:");
            for (Card card : player.getHand()) {
                System.out.println(card);
            }
            System.out.println();
        }
    }

    private void determineWinner() {
        Player winner = null;
        int maxHandRank = -1;

        for (Player player : players) {
            int handRank = HandRankings.getHandRank(player.getHand());
            if (handRank > maxHandRank) {
                maxHandRank = handRank;
                winner = player;
            } else if (handRank == maxHandRank) {
                // In case of a tie, compare high cards
                List<Card> winnerHand = winner.getHand();
                List<Card> playerHand = player.getHand();

                if (compareHighCards(playerHand, winnerHand) > 0) {
                    winner = player;
                }
            }
        }

        if (winner != null) {
            System.out.println("Winner: " + winner.getName());
        } else {
            System.out.println("It's a tie!");
        }
    }

    private int compareHighCards(List<Card> hand1, List<Card> hand2) {
        List<Rank> ranks1 = hand1.stream().map(Card::getRank).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<Rank> ranks2 = hand2.stream().map(Card::getRank).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < ranks1.size(); i++) {
            int rankComparison = ranks1.get(i).compareTo(ranks2.get(i));
            if (rankComparison != 0) {
                return rankComparison;
            }
        }

        return 0; // Both hands are identical
    }
}
