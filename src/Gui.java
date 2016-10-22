import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 13/10/2016.
 */
public class Gui extends JFrame implements ActionListener {
    private final int CARDS_MAX = 8;

    private JFrame frame;

//    JButton[] buttons = new JButton[CARDS_MAX];

    //Category Screen
    private final JPanel panelMenu = new JPanel(new GridLayout(3, 0));
    private final JPanel panelMenu2 = new JPanel(new GridLayout(1,1));
    private JLabel menuWelcome = new JLabel("Welcome To mineral Super Trumps"+ "Select a Category");
    private JLabel menuLabel1 = new JLabel("Dealer is ____" );
    private JButton categorySelectBtn = new JButton("continue");




    //Play Game Frame
    private final JPanel panel01 = new JPanel(new GridLayout(3, 0));
    private final JPanel panel02 = new JPanel(new GridLayout(2, 4));

    private JLabel msg1 = new  JLabel("player x Turn");
    private JLabel msg2 = new JLabel(" Category value to beat: ");
    private JLabel msg3 = new JLabel(" Round: ");

    public Gui() {
        super("Game Play");

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        //Category Screen
        panelMenu.setVisible(true);
        panelMenu2.setVisible(true);
        frame.getContentPane().add(panelMenu,BorderLayout.WEST);
        frame.getContentPane().add(panelMenu2);

        //panelMenu2.setLayout( new GridLayout(1,1));
        panelMenu2.add(menuLabel1, BorderLayout.NORTH);
        panelMenu2.add(categorySelectBtn,BorderLayout.SOUTH);

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
            //System.out.print(i);
            btn.setText("Card " + (i + 1));
            panel02.add(btn);  //adding to frame
            //System.out.print(btn.getText() + " ");
        }


        //action from category screen to play game screen

        categorySelectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel01.setVisible(true);
                panel02.setVisible(true);
                panelMenu2.setVisible(false);
            }
        });
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
        aFrame.frame.setSize(500, 400);
        //aFrame.pack();
        aFrame.frame.setVisible(true);

        Game Game = new Game(numPlayers); //creates a new Game object
        Game.dealCards();
        Game.dealer();

        System.out.println("== Game is starting ==\n");
        System.out.println("Dealer:");

        Game.playGame();





    }
}
