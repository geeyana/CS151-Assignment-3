import org.junit.Test;
import static org.junit.Assert.*;

public class TestRulesEngine {

    private final RulesEngine rulesEngine = new RulesEngine();

    @Test
    public void testDrawCases() {
        assertEquals(Result.DRAW, rulesEngine.determineWinner(Choice.ROCK, Choice.ROCK));
        assertEquals(Result.DRAW, rulesEngine.determineWinner(Choice.PAPER, Choice.PAPER));
        assertEquals(Result.DRAW, rulesEngine.determineWinner(Choice.SCISSORS, Choice.SCISSORS));
    }

    @Test
    public void testHumanWinsCases() {
        assertEquals(Result.HUMAN, rulesEngine.determineWinner(Choice.ROCK, Choice.SCISSORS));
        assertEquals(Result.HUMAN, rulesEngine.determineWinner(Choice.PAPER, Choice.ROCK));
        assertEquals(Result.HUMAN, rulesEngine.determineWinner(Choice.SCISSORS, Choice.PAPER));
    }

    @Test
    public void testComputerWinsCases() {
        assertEquals(Result.COMPUTER, rulesEngine.determineWinner(Choice.ROCK, Choice.PAPER));
        assertEquals(Result.COMPUTER, rulesEngine.determineWinner(Choice.PAPER, Choice.SCISSORS));
        assertEquals(Result.COMPUTER, rulesEngine.determineWinner(Choice.SCISSORS, Choice.ROCK));
    }
}