import java.util.Random;
import java.util.Scanner;

public class WhackAMole
{
    public static void main(String[] args)
    {
        // Set the grid size
        int gridSize = 5;

        // Create the grid
        String[][] grid = new String[gridSize][gridSize];

        // Task1: Fill the grid with the Deciduous Tree symbol
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                grid[i][j] = "\uD83C\uDF33";
            }
        }

        Random random = new Random();

        // Task2: Place 5 moles at random locations; no two or more moles are placed at the same location
        for (int i = 0; i < gridSize; i++)
        {
            grid[i][random.nextInt(gridSize)] = "\u25CF";
        }

        // The number of moles to be whacked to win
        int requiredMolesToWin = 3;

        // Enter the names of the players
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the name of the first player: ");
        String player1 = scanner.next();
        System.out.print("Type the name of the second player: ");
        String player2 = scanner.next();
        System.out.println("The location of moles whacked by the player " + player1 + " will be marked by \u2715");
        System.out.println("The location of moles whacked by the player " + player2 + " will be marked by \u274C");

        // Task3: Start the game

        // Initializes score variables
        int player1Score = 0;
        int player2Score = 0;

        // Asks the player to input coordinates to find the mole and exists the loop when they do
        while (player1Score < requiredMolesToWin && player2Score < requiredMolesToWin)
        {
            // first player's turn
            System.out.print(player1 + ", enter the row and column to whack (e.g. 1 2): ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            // Checks if player has hit a mole or missed and displays output
            if (grid[row][column] == "\u25CF")
            {
                System.out.println(player1 + " whacked a mole! +1 point");
                player1Score++;
                grid[row][column] = "\u2715";

                if (player1Score == 3)
                    break;
            }
            else
            {
                System.out.println(player1 + " missed the mole! No point");
            }

            // Next player's turn
            System.out.print(player2 + ", enter the row and column to whack (e.g. 1 2): ");
            row = scanner.nextInt();
            column = scanner.nextInt();

            // Checks if player has hit a mole or missed and displays output
            if (grid[row][column] == "\u25CF")
            {
                System.out.println(player2 + " whacked a mole! +1 point");
                player2Score++;
                grid[row][column] = "\u274C";
            }
            else
            {
                System.out.println(player2 + " missed the mole! No point");
            }
        }

        // Checks which player wins
        if (player1Score == 3)
        {
            System.out.println(player1 + " wins! Game Over!");
        }
        else
        {
            System.out.println(player2 + " wins! Game Over!");
        }

        // Prints the game that was played
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }

    }
}
