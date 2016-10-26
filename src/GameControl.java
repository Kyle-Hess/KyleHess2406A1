/**
 * Created by Kyle on 25/10/2016.
 */
public class GameControl {

    static Game instance;
    static final int length = 800;
    static  final int height = 800;


    public static void getGameInstance(Game gameInstance){
        instance = gameInstance;
    }

    public static void startGuiCategory(){
        GuiCategory guiCategory = new GuiCategory(instance);
        guiCategory.setSize(length, height);
        guiCategory.setVisible(true);
    }

    public static void startGuiGame(){
        GuiGame guiGame = new GuiGame(instance);
        guiGame.setSize(length, height);
        guiGame.setVisible(true);
    }


}
