import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String arg = args.length > 0 ? args[0] : "-r";
        ChoiceAlgorithm algorithm = FactoryChoiceAlgorithm.create(arg);
        Player cp = new ComputerPlayer(algorithm);
        Player hp = new HumanPlayer("Zain", sc);
        RulesEngine re = new RulesEngine();
        Display display = new Display();
        Game simulateGame = new Game(hp, cp, re, display);
        simulateGame.play();
        sc.close();

    }
}
