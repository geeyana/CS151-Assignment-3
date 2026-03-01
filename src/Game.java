/**
 * Must Implement Cohesion
 * @author _________
 * Must implement Delegation if needed (Game to RulesEngine)
 */
public class Game
{
    private Player human;
    private Player computer;
    private RulesEngine rulesEngine;
    private int humanScore;
    private int computerScore;
    private int draws;
    private static final int TOTAL_ROUNDS = 20;

    public Game(Player human, Player computer){
        this.human = human;
        this.computer = computer;
    }

    /**
     * To Do: Write the logic
     */
    public void playRound(){
        String humanChoice = human.getChoice();
        String computerChoice = computer.getChoice();
    }
}
