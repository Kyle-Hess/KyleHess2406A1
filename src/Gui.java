import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by Kyle on 13/10/2016.
 */
public class Gui extends JFrame implements ActionListener {
    private final int CARDS_MAX = 8;
    String categories [] = {"Hardness", "Specific gravity","Cleavage","Crystal abundance","Economic Value"};
    private JFrame frame;
    private  JFrame testFrame;

//    JButton[] buttons = new JButton[CARDS_MAX];

    /*test Frame*/
    JPanel testPanel = new JPanel(new CardLayout());
    String path = "images";
    ImageIcon image = new ImageIcon();
    JLabel label = new JLabel();
    JPanel card = new JPanel();


    /*Category Screen*/
    private final JPanel panelMenu = new JPanel(new GridLayout(3, 0));
    private final JPanel panelMenu2 = new JPanel(new FlowLayout());
    private JLabel menuWelcome = new JLabel("Welcome To mineral Super Trumps"+ "Select a Category");
    private JLabel menuLabel1 = new JLabel("Dealer is ____  Select category" );

    private JComboBox<String> selectCategory = new JComboBox<>(categories);
    JLabel categoryLabel = new JLabel("Dealer: Select a Category");
    private JButton confirmCategory = new JButton("Confirm category");


    //Play Game Frame
    private final JPanel panel01 = new JPanel(new GridLayout(3, 0));
    private final JPanel panel02 = new JPanel(new GridLayout(2, 4));

    private JLabel msg1 = new  JLabel("player x Turn");
    private JLabel msg2 = new JLabel(" Category value to beat: ");
    private JLabel msg3 = new JLabel(" Round: ");
    static int categorySelect;


    public Gui() {
        super("Game Play");
        testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testFrame.getContentPane().setLayout(new BorderLayout());

        card.setVisible(true);
        testFrame.getContentPane().add(testPanel);
        image = new ImageIcon (path + Game.deck.deckArray.get(0));
        label = new JLabel (image);
        card.add(label);

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        //Category Screen
        panelMenu.setVisible(true);
        panelMenu2.setVisible(true);
        frame.getContentPane().add(panelMenu,BorderLayout.NORTH);
        frame.getContentPane().add(panelMenu2,BorderLayout.CENTER);

        //panelMenu2.setLayout( new GridLayout(2,3));
        panelMenu.add(menuWelcome);
        panelMenu.add(menuLabel1);


        panelMenu2.add(categoryLabel);
        panelMenu2.add(selectCategory);
        panelMenu2.add(confirmCategory);


        //Play game Frame
        panel01.setVisible(false);
        panel02.setVisible(false);
        frame.getContentPane().add(panel01,BorderLayout.WEST);
        frame.getContentPane().add(panel02,BorderLayout.EAST);

        panel01.add(msg1);
        panel01.add(msg2);
        panel01.add(msg3);

        JButton btn = null;
        for (int i = 0; i < CARDS_MAX; i++) {
            btn = new JButton();
            ImageIcon img = new ImageIcon();
            //System.out.print(i);
            btn.setText("Card " + (i + 1));
            panel02.add(btn);  //adding to frame
            //System.out.print(btn.getText() + " ");
        }

        //action from category screen to play game screen
        this.confirmCategory.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectCategory.getSelectedItem().equals(categories[0])){
                categorySelect = 1;
                Game.startRound();
                //msg2.setText("Category: " + categories[0]);
                msg2.setText("Category: "+Game.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
                panel01.setVisible(true);
                panel02.setVisible(true);
                panelMenu.setVisible(false);
                panelMenu2.setVisible(false);
            }else if (selectCategory.getSelectedItem().equals(categories[1])) {
                msg2.setText("Category: "+Game.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
                categorySelect = 2;
                Game.startRound();
                panel01.setVisible(true);
                panel02.setVisible(true);
                panelMenu.setVisible(false);
                panelMenu2.setVisible(false);
            }else if (selectCategory.getSelectedItem().equals(categories[2])) {
                msg2.setText("Category: "+Game.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
                categorySelect = 3;
                Game.startRound();
                panel01.setVisible(true);
                panel02.setVisible(true);
                panelMenu.setVisible(false);
                panelMenu2.setVisible(false);
            }else if (selectCategory.getSelectedItem().equals(categories[3])) {
                msg2.setText("Category: "+Game.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
                categorySelect = 4;
                Game.startRound();
                panel01.setVisible(true);
                panel02.setVisible(true);
                panelMenu.setVisible(false);
                panelMenu2.setVisible(false);
            }else if (selectCategory.getSelectedItem().equals(categories[4])) {
                categorySelect = 5;
                msg2.setText("Category: "+Game.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
                Game.startRound();
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
            numPlayers = Integer.parseInt( JOptionPane.showInputDialog(null, welcome, "How Many Player? (3 to 5)"));
        } while (numPlayers < 3 || numPlayers > 5);

        Gui aFrame = new Gui();
        aFrame.frame.setSize(500, 400);
        //aFrame.pack();
        aFrame.frame.setVisible(true);

        aFrame.testFrame.setSize(600,600);
        aFrame.testFrame.setVisible(true);


        Game Game = new Game(numPlayers); //creates a new Game object
        Game.dealCards();
        Game.dealer();

        System.out.println("== Game is starting ==\n");
        System.out.println("Dealer:");

       // Game.startRound();
        //Game.playGame();
    }
    public static int getCategoryToPlay() {
        int categorySelect;
        System.out.println("Choo category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
        Scanner inputCategory = new Scanner(System.in);
        categorySelect = inputCategory.nextInt();
        return categorySelect;
    }




}
