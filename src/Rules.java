public class Rules {

    public void display() {
        System.out.println("            <<<Rules>>>");
        System.out.println(" ");
        System.out.println("1.  Normal Mode");
        System.out.println("------------------- ");
        System.out.println("2. Double Guesser");
    }

    public void normalMode() {
        System.out.println(" ");
        System.out.println("Objective: ");
        System.out.println("~~~~~~~~~~~");
        System.out.println("- Dependant on the Difficulty, there is a gap-with lower and upper-boundaries set");
        System.out.println("- You have to guess the random number inbetween the boundaries");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Outcome: ");
        System.out.println("~~~~~~~~~~~");
        System.out.println("- You win: congrats you won"); //add a reward system
        System.out.println("- You lose: Now you have lost, there are the following punishments");
        System.out.println("  --> first one: 20 normal push-ups");
        System.out.println("  --> Second one: 8 Diamond push-ups");
        System.out.println(" ");
        System.out.println("REMEMBER: only weaklings and scared little kids wont do the punishment, it's your choice...");
        System.out.println(" ");
        System.out.println(" ");
    }

    public void doubleGuesser() {
        System.out.println(" ");
        System.out.println("Objective:");
        System.out.println("~~~~~~~~~~~~");
        System.out.println("- Dependant on the Difficulty, there is a timer and a diagramm");
        System.out.println("- In the Diagramm there are 25 different squares all containing different numbers.");
        System.out.println("- The rarer the number the higher points you will get");
        System.out.println("- the objective is to get as many of the same numbers at the same time");
        System.out.println("- if the time is over you will get you Score-point displayed");
        System.out.println("- these scored points can be used to unlock features and gadgets");
        System.out.println("- if you have guessed the right all the numbers before its time out then you get additional Points");
        System.out.println("- the points are based on the chosen Difficulty");
        System.out.println(" ");
        System.out.println(" ");
    }
}
