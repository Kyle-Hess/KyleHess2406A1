import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kyle on 16/09/2016.
 */
public class Player {
    static ArrayList<Cards> cards;
    public String playerId;
    private int n;
    public static boolean setCards;


    public Player(String playerId) {
        this.playerId = playerId;
        //this.cards = new ArrayList<cards>(cards);
    }

//    public setCards(ArrayList<cards> cards) {
//        this.cards = cards;
//    }

 public void setCards(ArrayList<Cards> Cards) {
     Player.cards = new ArrayList<>(Cards);
}

public String getPlayer() {
    String hand = "";

    for (Cards i : cards) {
        hand += i + " ";}
    return ("Player name: " + this.playerId+"\n " + hand);
}

    public static Cards turn(int cardToPlay) {//removes the card placed from the players Deck
        Cards topCard = Player.cards.get(cardToPlay - 1);
        Player.cards.remove(Player.cards.get(cardToPlay - 1));
        System.out.println("cards in hand " + Player.cards.size());
        return topCard;
    }

    public static void drawACard(Player player, Deck deck) {// draw a card from the Deck and returns it to the players cards/hand
        Collections.shuffle(deck.deckArray);
        if (deck.deckArray.size() == 0) {
            System.out.println("Out of cards");

        } else {
            player.cards.add(deck.deckArray.get(deck.deckArray.size() - 1)) ;
            deck.deckArray.remove(deck.deckArray.size() - 1);
            System.out.println("Card: "  + "* Was drawn * \n"
                    + "=====================");
        }
    }

    public void showPlayerCards(Player players) {//Shows Players cards
        System.out.println(playerId + "'s turn. \n" + "cards in hand " + players.cards.size());
        for (int i = 0; i < players.cards.size(); i++)
            System.out.println("Card #" + (i + 1) + ":\n" + players.cards.get(i));
    }

    public void playersCards() {//shows players cards
        System.out.println(playerId + "'s turn. " + "cards: " + cards.size());
        for (Cards card : cards) {
            System.out.println("card: " + n + "\n" + card.toString());
            n++;
        }
    }

    public String toString() {
        return playerId + "\n" + "cards: " + cards + "\n";
    }



}