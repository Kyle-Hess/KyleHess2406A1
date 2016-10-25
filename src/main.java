import java.util.Scanner;

/**
 * Created by Kyle on 15/08/2016.
 *
 * BUG: SOMETIMES AFTER ENTERING PLAYER AMOUNT AN EXCEPTION OCCURS* restart required
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
        //when the Game ends this asks the Player if they want to play again
        while (running) {
            gameStart();
            System.out.println("Game ends");
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
        int numPlayers;
        //gets the number of players until the condition is met
        System.out.println("Welcome to Mineral Supertrumps Card Game!");
        Game.buildDeck();
        do {
            System.out.println("How Many Player? (3 to 5) ");
            Scanner input = new Scanner(System.in);
            numPlayers = input.nextInt();
        } while (numPlayers < 3 || numPlayers > 5);
        System.out.println(numPlayers + " players in this Game.");
        Game Game = new Game(numPlayers); //creates a new Game object
        Game.dealCards();
        Game.dealer();
        //Game.showPlayers();//test method

        System.out.println("== Game is starting ==\n");
        System.out.println("Dealer:");

        //Game.showPlayerCards(players);//test method for showing Player cards
        //=======================

        do {//
            Game.playGame();
            System.out.println("round done");
        } while (!gameOver);
    }

    public static int getCategoryToPlay() {//get the category for the first round
        int categorySelect;
        System.out.println("Choose category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
        Scanner inputCategory = new Scanner(System.in);
        categorySelect = inputCategory.nextInt();
        return categorySelect;
    }

    public static int playOrPass() {//asks the user to play a card or pass their turn
        int playOrPass;
        Scanner input_playOrPass = new Scanner(System.in);
        do {
            System.out.println("1: Play a card\n2: Pass turn");
            playOrPass = input_playOrPass.nextInt();
        } while (playOrPass != 1 && playOrPass != 2);
        return playOrPass;
    }

    public static int getCardToPlay() {// gets the users card
        Scanner inputCardToPlay = new Scanner(System.in);
        System.out.println("Choose card to play");
        int cardToPlay = inputCardToPlay.nextInt();
        return cardToPlay;
    }

    // TODO:multiple rounds
    // TODO:integrate Trump cards (if trump card placed round is won and category set)
    // TODO: first Player with no cards wins
}