/**
 * This class prints a countdown and illustrates the difference between `print` and `println`.
 *
 * @author Asaad
 */
public class Rocket
{
    public static void main(String[] args)
    {
        // The print method prints the string literal and keep the cursor on the current line
        System.out.print("Three...");
        System.out.print("Two...");
        System.out.print("One...");

        // The println method prints the string literal and then advances to the next line
        System.out.println("Liftoff!");
        System.out.println("Houston, we have a problem.");
    }
}
