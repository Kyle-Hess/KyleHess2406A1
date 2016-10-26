import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 25/10/2016.
 */
public class GuiCategory extends JFrame implements ActionListener {
    static GuiGame instance;
    static GameControl lCinstance;

    String categories [] = {"Hardness", "Specific gravity","Cleavage","Crystal abundance","Economic Value"};
    /*Category Screen*/
    final JPanel panelMenu = new JPanel(new GridLayout(3, 0));
    final JPanel panelMenu2 = new JPanel(new FlowLayout());
    JLabel menuWelcome = new JLabel("Welcome To mineral Super Trumps"+ "Select a Category");
    JLabel menuLabel1 = new JLabel("Dealer is ____  Select category" );

    JComboBox<String> selectCategory = new JComboBox<>(categories);
    JLabel categoryLabel = new JLabel("Dealer: Select a Category");
    JButton confirmCategory = new JButton("Confirm category");

    JButton hardnessButton = new JButton("Hardness");
    JButton specificGravityButton = new JButton("Specific Gravity");
    JButton cleavageButton = new JButton("Cleavage");
    JButton crustalAbundanceButton = new JButton("Crustal Abundance");
    JButton economicValueButton = new JButton("Economic Value");


    static int categorySelect;
    public int numPlayers;

    public static void getLaunchControl(GameControl gameControl){
        lCinstance = gameControl;

    }

    public GuiCategory(Game gameInstance){

        //Category Screen
        panelMenu.setVisible(true);
        panelMenu2.setVisible(true);
        add(panelMenu,BorderLayout.NORTH);
        add(panelMenu2,BorderLayout.CENTER);

        //panelMenu2.setLayout( new GridLayout(2,3));
        panelMenu.add(menuWelcome);
        panelMenu.add(menuLabel1);

        panelMenu2.add(categoryLabel);
        panelMenu2.add(selectCategory);
        panelMenu2.add(confirmCategory);

//        panelMenu2.add(hardnessButton);
//        panelMenu2.add(specificGravityButton);
//        panelMenu2.add(cleavageButton);
//        panelMenu2.add(crustalAbundanceButton);
//        panelMenu2.add(economicValueButton);

        //this.selectCategory.addActionListener(this);
        this.confirmCategory.addActionListener(this);
    }
//action from category screen to play game screen
    @Override
    public void actionPerformed(ActionEvent e) {
//        if (selectCategory.getSelectedItem().equals(categories[0])){
//            categorySelect = 1;
//            GuiGame.startRound();
//            GameControl.startGuiGame(numPlayers);
//            //GuiGame.startRound();
//            //msg2.setText("Category: " + categories[0]);
//            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
//            //JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
//            GuiGame.msg2.setText("Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
//            dispose();
//
//        }else if (e.getSource() == specificGravityButton) {
//            categorySelect = 2;
//            GuiGame.startRound();
//            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
//            JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
//            dispose();
//
//        }else if (e.getSource() == cleavageButton) {
//            categorySelect = 3;
//            GuiGame.startRound();
//            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
//            JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
//            dispose();
//        }else if (e.getSource() == crustalAbundanceButton) {
//            categorySelect = 4;
//            GuiGame.startRound();
//            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
//            JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
//            dispose();
//        }else if (e.getSource() == economicValueButton) {
//            categorySelect = 5;
//            GuiGame.startRound();
//            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
//            JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
//            dispose();
//        }
        if (selectCategory.getSelectedItem().equals(categories[0])){
            categorySelect = 1;
            GameControl.startGuiGame();
            //GuiGame.startRound();
            //msg2.setText("Category: " + categories[0]);
            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
            //JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
            GuiGame.msg2.setText("Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
            dispose();

        }else if (selectCategory.getSelectedItem().equals(categories[1])) {
            categorySelect = 2;
            GuiGame.startRound();
            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
            JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
            dispose();

        }else if (selectCategory.getSelectedItem().equals(categories[2])) {
            categorySelect = 3;
            GuiGame.startRound();
            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
            JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
            dispose();
        }else if (selectCategory.getSelectedItem().equals(categories[3])) {
            categorySelect = 4;
            GuiGame.startRound();
            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
            JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
            dispose();
        }else if (selectCategory.getSelectedItem().equals(categories[4])) {
            categorySelect = 5;
            GuiGame.startRound();
            //msg2.setText("Category: "+GuiGame.categoryAsString+"\n Value to beat: "+Game.categoryValueAsString);
            JOptionPane.showMessageDialog(null, "Category: " + GuiGame.categoryAsString+"Value to beat: "+GuiGame.categoryValueAsString);
            dispose();
        }
    }
}
