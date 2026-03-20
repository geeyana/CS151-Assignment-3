<<<<<<< HEAD
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRulesEngine {

    private final RulesEngine rulesEngine = new RulesEngine();

    @Test
    public void testDrawCases() {
        assertEquals("draw", rulesEngine.determineWinner("rock", "rock"));
        assertEquals("draw", rulesEngine.determineWinner("paper", "paper"));
        assertEquals("draw", rulesEngine.determineWinner("scissors", "scissors"));
    }

    @Test
    public void testHumanWinsCases() {
        assertEquals("human", rulesEngine.determineWinner("rock", "scissors"));
        assertEquals("human", rulesEngine.determineWinner("paper", "rock"));
        assertEquals("human", rulesEngine.determineWinner("scissors", "paper"));
    }

    @Test
    public void testComputerWinsCases() {
        assertEquals("computer", rulesEngine.determineWinner("rock", "paper"));
        assertEquals("computer", rulesEngine.determineWinner("paper", "scissors"));
        assertEquals("computer", rulesEngine.determineWinner("scissors", "rock"));
=======
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

public class TestRulesEngine
{
    private RulesEngine rulesEngine;
    @Before
    public void setUp(){
        rulesEngine = new RulesEngine();
    }

    @Test
    public void testComputerWinner(){

    }

    @Test
    public void testHumanWinner(){

    }

    @Test
    public void testDraw(){

>>>>>>> b127f76 (Updated TestGame.java and added getters/setters for Game.java)
    }
}
