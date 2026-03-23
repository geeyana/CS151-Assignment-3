import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;


import static org.junit.Assert.*;

public class MLAlgorithmTest {

    private ChoiceAlgorithm mlAlg;


    public void deleteFile() throws IOException {
        Path filePath = Paths.get("ml_data.txt");
        try{
            Files.deleteIfExists(filePath);

        }
        catch (Exception e){
            System.err.println("Failed to delete file due to " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
        deleteFile();
        assertFalse(Files.exists(Paths.get("ml_data.txt")));
        mlAlg = FactoryChoiceAlgorithm.create("2");

    }

    @After
    public void tearDown() throws Exception {
        deleteFile();
        assertFalse(Files.exists(Paths.get("ml_data.txt")));
    }

    /**
     * what happens when history is empty
     */
    @Test
    public void testMakeChoice1(){
        Choice test1 = mlAlg.makeChoice();

        assertNotNull(test1);
        assertTrue(test1 == Choice.ROCK || test1 == Choice.PAPER || test1 == Choice.SCISSORS);

    }

    /**
     * pattern exists in the map
     */
    @Test
    public void testMakeChoice2(){
        mlAlg.recordResult(Choice.PAPER, Choice.SCISSORS);
        mlAlg.recordResult(Choice.SCISSORS, Choice.SCISSORS );
        mlAlg.recordResult(Choice.ROCK, Choice.SCISSORS);
        mlAlg.recordResult(Choice.PAPER, Choice.SCISSORS);
        mlAlg.recordResult(Choice.SCISSORS, Choice.SCISSORS);
        Choice test2 = mlAlg.makeChoice();
        assertTrue(test2 == Choice.ROCK);


    }

    /**
     * history is partially full but pattern is empty
     */
    @Test
    public void testMakeChoice3(){
        mlAlg.recordResult(Choice.PAPER, Choice.SCISSORS);
        mlAlg.recordResult(Choice.ROCK, Choice.SCISSORS);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        Choice test3 = mlAlg.makeChoice();
        assertNotNull(test3);
        assertTrue(test3 == Choice.ROCK || test3 == Choice.PAPER || test3 == Choice.SCISSORS);

    }

    @Test
    public void testRecordResult() {
        // Train with human always choosing ROCK
        // After 5 calls history=[RRRR], call 5 records RRRR->ROCK
        // Call 6 also records RRRR->ROCK, so counts=[2,0,0]
        // makeChoice() predicts ROCK, returns PAPER
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        Choice result = mlAlg.makeChoice();
        assertTrue(result == Choice.PAPER);
    }

    @Test
    public void testSaveAndLoadData() {
        // Train first instance with human always ROCK
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.saveData();

        // New instance loads RRRR:[2,0,0] from file
        mlAlg = FactoryChoiceAlgorithm.create("2");

        // Replay to rebuild history to [R,R,R,R]
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);
        mlAlg.recordResult(Choice.PAPER, Choice.ROCK);

        // Should still predict ROCK and return PAPER
        Choice result = mlAlg.makeChoice();
        assertTrue(result == Choice.PAPER);
    }
}