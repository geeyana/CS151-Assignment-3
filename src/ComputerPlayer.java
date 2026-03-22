import java.util.EnumMap;
import java.util.Random;

/**
 * Implements Coding To Interface Design Principle
 * @author SyedZain
 */
public class ComputerPlayer implements Player {

    private final Random random = new Random();

    @Override
    public Choice getChoice() {
        Choice[] choices = Choice.values();
        int randomChoice = random.nextInt(choices.length);
        return choices[randomChoice];
    }
}
