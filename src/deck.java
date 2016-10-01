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
import java.util.Random;

public class deck extends cards {
    public ArrayList<cards> deckArray;

    public deck() throws ParserConfigurationException, ParseException, SAXException, PropertyListFormatException, IOException {
        deckArray = new ArrayList<cards>();
        Collections.shuffle(deckArray);
        try {
            Integer cardCounter = -1;
            Integer trumpCounter = 53;

            File file = new File("MstCards_151021.plist");
            NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(file);
            NSArray cardsArray = (NSArray) rootDict.objectForKey("cards");

            while (cardCounter < 53) {
                cardCounter = cardCounter + 1;

                NSDictionary card0 = (NSDictionary) cardsArray.objectAtIndex(cardCounter); // index of the cards

                NSString title1 = (NSString) card0.objectForKey("title");
                NSString chemistry1 = (NSString) card0.objectForKey("chemistry");
                NSString classification2 = (NSString) card0.objectForKey("classification");
                NSString crystalSystem3 = (NSString) card0.objectForKey("crystal_system");
                NSArray occurrence4 = (NSArray) card0.objectForKey("occurrence");
                NSString hardness5 = (NSString) card0.objectForKey("hardness");
                NSString specificGravity6 = (NSString) card0.objectForKey("specific_gravity");
                NSString cleavage7 = (NSString) card0.objectForKey("cleavage");
                NSString crustalAbundance8 = (NSString) card0.objectForKey("crustal_abundance");
                NSString economicValue9 = (NSString) card0.objectForKey("economic_value");

                deckArray.add(new cards(title1, chemistry1, classification2, crystalSystem3, occurrence4, hardness5, specificGravity6, cleavage7, crustalAbundance8, economicValue9));

            }

            while (trumpCounter < 59) {
                trumpCounter = trumpCounter + 1;

                NSDictionary card1 = (NSDictionary) cardsArray.objectAtIndex(trumpCounter); // index of the cards

                NSString value0 = (NSString) card1.objectForKey("title");
                NSString value1 = (NSString) card1.objectForKey("subtitle");

                deckArray.add(new TrumpCard(value0, value1));

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void print(){
        for (cards i: deckArray) {
            System.out.println(i.toString());
        }
    }

    public int size(){
        return deckArray.size();
    }

    public ArrayList<cards> dealCards(int numCards) {
        ArrayList<cards> ret = new ArrayList<cards>();
        for (int i = 0; i < numCards; i++){
            int idx = new Random().nextInt(deckArray.size());
            cards card = deckArray.remove(idx);
            ret.add(card);
            //System.out.println("card " +card);
        }
        return ret;
    }
    public cards drawCard(player player){
        Collections.shuffle(deckArray);
        if (deckArray.size()==0){
            System.out.println("Out of cards");
            return null;
        }
        else {
            cards temp = (cards) deckArray.get(deckArray.size()-1);
            deckArray.remove(deckArray.size()-1);
            System.out.println("Card: " + temp + "* Was drawn * \n"
                    + "=====================");
            return temp;
        }
    }


    public cards drawACard() {
        Collections.shuffle(deckArray);
        if (deckArray.size()==0){
            System.out.println("Out of cards");
            return null;
        }
        else {
            cards temp = (cards) deckArray.get(deckArray.size()-1);
            deckArray.remove(deckArray.size()-1);
            System.out.println("Card: " + temp + "* Was drawn * \n"
                    + "=====================");
            return temp;
        }
    }
}