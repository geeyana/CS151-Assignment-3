import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestHumanPlayer
{
    private final InputStream OriginalIn = System.in;
    private final PrintStream OriginalOut = System.out;
    private final PrintStream OriginalErr = System.err;
    private final ByteArrayOutputStream TheirOut = new ByteArrayOutputStream();
    private final ByteArrayOutputStream TheirErr = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(TheirOut));
        System.setErr(new PrintStream(TheirErr));
    }

    @After
    public void tearDown(){
        System.setIn(OriginalIn);
        System.setOut(OriginalOut);
        System.setErr(OriginalErr);
    }

    private void provideInput(String data){
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    public void testRock(){
        provideInput("1\n");
        Scanner scanner = new Scanner(System.in);
        HumanPlayer player = new HumanPlayer("test", scanner);
        String result = player.getChoice();
        assertEquals("rock", result);
    }

    @Test
    public void testPaper(){
        provideInput("2\n");
        Scanner scanner = new Scanner (System.in);
        HumanPlayer player = new HumanPlayer("test", scanner);
        String result = player.getChoice();
        assertEquals("paper", result);
    }

    @Test
    public void testScissors(){
        provideInput("3\n");
        Scanner scanner = new Scanner(System.in);
        HumanPlayer player = new HumanPlayer("test", scanner);
        String result = player.getChoice();
        assertEquals("scissors", result);

    }


}