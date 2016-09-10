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

    public String toString() {
        return ("This element is " + this.title);
    }
}

class MineralCard extends cards {
    NSString chemistry;
    NSString classification;
    NSString crystal_system;
    NSArray occurrence;
    NSString hardness;
    NSString specific_gravity;
    NSString cleavage;
    NSString crystal_abundance;
    NSString economic_value;

    MineralCard(NSString in_name, NSString in_class1, NSString in_class2, NSString in_class3, NSArray in_class4, NSString in_class5, NSString in_class6, NSString in_class7, NSString in_class8, NSString in_class9) {
        super(in_name);
        this.chemistry = in_class1;
        this.classification = in_class2;
        this.crystal_system = in_class3;
        this.occurrence = in_class4;
        this.hardness = in_class5;
        this.specific_gravity = in_class6;
        this.cleavage = in_class7;
        this.crystal_abundance = in_class8;
        this.economic_value = in_class9;
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