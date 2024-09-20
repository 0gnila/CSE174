/***************************************************
 * This program is supposed to take large data sets
 * and input and exact different types of data
 * @author cole.lingo
 *************************************************/

//import the scanner class
import java.util.Scanner;

public class StudentInformationBook
{
    public static void main ( String [] args)
    {
        int dataColumn = 13;
        int dataRow = 20;

        String[][] studentInfo = new String[dataRow][dataColumn];
        String lineData = "";

        //this was the given data
        Scanner data = new Scanner ("""
                                           Stacy,Giller,Smith,Fall,Senior,,123-145-4534,30/10/2004,,2023,Toms River,NJ,Aunt
                                           Oliver,James,Greenwitch,Spring,Sophomore,,129-349-3596,6/8/2003,Prefer Not To Answer,2025,New York City,ny,Uncle
                                           Marilyn,Reed,Johnson,Summer,Sophomore,,234-456-7890,11/13/2005,Female,2024,Baltimore,MD,N/A
                                           Ryan,Cooper,Moffett,Spring,Junior,,,7/24/2001,Gender Neutral,2025,Detroit,MI,Brother
                                           Graham,Peter,Carter,Fall,Sophomore,,720-446-1290,1/9/1998,Male,2026,Denver,CO,Prefer Not To Choose
                                           Stacy,John,Hale,Fall,Freshman,,330-145-3334,7/7/2004,,2025,,CO,Aunt
                                           Emily,Luis,Gakpo,Spring,Sophomore,,691-349-3596,2/17/2002,Female,2025,New York City,NY,Father
                                           Zack,Rhode,Harrison,Summer,Sophomore,,,11/13/2005,Male,2024,Cincinnati,OH,Friend
                                           Jude,Ali,Kamil,Spring,Junior,,440-455-7822,7/24/2001,,2025,Detroit,MI,Brother
                                           John,William,Poter,Spring,Senior,,980-446-0090,1/9/2000,Male,2023,Salt Lake City,UT,N/A
                                           Emma,Grace,Thompson,Fall,Freshman,,555-123-4567,5/12/2006,Female,2026,Chicago,IL,Mother
                                           Ethan,Michael,Miller,Summer,Sophomore,,555-987-6543,8/28/2004,Male,2024,Houston,TX,Father
                                           Mia,Elizabeth,Davis,Spring,Freshman,,,4/3/2007,Female,2025,Los Angeles,CA,Sister
                                           Jackson,Robert,Martinez,Fall,Junior,,555-567-8901,10/19/2003,Male,2023,Miami,FL,Cousin
                                           Olivia,Anne,Wilson,Summer,Senior,,555-234-5678,3/8/2000,Female,2023,Seattle,WA,Grandparent
                                           Liam,Alexander,Anderson,Spring,Sophomore,,555-876-5432,7/15/2004,Gender Neutral,2025,Boston,MA,Friend
                                           Ava,Charlotte,Luis,Fall,Freshman,,555-345-6789,9/25/2006,Female,2026,San Francisco,CA,Aunt
                                           Noah,Benjamin,Wright,Spring,Junior,,,2/2/2003,Male,2024,Phoenix,AZ,Brother
                                           Isabella,Grace,Hill,Summer,Senior,,555-789-0123,6/18/2002,Prefer Not To Answer,2023,Denver,CO,Friend
                                           James,Michael,Clark,Fall,Sophomore,,555-456-7890,11/7/2005,Prefer Not To Answer,2025,Portland,or,Cousin 
                                           """);

        //this makes the data into a matrix
        int row = 0;
        while (data.hasNextLine())
        {
            lineData = data.nextLine();
            studentInfo[row] = lineData.split(",");
            row++;
        }

        String temp = "";

        //this was to fill in missing gender data
        float noGender = 0;
        for (int i = 0 ; i < dataRow; i++ )
        {
            temp= studentInfo[i][8];
            if (temp.isEmpty())
            {
                studentInfo[i][8] = ("Prefer Not To Answer");
                noGender++;
            }
        }
        System.out.print ("Missing rate of Gender = " + noGender/dataRow);

        System.out.println (" ");

        float na = 0;

        //This was for emergency contact info
        for (int i = 0 ; i < dataRow ; i++ )
        {
            temp= studentInfo[i][12];
            if (temp.equals("N/A"))
            {
                studentInfo[i][12] = ("Prefer Not To Choose");
                na++;
            }
        }
        System.out.print ("Missing rate of Emergency Contact Relation = " + na/dataRow);

        System.out.println (" ");

        //this turned all there middle names into first initial and a period
        char middleInitials;
        for (int i = 0 ; i < dataRow ; i++ )
        {
            temp= studentInfo[i][1];
            middleInitials= temp.charAt(0);
            studentInfo[i][1] = (middleInitials + ".");
        }


        //this was to make emails for all the students
        String lastNameTempInitials = "";
        char firstNameTempInitial;
        for (int i = 0 ; i < dataRow ; i++ )
        {
            temp = studentInfo[i][0].toLowerCase();
            firstNameTempInitial= temp.charAt(0);
            temp= studentInfo[i][2].toLowerCase();
            lastNameTempInitials = temp.substring(0,4);
            studentInfo[i][5] = (lastNameTempInitials + firstNameTempInitial + "@example.com");

        }


        //this was to standardize all the states to uppercase
        String states = "";
        for (int i = 0 ; i < dataRow ; i++)
        {
            temp = studentInfo [i][11];
            states = temp.toUpperCase();
            studentInfo [i][11] = states;
        }

        //this was to make all the seniors emails a google email
        String emailChange = "";
        String newEmail = "";
        for (int i = 0 ; i < dataRow ; i++)
        {
            if (studentInfo [i][4].equals("Senior"))
            {
                temp = studentInfo [i][5].substring(0,5);
                emailChange = "@google.com";
                newEmail = String.join("",temp,emailChange);
                studentInfo [i][5] = newEmail;
            }
        }

        System.out.println (" ");
        System.out.println (" ");


        //This was to retrieve a list of students graduating in the fall of 2023
        System.out.println("Students graduating in Fall 2023");

        String studentInfoPrint = "";
        for (int i = 0 ; i < dataRow ; i++)
        {
            if (studentInfo[i][3].equals("Fall") && studentInfo[i][9].equals("2023"))
            {
                for (int j = 0 ; j < dataColumn ; j++)
                {
                    temp = studentInfo [i][j];
                    studentInfoPrint = String.join ("|",studentInfoPrint,temp);

                }
                System.out.println (studentInfoPrint);
                studentInfoPrint = "";
            }
        }

        System.out.println (" ");

        //this was to retrieve a list of the students graduating in year 2024 and 2025
        System.out.println("Students graduating in 2024 or 2025");

        for (int i = 0 ; i < dataRow ; i++)
        {
            if (studentInfo[i][9].equals("2024") || studentInfo[i][9].equals("2025"))
            {
                for (int j = 0 ; j < dataColumn ; j++)
                {
                    temp = studentInfo [i][j];
                    studentInfoPrint = String.join ("|",studentInfoPrint,temp);

                }
                System.out.println (studentInfoPrint);
                studentInfoPrint = "";
            }
        }

        System.out.println (" ");

        //This was to retrieve a list of female students whos emergency contact info is their father
        System.out.println ("Female students having their fathers as emergency contacts");
        for (int i = 0 ; i < dataRow ; i++)
        {
            if (studentInfo[i][8].equals("Female") && studentInfo[i][12].equals("Father"))
            {
                for (int j = 0 ; j < dataColumn ; j++)
                {
                    temp = studentInfo [i][j];
                    studentInfoPrint = String.join ("|",studentInfoPrint,temp);

                }
                System.out.println (studentInfoPrint);
                studentInfoPrint = "";
            }
        }

        //this was to retrieve a list of students born before 2004
        String [] yearOfBirth;
        System.out.println (" ");
        System.out.println ("Students were born before 2004");
        int year;
        for (int i = 0 ; i < dataRow ; i++)
        {
            temp = studentInfo [i][7];
            yearOfBirth = temp.split("/");
            temp = yearOfBirth [2];
            year = Integer.parseInt(temp);

            if (year < 2004)
            {
                for (int j = 0 ; j < dataColumn ; j++)
                {
                    temp = studentInfo [i][j];
                    studentInfoPrint = String.join ("|",studentInfoPrint,temp);

                }
                System.out.println (studentInfoPrint);
                studentInfoPrint = "";
            }
        }
    }
}
