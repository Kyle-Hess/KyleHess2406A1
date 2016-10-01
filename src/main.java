import java.util.Scanner;

/**
 * Created by Kyle on 15/08/2016.
 */
public class main {
    static boolean gameOver;
    public static void main(String[] args) {

        main t = new main();

    }

    public Scanner input = new Scanner(System.in);

    public main() {
        run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            gameStart();

            System.out.println("game ends");
            System.out.println("play again? y/n");
            boolean validResponse = false;
            while (!validResponse) {
                String response = input.nextLine();
                switch (response) {
                    case "y":
                        validResponse = true;
                        running = true;
                        break;
                    case "n":
                        validResponse = true;
                        running = false;
                        break;
                    default:
                        validResponse = false;
                        break;
                }
            }
        }
    }

    public void gameStart() {

        System.out.println("How Many Player? (3 to 5) ");
        Scanner input = new Scanner(System.in);

        int numPlayers = input.nextInt();
        game game = new game(numPlayers);
        //game.dealer();
        game.dealCards();
        //game.showPlayers();
        //game.selectPlayer();
//        player[] showsAPlayer = game.getPlayer();
//        showPlayer(showsAPlayer);
        System.out.println("== Game is starting ==");

        //game.showPlayerCards(players);


        //====

        do {
            //System.out.println("* Place a card. *");
//            int cardNum = input.nextInt();
//            System.out.println(cardNum + " was played");
            game.playGame();
            System.out.println("round done");
        }while (!gameOver);

    }


    private int getPlayersCard(int amount) {
        return amount;
    }

    private void showPlayer(player[] plays) {
        System.out.println(plays +"\n");
    }

    private int getNumPlayers(int amount) {
        int i = amount;
        System.out.println("Players: "+i);
        return i;
    }
}