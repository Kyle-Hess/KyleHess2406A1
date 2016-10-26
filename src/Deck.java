/**
 * Created by Kyle on 10/09/2016.
 */

import com.dd.plist.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Cards {
    public ArrayList<Cards> deckArray;//Deck array stores cards

    // searches through plist card dictionary and creats an array to store them
    public Deck() throws ParserConfigurationException, ParseException, SAXException, PropertyListFormatException, IOException {
        deckArray = new ArrayList<Cards>();
        try {
            Integer cardCounter = -1;
            Integer trumpCounter = 53;

            File file = new File("MstCards_151021.plist");
            NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(file);
            NSArray cardsArray = (NSArray) rootDict.objectForKey("Cards");

            while (cardCounter < 53) {//looping through and adding mineral cards to array
                cardCounter = cardCounter + 1;

                NSDictionary card0 = (NSDictionary)cardsArray.objectAtIndex(cardCounter); // index of the cards

                NSString title1 = (NSString) card0.objectForKey("title");
                NSString fileName = (NSString) card0.objectForKey("fileName");
                NSString chemistry1 = (NSString) card0.objectForKey("chemistry");
                NSString classification2 = (NSString) card0.objectForKey("classification");
                NSString crystalSystem3 = (NSString) card0.objectForKey("crystal_system");
                NSArray occurrence4 = (NSArray) card0.objectForKey("occurrence");
                NSString hardness5 = (NSString) card0.objectForKey("hardness");
                NSString specificGravity6 = (NSString) card0.objectForKey("specific_gravity");
                NSString cleavage7 = (NSString) card0.objectForKey("cleavage");
                NSString crustalAbundance8 = (NSString) card0.objectForKey("crustal_abundance");
                NSString economicValue9 = (NSString) card0.objectForKey("economic_value");

                deckArray.add(new Cards(title1, fileName, chemistry1, classification2, crystalSystem3, occurrence4, hardness5, specificGravity6, cleavage7, crustalAbundance8, economicValue9));

            }

            while (trumpCounter < 59) {//looping through and adding trump cards to array
                trumpCounter = trumpCounter + 1;

                NSDictionary card1 = (NSDictionary) cardsArray.objectAtIndex(trumpCounter); // index of the cards

                NSString value0 = (NSString) card1.objectForKey("title");
                NSString value1 = (NSString) card1.objectForKey("fileName");
                NSString value2 = (NSString) card1.objectForKey("subtitle");

                deckArray.add(new TrumpCard(value0, value1,value2));

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void print() {
        for (Cards i : deckArray) {
            System.out.println(i.toString());
        }
    }

    public int size() {
        return deckArray.size();
    }// returns the size of the Deck

    public ArrayList<Cards> dealCards(int numCards) {//deals cards to players and removes the cards taken from Deck
        ArrayList<Cards> ret = new ArrayList<Cards>();
        for (int i = 0; i < numCards; i++) {
            ret.add(deckArray.remove(0));
            //System.out.println("card " +card);
        }
        return ret;
    }

    public Cards drawCard() {// draw a card from the Deck and returns it to the players cards/hand
        Collections.shuffle(deckArray);
        if (deckArray.size() == 0) {
            System.out.println("Out of cards");
            return null;
        } else {
            Cards temp = (Cards) deckArray.get(deckArray.size() - 1);
            deckArray.remove(deckArray.size() - 1);
            System.out.println("Card: " + temp + "* Was drawn * \n"
                    + "=====================");
            return temp;
        }
    }



//    public cards drawACard() {
//        Collections.shuffle(deckArray);
//        if (deckArray.size() == 0) {
//            System.out.println("Out of cards");
//            return null;
//        } else {
//            cards temp = (cards) deckArray.get(deckArray.size() - 1);
//            deckArray.remove(deckArray.size() - 1);
//            System.out.println("Card: " + temp + "* Was drawn * \n"
//                    + "=====================");
//            return temp;
//        }
//    }
}


///**
// * Created by Kyle on 10/09/2016.
// */
//
//import com.dd.plist.*;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.File;
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Collections;
//
//
////this class is where the DDPlist reader searchs the Plist file for the data so it can be stored as an object in an array
//public class Deck {
//    public static ArrayList<Cards> deckArray = new ArrayList();
//
//    Deck() throws ParserConfigurationException, ParseException, SAXException, PropertyListFormatException, IOException {
//
//        try {
//            Integer cardCounter = -1;
//            Integer trumpCounter = 53;
//
//            File file = new File("MstCards_151021.plist");
//            NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(file);
//            NSArray cardsArray = (NSArray) rootDict.objectForKey("cards");
//
//
//            while (cardCounter < 53) {
//                cardCounter = cardCounter + 1;
//
//                NSDictionary card0 = (NSDictionary) cardsArray.objectAtIndex(cardCounter); // index of the cards
//
//                //each of these searches for the key and assigns its value to a place
//                // in the object that is then stored in the arraylist deck
//                NSString value0 = (NSString) card0.objectForKey("title");
//                NSString value1 = (NSString) card0.objectForKey("fileName");
//                NSString value2 = (NSString) card0.objectForKey("chemistry");
//                NSString value3 = (NSString) card0.objectForKey("classification");
//                NSString value4 = (NSString) card0.objectForKey("crystal_system");
//                //NSString value4 = (NSString) card0.objectForKey("occurrence"); /*value4 +*/
//                NSArray value5 = (NSArray) card0.objectForKey("occurrence");
//                //NSString value41 = (NSString) card0.objectForKey("string");
//                NSString value6 = (NSString) card0.objectForKey("hardness");
//                NSString value7 = (NSString) card0.objectForKey("specific_gravity");
//                NSString value8 = (NSString) card0.objectForKey("cleavage");
//                NSString value9 = (NSString) card0.objectForKey("crustal_abundance");
//                NSString value10 = (NSString) card0.objectForKey("economic_value");
//
//                deckArray.add(new MineralCard(value0, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10) {
//                    @Override
//                    String getDescription() {
//                        return null;
//                    }
//                });
//
//            }
//
//            while (trumpCounter < 59) {
//                trumpCounter = trumpCounter + 1;
//
//                NSDictionary card1 = (NSDictionary) cardsArray.objectAtIndex(trumpCounter); // index of the cards
//
//                NSString value0 = (NSString) card1.objectForKey("title");
//                NSString value1 = (NSString) card1.objectForKey("fileName");
//                NSString value2 = (NSString) card1.objectForKey("subtitle");
//
//                deckArray.add(new TrumpCard(value0, value1, value2) {
//                    @Override
//                    String getChemistry() {
//                        return null;
//                    }
//
//                    @Override
//                    String getClassification() {
//                        return null;
//                    }
//
//                    @Override
//                    String getCrystal_system() {
//                        return null;
//                    }
//
//                    @Override
//                    NSArray getOccurrence() {
//                        return null;
//                    }
//
//                    @Override
//                    String getHardness() {
//                        return null;
//                    }
//
//                    @Override
//                    String getSpecific_gravity() {
//                        return null;
//                    }
//
//                    @Override
//                    String getCleavage() {
//                        return null;
//                    }
//
//                    @Override
//                    String getCrustal_abundance() {
//                        return null;
//                    }
//
//                    @Override
//                    String getEconomic_value() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getCategoryInPlay(int categoryNumber) {
//                        return null;
//                    }
//                });
//
//            }
//
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void print() {
//        for (Cards i : deckArray) {
//            System.out.println(i.toString());
//        }
//    }
//
//    public int size() {
//        return deckArray.size();
//    }// returns the size of the Deck
//
//    public ArrayList<Cards> dealCards(int numCards) {//deals cards to players and removes the cards taken from Deck
//        ArrayList<Cards> ret = new ArrayList<Cards>();
//        for (int i = 0; i < numCards; i++) {
//            ret.add(deckArray.remove(0));
//            //System.out.println("card " +card);
//        }
//        return ret;
//    }
//
//    public Cards drawCard() {// draw a card from the Deck and returns it to the players cards/hand
//        Collections.shuffle(deckArray);
//        if (deckArray.size() == 0) {
//            System.out.println("Out of cards");
//            return null;
//        } else {
//            Cards temp = (Cards) deckArray.get(deckArray.size() - 1);
//            deckArray.remove(deckArray.size() - 1);
//            System.out.println("Card: " + temp + "* Was drawn * \n"
//                    + "=====================");
//            return temp;
//        }
//    }
//
//
//
////    public cards drawACard() {
////        Collections.shuffle(deckArray);
////        if (deckArray.size() == 0) {
////            System.out.println("Out of cards");
////            return null;
////        } else {
////            cards temp = (cards) deckArray.get(deckArray.size() - 1);
////            deckArray.remove(deckArray.size() - 1);
////            System.out.println("Card: " + temp + "* Was drawn * \n"
////                    + "=====================");
////            return temp;
////        }
////    }
//}