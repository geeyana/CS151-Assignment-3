
/**
 * Plays a game of Rock, Paper, Scissors with a human versus a computer.
 * Design principles: cohesion, delegation
 * @author Gianna (geeyana)
 */
public class Game
{
    private Player human;
    private Player computer;
    private RulesEngine rulesEngine;
    private int humanScore;
    private int computerScore;
    private int draws;
    private static final int TOTAL_ROUNDS = 20;

    /**
     * Creates a new Game with the players and rules engine.
     *
     * @param human       The human player
     * @param computer    The computer player
     * @param rulesEngine The rules engine used to determine round winners
     */
    public Game(Player human, Player computer, RulesEngine rulesEngine){
        this.human = human;
        this.computer = computer;
        this.rulesEngine = rulesEngine;
    }

    /**
     * Plays a round.
     * Gets choices from both players and determines a winner with rulesEngine.
     * Prints the round result and updates the score.
     */
    private void playRound(){
        String humanChoice = human.getChoice();
        String computerChoice = computer.getChoice();

        System.out.println("You chose: " + humanChoice);
        System.out.println("Computer chose: " + computerChoice);

        String winner = rulesEngine.determineWinner(humanChoice, computerChoice); // delegation

        switch (winner) {
            case "human":
                humanScore++;
                System.out.println("You win!");
                break;
            case "computer":
                computerScore++;
                System.out.println("Computer wins!");
                break;
            case "draw":
                draws++;
                System.out.println("It's a draw!");
                break;
        }
    }

    /** 
     * Runs the full game for a set number of rounds.
     * Prints the scores and number of draws for each round.
     * Prints the final game winner at the end.
     */
    public void play() {
        System.out.println("Welcome to: Rock, Paper, Scissors - CLI Version!");
        System.out.printf("There will be %d rounds.%n", TOTAL_ROUNDS);

        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            System.out.printf("%n---------- ROUND %02d ----------%n", round);
            playRound();
            printScore();
            System.out.println("------------------------------");
        }

        printResult();
    }

    /**
     * Prints each player's score and the number of draws.
     */
    private void printScore() {
        System.out.printf("%n%-10s %4d%n", "You:", humanScore);
        System.out.printf("%-10s %4d%n", "Computer:", computerScore);
        System.out.printf("%-10s %4d%n", "Draws:", draws);
    }

    /**
     * Displays the winner at the end of the game.
     */
    private void printResult() {
        System.out.printf("%n========== GAME OVER ===========%n");
        
        if (humanScore > computerScore) {
            System.out.println("You win the game!!!");
        }
        else if (computerScore > humanScore) {
            System.out.println("Computer wins the game!!!");
        }
        else {
            System.out.println("Game ended in a draw!!!");
        }
        System.out.println("================================");
    }

    /**
     * Get the computer's score for testing.
     * 
     * @return The computer player's score.
     */
    public int getComputerScore() {
        return computerScore;
    }

    /**
     * Get the human's score for testing.
     * 
     * @return The human player's score.
     */
    public int getHumanScore() {
        return humanScore;
    }

    /**
     * Get the number of draws.
     * 
     * @return The number of draws.
     */
    public int getDraws() {
        return draws;
    }
}