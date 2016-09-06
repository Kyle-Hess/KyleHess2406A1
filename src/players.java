/**
 * Created by Kyle on 28/08/2016.
 */
import java.util.Scanner;

public class players{
    public static void main(String args[]) {

    System.out.print("How many Payers? :");
    Scanner input = new Scanner(System.in);
    int amount = input.nextInt();

    if (amount > 3 || amount < 5 ){
        System.out.println("something");
    } else {
        System.out.println("Error");
    }


    Player[] players = new Player[amount];
    for(int i = 0; i < amount; i++) {
        players[i] = new Player();
    }
    Player.numberOfPlayers();
    }
}
class Player {
    private static int count = 0;
    public Player(){
    count++;
    }
    public static void numberOfPlayers(){
        System.out.println(count);
    }
}

