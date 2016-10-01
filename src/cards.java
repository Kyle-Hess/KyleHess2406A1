/**
 * Created by Kyle on 28/08/2016.
 */
import com.dd.plist.NSArray;
import com.dd.plist.NSString;

class cards {
    String title;
    String chemistry;
    String classification;
    String crystal_system;
    NSArray occurrence;
    String hardness;
    String specific_gravity;
    String cleavage;
    String crystal_abundance;
    String economic_value;
    public cards() {}

    public cards(NSString title, NSString chemistry1, NSString classification2, NSString crystalSystem3, NSArray occurrence4, NSString hardness5, NSString specificGravity6, NSString cleavage7, NSString crystalAbundance8, NSString economicValue9) {
        this.title = title.toString();
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
    public String getCategoryInPlay(int categorySelect) {
        String categoryInPlay = "";
        switch (categorySelect) {
            case 1:
                categoryInPlay = this.hardness;
                return categoryInPlay;
            case 2:
                categoryInPlay = this.specific_gravity;
                return categoryInPlay;
            case 3:
                categoryInPlay = this.cleavage;
                return categoryInPlay;
            case 4:
                categoryInPlay = this.crystal_abundance;
                return categoryInPlay;
            case 5:
                categoryInPlay = this.economic_value;
                return categoryInPlay;
        } return categoryInPlay;
    }

    @Override
    public String toString() {
        return ("Element: " + this.title + "\n Chemistry: " + this.chemistry + "\n Classification: " + this.classification + "\n Crystal System: " + this.crystal_system + "\n Occurrence: " + this.occurrence + "\n Hardness: " + this.hardness + "\n Specific gravity: " + this.specific_gravity + "\n Cleavage: " + this.cleavage + "\n Crystal abundance: " + this.crystal_abundance + "\n Economic value: " + this.economic_value + "\n");

    }



    class TrumpCard extends cards {

        String title;
        String subtitle;

        TrumpCard(NSString title, NSString description) {
            this.title= title.toString();
            this.subtitle = description.toString();
        }

        @Override
        public String toString() {
            return ("This Trump Card is " + this.title + "\n Description: " + this.subtitle + "\n");
        }
    }

}