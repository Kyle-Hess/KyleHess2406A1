/**
 * Created by Kyle on 28/08/2016.
 */
import com.dd.plist.NSArray;
import com.dd.plist.NSString;

class cards {
    NSString title;

    cards(NSString in_name) {
        this.title = in_name;
    }

    public cards() {

    }

    public String toString() {
        return ("This element is " + this.title);
    }

}

class MineralCard extends cards {
    private String chemistry;
    private String classification;
    private String crystal_system;
    private NSArray occurrence;
    private String hardness;
    private String specific_gravity;
    private String cleavage;
    private String crystal_abundance;
    private String economic_value;

    MineralCard(NSString title, NSString chemistry1, NSString classification2, NSString crystalSystem3, NSArray occurrence4, NSString hardness5, NSString specificGravity6, NSString cleavage7, NSString crystalAbundance8, NSString economicValue9) {
        super(title);
        this.chemistry = chemistry1.toString();
        this.classification = classification2.toString();
        this.crystal_system = crystalSystem3.toString();
        this.occurrence = occurrence4;
        this.hardness = hardness5.toString();
        this.specific_gravity = specificGravity6.toString();
        this.cleavage = cleavage7.toString();
        this.crystal_abundance = crystalAbundance8.toString();
        this.economic_value = economicValue9.toString();
    }

    public double getHardnessAsInt(String hardness){
        int hardnessValue = 0;
        switch (hardness){
            case "1":return 1;
            case "1-1.5":return 1.25;
            case "1-2":return 1.5;
            case "1.5-2.5":return 2;
            case "2":return 2;
            case "2-3":return 2.5;
            case "2.5":return 2.5;
            case "2.5-3":return 2.75;
            case "2.5-3.5":return 3;
            case "3":return 3;
            case "3-3.5":return 3.25;
            case "3.5-4":return 3.75;
            case "3.5-4.5":return 4;
            case "4":return 4;
            case "4-4.5":return 4.25;
            case "5":return 5;
            case "5-5.5":return 5.25;
            case "5-6":return 5.5;
            case "5.5":return 5.5;
            case "5.5-6":return 5.75;
            case "6":return 6;
            case "5.5-6.5":return 6;
            case "6-6.5":return 6.25;
            case "5.5-7":return 6.25;
            case "6-7":return 6.5;
            case "6.5-7":return 6.6;
            case "6-7.5":return 6.75;
            case "6.5-7.5":return 7;
            case "7":return 7;
            case "7-7.5":return 7.25;
            case "7.5":return 7.5;
            case "7.5-8":return 7.75;
            case "8":return 8;
            case "9":return 9;
            case "10":return 10;

        }return hardnessValue;
    }

    public double getSpecificGravity(String specific_gravity){
        int sgValue = 0;
        switch (specific_gravity){
            case "1":return 1;
            case "2.2":return 2.2;
            case "2.3":return 2.3;
            case "2.4":return 2.4;
            case "2.5-2.6":return 2.55;
            case "2.6":return 2.6;
            case "2.6-2.8":return 2.7;
            case "2.7":return 2.7;
            case "2.6-2.7":return 2.65;
            case "2.65":return 2.65;
            case "2.6-2.9":return 2.75;
            case "2.8-2.9":return 2.85;
            case "2.9":return 2.9;
            case "2.6-3.3":return 2.95;
            case "3.0":return 3;
            case "2.7-3.3":return 3;
            case "3.0-3.2":return 3.1;
            case "3.1-3,2":return 3.15;
            case "3.15":return 3.15;
            case "3.2":return 3.2;
            case "3.0-3.5":return 3.25;
            case "3.25":return 3.25;
            case "3.2-3.5":return 3.35;
            case "3.2-3.6":return 3.4;
            case "3.4-3.6":return 3.5;
            case "3.5":return 3.5;
            case "3.2-3.9":return 3.55;
            case "3.5-3.6":return 3.55;
            case "3.5-3.7":return 3.6;
            case "3.7-3.8":return 3.75;
            case "3.2-4.4":return 3.8;
            case "3.5-4.3":return 3.9;
            case "4.0":return 4;
            case "3.9-4.1":return 4;
            case "4.1-4.3":return 4.2;
            case "4.3":return 4.3;
            case "4.5":return 4.5;
            case "4.6":return 4.6;
            case "4.6-4.7":return 4.65;
            case "4.7":return 4.7;
            case "4.5-5.1":return 4.75;
            case "4.7-4.8":return 4.75;
            case "5.0":return 5.0;
            case "5.0-5.3":return 5.15;
            case "5.2":return 5.2;
            case "5.3":return 5.3;
            case "6.9-7.1":return 7;
            case "7.5-7.6":return 7.55;
            case "19.3":return 19.3;
        }return  sgValue;
    }

    public int getCleavage(String cleavage){
        int cleavageValue=0;
        switch (cleavage){
            case "none":return 0;
            case "poor/none":return 1;
            case "1 poor":return 2;
            case "2 poor":return 3;
            case "1 good, 1 poor":return 4;
            case "1 good":return 5;
            case "2 good":return 6;
            case "3 good":return 7;
            case "1 perfect":return 8;
            case "3 perfect":return 9;
            case "4 perfect":return 10;
            case "6 perfect":return 11;
            case "1 perfect, 1 good":return 12;
            case "1 perfect, 2 good":return 13;
            case "2 perfect, 1 good":return 14;
        }return cleavageValue;
    }

    public int getCrystalAbundance(String crystal_abundance){
        int caValue = 0;
        switch (crystal_abundance){
            case "ultratrace":return 0;
            case "trace":return 1;
            case "low":return 2;
            case "moderate":return 3;
            case "high":return 4;
            case "very high":return 5;
        }return caValue;
    }

    public int getEconomicValueAsInt(String economicValue){
        int economicAsInt = 0;
        switch (economicValue){
            case "trivial": return 1;
            case "low": return 2;
            case "moderate": return 3;
            case "high": return 4;
            case "very high": return 5;
            case "I'm rich": return 6;
        }return economicAsInt;
    }

    @Override
    public String toString() {
        return ("Element: " + this.title + "\n Chemistry: " + this.chemistry + "\n Classification: " + this.classification + "\n Crystal System: " + this.crystal_system + "\n Occurrence: " + this.occurrence + "\n Hardness: " + this.hardness + "\n Specific gravity: " + this.specific_gravity + "\n Cleavage: " + this.cleavage + "\n Crystal abundance: " + this.crystal_abundance + "\n Economic value: " + this.economic_value + "\n");

    }

}
class TrumpCard extends cards {
    NSString subtitle;

    TrumpCard(NSString in_name, NSString description) {
        super(in_name);
        this.subtitle = description;
    }

    @Override
    public String toString() {
        return ("This Trump Card is " + this.title + "\n Description: " + this.subtitle + "\n");
    }


}