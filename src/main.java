import java.util.Scanner;

/**
 * Created by Kyle on 15/08/2016.
 */
public class main {
    public static void main(String[] args) {

        playerInput();

        Scanner keyboard = new Scanner(System.in);
        String choice2 = keyboard.nextLine();
        char c = choice2.charAt(0);
        while (c != 'q'){


            System.out.println(choice2);


        }
    }

    public static void playerInput() {
        System.out.println("How Many players? (3 to 5) ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice > 3 || choice < 5 ){
            System.out.println("something");
        } else {
            System.out.println("Error");
        }

    }

}
