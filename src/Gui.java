import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 13/10/2016.
 */
public class Gui extends JFrame implements ActionListener {

    BorderLayout b = new BorderLayout();
    GridLayout flow = new GridLayout(2,3,3,4);
    GridBagConstraints c =new GridBagConstraints();

    JLabel msg1 = new  JLabel("top label");
    JButton button = new JButton("card 1");
    JButton button2 = new JButton("card 2");
    JButton button3 = new JButton("card 3");
    JButton button4 = new JButton("card 4");

    JLabel msg2 = new JLabel("bottom label");

    public Gui(){
        super("Gui");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //setLayout(b);
        add(msg1);
        setLayout(flow);
        add(button);
        add(button2);
        add(button3);
        add(button4);
        add(msg2);
        button.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //add();
        validate();
        repaint();
    }

    public static void main(String[] args) {
        Gui aFrame = new Gui();
        aFrame.setSize(600, 600);
        aFrame.setVisible(true);
        //aFrame.pack();
    }
}
