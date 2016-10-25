import com.dd.plist.PropertyListFormatException;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Kyle on 24/10/2016.
 */

public class GuiGame extends JFrame implements ActionListener{
    private static final int CARDS_MAX =8;
    static Integer playerLoop = 0;
    private static final int NUM_CARDS = 8;
    private static int numPlayers;
    private static int dealerId;
    public static Player[] players;

    public static Deck deck;
    static GameControl lCinstance;
    static GuiGame instance;

    Cards topCard = null;
    private int playersinRound;
    private static int valueInPlay;
    public static String categoryValueAsString;
    private int playerTurn;
    private int cardNum;
    private static int categoryNumber = 0;
    public static String categoryAsString;
    private int roundCounter;

    //============

    BorderLayout borderLayout = new BorderLayout();

    //public static JButton button = new ArrayList<>();
    static JButton button = new JButton();



    private final JPanel panel01 = new JPanel(new GridLayout(4, 0));
    private final JPanel panel02 = new JPanel(new GridLayout(2, 4));

    private JLabel msg1 = new  JLabel("player x Turn");
    private JLabel msg2 = new JLabel(" Category value to beat: ");
    private JLabel msg3 = new JLabel(" Round: ");
    private JButton pass = new JButton("Pass Turn");


    public static void getLaunchControl(GameControl gameControl) {
        lCinstance = gameControl;
    }

    public GuiGame() {
        super("Mineral Super Trumps");
        //this.numPlayers = numPlayers;
        setLayout(borderLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(null, "It is now " + Player.playerId + "'s turn");


        //Play game Frame
        panel01.setVisible(true);
        panel02.setVisible(true);
        getContentPane().add(panel01,BorderLayout.WEST);
        getContentPane().add(panel02,BorderLayout.EAST);

        panel01.add(msg1);
        panel01.add(msg2);
        panel01.add(msg3);
        panel01.add(pass);
        //getCardButtons();

        playersTurn();
//        for (int i = 0; i < players.length; i++) {
//            players[i].PlayerCards(players[i]);
//        }


        pass.addActionListener(this);
    }


//=============



    public static void dealer() {// selects a random Player to be dealer
        Random random = new Random();
        dealerId = random.nextInt(numPlayers) + 1;
        System.out.println("Player " + (dealerId + 1) + " is dealer\n");
    }

    //creates Player and deals them 8 cards each
    public static void dealCards() {
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }

        for (Player Player : players) {
            ArrayList<Cards> card = deck.dealCards(NUM_CARDS);
            Player.setCards(card);

        }
    }

    public void getCardButtons() {
//        for (int x = 0; x < Player.get().cards.size(); x++) {
//            String filePath = "images\\" + Player.cards.get(x);
//            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(135, 189, Image.SCALE_DEFAULT));
//            button.add(new JButton(imageIcon));
//            //button.get(x).addActionListener(this);
//            contentPane.add(button.get(x));
//        }

//        JButton btn = null;
//        for (int i = 0; i < CARDS_MAX; i++) {
//            button = new JButton();
//            ImageIcon img = new ImageIcon();
//            //System.out.print(i);
//            button.setText("Card " + (i + 1));
//            panel02.add(button);  //adding to frame
//            //System.out.print(btn.getText() + " ");
//        }
//        for (int x = 0; x < instance.players.cards.size(); x++) {
//            String filePath = "\\images" + Player.cards.get(x);
//            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(135, 189, Image.SCALE_DEFAULT));
//            button.add(new JButton(imageIcon));
//            //button.get(x).addActionListener(this);
//            panel02.add(button);
//        }

    }
    private void playersTurn() {
        for (int i = 0; i < instance.players.length; i++) {
            //if (!Player.pass) {
            players[i].PlayerCards(players[i]);

            //players[i].getPlayer().;

            //setCurrentValues();
            //displayCurrentValue();

            //playerTurn = numPlayers;
        }
    }
//    public void playersTurn() {
//        for (int i = 0; i < players.length; i++) {
//            //if (!Player.pass) {
//            players[i].PlayerCards(players[i]);
//            //players[i].getPlayer();
//
//            //setCurrentValues();
//            //displayCurrentValue();
//
//            //playerTurn = numPlayers;
//        }
//    }
//================

    public static void startRound() {
        //categoryNumber = main.getCategoryToPlay();

        categoryNumber = GuiMain.categorySelect;
        categoryAsString = getCategoryAsString(categoryNumber);
        setStartValues();
        //setCurrentValues();
        displayCurrentValue();
    }

    private void passPlayerTurn(Player player) {//handles Player passes.
        //deck.drawCard();
        //Player.drawCard(player, deck );
        Player.drawACard(player,deck);

        Player.setCards = true;
        playersinRound = playersinRound - 1;
        System.out.println(playersinRound + " players left in round.");
    }

    private static void setStartValues() {//sets the starting score to 0
        categoryValueAsString = "0";
        valueInPlay = 0;
    }

    private void setCurrentValues() {//gets the current category that has been played
        categoryValueAsString = topCard.getCategoryInPlay(categoryNumber);
        valueInPlay = getCategory(categoryNumber, topCard.getCategoryInPlay(categoryNumber));
    }

    private static void displayCurrentValue() {//displays the current category
        System.out.println("Category for this round is: " + categoryAsString.toUpperCase());
        System.out.println("Score to beat is: " + categoryValueAsString.toUpperCase() + "\n");
    }

    private static String getCategoryAsString(int categoryNumber) {//
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
            deck = new Deck();
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
        System.out.println("\ndeck has been shuffled. \n" + deck.size() + " cards in deck.\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!((JButton) e.getSource()).getText().contains("pass")) {
            System.out.println("You clicked a card");
        } else if (e.getSource() == pass) {
            ++playerLoop;
            JOptionPane.showMessageDialog(null, "You have passed");
            //drawCard();
            msg1.setText("The current player is: " + Player.playerId);
            dispose();

        }

    }


}


