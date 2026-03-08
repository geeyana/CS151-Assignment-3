/**
 * Implements Coding To Interface Design Principle
 * @author _______
 */
public class HumanPlayer implements Player{

    private String name;

    /**
     * To Do: Implement the logic
     * @return
     */
    @Override
    public String getChoice() {
        return "";
    }

    /**
     *
     * @param name
     */
    public HumanPlayer(String name){
        this.name = name;
    }



    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
