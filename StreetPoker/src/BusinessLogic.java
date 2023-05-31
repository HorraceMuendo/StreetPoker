import java.util.ArrayList;
import java.util.List;

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
            player.showHand();
        }
    }

    private void determineWinner() {
        int highestValue = 0;
        List<Player> winners = new ArrayList<>();

        for (Player player : players) {
            int value = player.calculateHandValue();
            if (value > highestValue && value <= 21) {
                highestValue = value;
                winners.clear();
                winners.add(player);
            } else if (value == highestValue) {
                winners.add(player);
            }
        }

        if (winners.isEmpty()) {
            System.out.println("No winners!");
        } else if (winners.size() == 1) {
            Player winner = winners.get(0);
            System.out.println("The winner is: " + winner.getName());
        } else {
            System.out.println("It's a tie! Winners are:");
            for (Player winner : winners) {
                System.out.println(winner.getName());
            }
        }
    }
}
