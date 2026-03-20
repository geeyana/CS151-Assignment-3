/**
 * Enum class for game choices.
 * @author Gianna (geeyana)
 */
public enum Choice {
    ROCK, PAPER, SCISSORS;

    /**
     * Parse input from the user.
     * @param input Choice made by the human player.
     * @return      The enum for that choice.
     */
    public static Choice fromString(String input) {
        return Choice.valueOf(input.trim().toUpperCase());
    }
}
