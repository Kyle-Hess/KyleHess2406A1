import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 13/10/2016.
 */
public class Gui extends JFrame implements ActionListener {

    BorderLayout b = new BorderLayout();
    GridLayout grid = new GridLayout(2,3,3,4);
    GridBagLayout gb =new GridBagLayout();

//    JFrame frame = new JFrame("Mineral Super trumps");
//    JPanel panel = new JPanel();
    private JLabel msg1 = new  JLabel("top label");
    private JButton button = new JButton("card 1");
    private JButton button2 = new JButton("card 2");
    private JButton button3 = new JButton("card 3");
    private JButton button4 = new JButton("card 4");
    private JLabel msg2 = new JLabel("bottom label");

    public Gui(){
        super("Game Play");

        //panel.setLayout(new GridLayout(3,4,3,3));
        setLayout(grid);

        add(msg1);
        add(button);
        add(button2);
        add(button3);
        add(button4);
        add(msg2);
        //button.addActionListener(this);
        //frame.add(panel);


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
        String welcome = ("Welcome to Mineral Super trumps Card Game!");
        do {
            numPlayers = Integer.parseInt( JOptionPane.showInputDialog(null, welcome, "How Many Player? (3 to 5)"));
        } while (numPlayers < 3 || numPlayers > 5);


        Gui aFrame = new Gui();

        //aFrame.setSize(600, 600);
        aFrame.pack();
        aFrame.setVisible(true);

    }
}
