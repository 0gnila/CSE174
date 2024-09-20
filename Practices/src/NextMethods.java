/**
 * This class illustrates the difference between next() and nextLine() methods in the Scanner class
 * Takeaways:
 *  1. It is possible to pass string data (text) to the Scanner class; replace `System.in` by the text
 *  2. It is possible for a string variable to hold a block of text lies on multiple lines using """ """
 */

import java.util.Scanner;

public class NextMethods
{

    public static void main(String[] args)
    {
        String text = """
                Programmers love Java
                User input with Java is so easy
                Just use the Scanner class.""";

        Scanner scan = new Scanner(text);

        // Section1: comment all statements in section2 if you want to run section1
//        System.out.println("First call: " + scan.nextLine());           // Programmers love Java
//        System.out.println("Second call: " + scan.nextLine());      // User input with Java is so easy
//        System.out.println("Third call: " + scan.nextLine());          // Just use the Scanner class.

        // Section2: comment all statements in section1 if you want to run section2
        System.out.println("First call: " + scan.next());                // Programmers
        System.out.println("Second call: " + scan.next());           // love
        System.out.println("Third call: " + scan.next());               // Java

        // Close the input stream
        scan.close();

    }
}
