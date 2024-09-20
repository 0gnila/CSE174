/**
 * Prints facts about the number of stars and stripes on the US flag from 1777 to 2023
 * Illustrates:
 *      - The basics of declaring, initializing, and assigning to variables of type integer
 *      - The use of the `final` keyword
 */
public class USFlag
{
    public static void main(String[] args)
    {
        int numStars = 13;
        System.out.println("In 1777, there were " + numStars + " stars on the US flag");

        numStars = 20;
        System.out.println("In 1818, there were " + numStars + " stars on the US flag");

        numStars = 48;
        System.out.println("In 1912, there were " + numStars + " stars on the US flag");

        numStars = 50;
        System.out.println("In 2023, there are " + numStars + " stars on the US flag");

        final int NUM_STRIPES = 13;
        System.out.println();
        System.out.println("There have always been " + NUM_STRIPES + " stripes on the US flag");

        // Why would uncommenting the next line (line 28) trigger an error?
        // NUM_STRIPES = 15;
    }
}

