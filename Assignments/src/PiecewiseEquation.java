/****************************************************
 *This program is for a piece wise function, it will
 * calculate the y value of once you put an x value in
 * @author cole.lingo
 ***************************************************/
//So I can use the Scanner
import java.util.Scanner;


public class PiecewiseEquation
{
    public static void main (String[] args)
    {
        //Use the keyboard for my Scanner
        Scanner keyboard = new Scanner(System.in);

        //Allows the user to type in values
        System.out.print("Enter the value of x: ");
        double xValue = keyboard.nextDouble();

        // if the x value is more than 0 then use this
        if(xValue > 0)
        {
           double yValue = (Math.pow(xValue, 2) - (2 * xValue) + 5) / (2 * xValue);
           System.out.print("For x = " + xValue + "," + " y = " + yValue);
        }

        // if x value is less than 0 then use this
        else if (xValue < 0)
        {
            double yValue = Math.abs(Math.pow(xValue, 2) + (5 * xValue));
            System.out.print("For x = " + xValue + "," + " y = " + yValue);
        }

        // if x value is equal to 0 then use this
        else if (xValue == 0)
        {
            double yValue = Double.POSITIVE_INFINITY;
            System.out.print("For x = " + xValue + "," + " y = " + yValue);
        }
    }
}
