import com.dd.plist.PropertyListFormatException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kyle on 5/09/2016.
 */
public class hand {
    private static ArrayList<cards> cards;

    // Empty hand
    public hand() {
        cards = new ArrayList<cards>();
    }

    // Hand of n random cards
    public hand(int n) throws PropertyListFormatException, ParserConfigurationException, SAXException, ParseException, IOException {
        deck instance = null;

        cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            instance = new deck();
            Collections.shuffle(instance.deckArray);
            cards.add(instance);
        }
    }

    public static void setCards() {
        System.out.println("test"+cards);
    }
}
