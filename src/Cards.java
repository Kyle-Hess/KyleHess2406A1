import com.dd.plist.NSArray;
import com.dd.plist.NSString;

class Cards {
    String title;
    String fileName;
    String chemistry;
    String classification;
    String crystal_system;
    NSArray occurrence;
    String hardness;
    String specific_gravity;
    String cleavage;
    String crystal_abundance;
    String economic_value;

    public Cards() {
    }

    public Cards(NSString title, NSString fileName, NSString chemistry1, NSString classification2, NSString crystalSystem3, NSArray occurrence4, NSString hardness5, NSString specificGravity6, NSString cleavage7, NSString crystalAbundance8, NSString economicValue9) {
        this.title = title.toString();
        this.fileName = fileName.toString();
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

    // Mineral card objects
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
        }
        return categoryInPlay;
    }

    @Override
    public String toString() {
        return ("Element: " + this.title + "\n Chemistry: " + this.chemistry + "\n Classification: " + this.classification + "\n Crystal System: " + this.crystal_system + "\n Occurrence: " + this.occurrence + "\n Hardness: " + this.hardness + "\n Specific gravity: " + this.specific_gravity + "\n Cleavage: " + this.cleavage + "\n Crystal abundance: " + this.crystal_abundance + "\n Economic value: " + this.economic_value + "\n");

    }

    public String get(String fileName) {
        this.fileName = fileName;
        return fileName;
    }

    //trump card objects
    class TrumpCard extends Cards {

        String title;
        String fileName;
        String subtitle;

        TrumpCard(NSString title,NSString fileName, NSString description) {
            this.title = title.toString();
            this.fileName = fileName.toString();
            this.subtitle = description.toString();
        }

        @Override
        public String toString() {
            return ("This Trump Card is " + this.title + "\n Description: " + this.subtitle + "\n");
        }
    }

}
//import com.dd.plist.NSArray;
//import com.dd.plist.NSString;
//
///**
// * Created by pccc on 8/27/2016.
// */
////this class is where the card classes are created and stored
//
//abstract class Cards {
//    String title;
//    String fileName;
//
//    Cards() {
//
//    }
//
//    Cards(NSString in_name, NSString inFileName) {
//
//        this.title = in_name.toString();
//        this.fileName = inFileName.toString();
//    }
//
//    abstract String getChemistry();
//
//    abstract String getClassification();
//
//    abstract String getCrystal_system();
//
//    abstract NSArray getOccurrence();
//
//    abstract String getHardness();
//
//    abstract String getSpecific_gravity(); //might change to float
//
//    abstract String getCleavage();
//
//    abstract String getCrustal_abundance();
//
//    abstract String getEconomic_value();
//
//    abstract String getDescription();
//
//    public String toString() {
//        return ("\n" + "Card name: " + this.title + "\n Hardness: " + getHardness() + "\n Specific Gravity: " + getSpecific_gravity() +
//                "\n Cleavage: " + getCleavage() + "\n Crustal Abundance: " + getCrustal_abundance() + "\n Economic Value: " + getEconomic_value() + "\n");
//    }
//
//
//    public abstract String getCategoryInPlay(int categoryNumber);
//
//    public String get(String fileName) {
//        this.fileName = fileName.toString();
//        return fileName;
//    }
//}
//
//abstract class MineralCard extends Cards {
//    public String chemistry;
//    public String classification;
//    public String crystal_system;
//    public NSArray occurrence;
//    public String hardness;
//    public String specific_gravity; //might change to float
//    public String cleavage;
//    public String crystal_abundance;
//    public String economic_value;
//
//    MineralCard(NSString in_name, NSString inFileName, NSString in_class1, NSString in_class2, NSString in_class3, NSArray in_class4, NSString in_class5, NSString in_class6, NSString in_class7, NSString in_class8, NSString in_class9) {
//        super(in_name, inFileName);
//        this.chemistry = in_class1.toString();
//        this.classification = in_class2.toString();
//        this.crystal_system = in_class3.toString();
//        this.occurrence = in_class4;
//        this.hardness = in_class5.toString().replaceAll("\\s+","");
//        this.specific_gravity = in_class6.toString().replaceAll("\\s+","");
//        this.cleavage = in_class7.toString();
//        this.crystal_abundance = in_class8.toString();
//        this.economic_value = in_class9.toString();
//    }
//
//    public String getCategoryInPlay(int categoryNumber) {
//        String categoryInPlay = "";
//        switch (categoryNumber) {
//            case 1:
//                categoryInPlay = this.hardness;
//                return categoryInPlay;
//            case 2:
//                categoryInPlay = this.specific_gravity;
//                return categoryInPlay;
//            case 3:
//                categoryInPlay = this.cleavage;
//                return categoryInPlay;
//            case 4:
//                categoryInPlay = this.crystal_abundance;
//                return categoryInPlay;
//            case 5:
//                categoryInPlay = this.economic_value;
//                return categoryInPlay;
//        }
//        return categoryInPlay;
//    }
//
//    /*public String toString() { return (this.specific_gravity + " "); }*/
//
//    @Override
//    public String getChemistry() {
//        return chemistry;
//    }
//
//    public String getClassification() {
//        return classification;
//    }
//
//    public String getCrystal_system() {
//        return crystal_system;
//    }
//
//    public NSArray getOccurrence() {
//        return occurrence;
//    }
//
//    public String getHardness() {
//        return hardness;
//    }
//
//    public String getSpecific_gravity() {
//        return specific_gravity;
//    }
//
//    public String getCleavage() {
//        return cleavage;
//    }
//
//    public String getCrustal_abundance() {
//        return crystal_abundance;
//    }
//
//    public String getEconomic_value() {
//        return economic_value;
//    }
//
//}
//
//abstract class TrumpCard extends Cards {
//    public String subtitle;
//
//    TrumpCard(NSString in_name, NSString inFileName, NSString in_class10) {
//        super(in_name, inFileName);
//        this.subtitle = in_class10.toString();
//    }
//
//    @Override
//    public String getDescription() {
//        return subtitle;
//    }
//    /*
//    public String toString() {
//        return ("This Trump Card is " + this.title + "\n its description is " + this.subtitle + "\n");
//    }
//    */
//
//}
//
/////**
//// * Created by Kyle on 28/08/2016.
//// */
////
////import com.dd.plist.NSArray;
////import com.dd.plist.NSString;
////
////abstract class Cards {
////    String title;
////    String fileName;
////
////    Cards(NSString title, NSString inFilename) {
////        this.title = title.toString();
////        this.fileName = inFilename.toString();
////    }
////
////    Cards() {
////    }
////
////    public abstract String getCategoryInPlay(int categoryNumber);
////
////
////    static class MineralCards extends Cards {
////        String chemistry;
////        String classification;
////        String crystal_system;
////        NSArray occurrence;
////        String hardness;
////        String specific_gravity;
////        String cleavage;
////        String crystal_abundance;
////        String economic_value;
////
////        MineralCards(NSString title, NSString inFilename, NSString chemistry1, NSString classification2, NSString crystalSystem3, NSArray occurrence4, NSString hardness5, NSString specificGravity6, NSString cleavage7, NSString crystalAbundance8, NSString economicValue9) {
////
////            //            this.fileName = filename.toString();
//////            this.title = title.toString();
////            super(title, inFilename);
////            this.chemistry = chemistry1.toString();
////            this.classification = classification2.toString();
////            this.crystal_system = crystalSystem3.toString();
////            this.occurrence = occurrence4;
////            this.hardness = hardness5.toString();
////            this.specific_gravity = specificGravity6.toString();
////            this.cleavage = cleavage7.toString();
////            this.crystal_abundance = crystalAbundance8.toString();
////            this.economic_value = economicValue9.toString();
////        }
////
////        // Mineral card objects
////        public String getCategoryInPlay(int categorySelect) {
////            String categoryInPlay = "";
////            switch (categorySelect) {
////                case 1:
////                    categoryInPlay = this.hardness;
////                    return categoryInPlay;
////                case 2:
////                    categoryInPlay = this.specific_gravity;
////                    return categoryInPlay;
////                case 3:
////                    categoryInPlay = this.cleavage;
////                    return categoryInPlay;
////                case 4:
////                    categoryInPlay = this.crystal_abundance;
////                    return categoryInPlay;
////                case 5:
////                    categoryInPlay = this.economic_value;
////                    return categoryInPlay;
////            }
////            return categoryInPlay;
////        }
////
////        @Override
////        public String toString() {
////            return ("Element: " + this.title + "\n Chemistry: " + this.chemistry + "\n Classification: " + this.classification + "\n Crystal System: " + this.crystal_system + "\n Occurrence: " + this.occurrence + "\n Hardness: " + this.hardness + "\n Specific gravity: " + this.specific_gravity + "\n Cleavage: " + this.cleavage + "\n Crystal abundance: " + this.crystal_abundance + "\n Economic value: " + this.economic_value + "\n");
////
////        }
////
////        //trump card objects
////        abstract static class TrumpCard extends Cards {
////            private final String subtitle;
////
//////            String title;
//////            String.fileName;
//////            String subtitle;
////
////            TrumpCard(NSString inFileName, NSString title, NSString description) {
////                super(title, inFileName);
//////                this.title = title.toString();
//////                this.fileName = fileName.toString();
////                this.subtitle = description.toString();
////            }
////
////            @Override
////            public String toString() {
////                return ("This Trump Card is " + this.title + "\n Description: " + this.subtitle + "\n");
////            }
////        }
////    }
////}