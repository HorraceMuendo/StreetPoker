import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    public Deck(){
        cards=new ArrayList<>();
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                cards.add(new Card(rank,suit))
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card drawCard (){
        if (cards.isEmpty()){
            return null;
        }
        return cards.remove(cards.size()-1);
    }


}
