import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Player cp = new ComputerPlayer();
        Player hp = new HumanPlayer("Zain", sc);
        RulesEngine re = new RulesEngine();
        Display display = new Display();
        Game simulateGame = new Game(hp, cp, re, display);
        simulateGame.play();
        sc.close();

    }
}
