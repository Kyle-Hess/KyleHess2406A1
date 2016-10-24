import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kyle on 24/10/2016.
 */

public class GuiGame extends JFrame implements ActionListener{
    public static GuiGame bFrame;

    static int playerLoop = 0;

    private static final int NUM_CARDS = 8;
    private static int numPlayers;
    private static int dealerId;
    private static Player[] players;
    public static Deck deck;
    Cards topCard = null;
    private int playersinRound;
    private static int valueInPlay;
    public static String categoryValueAsString;
    private int playerTurn;
    private int cardNum;
    private static int categoryNumber = 0;
    public static String categoryAsString;
    private int roundCounter;

    BorderLayout borderLayout = new BorderLayout();
    JLabel playerNameLabel = new JLabel("The current player is: " + Player.playerId);
    JLabel statusMessageLabel = new JLabel("The type for the current round is: " );
    static JPanel contentPane = new JPanel();
    public static ArrayList<JButton> button = new ArrayList<>();
    JButton passButton = new JButton("pass");


    public GuiGame(int numPlayers) {
        super("Mineral Super Trumps");
        this.numPlayers = numPlayers;

        setLayout(borderLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(playerNameLabel, borderLayout.NORTH);
        add(statusMessageLabel, borderLayout.SOUTH);
        add(contentPane, borderLayout.CENTER);
        JOptionPane.showMessageDialog(null, "It is now " + Player.playerId + "'s turn");
        getCardButtons();
        contentPane.add(passButton);
        passButton.addActionListener(this);
    }




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

    public static void getCardButtons() {
        for (int x = 0; x < Player.cards.size(); x++) {
            String filePath = "images\\" + Player.cards.get(x);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(135, 189, Image.SCALE_DEFAULT));
            button.add(new JButton(imageIcon));
            //button.get(x).addActionListener(this);
            contentPane.add(button.get(x));
        }
    }

    public static void playersTurn() {
        for (int i = 0; i < players.length; i++) {
            //if (!Player.pass) {
            players[i].PlayerCards(players[i]);
            //players[i].getPlayer();

            //setCurrentValues();
            //displayCurrentValue();

            //playerTurn = numPlayers;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (!((JButton) e.getSource()).getText().contains("pass")) {
            System.out.println("u clicked a card");
        } else if (e.getSource() == passButton) {
            ++playerLoop;
            statusMessageLabel.setText("You have chosen to pass");
            //instance.playerArray.get(playerLoopIndex).inOut = Boolean.FALSE;
            //drawCard();
            playerNameLabel.setText("The current player is: " + Player.playerId);
            dispose();

        }

    }
}


