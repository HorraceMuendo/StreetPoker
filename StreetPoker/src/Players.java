import java.util.List;

public class Players {
    private String name;
    private List<Card> hand;

    public Players(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }
    public String getName(){
        return  name;
    }
    public void drawCard(Card card){
        hand.add(card);
    }
    public List<Card> getHand(){
        return hand;
    }

}
