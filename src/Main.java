import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Display display = new Display();
        Scanner sc = new Scanner(System.in);

        display.welcome();
        String arg = display.chooseAlgo(sc);
        ChoiceAlgorithm algorithm = FactoryChoiceAlgorithm.create(arg);
        display.confirmAlgo(arg);

        Player hp = new HumanPlayer("Zain", sc);
        Player cp = new ComputerPlayer(algorithm);
        RulesEngine re = new RulesEngine();
        Game simulateGame = new Game(hp, cp, re, display);

        simulateGame.play();
        sc.close();
    }
}
