/**
 * This class illustrates:
 * 1. The use of parenthesis to enforce order of operations
 * 2. The use of casting between floating point and integer variables
 */
public class TypeConversionCasting
{
    public static void main(String[] args)
    {
        int num1 = 17, num2 = 5;
        double val = 4.6;

        int iResult = num1 + num2 / 2;
        System.out.println("iResult=" + iResult);

        iResult = (num1 + num2 ) / 2;                                   // note the effect of parenthesis
        System.out.println("iResult=" + iResult);

        iResult = num1 / num2;
        System.out.println("iResult=" + iResult);

        double fResult = num1 / num2;             // note the effect of casting and parenthesis
        System.out.println("fResult=" + fResult);

        fResult = (double) num1 / num2;                             // note the effect of parenthesis
        System.out.println("fResult=" + fResult);

        // Why would uncommenting the next line (line 29) trigger a compilation error?
        // iResult = val / 2;
        // System.out.println("Would result in a compile-time error");

        iResult = (int)(val / 2);                                               // note the effect of casting and parenthesis
        System.out.println("iResult=" + iResult);

        iResult = (int) val / 2;                                                // note the effect of casting
        System.out.println("iResult=" + iResult);

    }
}

