import com.dd.plist.PropertyListFormatException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Kyle on 15/08/2016.
 */
public class main {
    public static void main(String[] args) {

        deck instance = null;
        try {
            instance = new deck();
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
//instance.print();
        System.out.println(instance.deckArray.get(0).toString());
        System.out.println(instance.deckArray.size());
        //System.out.println(instance.deckArray);


        // asks for the amount of players, to create player objects

        System.out.println("How Many players? (3 to 5) ");
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();

        Player[] players = new Player[amount];
        for(int i = 0; i < amount; i++) {
            players[i] = new Player();
        }
        System.out.println("number of players is:");
        Player.numberOfPlayers();



        System.out.println("while loop begins. q to quit");
        Scanner keyboard = new Scanner(System.in);
        String choice2 = keyboard.nextLine();
        char c = choice2.charAt(0);
        while (c != 'q'){

            System.out.println(choice2);


        }
    }

//    public static void playerInput( ) {
//        System.out.println("How Many players? (3 to 5) ");
//        Scanner input = new Scanner(System.in);
//        int choice = input.nextInt();
//
//        if (choice > 3 || choice < 5 ){
//            System.out.println("something");
//        } else {
//            System.out.println("Error");
//        }
//
//    }
//
//    }

}
