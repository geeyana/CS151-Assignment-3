/**
 * Must Implement Cohesion
 * @author _________
 * May implement Delegation if needed (Game to RulesEngine) - To Be Discussed
 */
public class Game
{
    private Player human;
    private Player computer;

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
