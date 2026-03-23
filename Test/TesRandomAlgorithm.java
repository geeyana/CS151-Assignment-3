import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Need to update it @author Zain
 */
public class TesRandomAlgorithm
{
    private ComputerPlayer player;
    private ChoiceAlgorithm algorithm;

    @Before
    public void setUp(){
        algorithm = FactoryChoiceAlgorithm.create("1");
        player = new ComputerPlayer(algorithm);
    }

    /**
     * This is to test whether every option is legal
     */
    @Test
    public void testGetChoice(){
        List<String> validChoice = List.of("rock", "paper", "scissors");

        for(int i = 0; i < 200; i++){
            Choice result = player.getChoice();
            assertTrue(validChoice.contains(result.toString().toLowerCase()));
        }
    }

    /**
     * This is to test whether all options can be returned
     */
    @Test
    public void testAllOptions(){
        Set<String> seen = new HashSet<String>();

        for(int i = 0; i < 200; i++){
            seen.add(player.getChoice().toString().toLowerCase());
        }
        assertTrue(seen.contains("rock"));
        assertTrue(seen.contains("paper"));
        assertTrue(seen.contains("scissors"));
    }


}
