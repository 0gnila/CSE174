/***************************************************
 *A game were you gamble to try to get to your goal
 *
 * @author cole.lingo
 **************************************************/
import java.util.Scanner;
import java.util.Random;
public class GambleGame
{
    public static void main(String[]args)
    {
        Scanner keyboard = new Scanner(System.in);
        Random gamble = new Random();


        System.out.print ("How much $$$ would you put in your stake to start with? ");
        int stake = keyboard.nextInt();

        System.out.print ("How much $$$ would be your target? ");
        int goal = keyboard.nextInt();

        int cash = stake;
        int counter = 0;

        while ((cash > 0) && (cash != goal))
        {
            ++counter;
            double chance = gamble.nextDouble();

            if (chance < .5)
            {
                ++cash;
            }

            else
            {
            --cash;
            }

            if (cash == 0)
            {
                System.out.print ("Sorry, you lost all your money after " + counter + " bets. STOP GAMBLING!");
            }

            if (cash == goal)
            {
                System.out.print ("Congratulation, you won $" + cash + " after " + counter + " bets!!");
            }

        }
    }
}
