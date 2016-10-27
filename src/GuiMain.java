import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Kyle on 13/10/2016.
 */
public class GuiMain extends JFrame implements ActionListener {
    private final int CARDS_MAX = 8;
    private final float newSize = 20;
    String categories[] = {"Hardness", "Specific gravity", "Cleavage", "Crystal abundance", "Economic Value"};
    private JFrame frame;
    private JFrame testFrame;


    //    JButton[] buttons = new JButton[CARDS_MAX];
    /*test Frame*/
    JPanel testPanel = new JPanel(new CardLayout());
    String path = "\\images";
    ImageIcon image = new ImageIcon();
    JLabel label = new JLabel();
    JPanel card = new JPanel();


    /*Exit or Play Screen*/
    private final JPanel welcomePanel = new JPanel(new GridLayout(3, 0));
    JLabel statusMessage = new JLabel("Welcome to the Mineral Super Trumps Game \n Please select an option");
    JButton playButton = new JButton("Play Game");
    JButton exitButton = new JButton("Exit");


    /*Category Screen*/
    private final JPanel panelMenu = new JPanel(new GridLayout(3, 0));
    private final JPanel panelMenu2 = new JPanel(new FlowLayout());
    private JLabel menuWelcome = new JLabel("Welcome To Mineral Super Trumps, " + "Select a Category");
    private JLabel menuLabel1 = new JLabel("Dealer is ____  Select category");
    private JComboBox<String> selectCategory = new JComboBox<>(categories);
    JLabel categoryLabel = new JLabel("Dealer: Select a Category");
    private JButton confirmCategory = new JButton("Confirm category");


    /* Fonts */
    private int fontSize = 40;
    private int fontSize2 = 20;
    Font f = new Font("serif", Font.PLAIN, fontSize);
    Font f2 = new Font("serif", Font.PLAIN, fontSize2);


    /*Play Game Frame*/
    private final JPanel panel01 = new JPanel(new GridLayout(5, 0));
    private final JPanel panel02 = new JPanel(new GridLayout(2, 4));
    public ArrayList<JButton> button = new ArrayList<>();

    private JLabel msg1 = new JLabel("player x Turn");
    private JLabel msg2 = new JLabel("Category, value to beat: ");
    private JLabel msg3 = new JLabel("Value to beat: ");
    private JLabel msg4 = new JLabel("Round: ");
    private JButton pass = new JButton("Pass Turn");
    static int categorySelect;

    public GuiMain() {
        super("Mineral Super Trumps Game");
/*
        testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testFrame.getContentPane().setLayout(new BorderLayout());

        card.setVisible(true);
        testFrame.getContentPane().add(testPanel);
        image = new ImageIcon (path + Game.deck.deckArray.get(0));
        label = new JLabel (image);
        card.add(label);
*/

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        /* play or exit Screen*/
        welcomePanel.setVisible(false);
        frame.getContentPane().add(welcomePanel);
        welcomePanel.add(statusMessage);
        welcomePanel.add(playButton);
        welcomePanel.add(exitButton);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                welcomePanel.setVisible(false);
                panelMenu.setVisible(true);
                panelMenu2.setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        /* Category Screen*/
        panelMenu.setVisible(true);
        panelMenu2.setVisible(true);
        panelMenu.setBackground(Color.lightGray);
        frame.getContentPane().add(panelMenu, BorderLayout.NORTH);
        frame.getContentPane().add(panelMenu2, BorderLayout.CENTER);
        panelMenu.add(menuWelcome);
        panelMenu.add(menuLabel1);

        panelMenu2.add(categoryLabel);
        panelMenu2.add(selectCategory);
        panelMenu2.add(confirmCategory);

        menuWelcome.setFont(f);
        menuLabel1.setFont(f2);
        //menuWelcome.setFont(menuWelcome.getFont().deriveFont(newSize));

        /* Play game Frame*/
        panel01.setVisible(false);
        panel02.setVisible(false);
        frame.getContentPane().add(panel01, BorderLayout.WEST);
        frame.getContentPane().add(panel02, BorderLayout.EAST);

        panel01.setBackground(Color.lightGray);
        panel01.add(msg1);
        panel01.add(msg2);
        panel01.add(msg3);
        panel01.add(msg4);
        panel01.add(pass);

        msg1.setFont(f2);

        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Player: "+Game.dealerId+" has passed");
            }
        });


        //GuiGame.playersTurn();
        //Player.PlayerCards(panel01,btn);
        //GuiGame.buildDeck();

//        JButton btn = null;
//        for (int i = 0; i < CARDS_MAX; i++) {
//            btn = new JButton();
//            ImageIcon img = new ImageIcon();
//            //System.out.print(i);
//            btn.setText("Card " + (i + 1));
//            panel02.add(btn);  //adding to frame
//            //System.out.print(btn.getText() + " ");
//        }

        //action from category screen to play game screen
        this.confirmCategory.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (selectCategory.getSelectedItem().equals(categories[0])) {
            categorySelect = 1;
            Game.startRound();
            getCardButtons();
            //GuiGame.playersTurn();
            msg2.setText("Category: " + Game.categoryAsString);
            msg3.setText("Value to beat: " + Game.categoryValueAsString);
            msg1.setText("Player: "+Game.dealerId);
            panel01.setVisible(true);
            panel02.setVisible(true);
            panelMenu.setVisible(false);
            panelMenu2.setVisible(false);
            repaint();
        } else if (selectCategory.getSelectedItem().equals(categories[1])) {
            categorySelect = 2;
            Game.startRound();
            getCardButtons();
            msg1.setText("Player: "+Game.dealerId);
            msg2.setText("Category: " + GuiGame.categoryAsString);
            msg3.setText("Value to beat: " + GuiGame.categoryValueAsString);
            panel01.setVisible(true);
            panel02.setVisible(true);
            panelMenu.setVisible(false);
            panelMenu2.setVisible(false);
            repaint();
        } else if (selectCategory.getSelectedItem().equals(categories[2])) {
            categorySelect = 3;
            Game.startRound();
            getCardButtons();
            msg1.setText("Player: "+Game.dealerId);
            msg2.setText("Category: " + GuiGame.categoryAsString);
            msg3.setText("Value to beat: " + GuiGame.categoryValueAsString);
            panel01.setVisible(true);
            panel02.setVisible(true);
            panelMenu.setVisible(false);
            panelMenu2.setVisible(false);
        } else if (selectCategory.getSelectedItem().equals(categories[3])) {
            categorySelect = 4;
            Game.startRound();
            getCardButtons();
            msg1.setText("Player: "+Game.dealerId);
            msg2.setText("Category: " + GuiGame.categoryAsString);
            msg3.setText("Value to beat: " + GuiGame.categoryValueAsString);
            panel01.setVisible(true);
            panel02.setVisible(true);
            panelMenu.setVisible(false);
            panelMenu2.setVisible(false);
        } else if (selectCategory.getSelectedItem().equals(categories[4])) {
            categorySelect = 5;
            Game.startRound();
            getCardButtons();
            msg1.setText("Player: "+Game.dealerId);
            msg2.setText("Category: " + GuiGame.categoryAsString);
            msg3.setText("Value to beat: " + GuiGame.categoryValueAsString);
            panel01.setVisible(true);
            panel02.setVisible(true);
            panelMenu.setVisible(false);
            panelMenu2.setVisible(false);
        }
    }

    public static void main(String[] args) {
        int numPlayers;
        Game.buildDeck();
        String welcome = ("Welcome to Mineral Super trumps Card Game!");
        do {
            numPlayers = Integer.parseInt(JOptionPane.showInputDialog(null, welcome, "How Many Player? (3 to 5)"));
        } while (numPlayers < 3 || numPlayers > 5);

        GuiMain aFrame = new GuiMain();
        aFrame.frame.setSize(900, 600);
        //aFrame.pack();
        aFrame.frame.setVisible(true);

//        aFrame.testFrame.setSize(600,600);
//        aFrame.testFrame.setVisible(true);


        Game Game = new Game(numPlayers); //creates a new Game object
        Game.dealCards();
        Game.dealer();

        System.out.println("== Game is starting ==\n");
        System.out.println("Dealer:");

        // Game.startRound();
        //Game.playGame();
    }

    public void getCardButtons() {
        for (int x = 0; x < Player.cards.size(); x++) {
            String filePath = "images\\" + Player.cards.get(x).fileName;
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(135, 189, Image.SCALE_SMOOTH));
            button.add(new JButton(imageIcon));
            button.get(x).addActionListener(this);
            panel02.add(button.get(x));
        }

//        JButton cards[] = new JButton[Player.cards.size()];
//        for (int i = 0; i < Player.cards.size(); i++) {
//
//            cards[i] = new JButton((Action) displayCard(Player.cards.get(i)));
//            panel02.add(cards[i]);
//        }
    }

    private Image displayCard(Cards card) {
        ImageIcon cardImage = new ImageIcon("images/" + card.get(card.fileName));
        Image img = cardImage.getImage();
        Image newImg = img.getScaledInstance(136, 190, Image.SCALE_SMOOTH);
        return newImg;

    }


}
