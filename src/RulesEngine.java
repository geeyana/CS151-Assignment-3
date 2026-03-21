/**
 * RulesEngine determines the winner of a Rock-Paper-Scissors round.
 *
 * Design Principles:
 * - Cohesion: This class is only responsible for determining the winner.
 * - Encapsulation: The Game class delegates winner logic to this class.
 *
 * @author Mahika
 */
public class RulesEngine implements IRulesEngine {
    /**
     * Determines the winner of a round.
     *
     * @param humanChoice the human player's choice
     * @param computerChoice the computer player's choice
     * @return "human" if human wins,
     *         "computer" if computer wins,
     *         "draw" if both choices are the same
     */
    @Override
    public String determineWinner(String humanChoice, String computerChoice) {

        if (humanChoice == null || computerChoice == null) {
            throw new IllegalArgumentException("Choices cannot be null.");
        }

        String human = humanChoice.trim().toLowerCase();
        String computer = computerChoice.trim().toLowerCase();

        // Draw case
        if (human.equals(computer)) {
            return "draw";
        }

        // Human winning cases
        if ((human.equals("rock") && computer.equals("scissors")) ||
            (human.equals("paper") && computer.equals("rock")) ||
            (human.equals("scissors") && computer.equals("paper"))) {
            return "human";
        }

        // Otherwise computer wins
        return "computer";
    }
}