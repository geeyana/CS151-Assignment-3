import static org.junit.Assert.*;
import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestGame {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final Display display = new Display();

    // Stub players - possible because Game uses Player interface
    private Player alwaysRock    = () -> Choice.ROCK;
    private Player alwaysPaper   = () -> Choice.PAPER;
    private Player alwaysScissors = () -> Choice.SCISSORS;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testHumanWinsAllRounds() {
        // paper beats rock
        Game game = new Game(alwaysPaper, alwaysRock, new RulesEngine(), display);
        game.play();
        assertTrue(output.toString().contains("You win the game!!!"));
    }

    @Test
    public void testComputerWinsAllRounds() {
        // rock loses to paper
        Game game = new Game(alwaysRock, alwaysPaper, new RulesEngine(), display);
        game.play();
        assertTrue(output.toString().contains("Computer wins the game!!!"));
    }

    @Test
    public void testAllDraws() {
        // same choice every round
        Game game = new Game(alwaysRock, alwaysRock, new RulesEngine(), display);
        game.play();
        assertTrue(output.toString().contains("Game ended in a draw!!!"));
    }

    @Test
    public void testComputerScoreKeeping() {
        Game game = new Game(alwaysRock, alwaysPaper, new RulesEngine(), display);
        game.play();
        assertEquals(20, game.getComputerScore());
    }

    @Test
    public void testHumanScoreKeeping() {
        Game game = new Game(alwaysScissors, alwaysPaper, new RulesEngine(), display);
        game.play();
        assertEquals(20, game.getHumanScore());
    }

    @Test
    public void testDrawsScoreKeeping() {
        Game game = new Game(alwaysScissors, alwaysScissors, new RulesEngine(), display);
        game.play();
        assertEquals(20, game.getDraws());
    }
}