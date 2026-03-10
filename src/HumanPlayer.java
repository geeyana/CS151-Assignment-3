import java.util.Scanner;

/**
 * Implements Coding To Interface Design Principle
 * @ asmitadulla
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
            if (!scanner.hasNextLine()) {
                return "";
            }

            String input = scanner.nextLine().trim();
            input = input.replace("/n", "");

            if (input.equals("1")) {
                return "rock";
            } 
            else if (input.equals("2")) {
                return "paper";
            } 
            else if (input.equals("3")) {
                return "scissors";
            } 
            else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
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
