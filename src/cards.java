import com.dd.plist.*;

import java.io.File;


/**
 * Created by Kyle on 28/08/2016.
 */
public class cards {
    public static void main(String[] args) {

        try {
            File file = new File("MstCards_151021.plist");
            NSDictionary rootDict = (NSDictionary)PropertyListParser.parse(file);
            String name = rootDict.objectForKey("fileName").toString();
            NSObject[] parameters = ((NSArray)rootDict.objectForKey("Parameters")).getArray();
            for(NSObject param:parameters) {
                if(param.getClass().equals(NSNumber.class)) {
                    NSNumber num = (NSNumber)param;
                    switch(num.type()) {
                        case NSNumber.BOOLEAN : {
                            boolean bool = num.boolValue();
                            //...
                            break;
                        }
                        case NSNumber.INTEGER : {
                            long l = num.longValue();
                            //or int i = num.intValue();
                            //...
                            break;
                        }
                        case NSNumber.REAL : {
                            double d = num.doubleValue();
                            //...
                            break;
                        }
                    }
                    // else...
                }
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
