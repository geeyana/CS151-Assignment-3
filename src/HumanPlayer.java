import java.util.Scanner;

/**
 * Implements Coding To Interface Design Principle
 * @author _______
 */
public class HumanPlayer implements Player {

    private String name;
    private Scanner scanner;

    /**
     * To Do: Implement the logic
     * @return
     */
    @Override
    public String getChoice() {
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("1")) return "rock";
            if (input.equals("2")) return "paper";
            if (input.equals("3")) return "scissors";

            System.out.println("Invalid input. Please enter 1, 2, or 3.");
        }
    }

    /**
     *
     * @param name
     */
    public HumanPlayer(String name) {
        this(name, new Scanner(System.in));
    }

    public HumanPlayer(String name, Scanner scanner) {
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
