import com.dd.plist.PropertyListFormatException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Kyle on 16/09/2016.
 */
public class game {
    private static final int NUM_CARDS = 8;
    public static ArrayList<player> players;
    private int numPlayers;
    int dealerId;
    //private player[] players;
    public static deck deck;
    cards topCard = null;
    int playersinRound;
    int valueInPlay;
    String categoryValueAsString;
    int playerTurn;
    int cardNum;
    int categoryNumber = 0;
    String categoryAsString;
    int roundCounter;

    public game(int numPlayers) {
        this.numPlayers = numPlayers;

    }

    public void dealer() {// selects a random player to be dealer
        Random random = new Random();
        dealerId = random.nextInt(numPlayers) + 1;
        System.out.println("Player " + (dealerId + 1) + " is dealer\n");
    }

    //creates player and deals them 8 cards each
    public void dealCards() {

        for (int i = 0; i < numPlayers; i++) {
            player playerP = new player("player" + (i+1));
            //players[i] = new player("Player " + (i + 1));
            while (playerP.cards.size() < NUM_CARDS) {
            playerP.cards.add(deck.deckArray.remove(0));
        }
            game.players.add(playerP);
        }

//        for (int i = 0; i < numPlayers; i++) {
//            player player = new player("Player " + (i + 1));
//        }
//
//        for (player player : players) {
//            while (player.cards.size() < NUM_CARDS) {
//            player.cards.add(deck.deckArray.remove(0));
//        }
//        }
    }

    public void showPlayers() {//test function
        System.out.println("This games players are:");

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }
    }

    public int playGame() {//handles players turns and rounds
        boolean inGame = false;
        playersinRound = numPlayers;
        roundCounter = roundCounter + 1;
        //startRound();
        startRoundPlayer(players.get(dealerId));
        do {
            for (player player: players) {

                playersTurn(player);
            }
        }
        while (playersinRound > 1);
        categoryValueAsString = null;
        valueInPlay = 0;
        main.gameOver = false;
        return cardNum;
    }
//================================

    private void startRoundPlayer(player player) {//test* - first player chooses card to play  and sets the category
        categoryNumber = player.getCategoryToPlay();
        player.showPlayerCards(player);
        int cardToPlay = player.getCardToPlay();
        //topCard = player.turn(cardToPlay);

        categoryAsString = getCategoryAsString(categoryNumber);
        setCurrentValues();
        displayCurrentValue();
    }

    //gets the category to play.
//currently get a card from the deck and uses its category stats
    private void startRound() {
        playerTurn = numPlayers;
        categoryNumber = player.getCategoryToPlay();
        topCard = deck.drawCard();
        //startRoundPlayer(this.players[0]);
        //playerTurn = numPlayers;

        categoryAsString = getCategoryAsString(categoryNumber);
        setCurrentValues();
        displayCurrentValue();
    }

    //loops through each player to place a card    //currently only uses first players cards
//    private void playersTurn() {
//        for (int i = 0; i < players.length; i++) {
//            //if (!player.pass) {
//            //players[i].showPlayerCards(players[i]);
//            players[i].playersCards();
//            int userMove = player.playOrPass();
//            if (userMove == 1) {
//                int cardToPlay = player.getCardToPlay();
//                int valueToPlay = getCategory(categoryNumber, player.cards.get(cardToPlay - 1).getCategoryInPlay(categoryNumber));
//                if (valueToPlay > valueInPlay) {
//                    topCard = player.turn(cardToPlay);
//                } else {
//                    passPlayerTurn();
//                }
//            } else {
//                passPlayerTurn();
//            }
//            //}
//            setCurrentValues();
//            displayCurrentValue();
//            //playPlayerTurns(players[i]);
//            playerTurn = numPlayers;
//        }
//    }
    public void playersTurn(player player) {
        //players[i].showPlayerCards(players[i]);
        int userMove = player.playOrPass();
        if (userMove == 1) {
            int cardToPlay = player.getCardToPlay();
            int valueToPlay = getCategory(categoryNumber, player.cards.get(cardToPlay - 1).getCategoryInPlay(categoryNumber));
            if (valueToPlay > valueInPlay) {
                //topCard = player.turn(cardToPlay);
            } else {
                passPlayerTurn();
            }
        } else {
            passPlayerTurn();
        }
        //}
        setCurrentValues();
        displayCurrentValue();
        //playPlayerTurns(players[i]);
        playerTurn = numPlayers;
    }




    private void passPlayerTurn() {//handles player passes.
        deck.drawCard();
        //player.setCards = true;
        playersinRound = playersinRound - 1;
        System.out.println(playersinRound + " players left in round.");
    }


    private void displayCurrentValue() {//displays the current category
        System.out.println("Category for this round is: " + categoryAsString.toUpperCase());
        System.out.println("Score to beat is: " + categoryValueAsString.toUpperCase() + "\n");
    }

    private void setCurrentValues() {//gets the current category that has been played
        categoryValueAsString = topCard.getCategoryInPlay(categoryNumber);
        valueInPlay = getCategory(categoryNumber, topCard.getCategoryInPlay(categoryNumber));
    }


    private String getCategoryAsString(int categoryNumber) {//
        String categoryAsString;
        loop:
        do {
            switch (categoryNumber) {
                case 1:
                    categoryAsString = "Hardness";
                    break loop;
                case 2:
                    categoryAsString = "Specific gravity";
                    break loop;
                case 3:
                    categoryAsString = "Cleavage";
                    break loop;
                case 4:
                    categoryAsString = "Crustal abundance";
                    break loop;
                case 5:
                    categoryAsString = "Economic value";
                    break loop;
                default:
                    categoryAsString = "";
                    break;
            }
        } while (categoryAsString.equals(""));
        return categoryAsString;
    }

    // returns categories as integers for mineral card comparison
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
        }
        return value;
    }

    //converts the plist hardness category from string to integer for comparison
    public static int getHardnessAsInt(String hardness) {
        int hardnessValue = 0;
        switch (hardness) {
            case "1":
                hardnessValue = 1;
                return hardnessValue;
            case "1-1.5":
                hardnessValue = 2;
                return hardnessValue;
            case "1-2":
                hardnessValue = 3;
                return hardnessValue;
            case "1.5-2.5":
                hardnessValue = 4;
                return hardnessValue;
            case "2":
                hardnessValue = 4;
                return hardnessValue;
            case "2-3":
                hardnessValue = 5;
                return hardnessValue;
            case "2.5":
                hardnessValue = 5;
                return hardnessValue;
            case "2.5-3":
                hardnessValue = 6;
                return hardnessValue;
            case "2.5-3.5":
                hardnessValue = 7;
                return hardnessValue;
            case "3":
                hardnessValue = 7;
                return hardnessValue;
            case "3-3.5":
                hardnessValue = 8;
                return hardnessValue;
            case "3.5-4":
                hardnessValue = 9;
                return hardnessValue;
            case "3.5-4.5":
                hardnessValue = 10;
                return hardnessValue;
            case "4":
                hardnessValue = 10;
                return hardnessValue;
            case "4-4.5":
                hardnessValue = 11;
                return hardnessValue;
            case "5":
                hardnessValue = 12;
                return hardnessValue;
            case "5-5.5":
                hardnessValue = 13;
                return hardnessValue;
            case "5-6":
                hardnessValue = 14;
                return hardnessValue;
            case "5.5":
                hardnessValue = 14;
                return hardnessValue;
            case "5.5-6":
                hardnessValue = 15;
                return hardnessValue;
            case "6":
                hardnessValue = 16;
                return hardnessValue;
            case "5.5-6.5":
                hardnessValue = 16;
                return hardnessValue;
            case "6-6.5":
                hardnessValue = 17;
                return hardnessValue;
            case "5.5-7":
                hardnessValue = 17;
                return hardnessValue;
            case "6-7":
                hardnessValue = 18;
                return hardnessValue;
            case "6.5-7":
                hardnessValue = 19;
                return hardnessValue;
            case "6-7.5":
                hardnessValue = 20;
                return hardnessValue;
            case "6.5-7.5":
                hardnessValue = 21;
                return hardnessValue;
            case "7":
                hardnessValue = 21;
                return hardnessValue;
            case "7-7.5":
                hardnessValue = 22;
                return hardnessValue;
            case "7.5":
                hardnessValue = 23;
                return hardnessValue;
            case "7.5-8":
                hardnessValue = 24;
                return hardnessValue;
            case "8":
                hardnessValue = 25;
                return hardnessValue;
            case "9":
                hardnessValue = 26;
                return hardnessValue;
            case "10":
                hardnessValue = 27;
                return hardnessValue;
        }
        return hardnessValue;
    }

    //converts the plist Specific gravity category from string to integer
    public static int getSpecificGravity(String specific_gravity) {
        int sgValue = 0;
        switch (specific_gravity) {
            case "1":
                sgValue = 1;
                return sgValue;
            case "2.2":
                sgValue = 2;
                return sgValue;
            case "2.3":
                sgValue = 3;
                return sgValue;
            case "2.4":
                sgValue = 4;
                return sgValue;
            case "2.5-2.6":
                sgValue = 5;
                return sgValue;
            case "2.6":
                sgValue = 6;
                return sgValue;
            case "2.6-2.7":
                sgValue = 7;
                return sgValue;
            case "2.65":
                sgValue = 7;
                return sgValue;
            case "2.6-2.8":
                sgValue = 8;
                return sgValue;
            case "2.7":
                sgValue = 8;
                return sgValue;
            case "2.6-2.9":
                sgValue = 9;
                return sgValue;
            case "2.8-2.9":
                sgValue = 10;
                return sgValue;
            case "2.9":
                sgValue = 11;
                return sgValue;
            case "2.6-3.3":
                sgValue = 12;
                return sgValue;
            case "3.0":
                sgValue = 13;
                return sgValue;
            case "2.7-3.3":
                sgValue = 13;
                return sgValue;
            case "3.0-3.2":
                sgValue = 14;
                return sgValue;
            case "3.1-3,2":
                sgValue = 15;
                return sgValue;
            case "3.15":
                sgValue = 15;
                return sgValue;
            case "3.2":
                sgValue = 16;
                return sgValue;
            case "3.0-3.5":
                sgValue = 17;
                return sgValue;
            case "3.25":
                sgValue = 17;
                return sgValue;
            case "3.2-3.5":
                sgValue = 18;
                return sgValue;
            case "3.2-3.6":
                sgValue = 19;
                return sgValue;
            case "3.4-3.6":
                sgValue = 20;
                return sgValue;
            case "3.5":
                sgValue = 20;
                return sgValue;
            case "3.2-3.9":
                sgValue = 21;
                return sgValue;
            case "3.5-3.6":
                sgValue = 21;
                return sgValue;
            case "3.5-3.7":
                sgValue = 22;
                return sgValue;
            case "3.7-3.8":
                sgValue = 23;
                return sgValue;
            case "3.2-4.4":
                sgValue = 24;
                return sgValue;
            case "3.5-4.3":
                sgValue = 25;
                return sgValue;
            case "4.0":
                sgValue = 26;
                return sgValue;
            case "3.9-4.1":
                sgValue = 26;
                return sgValue;
            case "4.1-4.3":
                sgValue = 27;
                return sgValue;
            case "4.3":
                sgValue = 28;
                return sgValue;
            case "4.5":
                sgValue = 29;
                return sgValue;
            case "4.6":
                sgValue = 30;
                return sgValue;
            case "4.6-4.7":
                sgValue = 31;
                return sgValue;
            case "4.7":
                sgValue = 32;
                return sgValue;
            case "4.5-5.1":
                sgValue = 33;
                return sgValue;
            case "4.7-4.8":
                sgValue = 33;
                return sgValue;
            case "5.0":
                sgValue = 34;
                return sgValue;
            case "5.0-5.3":
                sgValue = 35;
                return sgValue;
            case "5.2":
                sgValue = 36;
                return sgValue;
            case "5.3":
                sgValue = 37;
                return sgValue;
            case "6.9-7.1":
                sgValue = 38;
                return sgValue;
            case "7.5-7.6":
                sgValue = 39;
                return sgValue;
            case "19.3":
                sgValue = 40;
                return sgValue;
        }
        return sgValue;
    }

    //converts the plist cleavage category from string to integer
    public static int getCleavage(String cleavage) {
        int cleavageValue = 0;
        switch (cleavage) {
            case "none":
                cleavageValue = 1;
                return cleavageValue;
            case "poor/none":
                cleavageValue = 2;
                return cleavageValue;
            case "1 poor":
                cleavageValue = 3;
                return cleavageValue;
            case "2 poor":
                cleavageValue = 4;
                return cleavageValue;
            case "1 good, 1 poor":
                cleavageValue = 5;
                return cleavageValue;
            case "1 good":
                cleavageValue = 6;
                return cleavageValue;
            case "2 good":
                cleavageValue = 7;
                return cleavageValue;
            case "3 good":
                cleavageValue = 8;
                return cleavageValue;
            case "1 perfect":
                cleavageValue = 9;
                return cleavageValue;
            case "3 perfect":
                cleavageValue = 10;
                return cleavageValue;
            case "4 perfect":
                cleavageValue = 11;
                return cleavageValue;
            case "6 perfect":
                cleavageValue = 12;
                return cleavageValue;
            case "1 perfect, 1 good":
                cleavageValue = 13;
                return cleavageValue;
            case "1 perfect, 2 good":
                cleavageValue = 14;
                return cleavageValue;
            case "2 perfect, 1 good":
                cleavageValue = 15;
                return cleavageValue;
        }
        return cleavageValue;
    }

    //converts the plist crystal abundance category from string to integer
    public static int getCrystalAbundance(String crystal_abundance) {
        int caValue = 0;
        switch (crystal_abundance) {
            case "ultratrace":
                caValue = 1;
                return caValue;
            case "trace":
                caValue = 2;
                return caValue;
            case "low":
                caValue = 3;
                return caValue;
            case "moderate":
                caValue = 4;
                return caValue;
            case "high":
                caValue = 5;
                return caValue;
            case "very high":
                caValue = 6;
                return caValue;
        }
        return caValue;
    }

    //converts the plist economic value category from string to integer
    public static int getEconomicValue(String economicValue) {
        int economicAsInt = 0;
        switch (economicValue) {
            case "trivial":
                economicAsInt = 1;
                return economicAsInt;
            case "low":
                economicAsInt = 2;
                return economicAsInt;
            case "moderate":
                economicAsInt = 3;
                return economicAsInt;
            case "high":
                economicAsInt = 4;
                return economicAsInt;
            case "very high":
                economicAsInt = 5;
                return economicAsInt;
            case "I'm rich":
                economicAsInt = 6;
                return economicAsInt;
        }
        return economicAsInt;
    }

    public static void buildDeck() {
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
        Collections.shuffle(deck.deckArray);
        System.out.println("\nDeck has been shuffled. \n" + deck.size() + " cards in deck.\n");
    }
}

