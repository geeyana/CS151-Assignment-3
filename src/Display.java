import java.util.Scanner;

/**
 * Handles the CLI output for the game.
 * 
 * @author Gianna (geeyana)
 */
public class Display {
    /**
     * Print the welcome message to start the game.
     */
    public void welcome() {
        System.out.printf("%nWelcome to: Rock, Paper, Scissors - CLI Version!");
    }

    /**
     * Shows the number of rounds to the user (set in Game.java)
     * 
     * @param rounds The number of rounds in the game.
     */
    public void showRounds(int rounds) {
        System.out.printf("%nThere will be %d rounds.%n", rounds);
    }

    /**
     * Get user input on the algorithm choice.
     * 
     * @param sc Scanner object for user input.
     * @return The algorithm choice.
     */
    public String chooseAlgo(Scanner sc) {
        System.out.printf("%n%nChoose an algorithm for your opponent:%n");
        System.out.println("    (1) Random Choice");
        System.out.println("    (2) Machine Learning");

        while (true) {
            System.out.print("Enter number here: ");
            String input = sc.nextLine().trim();

            if (!input.equals("1") && !input.equals("2")) {
                System.out.printf("%nInvalid input. Enter 1 or 2.%n");
                continue;
            }

            return input;
        }
    }

    /**
     * Confirm the user's algorithm choice.
     * 
     * @param input The user's algorithm choice.
     */
    public void confirmAlgo(String input) {
        if (input.equals("1")) {
            System.out.printf("%nYou chose: Random choice%n");
        } else if (input.equals("2")) {
            System.out.printf("%nYou chose: Machine learning%n");
        }
    }

    /**
     * After each choice is made, print both.
     * 
     * @param humanChoice    What the human player chose.
     * @param computerChoice What the computer player chose.
     */
    public void printChoices(Choice humanChoice, Choice computerChoice) {
        System.out.printf("%nYou chose: " + humanChoice);
        System.out.printf("%nComputer chose: " + computerChoice);
    }

    /**
     * A header to divide each round.
     * 
     * @param round The current round.
     */
    public void printRoundStart(int round) {
        System.out.printf("%n---------- ROUND %02d ----------%n", round);
    }

    /**
     * A footer to divide each round.
     */
    public void printRoundEnd() {
        System.out.println("------------------------------");
    }

    /**
     * Prints each player's score and the number of draws.
     * 
     * @param humanScore    The human player's score.
     * @param computerScore The computer player's score.
     * @param draws         The number of draws.
     */
    public void printScore(int humanScore, int computerScore, int draws) {
        System.out.printf("%n%-10s %4d%n", "You:", humanScore);
        System.out.printf("%-10s %4d%n", "Computer:", computerScore);
        System.out.printf("%-10s %4d%n", "Draws:", draws);
    }

    /**
     * Print the winner at the end of each round
     * 
     * @param result The winner.
     */
    public void printRoundResult(Result result) {
        switch (result) {
            case HUMAN:
                System.out.printf("%n%nYou win!%n");
                break;
            case COMPUTER:
                System.out.printf("%n%nComputer wins!%n");
                break;
            case DRAW:
                System.out.printf("%n%nIt's a draw!%n");
                break;
        }
    }

    /**
     * Prints the winner at the end of the game.
     */
    public void printResult(Result result) {
        System.out.printf("%n========= GAME OVER ==========%n");

        switch (result) {
            case HUMAN:
                System.out.println("You win the game!!!");
                break;
            case COMPUTER:
                System.out.println("Computer wins the game!!!");
                break;
            case DRAW:
                System.out.println("Game ended in a draw!!!");
                break;
        }

        System.out.println("==============================");
    }

    /**
     * Prints error message if the human gives an incorrect choice.
     */
    public void showInvalidInput() {
        System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
    }
}
