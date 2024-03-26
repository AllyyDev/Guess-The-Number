import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;

public class NormalGM {
    Exit exit = new Exit();
    StartingMenu sm = new StartingMenu();

    private int rn;
    private int guesses;
    private double rdn;
    private int lb;
    private int ub;
    private int lives;
    private String option;
    private int gap;

    public void reset() {
        generateRandomBounds();
        generateRandomNumber(ub, lb);
    }

    // random bounds generator
    public int generateRandomBounds() {
        Random random = new Random();

        return random.nextInt(100);
    }

    // random integer number generator
    public int generateRandomNumber(int ub, int lb) {
        Random random = new Random();
        return random.nextInt(ub - lb + 1) + lb;
    }

    // random double number generator
    public double generateRandomDoubleNumber(double ub, double lb) {
        Random random = new Random();
        return random.nextDouble(ub - lb + 1) + lb;
    }

    // difficulty method
    public void difficulty () {
        // Input variable
        Scanner diff = new Scanner(System.in);

        // Difficulty options on Display
        System.out.println("    1.     Easy");
        System.out.println("    2.    Normal");
        System.out.println("    3.     Hard");
        System.out.println("    4.    Insane");
        System.out.println("    5. Mentally-Ill");
        System.out.println(" ");
        System.out.println("-------------------------");

        // user Input
        System.out.println("Choose a Difficulty: ");
        option = diff.nextLine();
        System.out.println("Chosen Difficulty: " + option);

        // Difficulty settings and standards
        if(option.equals("1") || option.equals("1.")) { // Easy diff
            gap = 10;
            lives = 5;

            lb = generateRandomBounds();
            ub = lb + gap;
            rn = generateRandomNumber(ub, lb);
        } else if (option.equals("2") || option.equals("2.")) { // Normal Diff
            gap = 20;
            lives = 5;

            lb = generateRandomBounds();
            ub = lb + gap;
            rn = generateRandomNumber(ub, lb);
        } else if (option.equals("3") || option.equals("3.")) { // Hard Diff
            gap = 50;
            lives = 7;

            lb = generateRandomBounds();
            ub = lb + gap;
            rn = generateRandomNumber(ub, lb);
        } else if (option.equals("4") || option.equals("4.")) { // Insane Diff
            gap = 100;
            lives = 15;

            lb = generateRandomBounds();
            ub = lb + gap;
            rn = generateRandomNumber(ub, lb);
        } else if (option.equals("5") || option.equals("5.")) { // Mentally-Ill Diff
            gap = 10;
            lives = 3;

            lb = generateRandomBounds();
            ub = lb + gap;
            rdn = generateRandomDoubleNumber(ub, lb);
        } else { // In case the player puts in an invalid String value
            System.out.println("You gave an invalid option, enter the number of Difficulty");
            System.out.println(" ");
            difficulty(); // Recursion
        }
    }

    // only shows up if the player won
    public boolean playAgainW() {
        Scanner option = new Scanner(System.in);

        // Display stats
        System.out.println(">>>You Guessed It Right!!!<<<");
        System.out.println(" ");
        System.out.println("Stats: ");
        System.out.println(" ");
        System.out.println("Guesses Made: " + guesses);
        System.out.println("Guesses left: " + lives);
        System.out.println("-----------------");

        System.out.println("Do you want to play again (y/n)");
        String choose = option.nextLine();

        if(choose.equals("y")) {
            return true;
        } else if (choose.equals("n")) {
            sm.starter();
            return false;
        } else {
            System.out.println("Invalid option, choose y or n");
            return playAgainW();
        }
    }

    public boolean playAgainL() {
        Scanner option = new Scanner(System.in);

        // Display stats
        System.out.println("You Guessed it wrong...");
        System.out.println(" ");
        System.out.println("Stats: ");
        System.out.println(" ");
        System.out.println("Guesses Made: " + guesses);
        System.out.println("Guesses left: " + lives);
        System.out.println("-----------------");

        System.out.println("Do you want to play again (y/n)? ");
        String choose = option.nextLine();

        if(choose.equals("y")) {
            return true;
        } else if (choose.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid option, choose y or n");
            System.out.println(" ");
            System.out.println(" ");
            return playAgainL();
        }

    }

    // Game-setting method
    public boolean game() {
        // local variables
        int randomNumber;
        double randomDoubleNumber;
        guesses = 0;
        boolean rg = false;

        // input
        Scanner input = new Scanner(System.in);

        // Game-course on "Mentally Ill" difficulty
        if(option.equals("5") || option.equals("5.")) {
            while(lives != 0 || !rg){
                System.out.println("Guesses Available: " + lives);
                System.out.println("Guesses made: " + guesses);
                System.out.println("Boundary: " + ub + " - " + lb + "   |   " + "gap: " + gap);
                System.out.println("Difficulty: " + option);
                System.out.println("-----------------------------");
                System.out.println(" ");

                System.out.println("Type your guess: ");
                randomDoubleNumber = input.nextDouble();

                if(randomDoubleNumber == rdn) {
                    System.out.println("Wow, you got it right! Awesome!");
                    guesses++;
                    lives--;
                    rg = true;
                    return playAgainW();
                } else {
                    System.out.println("your wrong guess again");
                    lives--;
                    guesses++;
                }
                if(lives == 0) {
                    return playAgainL();
                }

            }
        } else { // Game-course on every other Difficulty
            while(lives != 0 || !rg){
                System.out.println("Guesses Available: " + lives);
                System.out.println("Guesses made: " + guesses);
                System.out.println("Boundary: " + ub + " - " + lb + "   |   " + "gap: " + gap);
                System.out.println("Difficulty: " + option);
                System.out.println("-----------------------------");
                System.out.println(" ");

                System.out.println("Type your guess: ");
                randomNumber = input.nextInt();
                System.out.println(" ");

                if(randomNumber == rn) {
                    System.out.println("Wow, you got it right! Awesome!");
                    guesses++;
                    lives--;
                    rg = true;
                    return playAgainW();
                } else {
                    System.out.println("your wrong guess again");
                    lives--;
                    guesses++;
                }
                if(lives == 0) {
                    return playAgainL();
                }
            }
        }
        return false;
    }
}
