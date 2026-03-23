/**
 * Handles the CLI output for the game.
 * @author Gianna (geeyana)
 */
public class Display {
    /**
     * Print the welcome message to start the game.
     * @param rounds    The total number of rounds for the game.
     */
    public void welcome(int rounds) {
        System.out.println("Welcome to: Rock, Paper, Scissors - CLI Version!");
        System.out.printf("There will be %d rounds.%n", rounds);
    }

    /**
     * After each choice is made, print both.
     * @param humanChoice       What the human player chose.
     * @param computerChoice    What the computer player chose.
     */
    public void printChoices(Choice humanChoice, Choice computerChoice) {
        System.out.printf("%nYou chose: " + humanChoice);
        System.out.printf("%nComputer chose: " + computerChoice);
    }

    /**
     * A header to divide each round.
     * @param round     The current round.
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
     * @param result    The winner.
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
}
