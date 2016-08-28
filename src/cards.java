import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Kyle on 28/08/2016.
 */
public class cards {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }

        DefaultHandler handler = new DefaultHandler(){

            boolean fileName = false;
			boolean imageName = false;
			boolean card_type = false;
            boolean play = false;
            boolean title = false;
            boolean chemistry = false;
            boolean classification = false;
            boolean crystal_system = false;
            boolean occurrence = false;
            boolean hardness = false;
            boolean specific_gravity = false;
            boolean cleavage = false;
            boolean crystal_abundance = false;
            boolean economic_value = false;


            public void startElement( String uri, String localName, String cName, Attributes attributes)
                    throws SAXException{

                if (cName.equalsIgnoreCase("fileName")){
                    fileName = true;
                }
                if (cName.equalsIgnoreCase("imageName")){
                    imageName = true;
                }
                if (cName.equalsIgnoreCase("card_type")){
                    card_type = true;
                }
                if (cName.equalsIgnoreCase("play")){
                    play = true;
                }
                if (cName.equalsIgnoreCase("title")){
                    title = true;
                }
                if (cName.equalsIgnoreCase("chemistry")){
                    chemistry = true;
                }
                if (cName.equalsIgnoreCase("classification")){
                    classification = true;
                }
                if (cName.equalsIgnoreCase("crystal_system")){
                    crystal_system = true;
                }
                if (cName.equalsIgnoreCase("occurrence")){
                    occurrence = true;
                }
                if (cName.equalsIgnoreCase("hardness")){
                    hardness = true;
                }
                if (cName.equalsIgnoreCase("specific_gravity")){
                    specific_gravity = true;
                }
                if (cName.equalsIgnoreCase("cleavage")){
                    cleavage = true;
                }
                if (cName.equalsIgnoreCase("crystal_abundance")){
                    crystal_abundance = true;
                }
                if (cName.equalsIgnoreCase("economic_value")){
                    economic_value = true;
                }
            }
            public void endElement(String uri, String localName, String cName) throws  SAXException{

            }
            public void characters(char ch[], int start, int length) throws  SAXException{

                if(fileName){
                    System.out.println("fileName : " +new String(ch, start, length));
                    fileName = false;
                }
                if(imageName){
                    System.out.println("imageName : " +new String(ch, start, length));
                    imageName = false;
                }
//                if(card_type){
//                    System.out.println("card type : " +new String(ch, start, length));
//                    card_type = false;
//                }
//                if(play){
//                    System.out.println("play : " +new String(ch, start, length));
//                    play = false;
//                }
                if(title){
                    System.out.println("title : " +new String(ch, start, length));
                    title = false;
                }
                if(chemistry){
                    System.out.println("chemistry : " +new String(ch, start, length));
                    chemistry = false;
                }
                if(classification){
                    System.out.println("classification : " +new String(ch, start, length));
                    classification = false;
                }
                if(crystal_system){
                    System.out.println("crystal system : " +new String(ch, start, length));
                    crystal_system = false;
                }
                if(occurrence){
                    System.out.println("occurrence : " +new String(ch, start, length));
                    occurrence = false;
                }
                if(hardness){
                    System.out.println("hardness : " +new String(ch, start, length));
                    hardness = false;
                }
                if(specific_gravity){
                    System.out.println("specific gravity : " +new String(ch, start, length));
                    specific_gravity = false;
                }
                if(cleavage){
                    System.out.println("cleavage : " +new String(ch, start, length));
                    cleavage = false;
                }
                if(crystal_abundance){
                    System.out.println("crystal abundance : " +new String(ch, start, length));
                    crystal_abundance = false;
                }
                if(economic_value){
                    System.out.println("economic value : " +new String(ch, start, length));
                    economic_value = false;
                }

            }
        };
        try {
            saxParser.parse("MstCards_151021.plist", handler);
        } catch (SAXException e){
            e.printStackTrace();
        }
    }
}
//    String cfileName, String cimageName, String cPlay, String cTitle, String cCemistry,
//        String cClassification, String cCrystalSystem, String cOccurrence, String cHardness,
//        String cSpecificGravity, String cCleavage, String cCrystalAbundance, String cEconomicValue

//test