import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestComputerPlayer
{
    private ComputerPlayer player;

    @Before
    public void setUp(){
        player = new ComputerPlayer();
    }

    /**
     * This is to test whether every option is legal
     */
    @Test
    public void testGetChoice(){
        List<String> validChoice = List.of("rock", "paper", "scissors");

        for(int i = 0; i < 200; i++){
            String result = player.getChoice();
            assertTrue(validChoice.contains(result));
        }
    }

    /**
     * This is to test whether all options can be returned
     */
    @Test
    public void testAllOptions(){
        Set<String> seen = new HashSet<String>();

        for(int i = 0; i < 200; i++){
            seen.add(player.getChoice());
        }
        assertTrue(seen.contains("rock"));
        assertTrue(seen.contains("paper"));
        assertTrue(seen.contains("scissors"));
    }

    /**
     * This is to test whether the method returns null
     */
    @Test
    public void testNullOption(){
        for(int i = 0; i < 200; i++){
            assertFalse(player.getChoice().isEmpty());
        }
    }
}
