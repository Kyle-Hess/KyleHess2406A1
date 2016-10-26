import com.dd.plist.PropertyListFormatException;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Kyle on 13/10/2016.
 */
public class test extends JFrame implements ActionListener {
    private static GuiGame game;
    private static GameControl gameControl;

    private final int CARDS_MAX = 8;
    private JFrame frame;

    private final JPanel panelMenu = new JPanel(new GridLayout(3, 0));
    FlowLayout flowLayout = new FlowLayout();
    JLabel statusMessage = new JLabel("Welcome to the Mineral Super Trumps Game \n Please select an option");
    JButton runButton = new JButton("Play Game");
    JButton exitButton = new JButton("Exit");
//    JButton[] buttons = new JButton[CARDS_MAX];

    //Play Game Frame
    public test() {
        super("Game Play");
        setLayout(flowLayout);
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        frame.getContentPane().add(panelMenu);

        panelMenu.add(statusMessage);
        panelMenu.add(runButton);
        panelMenu.add(exitButton);
        runButton.addActionListener(this);
        exitButton.addActionListener(this);



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
        //this.confirmCategory.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runButton) {
            //JOptionPane.showMessageDialog(null, "The Game will now begin good luck");
            GameControl.startGuiCategory();

            frame.dispose();
        } else if (e.getSource() == exitButton) {
            JOptionPane.showMessageDialog(null, "Goodbye");
            frame.dispose();
        }

    }

    public static void main(String[] args) throws PropertyListFormatException, ParserConfigurationException, SAXException, ParseException, IOException {


        int numPlayers;

        GuiGame.buildDeck();
        String welcome = ("Welcome to Mineral Super trumps Card Game!");
        do {
            numPlayers = Integer.parseInt(JOptionPane.showInputDialog(null, welcome, "How Many Player? (3 to 5)"));
        } while (numPlayers < 3 || numPlayers > 5);

        test aFrame = new test();
        aFrame.frame.setSize(500, 400);
        aFrame.frame.setVisible(true);



        //Game Game = new Game(numPlayers); //creates a new Game object
//        GuiGame.dealCards();
//        //GuiGame.dealer();
//
//        gameControl = new GameControl();
//        //GameControl.getGameInstance(GuiGame);
//        GuiCategory.getLaunchControl(gameControl);
//        GuiGame.getLaunchControl(gameControl);

        game = new GuiGame(numPlayers);
        game.deck = new Deck();
        game.players = new Player[]{};

        gameControl = new GameControl();

        gameControl.getGameInstance(game);
        GuiGame.getLaunchControl(gameControl);
        GuiCategory.getLaunchControl(gameControl);


        //startScreen();

        System.out.println("== Game is starting ==\n");
        System.out.println("Dealer:");

        // Game.startRound();
        //Game.playGame();
    }

    private static void startScreen() {
        //GuiWelcome guiWelcome = new GuiWelcome();
//        game.setSize(500, 200);
//        game.setVisible(true);

    }
//    public static int getCategoryToPlay() {
//        int categorySelect;
//        System.out.println("Choo category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
//        Scanner inputCategory = new Scanner(System.in);
//        categorySelect = inputCategory.nextInt();
//        return categorySelect;
//    }


}
