import java.util.Scanner;

/**
 * Implements Coding To Interface Design Principle
 * @ asmita
 */
public class HumanPlayer implements Player{

    private String name;
    private Scanner scanner;

    /**
     * To Do: Implement the logic
     * @return
     */
    
    @Override
    public String getChoice() {

        while (true) {
            System.out.print("Choose (1=rock, 2=paper, 3=scissors): ");

            if (!scanner.hasNextLine()) {
                return "";
            }

            String input = scanner.nextLine().trim();
            Move move = null;

            if (input.equals("1")) {
                move = Move.ROCK;
            } 
            else if (input.equals("2")) {
                move = Move.PAPER;
            } 
            else if (input.equals("3")) {
                move = Move.SCISSORS;
            } 
            else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                continue;
            }

            return move.name().toLowerCase();
        }
    }

    /**
     *
     * @param name
     */
    public HumanPlayer(String name){
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    public HumanPlayer(String name, Scanner scanner){
        this.name = name;
        this.scanner = scanner;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
