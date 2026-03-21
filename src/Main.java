import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Player cp = new ComputerPlayer();
        Player hp = new HumanPlayer("Zain", sc);
        RulesEngine re = new RulesEngine();
        Game simulateGame = new Game(hp, cp, re);
        simulateGame.play();
        sc.close();

    }
}
