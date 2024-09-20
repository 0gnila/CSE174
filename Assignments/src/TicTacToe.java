/************************************************************
 * This is a simple game of Tic Tac Toe get 3 in a row to win
 *
 * @author cole.lingo
 ***********************************************************/

// Import component classes from swing package
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

// Import layout classes and event-handling interfaces from awt package
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//inherits the JFrame and ActionListener
public class TicTacToe extends JFrame implements ActionListener
{

    //sets up constants for the program
    private String player1;                             // Name of player 1
    private String player2;                             // Name of player 2
    private String currentPlayer;                       // Name of the current player
    private boolean gameOver = false;                   // Flag indicating if the game is over
    private JButton[][] buttons = new JButton[3][3];    // Buttons for the game board
    private JLabel turnLabel;


    /******************************************
     *This method sets up the basics of the gui
     * and gets names and sets player turns
     *
     *****************************************/
    public TicTacToe()
    {
        // Set the title of the game window
        super("Tic Tac Toe");
        // Set the closing operation of the game window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the game window
        setSize(600,600);
        // Set the layout of the game window
        setLayout(new BorderLayout());
        // Create panel for player turn label and add it to the frame
        turnLabel = new JLabel(player1 +"'s Turn");
        add(turnLabel, BorderLayout.NORTH);
        // Create panel for game board (3 * 3) and add it to the frame
        JPanel gamePanel = new JPanel(new GridLayout(3,3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                gamePanel.add(buttons[i][j]);
            }
        }

        //adds the panel and layout to gui
        add(gamePanel, BorderLayout.CENTER);

        // Get player names through Dialog container
        do
        {
            player1 = JOptionPane.showInputDialog(this, "Enter Player 1 Name:");
        }
        while (player1 == null || player1.trim().isEmpty());

        do
        {
            player2 = JOptionPane.showInputDialog(this, "Enter Player 2 Name:");
        }
        while (player2 == null || player2.trim().isEmpty() || player2.equals(player1));

        // Set the currentPlayer to player1
        currentPlayer = player1;
        // Set the text of the turnLabel to hold the name of player1 at the beginning of the game
        turnLabel.setText(currentPlayer + " 's Turn");

        setVisible(true);
    }

    /************************************************
     * This method reacts to when one of the buttons
     * on the 3x3 grid are pressed, it will check if
     * the game is won or a draw
     *
     * @param press the event to be processed
     *************************************************/
    @Override
    public void actionPerformed(ActionEvent press)
    {
        // Get the button that triggered the action event
        JButton clickedButton = (JButton) press.getSource();
        // Determine the location of which button was clicked (i.e., grid cell)
        int[] gameCoordinate = getCoordinate(clickedButton);

        //then assigns the location of what was pressed to a row and col variable so we can use it later
        int row = gameCoordinate[0];
        int col = gameCoordinate[1];

        // Check if the chosen cell is empty or not. If empty:
        // 1. Set the text of the grid cell

        //if the game is not over and if the button selected is empty
        if (!gameOver && buttons[row][col].getText().equals(""))
        {
            //put the name of currentplayer in the button
            buttons[row][col].setText(currentPlayer);

            //This starts the main game loop, it starts with checking for a win, then a draw, then will switch the player
            // 2. Check for win
            //calls method win and if true then this will happen
            if (win())
            {
                // if win it will come up with a game over pane with the current player
                JOptionPane.showMessageDialog(this, "Game Over! " + currentPlayer + " wins!");
                gameOver = true;
            }

            // 3. Check for draw
            //calls method draw and if true then this happens
            else if (draw())
            {
                //if the game is a draw it will come up with a game over pane with its a draw 
                JOptionPane.showMessageDialog(this, "Game Over! It's a draw!");
                gameOver = true;
            }
            // 4. Switch player and set the text of the 'turnLabel' no win or draw yet!
            else
            {
                if (currentPlayer.equals(player1))
                {
                    currentPlayer = player2;
                }
                else
                {
                    currentPlayer = player1;
                }
                turnLabel.setText(currentPlayer + "'s Turn");
            }
        }
        // If not empty, a pop-up window (Dialog) stating the cell is already taken!
        else if (!buttons[row][col].getText().equals(""))
        {
            System.out.println(buttons[row][col].getText());
            JOptionPane.showMessageDialog(this, "Cell already taken!");
        }

    }



    // Method to check for win
    public boolean win()
    {
        for (int i = 0; i < 3; i++)
        {
            //calls line checker to check if there is 3 in a row
            if(lineChecker(buttons[i][0].getText(), buttons[i][1].getText(), buttons[i][2].getText()) ||
                    lineChecker(buttons[0][i].getText(), buttons[1][i].getText(), buttons[2][i].getText()))
            {
                return true;
            }
        }
        //returns falls if not 3 in a row
        return false;
    }

    // Method to check for draw
    public boolean draw()
    {
        //goes through the array of buttons to check if any are not claimed
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (buttons[i][j].getText().equals(""))
                {
                    return false;
                }
            }
        }
        return true;
    }

    //check lines for 3 in a row for a win
    public boolean lineChecker(String button1, String button2, String button3)
    {
        //checks rows
        for(int i = 0; i < 3; i++)
        {
            if(buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().equals(""))
            {
                return true;
            }
        }
        //check columns
        for(int i = 0; i < 3; i++)
        {
            if(buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().equals(""))
            {
                return true;
            }
        }
        //check diagonal
        for(int i = 0; i < 3; i++)
        {
            if(buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().equals(""))
            {
                return true;
            }
        }
        return false;

    }

    //this methods gets the coordinate of the pushed button
    private int[] getCoordinate(JButton button)
    {
        //does through the array to see what button was pressed
        try {
            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[i].length; j++) {
                    if (buttons[i][j] == button) {
                        return new int[] { i, j };
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Buttons array not properly initialized: " + e.getMessage());
        }
        return new int[] { -1, -1 };
    }

    // Main method
    public static void main(String[] args)
    {
        // Instantiate the TicTacToeTemplate class
        new TicTacToe();
    }
}

