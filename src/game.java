import com.dd.plist.PropertyListFormatException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

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
    cards topCard = null;
    int playersRound;
    int valueInPlay;
    String categoryValueAsString;
    int playerTurn;
    int cardNum;
    int categoryNumber =0;
    String categoryAsString;
    int roundCounter;

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
    //creates player and deals them 8 cards each
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
    public void showPlayers() {
        System.out.println("This games players are:");

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i]);
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

    public int playGame() {
        boolean inGame = false;
        //topCard = deck.drawCard();
        playersRound = numPlayers ;
        roundCounter = roundCounter +1;
        startRound();
        do {
            //System.out.println("* Place a card. *");
            playersTurn();
            //player.turn(cardNum);
            //System.out.println(cardNum+"was placed");
        }
        while (playersRound >1);
        categoryValueAsString = null;
        valueInPlay = 0;
        main.gameOver = false;
        return cardNum;
    }

//    private boolean playerPass(boolean inGame) {
//        deck.drawCard(player);
//
//        inGame = true;
//        return inGame;
//    }

//    public int playGame(int cardNum) {
//        boolean inGame = true;
//        //topCard = deck.drawCard();
//        while (inGame){
//
//            for (int i = 0; i<numPlayers;i++ ){
//                player.turn(cardNum);
//
//                //System.out.println("* Place a card. *");
//                break;
//            }
//            break;
//        }
//        return 0;
//    }
    //=====
//    public int playGame(int cardNum) {
//        playersRound = numPlayers;
//        startRound();
//        do {
//            playersTurn();
//        }while(playersRound > 1);
//        main.gameOver = false;
//        return 0;
//    }

    private void startRound() {
        playerTurn = numPlayers;


        categoryNumber = player.getCategoryToPlay();
        topCard = deck.drawACard();
        //startRoundPlayer(this.players[0]);
        playerTurn = numPlayers;

        categoryAsString = getCategoryAsString(categoryNumber);
        setCurrentValues();
        displayCurrentValue();
    }
    private void playersTurn() {
        for (int i=0; i<players.length;i++){

            playPlayerTurns(players[0]);
            playerTurn = numPlayers;

        }
        setCurrentValues();
        displayCurrentValue();
    }

    private void playPlayerTurns(player player) {
        if (!player.setCards) {
            player.showPlayerCards(player);
            int userMove = player.playOrPass();
            if (userMove == 1) {
                int cardToPlay = player.getCardToPlay();
                int valueToPlay = getCategory(categoryNumber, player.cards.get(cardToPlay-1).getCategoryInPlay(categoryNumber));
                if (valueToPlay > valueInPlay) {
                    topCard = player.turn(player, cardToPlay);
                } else { passPlayerTurn(player); }
            } else {
                passPlayerTurn(player);
            }
        }
    }

    private void passPlayerTurn(player player) {
        deck.drawCard(player);
        player.setCards = true;
        playersRound = playersRound - 1;
        System.out.println(playersRound + " players left in round.");
    }


    private void displayCurrentValue() {
        System.out.println("Category for this round is: " + categoryAsString.toUpperCase());
        System.out.println("Score to beat is: " + categoryValueAsString.toUpperCase() + "\n");
    }

    private void setCurrentValues() {
        categoryValueAsString = topCard.getCategoryInPlay(categoryNumber);
        valueInPlay = getCategory(categoryNumber, topCard.getCategoryInPlay(categoryNumber));
    }

    private String getCategoryAsString(int categoryNumber) {
        String categoryAsString;
        loop: do {
            switch (categoryNumber) {
                case 1: categoryAsString = "Hardness";
                    break loop;
                case 2: categoryAsString = "Specific gravity";
                    break loop;
                case 3: categoryAsString = "Cleavage";
                    break loop;
                case 4: categoryAsString = "Crustal abundance";
                    break loop;
                case 5: categoryAsString = "Economic value";
                    break loop;
                default: categoryAsString = "";
                    break;
            }
        } while (categoryAsString.equals(""));
        return categoryAsString;
    }

    private void startRoundPlayer(player player) {
        categoryNumber = player.getCategoryToPlay();
        player.showPlayerCards(player);
        int cardToPlay = getCardNum();
        topCard = player.turn(player, cardToPlay);

    }







//        for (int i = 0; i< this.players.length; i++ ){
//            this.players[i].playersCards();
//
//        }


    public static int getCategory(int categorySelect, String categoryValueAsString) {
        int value = 0;
        switch (categorySelect) {
            case 1:
                value = getHardnessAsInt(categoryValueAsString);
                return value;
            case 2:
                value = getSpecificGravity(categoryValueAsString);
                return value;
            case 3:
                value = getCleavage(categoryValueAsString);
                return value;
            case 4:
                value = getCrystalAbundance(categoryValueAsString);
                return value;
            case 5:
                value = getEconomicValue(categoryValueAsString);
                return value;
        } return value;
    }
    public static int getHardnessAsInt(String hardness){
        int hardnessValue = 0;
        switch (hardness){
            case "1":return 1;
            case "1-1.5":return 2;
            case "1-2":return 3;
            case "1.5-2.5":return 4;
            case "2":return 4;
            case "2-3":return 5;
            case "2.5":return 5;
            case "2.5-3":return 6;
            case "2.5-3.5":return 7;
            case "3":return 7;
            case "3-3.5":return 8;
            case "3.5-4":return 9;
            case "3.5-4.5":return 10;
            case "4":return 10;
            case "4-4.5":return 11;
            case "5":return 12;
            case "5-5.5":return 13;
            case "5-6":return 14;
            case "5.5":return 14;
            case "5.5-6":return 15;
            case "6":return 16;
            case "5.5-6.5":return 16;
            case "6-6.5":return 17;
            case "5.5-7":return 17;
            case "6-7":return 18;
            case "6.5-7":return 19;
            case "6-7.5":return 20;
            case "6.5-7.5":return 21;
            case "7":return 21;
            case "7-7.5":return 22;
            case "7.5":return 23;
            case "7.5-8":return 24;
            case "8":return 25;
            case "9":return 26;
            case "10":return 27;

        }return hardnessValue;
    }

    public static int getSpecificGravity(String specific_gravity){
        int sgValue = 0;
        switch (specific_gravity){
            case "1":return 1;
            case "2.2":return 2;
            case "2.3":return 3;
            case "2.4":return 4;
            case "2.5-2.6":return 5;
            case "2.6":return 6;
            case "2.6-2.7":return 7;
            case "2.65":return 7;
            case "2.6-2.8":return 8;
            case "2.7":return 8;
            case "2.6-2.9":return 9;
            case "2.8-2.9":return 10;
            case "2.9":return 11;
            case "2.6-3.3":return 12;
            case "3.0":return 13;
            case "2.7-3.3":return 13;
            case "3.0-3.2":return 14;
            case "3.1-3,2":return 15;
            case "3.15":return 15;
            case "3.2":return 16;
            case "3.0-3.5":return 17;
            case "3.25":return 17;
            case "3.2-3.5":return 18;
            case "3.2-3.6":return 19;
            case "3.4-3.6":return 20;
            case "3.5":return 20;
            case "3.2-3.9":return 21;
            case "3.5-3.6":return 21;
            case "3.5-3.7":return 22;
            case "3.7-3.8":return 23;
            case "3.2-4.4":return 24;
            case "3.5-4.3":return 25;
            case "4.0":return 26;
            case "3.9-4.1":return 26;
            case "4.1-4.3":return 27;
            case "4.3":return 28;
            case "4.5":return 29;
            case "4.6":return 30;
            case "4.6-4.7":return 31;
            case "4.7":return 32;
            case "4.5-5.1":return 33;
            case "4.7-4.8":return 33;
            case "5.0":return 34;
            case "5.0-5.3":return 35;
            case "5.2":return 36;
            case "5.3":return 37;
            case "6.9-7.1":return 38;
            case "7.5-7.6":return 39;
            case "19.3":return 40;
        }return  sgValue;
    }

    public static int getCleavage(String cleavage){
        int cleavageValue=0;
        switch (cleavage){
            case "none":return 1;
            case "poor/none":return 2;
            case "1 poor":return 3;
            case "2 poor":return 4;
            case "1 good, 1 poor":return 5;
            case "1 good":return 6;
            case "2 good":return 7;
            case "3 good":return 8;
            case "1 perfect":return 9;
            case "3 perfect":return 10;
            case "4 perfect":return 11;
            case "6 perfect":return 12;
            case "1 perfect, 1 good":return 13;
            case "1 perfect, 2 good":return 14;
            case "2 perfect, 1 good":return 15;
        }return cleavageValue;
    }

    public static int getCrystalAbundance(String crystal_abundance){
        int caValue = 0;
        switch (crystal_abundance){
            case "ultratrace":return 1;
            case "trace":return 2;
            case "low":return 3;
            case "moderate":return 4;
            case "high":return 5;
            case "very high":return 6;
        }return caValue;
    }

    public static int getEconomicValue(String economicValue){
        int economicAsInt = 0;
        switch (economicValue){
            case "trivial": return 1;
            case "low": return 2;
            case "moderate": return 3;
            case "high": return 4;
            case "very high": return 5;
            case "I'm rich": return 6;
        }return economicAsInt;
    }

    public int getCardNum() {
        Scanner inputCardToPlay = new Scanner(System.in);
        System.out.println("Choose card to play");
        int cardNum =  inputCardToPlay.nextInt();
        return cardNum;
    }
}
