import java.util.ArrayList;

/**
 * Created by Kyle on 16/09/2016.
 */
public class player {
    static ArrayList<cards> cards;
    public String playerId;
    private int n;
    public static boolean setCards;


    public player(String playerId) {
        this.playerId = playerId;
        //this.cards = new ArrayList<cards>(cards);
    }

//    public setCards(ArrayList<cards> cards) {
//        this.cards = cards;
//    }
public String getPlayer() {
    String hand = "";

    for (cards i : cards) {
        hand += i + " ";}
    return ("Player name: " + this.playerId+"\n " + hand);
}

    public static cards turn(int cardToPlay) {//removes the card placed from the players deck
        cards topCard = player.cards.get(cardToPlay - 1);
        player.cards.remove(player.cards.get(cardToPlay - 1));
        System.out.println("Cards in hand " + player.cards.size());
        return topCard;
    }

    public void setCards(ArrayList<cards> cards) {
        player.cards = new ArrayList<>(cards);
    }

    public void showPlayerCards(player players) {//Shows Players cards
        System.out.println(playerId + "'s turn. \n" + "Cards in hand " + players.cards.size());
        for (int i = 0; i < players.cards.size(); i++)
            System.out.println("Card #" + (i + 1) + ":\n" + players.cards.get(i));
    }

    public void playersCards() {//shows players cards
        System.out.println(playerId + "'s turn. " + "Cards: " + cards.size());
        for (cards card : cards) {
            System.out.println("card: " + n + "\n" + card.toString());
            n++;
        }
    }

    public String toString() {
        return playerId + "\n" + "cards: " + cards + "\n";
    }



}