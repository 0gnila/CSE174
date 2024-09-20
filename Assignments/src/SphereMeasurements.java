/****************************************************
 This Program is to get the Volume of a Sphere
 also to find the Circumference of the Sphere

 @author Cole Lingo
****************************************************/
//This import the Scancer class so the user can type in data
import java.util.Scanner;

public class SphereMeasurements
{
    public static void main (String[] args)
    {
        //This shows that the input we will be taking is keyboard inputs
        Scanner keyboard = new Scanner(System.in);

        //This line is asking the user to type in a number for the diameter
        System.out.print ("Enter the diameter of the sphere: ");

        //This line is allows the user to type in the number
        double diameter = keyboard.nextDouble();

        //This line is dividing the diameter by 2 to get the radius
        double radius =  diameter / 2 ;

        //This line is getting us the circumfernce
        double circumference = (2 * Math.PI) * radius;

        //This line gets us the volume
        double volume = ((4.00 / 3.00) * Math.PI) * Math.pow(radius, 3);

        //This line prints out the result of the volume
        System.out.println("Volume of the sphere: " + volume);

        //This line prints out the result of the circumfernce
        System.out.print("Circumference of the sphere: " + circumference);


    }

}
