/**
 * This class illustrates the 8 basic primitive types in Java
 * @author Asaad
 */
public class DataTypes
{
    public static void main(String[] args)
    {
        // Declaring variables of basic dataTypes
        short age = 20;
        int circleWidth = 200;
        long population = 7000000000L;          // note the L at the end
        float size = 40.2F;                                      // note the F at the end
        double radius = 50.11112;
        char letterGrade = 'A';
        boolean isGameOver = false;

        System.out.println("Your age is " + age);
        System.out.println("The circle's width is " + circleWidth);
        System.out.println("The world's population is " + population);
        System.out.println("The size is " + size);
        System.out.println("The radius is " + radius);
        System.out.println("Your letter grade is " + letterGrade);
        System.out.println("Is the game over? " + isGameOver);

        // Assigning new values to the variables
        age = 22;
        circleWidth = 100;
        population = 7000000001L;       // note the L at the end
        size = -40.2F;                                 // note the F at the end
        radius = 30.33333;
        letterGrade = 'B';
        isGameOver = true;

        System.out.println("-------------------------------------");
        System.out.println("Your age is now " + age);
        System.out.println("The circle's width is now " + circleWidth);
        System.out.println("The world's population is now " + population);
        System.out.println("The size is now " + size);
        System.out.println("The radius is now " + radius);
        System.out.println("Your letter grade is now " + letterGrade);
        System.out.println("Is the game over now? " + isGameOver);
    }
}
