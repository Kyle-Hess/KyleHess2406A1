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

            for (int i = 0; i < numPlayers; i++) {
                player newPlayer = new player("player" + (i+1));
                while (newPlayer.cards.size() < 8) {
                    newPlayer.cards.add(game.deck.deckArray.remove(0));
                }
                game.players.add(newPlayer);
            }

        } while (numPlayers < 3 || numPlayers > 5);
        System.out.println(numPlayers + " players in this game.");

        game game = new game(numPlayers); //creates a new game object

        //game.dealCards();
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
    // TODO:multiple rounds
    // TODO:integrate Trump cards (if trump card placed round is won and category set)
    // TODO: first player with no cards wins
}