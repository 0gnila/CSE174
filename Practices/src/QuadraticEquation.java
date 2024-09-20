/**
 * The QuadraticEquation class calculates the roots of a quadratic equation of the form ax^2 + bx + c = 0, given coefficients b and c.
 * The class uses the quadratic formula to compute the roots. It calculates the discriminant and then applies the quadratic formula to find the roots.
 *
 * @author Asaad
 */
public class QuadraticEquation
{
    public static void main(String[] args)
    {
        // Enter coefficients b and c
        double b = 2.5;
        double c = 1.8;

        double discriminant = Math.pow(b, 2) - 4.0 * c;
        double root1 = (-b + Math.sqrt(discriminant)) / 2.0;
        double root2 = (-b - Math.sqrt(discriminant)) / 2.0;

        System.out.println(root1);
        System.out.println(root2);
    }
}
