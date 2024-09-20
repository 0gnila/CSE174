/********************************************
 * This program is to find your Zodiac Sign
 * @author cole.lingo
*********************************************/
//this imported the Scanner class
import java.util.Scanner;

public class ZodiacSign
{
    public static void main(String[] args)
    {
        //This makes all the Zodiac Signs a variable
        String Aquarius = "\u2652";
        String Pisces = "\u2653";
        String Aries = "\u2648";
        String Taurus = "\u2649";
        String Gemini = "\u264A";
        String Cancer = "\u264B";
        String Leo = "\u264C";
        String Virgo = "\u264D";
        String Libra = "\u264E";
        String Scorpio = "\u264F";
        String Sagittarius = "\u2650";
        String Capicorn = "\u2651";

        //this allows the Scanner to take in computer inputs
        Scanner keyboard= new Scanner(System.in);

        // This allows people to type there month of brith in
        System.out.print("Enter the month of birth (1-12): ");
        int month = keyboard.nextInt();

        //This allows people to type there day of brith in
        System.out.print("Enter the day of birth (1-31): ");
        int day = keyboard.nextInt();

        //Closes the submission for the Scanner class
        keyboard.close();

        // Declare a variable so my switch can add into this
        String zodiacSign= "";

        switch (month)
        {
            //January
            case 1:
                if (1 <= day && day <= 19)
                    zodiacSign = Capicorn + " Capricorn";
                else
                    zodiacSign = Aquarius + " Aquarius";
                break;
            //February
            case 2:
                if (1 <= day && day <= 18)
                    zodiacSign = Aquarius + " Aquarius";
                else
                    zodiacSign = Pisces + " Pisces";

                break;
            //March
            case 3:
                if (1 <= day && day <= 20)
                    zodiacSign =  Pisces+ " Pisces";
                else
                    zodiacSign =  Aries+ " Aries";

                break;
            //April
            case 4:
                if (1 <= day && day <= 19)
                    zodiacSign =  Aries+ " Aries";
                else
                    zodiacSign =  Taurus + " Taurus ";

                break;
            //May
            case 5:
                if (1 <= day && day <= 20)
                    zodiacSign =  Taurus+ " Taurus";
                else
                    zodiacSign =  Gemini+ " Gemini";

                break;
            //June
            case 6:
                if (1 <= day && day <= 21)
                    zodiacSign =  Gemini+ " Gemini ";
                else
                    zodiacSign =  Cancer+ " Cancer";

                break;
            //July
            case 7:
                if (1 <= day && day <= 22)
                    zodiacSign =  Cancer+ " Cancer";
                else
                    zodiacSign =  Leo + " Leo";

                break;
            //August
            case 8:
                if (1 <= day && day <= 22)
                    zodiacSign =  Leo+ " Leo";
                else
                    zodiacSign =  Virgo+ " Virgo ";

                break;
            //September
            case 9:
                if (1 <= day && day <= 22)
                    zodiacSign =  Virgo+ " Virgo";
                else
                    zodiacSign =  Libra+ " Libra";

                break;
            //October
            case 10:
                if (1 <= day && day <= 22)
                    zodiacSign =  Libra + " Libra";
                else
                    zodiacSign =  Scorpio+ " Scorpio";

                break;
            //November
            case 11:
                if (1 <= day && day <= 21)
                    zodiacSign =  Scorpio+ " Scorpio";
                else
                    zodiacSign =  Sagittarius+ " Sagittarius";

                break;
            //December
            case 12:
                if (1 <= day && day <= 21)
                    zodiacSign =  Sagittarius+ " Sagittarius";
                else
                    zodiacSign =  Capicorn+ " Capicorn ";

                break;

            //If they input anything above 12 for month it will read this message
            default:
                System.out.println("Please input a valid month");
        }

        //This makes it so if you put a valid month it will print this out
        if (month>= 1 && month <=12)
            System.out.print ("Your zodiac sign is: " + zodiacSign);
    }
}
