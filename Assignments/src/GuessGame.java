/******************************
 * This program is made to make the user
 * play a guessing game
 * @author cole.lingo
 *****************************/

//So I can use the Scanner to get numbers from the user
import java.util.Scanner;

//So I can use the random class to make up the number
import java.util.Random;

public class GuessGame {

    public static void main(String[] args)
    {

        //To make the number variable
        Random num = new Random();

        // To get my random number from 100 - 1000
        int randNum = num.nextInt(901) + 100;

        //To get keyboard inout
        Scanner keyboard = new Scanner(System.in);

        // start the variable counter to keep track on tries
        int counter = 1;

        //max amount of tries
        int trials = 10;

        // to keep track if you are high or low
        String highorlow = "";

        //welcomes player
        System.out.println ("Welcome to the Guessing Game!");

        //tell them to guess
        System.out.println ("Guess the winning number between 100 - 1000.");

        // allows them to guess and tell them how many tries they have
        System.out.print ("Attempt " + counter + "/" + trials + ", enter your guess: ");
        int guess = keyboard.nextInt();

        // while loop will keep looping as long as counter says below 10
        while (++counter <= trials)
        {

            // if they guess above the random number
            if (guess > randNum)
            {
                highorlow = "high";
                System.out.print ("Try again, your guess was too " + highorlow + ". Attempt " + counter + "/" + trials + ", enter your guess: ");
                guess = keyboard.nextInt();

            }

            // if they guess lower than the random number
            else
            {
                highorlow = "low";
                System.out.print ("Try again, your guess was too " + highorlow + ". Attempt " + counter + "/" + trials + ", enter your guess: ");
                guess = keyboard.nextInt();

            }


            // if they dont get it right in the number of tries
            if ((counter == trials) && (guess != randNum))
            {
                System. out.print ("Try again, your guess was too " + highorlow + ". Sorry, you've used all 10 attempts. The winning number was " + randNum);
            }

            //if they get it correct
            if (guess == randNum)
            {
                System.out.print ("Congratulations! You guessed the winning number " + randNum + " in " + counter + " attempts.");
                break;
            }
        }

    }


}