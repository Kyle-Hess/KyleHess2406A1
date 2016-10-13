import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kyle on 16/09/2016.
 */
public class player {
    ArrayList<cards> cards;
    public String playerId;
    private int n;
    boolean setInOut;


    public player(String playerId) {
        this.playerId = playerId;
        this.cards = new ArrayList<>();
        this.setInOut = true;
    }

//    public setCards(ArrayList<cards> cards) {
//        this.cards = cards;
//        //return false;
//    }

    public String getPlayer() {
        String hand = "";

        for (cards i : cards) {
            hand += i + " ";}
        return ("Player name: " + this.playerId+"\n " + hand);
    }

//    public static cards turn(int cardToPlay) {//removes the card placed from the players deck
//        cards topCard = player.cards.get(cardToPlay - 1);
//        player.cards.remove(player.cards.get(cardToPlay - 1));
//        System.out.println("Cards in hand " + player.cards.size());
//        return topCard;
//    }

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
        return this.playerId + "\n" + "cards: " + this.cards + "\n";
    }

    public static int getCategoryToPlay() {//get the category for the first round
        int categorySelect;
        System.out.println("Choose category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
        Scanner inputCategory = new Scanner(System.in);
        categorySelect = inputCategory.nextInt();
        return categorySelect;
    }

    public static int playOrPass() {//asks the user to play a card or pass their turn
        int playOrPass;
        Scanner input_playOrPass = new Scanner(System.in);
        do {
            System.out.println("1: Play a card\n2: Pass turn");
            playOrPass = input_playOrPass.nextInt();
        } while (playOrPass != 1 && playOrPass != 2);
        return playOrPass;
    }

    public static int getCardToPlay() {// gets the users card
        Scanner inputCardToPlay = new Scanner(System.in);
        System.out.println("Choose card to play");
        int cardToPlay = inputCardToPlay.nextInt();
        return cardToPlay;
    }

}
