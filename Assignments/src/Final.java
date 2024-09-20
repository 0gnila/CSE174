/************************************************
 * This is a game where you move around a minefield
 * and try to survive 15 moves, there are 2 type of
 * bombs. You need to look for the undetectable ones!
 * @author cole.lingo
 * @author matthew.shuppert
 ***********************************************/

import java.util.Scanner;
import java.util.Random;

public class Final
{
    //this method is to make the play area for game
    public static void initializeGrid(String[][]grid)
    {
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid.length; column++)
                grid[row][column] = "\uD83D\uDFEB";
    }

    //this adds the mines in the play area
    public static void placeMines(String[][]grid)
    {
        Random ran = new Random();
        int randRow;
        int randColumn;
        int placedMines = 0;
        boolean isDetectable;
        while (placedMines != 20)
        {
            randRow = ran.nextInt(10);
            randColumn = ran.nextInt(10);
            if (grid[randRow][randColumn].equals("\uD83D\uDFEB") && randRow + randColumn != 0 && randRow + randColumn != 1)
            {
                isDetectable = ran.nextBoolean();
                if (isDetectable)
                    grid[randRow][randColumn] = "\uD83D\uDCA3";
                else
                    grid[randRow][randColumn] = "\uD83D\uDEA8";
                placedMines++;
            }

        }
    }

    //this prints the whole play area with every piece of information
    public static void printGrid(String[][]grid)
    {
        for (int row = 0; row < grid.length; row++)
        {
            for (int column = 0; column < grid.length; column++)
                System.out.print(grid[row][column] + " ");
            System.out.print("\n");
        }
    }

    //this prints out the play area for the player, it hides bombs that haven't been detected or cant be
    public static void playerPrintGrid(String[][]grid, int yCord, int xCord)
    {
        for (int row = 0; row < grid.length; row++)
        {
            for (int column = 0; column < grid.length; column++)
            {
                //this makes it so it doesn't give any info to the player about bombs
                if (grid[row][column].equals("\uD83D\uDCA3") || grid[row][column].equals("\uD83D\uDEA8"))
                {
                    System.out.print("\uD83D\uDFEB" + " ");
                    continue;
                }
                if (row == xCord && column == yCord)
                {
                    System.out.print("\u263A" + " ");
                    continue;
                }
                System.out.print(grid[row][column] + " ");
            }
            System.out.print("\n");
        }
    }

    //this tells the player if there are any detectable or undetectable bombs nearby
    public static void detectNearbyMines(String[][]grid, int yCord, int xCord)
    {
        int detectableMinesFound = 0;
        int undetectableMinesFound = 0;

        // Check up
        if (yCord != 0)
        {
            if (grid[xCord][yCord - 1].equals("\uD83D\uDCA3")) {
                grid[xCord][yCord - 1] = "\u2705";
                detectableMinesFound++;
            }
            if (grid[xCord][yCord - 1].equals("\uD83D\uDEA8")) {
                undetectableMinesFound++;
            }
        }

        // Checks down
        if (yCord != 9)
        {
            if (grid[xCord][yCord + 1].equals("\uD83D\uDCA3")) {
                grid[xCord][yCord + 1] = "\u2705";
                detectableMinesFound++;
            }
            if (grid[xCord][yCord + 1].equals("\uD83D\uDEA8")) {
                undetectableMinesFound++;
            }
        }

        // Checks right
        if (xCord != 9)
        {
            if (grid[xCord + 1][yCord].equals("\uD83D\uDCA3")) {
                grid[xCord + 1][yCord] = "\u2705";
                detectableMinesFound++;
            }
            if (grid[xCord + 1][yCord].equals("\uD83D\uDEA8")) {
                undetectableMinesFound++;
            }
        }

        // Checks left
        if (xCord != 0)
        {
            if (grid[xCord - 1][yCord].equals("\uD83D\uDCA3")) {
                grid[xCord - 1][yCord] = "\u2705";
                detectableMinesFound++;
            }
            if (grid[xCord - 1][yCord].equals("\uD83D\uDEA8")) {
                undetectableMinesFound++;
            }
        }

        System.out.println(detectableMinesFound + " regular mine(s) were detected and swept nearby, but there's still " + undetectableMinesFound + " undetectable mine(s) nearby!");
    }

    public static void main(String[] args)
    {
        String[][] grid = new String[10][10];
        Scanner scanner = new Scanner(System.in);
        initializeGrid(grid);  //this sends the 2d array we just made above to the initialize grid method
        placeMines(grid);  //this takes the array and fills it with bombs


        boolean winCondition = false;
        boolean endCondition = false;
        boolean mineCondition = false;
        int moveAmount = 0;
        String input;
        int playerXCord = 0;
        int playerYCord = 0;
        playerPrintGrid(grid, playerXCord, playerYCord);  //this sends the position of the player and the array we made to the player print grid method

        while (!endCondition || moveAmount == 15)  //while loop ends if player hits a mine or reaches the move amount
        {
            System.out.print("W/A/S/D to move, Q to quit: ");
            input = scanner.next();
            input = input.toLowerCase(); //makes it so its not case-sensitive

            System.out.println("");

            switch(input)
            {
                case "w": //if the player tries to move up
                    if (playerYCord == 0) // if the player is on the edge
                    {
                        System.out.println("Invalid movement\n");
                        moveAmount++;
                        break;
                    }
                    else
                    {
                        moveAmount++;
                        playerYCord--;
                    }
                    break;

                case "a": // if the player want to move left
                    if (playerXCord == 0) // if the player is on the edge
                    {
                        System.out.println("Invalid movement\n");
                        moveAmount++;
                        break;
                    }
                    else
                    {
                        moveAmount++;
                        playerXCord--;
                    }
                    break;

                case "s": // if the player want to move down
                    if (playerYCord == 9) // if the player is on the edge
                    {
                        System.out.println("Invalid movement\n");
                        moveAmount++;
                        break;
                    }
                    else
                    {
                        moveAmount++;
                        playerYCord++;
                    }
                    break;

                case "d": // if the player want to move right
                    if (playerXCord == 9) // if the player is on the edge
                    {
                        System.out.println("Invalid movement\n");
                        moveAmount++;
                        break;
                    }
                    else
                    {
                        moveAmount++;
                        playerXCord++;
                    }
                    break;

                case "q": // if the player wants to quit
                {
                    endCondition = true;
                    break;
                }

                default: // if the player puts in a wrong key press
                    System.out.println("Invalid key press\n");
                    break;
            }

            if (grid[playerYCord][playerXCord].equals("\uD83D\uDEA8")) //if the player hits an undetectable mine
            {
                mineCondition = true;
                grid[playerYCord][playerXCord] = "\uD83D\uDD25";
                break;
            }

            if (moveAmount == 15) // if the player hits the movement limit
            {
                winCondition = true;
                break;
            }

            detectNearbyMines(grid, playerXCord, playerYCord); // sends the grid and the player cords to see if there are any nearby bombs
            playerPrintGrid(grid, playerXCord, playerYCord); // sends the grid and the player cords to print the array to see the player location
        }

        if (winCondition) // if the movement limit is reached
            System.out.println("You Win!");
        else //if you quit the game
            System.out.print("Game over!");
        if (mineCondition) //when you hit the mine
            System.out.println(" You hit a mine.");

        printGrid(grid); // prints the final grid
    }
}