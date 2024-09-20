/**
 * This class is to find the number of quarters, dimes, nickels and pennies in a given number of coins
 * CSE 174
 * D
 * @author ColeLingo
 */

public class CoinConverter
{
    public static void main(String[] args)
    {
        // Declare a variable 'cents' and initialize it to the value 99
        int cents = 99;


        // Declare a variable 'quarters' and set it to the number of quarters after calculation
        int quarters = cents / 25;
        cents = cents % 25;

        // Declare a variable 'dimes' and set it to the number of dimes after calculation
        int dimes = cents / 10;
        cents = cents % 10;

        // Declare a variable 'nickels' and set it to the number of nickels after calculation
        int nickels = cents / 5;
        cents = cents % 5;

        // Declare a variable 'pennies' and set it to the number of pennies after calculation
        int pennies = cents /1;

        // The count of all the quarters, dimes, nickels, and pennies
        System.out.println("Number of cents entered by the user is 99");
        System.out.println("99 cents has " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickles, " + pennies + " pennies" );
    }
}
