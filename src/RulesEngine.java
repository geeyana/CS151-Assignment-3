public class RulesEngine implements IRulesEngine {

    @Override
    public String determineWinner(String humanChoice, String computerChoice) {

        if (humanChoice == null || computerChoice == null) {
            throw new IllegalArgumentException("Choices cannot be null.");
        }

        String human = humanChoice.trim().toLowerCase();
        String computer = computerChoice.trim().toLowerCase();

        if (human.equals(computer)) {
            return "draw";
        }

        if ((human.equals("rock") && computer.equals("scissors")) ||
            (human.equals("paper") && computer.equals("rock")) ||
            (human.equals("scissors") && computer.equals("paper"))) {
            return "human";
        }

        return "computer";
    }
}