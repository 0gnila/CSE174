/**
 * Converts Fahrenheit to Celsius
 * Coverts miles per hour to km per hour
 * Illustrates
 * - Using parenthesis to enforce order of operations
 * - Division with floating point numbers
 * - Using final keyword for mathematical constants
 *
 * @author Asaad
 */
public class UnitConversions
{

    public static void main(String[] args)
    {

        // The equation for converting Fahrenheit to Celsius: C = (F - 32) * 5/9
        final int FREEZING_POINT = 32;
        final double CONVERSION_RATIO = 5.0 / 9.0;

        double fahrenheit = 50.0;
        double celsius = (fahrenheit - FREEZING_POINT) * CONVERSION_RATIO;
        System.out.println(fahrenheit + " degrees fahrenheit equals " + celsius + " degrees celsius");


        // The conversion factor is: 1 mph = 1.60935 km/h
        final double CONVERSION_FACTOR = 1.60935;
        double milesPerHour = 60.0;
        double kmPerHour = milesPerHour * CONVERSION_FACTOR;
        System.out.println(milesPerHour + " mph is " + kmPerHour + " km/h");
    }
}
