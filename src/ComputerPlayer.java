import java.util.EnumMap;
import java.util.Random;

/**
 * Implements Coding To Interface Design Principle
 * 
 * @author SyedZain
 */
public class ComputerPlayer implements Player {

    private final ChoiceAlgorithm algorithm;

    public ComputerPlayer(ChoiceAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public Choice getChoice() {
        return algorithm.makeChoice();
    }

    public void recordResult(Choice computerChoice, Choice humanChoice) {
        algorithm.recordResult(computerChoice, humanChoice);

    }

    public void saveData() {
        algorithm.saveData();
    }
}
