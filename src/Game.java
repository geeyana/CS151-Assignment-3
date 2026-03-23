
/**
 * Plays a game of Rock, Paper, Scissors with a human versus a computer.
 * 
 * @author Gianna (geeyana)
 */

public class Game {
    private Player human;
    private Player computer;
    private RulesEngine rulesEngine;
    private Display display;
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
    public Game(Player human, Player computer, RulesEngine rulesEngine, Display display) {
        this.human = human;
        this.computer = computer;
        this.rulesEngine = rulesEngine;
        this.display = display;
    }

    /**
     * Plays a round.
     * Gets choices from both players and determines a winner with rulesEngine.
     * Prints the round result and updates the score.
     */
    private void playRound() {
        Choice humanChoice = human.getChoice();
        Choice computerChoice = computer.getChoice();

        display.printChoices(humanChoice, computerChoice);

        Result winner = rulesEngine.determineWinner(humanChoice, computerChoice);
        switch (winner) {
            case HUMAN:
                humanScore++;
                break;
            case COMPUTER:
                computerScore++;
                break;
            case DRAW:
                draws++;
                break;
        }

        display.printRoundResult(winner);
    }

    /**
     * Runs the full game for a set number of rounds.
     * Prints the scores and number of draws for each round.
     * Prints the final game winner at the end.
     */
    public void play() {
        display.showRounds(TOTAL_ROUNDS);

        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            display.printRoundStart(round);
            playRound();
            display.printScore(humanScore, computerScore, draws);
            display.printRoundEnd();
        }

        Result finalWinner;
        if (humanScore == computerScore) {
            finalWinner = Result.DRAW;
        } else if (humanScore > computerScore) {
            finalWinner = Result.HUMAN;
        } else {
            finalWinner = Result.COMPUTER;
        }

        display.printResult(finalWinner);
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