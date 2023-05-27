import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {
    private  Deck deck;
    private List<Players> players;

    public BusinessLogic() {
       deck = new Deck();
       players = new ArrayList<>();
    }
    public void addPlayer(Players player){
        players.add(player);
    }
    private void dealCards(){
        for (int i=0; i<5;i++){
            for (Players players1 :players){
                Card card = deck.drawCard();
                if (card != null){
                    players1.drawCard(card);
                }
            }
        }
    }
    public void hands(){
        for (Players players1 : players){
            System.out.println(players1.getName()+"'s hand:");
            for (Card card : players1.getHand()){
                System.out.println(card);
            }
            System.out.println();
        }
    }

    public void startGame(){
        deck.shuffle();

    }
}
