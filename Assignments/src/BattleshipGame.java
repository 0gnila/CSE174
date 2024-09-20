/****************************************************
 * In this game you will play against another person
 * trying to sink each other's battles ships
 * @author cole.lingo
 ***************************************************/
//this allows the classes random and scanner to be used
import java.util.Random;
import java.util.Scanner;

public class BattleshipGame
{
    public static void main ( String [] args)
    {
        //this allows the uses of scanner and random
        Scanner keyboard = new Scanner (System.in);
        Random random = new Random();

        //Ask for the players names
        System.out.print ("First player's name: ");
        String player1 = keyboard.next();

        System.out.print ("Second player's name: ");
        String player2 = keyboard.next();

        //this makes the grids for each player
        String[][] player1Grid = new String[6][6];
        String[][] player2Grid = new String[6][6];

        //this fills the grid with water
        for (int i = 0 ; i < 6 ; i++)
        {
            for (int j = 0 ; j < 6 ; j++)
            {
                player1Grid [i][j] = "\uD83C\uDF0A";
                player2Grid [i][j] = "\uD83C\uDF0A";
            }
        }

        //this places the ships in the arrays
        for (int i = 0 ; i < 6 ; i++)
        {
            player1Grid [i][random.nextInt(6)] = "\uD83D\uDEA2";
        }

        for (int i = 0 ; i < 6 ; i++)
        {
            player2Grid [i][random.nextInt(6)] = "\uD83D\uDEA2";
        }


        //these variables will keep score
        int player1Score = 0;
        int player2Score = 0;

        //these variables will keep track of player guesses
        int lat;
        int lon;

        // This will repeat the game until someone wins
        while (player1Score < 6 || player2Score < 6)
        {
            System.out.print(player1 + ", guess a latitude and longitude (e.g., 0 3) of a ship to fire at in User2's fleet [0, 5]: ");
            lat = keyboard.nextInt();
            lon = keyboard.nextInt();

            // if the player guess equals a ship
            if (player2Grid [lat][lon].equals ("\uD83D\uDEA2"))
            {
                System.out.println(" That's a hit .... a ship at [" + lat +"," + lon + "]" + " in " + player2 + "'s fleet has just been fired!");
                player1Score++;
                player2Grid[lat][lon] = "\uD83D\uDD25";

                //break if you get all the ships
                if (player1Score == 6)
                    break;
            }
            else
            {
                //if you miss
                System.out.println ("That's a miss .... there was no ship deployed at [" + lat +"," + lon + "]");
            }

            System.out.print(player2 + ", guess a latitude and longitude (e.g., 0 3) of a ship to fire at in User2's fleet [0, 5]: ");
            lat = keyboard.nextInt();
            lon = keyboard.nextInt();

            //if the guess equal a ship
            if (player1Grid [lat][lon] .equals ("\uD83D\uDEA2"))
            {
                System.out.println(" That's a hit .... a ship at [" + lat +"," + lon + "]" + " in " + player1 + "'s fleet has just been fired!");
                player2Score++;
                player1Grid[lat][lon] = "\uD83D\uDD25";

                //if this player gets all the ships
                if (player2Score == 6)
                    break;
            }
            else
            {
                //if they miss a ship
                System.out.println ("That's a miss .... there was no ship deployed at [" + lat +"," + lon + "]");
            }
        }

        //prints who wins
        if (player1Score == 6)
        {
            System.out.println("WINNER ! Congratulations " + player1 + ", you've successfully fired all ships in " + player2 + "'s fleet!");
        }
        else
        {
            System.out.println("WINNER ! Congratulations " + player2 + ", you've successfully fired all ships in " + player1 + "'s fleet!");
        }

        // Prints the game boards of each player
        System.out.println("\t" + "\t" + "Fleet1" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "Fleet2");
        System.out.println("_________________" + "\t" + "\t" + "\t" +"\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "_________________");

        for (int i = 0 ; i < 6 ; i++)
        {
            for (int j = 0 ; j < 6 ; j++)
            {
                System.out.print(player1Grid [i][j]);

            }
            System.out.print ("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t");
            for (int j = 0 ; j < 6 ; j++)
            {
                System.out.print(player2Grid [i][j]);

            }
            System.out.print("\n");
        }

    }
}
