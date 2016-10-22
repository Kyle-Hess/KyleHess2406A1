import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 13/10/2016.
 */
public class Gui extends JFrame implements ActionListener {

    private final int CARDS_MAX = 8;
//    BorderLayout b = new BorderLayout();
//    GridLayout grid = new GridLayout(2,3,3,4);
//    GridBagLayout gb =new GridBagLayout();
//    JButton[] buttons = new JButton[CARDS_MAX];

    //    JFrame frame = new JFrame("Mineral Super trumps");
    //JPanel panel = new JPanel();
    //Container container = new Container();

    private JPanel panel01 = new JPanel(new GridLayout(3, 0));
    private JPanel panel02 = new JPanel(new GridLayout(2, 4));
    //private JPanel panel03 = new JPanel(new GridLayout(2, 0));

    private JLabel msg1 = new  JLabel("player x Turn");
    private JLabel msg2 = new JLabel(" Category value to beat: ");
    private JLabel msg3 = new JLabel(" Round: ");

    public Gui() {
        super("Game Play");
        setLayout(new BorderLayout());
        add(panel01, BorderLayout.WEST);
        add(panel02, BorderLayout.EAST);
        //add(panel03,BorderLayout.SOUTH);

        panel01.add(msg1);
        panel01.add(msg2);
        panel01.add(msg3);

//        panel02.add(button);
//        panel02.add(button2);
//        panel02.add(button3);
//        panel02.add(button4);

        JButton btn = null;
        for (int i = 0; i < CARDS_MAX; i++) {
            btn = new JButton();
            //System.out.print(i);
            btn.setText("Card " + (i + 1));
            panel02.add(btn);                 //adding to frame
            //System.out.print(btn.getText() + " ");
        }
        btn.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //add();
        validate();
        repaint();
    }

    public static void main(String[] args) {
        int numPlayers;
        Game.buildDeck();
        String welcome = ("Welcome to Mineral Super trumps Card Game!");
        do {
            numPlayers = Integer.parseInt( JOptionPane.showInputDialog(null, welcome, "How Many Player? (3 to 5)"));
        } while (numPlayers < 3 || numPlayers > 5);
        Gui aFrame = new Gui();
        aFrame.setSize(500, 400);
        //aFrame.pack();
        aFrame.setVisible(true);

        Game Game = new Game(numPlayers); //creates a new Game object
        Game.dealCards();
        Game.dealer();





    }
}
