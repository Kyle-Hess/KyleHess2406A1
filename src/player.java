import java.util.ArrayList;

/**
 * Created by Kyle on 16/09/2016.
 */
public class player {
    private ArrayList<cards> cards;
    private String playerId;
    private int n;

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

    public void playersCards() {//shows players cards
        System.out.println(playerId + "'s turn. " + "Cards: "+cards.size());
        for (cards card :cards) {

            
            System.out.println("card: "+n+"\n" +card.toString());
            n++;
        }
    }

    public String toString(){
        return playerId +"\n"+"cards: " + cards + "\n" ;
    }
}
