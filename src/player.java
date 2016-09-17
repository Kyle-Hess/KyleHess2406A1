import java.util.ArrayList;

/**
 * Created by Kyle on 28/08/2016.
 */
public class player {
    private ArrayList<cards> cards;
    private String playerId;

    public player(String playerId) {
        this.playerId = playerId;
    }

    public void setCards(ArrayList<cards> cards) {
        this.cards = cards;
    }

    public void turn(cards topCard) {
        System.out.println(playerId + "'s turn. " + "Cards: "+cards.size());
        for (cards card :cards) {
            System.out.println(card.toString());
        }

    }


    public String toString(){
        return playerId +"\n"+"cards: " + cards + "\n" ;
    }
}
