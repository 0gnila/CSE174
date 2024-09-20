/**
 * This program illustrates:
 * 1. How to use unary operators
 * 2. How to use increment/decrement operators
 */
public class UnaryOperators {
    public static void main(String[] args) {
        int num1 = 100, num2 = 200;

        // minus(-) unary operator
        int inverseNum = -num1;
        System.out.println("inverse of " + num1 + " is " + inverseNum);

        // increment
        num1++;             // num1 = 100
        ++num1;             // num1 = 102
        System.out.println("The updated value is " + ++num1);               // num1 = ?

        // decrement
        num2--;             // num2 = 200
        --num2;             // num2 = 198
        System.out.println("The updated value is " + num2--);               // num2 = ?
        System.out.println("The updated value is " + num2);

    }
}