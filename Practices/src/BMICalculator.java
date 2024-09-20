/**
 * If you have a person's weight in pounds and their height in inches, use the following formula to calculate their Body Mass Index (BMI):
 *                          BMI = (weight in pounds) / (height in inches * height in inches) * 703
 * In this formula:
 *  "weight in pounds" is the person's weight in pounds.
 *  "height in inches" is the person's height in inches.
 *  The factor 703 is used to convert the BMI calculation to the appropriate units.
 * After calculating BMI using this formula, the result falls into one of the categories mentioned earlier:
 * Underweight: BMI less than 18.5
 * Normal weight: BMI between 18.5 and 24.9
 * Overweight: BMI between 25 and 29.9
 * Obesity: BMI of 30 or greater
 */

// import the Scanner class
import java.util.Scanner;

public class BMICalculator
{
    public static void main(String[] args)
    {
        // Create object 'keyboard' of the Scanner class and set it to the default input system stream "System.in"
        Scanner keyboard = new Scanner(System.in);

        // Scan height and weight values from keyboard and store them in variables
        System.out.print("Enter height (feet.inches): ");
        double height = keyboard.nextDouble();

        System.out.print("Enter weight (lbs): ");
        double weight = keyboard.nextDouble();

        // Extract the feet and inches parts
        int feetPart = (int) height;
        double inchesPart = (height - feetPart) * 100;               // Convert the inches part to hundredths of an inch

        // Convert to total inches
        int totalInches = (feetPart * 12) + (int) inchesPart;

        // Compute the BMI and store it in a variable
        double bmi = weight / (totalInches * totalInches) * 703;

        // Print values and BMI
        System.out.println("Height is " + height);
        System.out.println("Weight is " + weight);
        System.out.println("BMI is " + bmi);

        // Close the `keyboard` object (the Scanner stream)
        keyboard.close();
    }
}