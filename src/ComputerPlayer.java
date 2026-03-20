import java.util.EnumMap;
import java.util.Random;

/**
 * Implements Coding To Interface Design Principle
 * @author SyedZain
 */
public class ComputerPlayer implements Player {

    //private String[] choice = {"rock", "paper", "scissors"};
    private final EnumMap<Choice, Integer> choiceMap = new EnumMap<>(Choice.class);

    @Override
    public String getChoice() {
        int min = 0;
        int max = choiceMap.size() - 1;
        Random random = new Random();
        int randomNum = random.nextInt(max - min + 1) + min;
        return choiceMap.get(choiceMap.randomNum);
    }
}
