import static org.junit.Assert.*;
import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestGame {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Stub players - possible because Game uses Player interface
    private Player alwaysRock    = () -> "rock";
    private Player alwaysPaper   = () -> "paper";
    private Player alwaysScissors = () -> "scissors";

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
        Game game = new Game(alwaysPaper, alwaysRock, new RulesEngine());
        game.play();
        assertTrue(output.toString().contains("You win the game!!!"));
    }

    @Test
    public void testComputerWinsAllRounds() {
        // rock loses to paper
        Game game = new Game(alwaysRock, alwaysPaper, new RulesEngine());
        game.play();
        assertTrue(output.toString().contains("Computer wins the game!!!"));
    }

    @Test
    public void testAllDraws() {
        // same choice every round
        Game game = new Game(alwaysRock, alwaysRock, new RulesEngine());
        game.play();
        assertTrue(output.toString().contains("Game ended in a draw!!!"));
    }

    @Test
    public void testOutputContainsWelcomeMessage() {
        Game game = new Game(alwaysRock, alwaysRock, new RulesEngine());
        game.play();
        assertTrue(output.toString().contains("Welcome to: Rock, Paper, Scissors - CLI Version!"));
    }
}