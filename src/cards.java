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

    public  int getHardnessAsInt(String hardness){
        int hardnessValue = 0;
        switch (hardness){
            case "1":return 1;
            case "2":return 2;
            case "3":return 3;

        }return hardnessValue;
    }

    public  int getSpecificGravity(String specific_gravity){
        int sgValue = 0;
        switch (specific_gravity){
            case "1":return 1;
        }return  sgValue;
    }

    public int getCleavage(String cleavage){
        int cleavageValue=0;
        switch (cleavage){
            case "1":return 1;
        }return cleavageValue;
    }

    public int getCrystalAbundance(String crystal_abundance){
        int caValue = 0;
        switch (crystal_abundance){
            case "1":return 1;
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