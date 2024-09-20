/***************************************************
 * This program is supposed to take large data sets
 * and input and exact different types of data
 * @author cole.lingo
 *************************************************/

//import the Arrays and Scanner class
import java.util.Scanner;
import java.util.Arrays;


public class StudentInformationDataFrame {

    //This builds the array with the given data
    public static void buildDataFrame(String[][] table, String text) {
        Scanner scan = new Scanner(text);

        int row = 0;
        String lineData = "";

        while (scan.hasNextLine()) {
            lineData = scan.nextLine();
            table[row] = lineData.split(",");
            row++;
        }
    }

    //This calculate the missing data rate for a given column
    public static double findMissingRate(String[][] table, int index)
    {
        String temp = "";
        float noData = 0;
        double missingRate;
        for (int i = 0 ; i < 20 ; i++) {
            temp = table[i][index];
            if (temp.isEmpty()) {
                noData++;
            }
        }
        missingRate = noData / 20;
        return missingRate;
    }

    //This fills the missing data cells in the data set
    public static void fillmissing(String[][] table, int index, String filler)
    {

        String temp = "";
        for (int i = 0 ; i < 20 ; i++) {
            temp = table[i][index];
            if (temp.isEmpty() && index == 8) {
                table[i][index] = (filler);
            }
            if (temp.isEmpty() && index == 10) {
                table[i][index] = (filler);
            }
            if (temp.equals("N/A") && index == 12) {
                table[i][index] = (filler);
            }
        }
    }

    //this creates an email for all of the students
    public static void createEmail(String[][] table) {
        String lastNameTempInitials = "";
        char firstNameTempInitial;
        String temp = "";
        for (int i = 0 ; i < 20 ; i++) {
            temp = table[i][0].toLowerCase();
            firstNameTempInitial = temp.charAt(0);
            temp = table[i][2].toLowerCase();
            lastNameTempInitials = temp.substring(0, 4);
            table[i][5] = (lastNameTempInitials + firstNameTempInitial + "@example.com");

        }
    }

    //this changes the email of seniors to a google email
    public static void changeEmail(String[][] table, String senior) {
        String emailChange = "";
        String newEmail = "";
        String temp = "";
        for (int i = 0 ; i < 20 ; i++) {
            if (table[i][4].equals(senior)) {
                temp = table[i][5].substring(0, 5);
                emailChange = "@google.com";
                newEmail = String.join("", temp, emailChange);
                table[i][5] = newEmail;
            }
        }
    }

    //this calculates the age of every student
    public static void findStudentAge(String[][] table, int currentYear) {
        String temp = "";
        String[] yearOfBirth;
        int birthYear;
        int age;
        for (int i = 0 ; i < 20 ; i++) {
            temp = table[i][7];
            yearOfBirth = temp.split("/");
            temp = yearOfBirth[2];
            birthYear = Integer.parseInt(temp);
            age = currentYear - birthYear;
            String str = String.valueOf(age);
            table[i][6] = str;
        }
    }

    //this sorts the data by alphabetical order based on first names
    public static void sortDataForm(String[][] table, int index) {
        try {
            Arrays.sort(table, (a, b) -> Integer.compare(Integer.parseInt(a[index]), Integer.parseInt(b[index])));
        }
        catch (Exception e) {
            Arrays.sort(table, (a, b) -> a[index].compareTo(b[index]));
        }
    }

    //this finds the students that will be graduating in spring of 2024
    public static void findStudentGraduating (String [][] table, String semester, String gradYear)
    {
        String temp = "";
        String studentInfoPrint = "";
        for (int i = 0 ; i < 20 ; i++)
        {
            if (table[i][3].equals(semester) && table[i][9].equals(gradYear))
            {
                for (int j = 0 ; j < 13 ; j++)
                {
                    temp = table [i][j];
                    studentInfoPrint = String.join (" | ",studentInfoPrint,temp);

                }
                String strNew = studentInfoPrint.substring (3);
                System.out.println ("[" + strNew + "]");
            }
        }
    }

    //this finds specific emergency contact info based on gender and relation
    public static void findStudentsOnEmergency(String [][] table, String gender, String relation)
    {
        String temp = "";
        String studentInfoPrint = "";
        for (int i = 0 ; i < 20 ; i++)
        {
            if (table[i][8].equals(gender) && table[i][12].equals(relation))
            {
                for (int j = 0 ; j < 13 ; j++)
                {
                    temp = table [i][j];
                    studentInfoPrint = String.join (" | ",studentInfoPrint,temp);

                }
                String strNew = studentInfoPrint.substring (3);
                System.out.println ("[" + strNew + "]");
            }
        }
    }

    //this is used to display the data of the students to the user
    public static void displayStudents (String [][] table)
    {
        String temp = "";
        String studentInfoPrint = "";
        for (int i = 0 ; i < 20 ; i++)
        {
                for (int j = 0 ; j < 13 ; j++)
                {
                    temp = table [i][j];
                    studentInfoPrint = String.join (" | ",studentInfoPrint,temp);

                }
                String strNew = studentInfoPrint.substring (3);
                System.out.println ("[" + strNew + "]");
                studentInfoPrint = "";
        }
    }

    public static void main(String[] args) {
        int dataColumn = 13;
        int dataRow = 20;

        //this is the initialization of the array that the data will be stored in
        String[][] dataFrame = new String[dataRow][dataColumn];

        //this was the given data
        String text = """
                Stacy,Giller,Smith,Fall,Senior,,123-145-4534,30/10/2004,,2023,Toms River,NJ,Aunt
                Oliver,James,Greenwitch,Spring,Sophomore,,129-349-3596,6/8/2003,Prefer Not To Answer,2025,New York City,NY,Uncle
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
                James,Michael,Clark,Fall,Sophomore,,555-456-7890,11/7/2005,Prefer Not To Answer,2025,Portland,OR,Cousin""";

        //sends the text that was given above to fill the array
        buildDataFrame(dataFrame, text);

        //this sends the array and index of what column to look in to calculate the missing data
        double missingRateGender = findMissingRate(dataFrame, 8);
        double missingRateCity = findMissingRate(dataFrame, 10);

        //this prints out that missing rate
        System.out.println("Missing rate of Gender = " + (float) missingRateGender);
        System.out.println("Missing rate of City = " + (float) missingRateCity);

        //while this send the data to fill those missing data cells
        fillmissing(dataFrame, 8, "Prefer Not To Answer");
        fillmissing(dataFrame, 10, "N/A");
        fillmissing(dataFrame, 12, "Prefer Not To Choose");

        //this send the array to create the emails
        createEmail(dataFrame);

        //this gives the data needed to change peoples emails if needed
        changeEmail(dataFrame, "Senior");

        //this allows the method to calculate the age of students
        findStudentAge(dataFrame, 2023);

        //this sends the data of how the array should be sorted
        sortDataForm(dataFrame, 0);

        //this sends the data to find who graduates in the spring of 2024
        System.out.println(" ");
        System.out.println("Students graduating in Spring 2024");
        findStudentGraduating(dataFrame, "Spring", "2024");

        //this sends the data needed to find people who are female and have there dad as the emergency contact
        System.out.println(" ");
        System.out.println("Female students having their Fathers as emergency contacts");
        findStudentsOnEmergency(dataFrame, "Female","Father");

        //this prints out all the data of the students
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------- The Updated Data Frame -------------------------------------------------------------");
        displayStudents(dataFrame);

    }
}


