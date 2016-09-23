import com.dd.plist.PropertyListFormatException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Kyle on 16/09/2016.
 */
public class game {
    private static final int NUM_CARDS = 8;
    private int numPlayers;
    private int dealerId;
    private player[] players;
    //private cardPile[] piles;
    private deck deck;
    int playerId;
    private cards topCard;

    public game(int numPlayers) {
        this.numPlayers = numPlayers;
        try {
            deck = new deck();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (PropertyListFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dealer() {
        //int i = new Random().nextInt(2);
        dealerId = 1;
    }

    public void dealCards() {
        players = new player[numPlayers];
        for (int i = 0; i <numPlayers; i++){
            players[i] = new player("Player "+ i);
        }

        for (player player : players){
            ArrayList<cards> card = deck.dealCards(NUM_CARDS);
            player.setCards(card);

        }
    }

    public void selectPlayer() {
        playerId = 0;
    }

    public player[] getPlayer() {
        for (int i = 0; i < players.length;i++) {
            System.out.println(players[i].toString());
        }
        return players;
    }



    public int playGame(int cardNum) {
        boolean inGame = true;
        //topCard = deck.drawCard();
        while (inGame){

            for (int i = 0; i<numPlayers;i++ ){
                players[i].turn(topCard);
                cards temp = topCard;
                //System.out.println("* Place a card. *");
                break;
            }
            break;
        }
        return 0;
    }
    public void showCards() {//Shows Players cards
        for (int i = 0; i<numPlayers;i++ ){
            players[i].playersCards();{
            }
            break;
        }
    }

}
