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
        //when the game ends this asks the player if they want to play again
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
        int numPlayers;
        //gets the number of players until the condition is met
        System.out.println("Welcome to Mineral Supertrumps Card Game!");
        game.buildDeck();
        do {
            System.out.println("How Many Player? (3 to 5) ");
            Scanner input = new Scanner(System.in);
            numPlayers = input.nextInt();
        } while (numPlayers < 3 || numPlayers > 5);
        System.out.println(numPlayers + " players in this game.");
        game game = new game(numPlayers); //creates a new game object
        game.dealCards();
        game.dealer();
        //game.showPlayers();//test method

        System.out.println("== Game is starting ==\n");
        System.out.println("Dealer:");

        //game.showPlayerCards(players);//test method for showing player cards
        //=======================

        do {//
            game.playGame();
            System.out.println("round done");
        } while (!gameOver);
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
    // TODO: first player with no cards wins
}