import java.util.Random;

/**
 * Implements Coding To Interface Design Principle
 * @author SyedZain
 */
public class ComputerPlayer implements Player {

    private String[] choice = {"rock", "paper", "scissor"};

    @Override
    public String getChoice() {
        int min = 0;
        int max = choice.length - 1;
        Random random = new Random();
        int randomNum = random.nextInt(max - min + 1) + min;
        return choice[randomNum];
    }
}
