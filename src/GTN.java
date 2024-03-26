import java.util.Scanner;

public class GTN {
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        NormalGM settings = new NormalGM();
        Rules rules = new Rules();
        Credits credits = new Credits();
        Exit exit = new Exit();
        StartingMenu sm = new StartingMenu();
        DoubleG doubleG = new DoubleG();

        while (true) {
            sm.starter();
            int choice = inp.nextInt();
            System.out.println(" ");

            if (choice == 1) {
                settings.difficulty();
                if (!settings.game()) {
                    break; // Exit the loop if the player chooses not to play again
                }
            } else if (choice == 2) {
                doubleG.game(); // isn't finished yet
                if (!doubleG.game()) {
                    break; // Exit the loop if the player chooses not to play again
                }
            } else if (choice == 3) {
                rules.display();
                int choose = inp.nextInt();
                System.out.println(" ");
                do {
                    if (choose == 1) {
                        rules.normalMode();
                        break;
                    } else if (choose == 2) {
                        rules.doubleGuesser();
                        break; // Exit the loop if the player chooses not to play again
                    } else {
                        System.out.println("That is an invalid option number. Type the right option number!");
                        choose = inp.nextInt(); // Ask for input again
                        System.out.println(" ");
                    }
                } while (true);
            } else if (choice == 4) {
                credits.credits();
                break; // Exit the loop if the player chooses not to play again
            } else if (choice == 5) {
                exit.exit();
                break; // Exit the loop after the game is finished
            } else {
                System.out.println("You typed a wrong option number. Type the right option number");
            }
        }
    }
}

// noch nicht fertig!
        /*
          1. Verbinde die start option mit der setting klasse
          > Gamemodes machen und difficulty anpassen
          2. Credits
          > credits seite machen
          3. Rules
          > eine klasse die zeigt, was die verschiedenen Regeln von verschiedenen Gamemodes sind
          4. Exit
          > die option ermöglichen das spiel sofort auszumachen
          Bonus: wenn man das Spiel gewinnt oder verliert und man n eingibt, dass man zurück zur startseite kehrt
          und nicht, dass man direkt das Spiel endet

        System.out.println("Welcome to Guess The Number!");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1. Start");
        System.out.println("2. Credits");
        System.out.println("3. Rules");
        System.out.println("4. Exit");
         */

