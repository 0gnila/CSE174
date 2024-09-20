/******************************************
 This program purpose is to check a year
 to see if it will be a leap year
 *
 * @auther Cole Lingo
*****************************************/
//This imports the Scanner class
import java.util.Scanner;
//This imports the Random class
import java.util.Random;

public class LeapYearChecker
{
    public static void main(String[] args)
    {
        //This shows that the user will be inputting the data
        Scanner keyboard = new Scanner (System.in);

        //This shows that the computer will pick something random
        Random randomyear= new Random();

        //Tells the user to print
        System.out.print ("Enter a year: ");

        //Allows the computer to take the input
        int year = keyboard.nextInt();

        //Randomly guess on if it is a leap year
        boolean guess = randomyear.nextBoolean();

        //Determines if it is a leap year
        boolean leapyear = (year % 400 == 0 || year % 4 == 0) && !(year % 100 == 0);

        //Prints the computer's guess
        System.out.println("Guessed leap year? " + guess);

        //Prints the actual answer
        System.out.print("Actual leap year? " + leapyear);

    }
}
