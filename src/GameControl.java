/**
 * Created by Kyle on 25/10/2016.
 */
public class GameControl {
    static GuiGame instance;
    static final int length = 600;
    static  final int height = 600;

    public static void getGameInstance(GuiGame gameInstance){
        instance = gameInstance;
    }

    public static void startGuiCategory(){
        GuiCategory guiCategory = new GuiCategory(instance);
        guiCategory.setSize(length, height);
        guiCategory.setVisible(true);
    }

    public static void startGuiGame(){
        GuiGame guiGame = new GuiGame();
        guiGame.setSize(length, height);
        guiGame.setVisible(true);
    }


}
