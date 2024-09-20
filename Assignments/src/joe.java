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
import java.util.ArrayList;

public class joe extends JFrame implements ActionListener
{
    private String player1;                             // Name of player 1
    private String player2;                             // Name of player 2
    private String currentPlayer;                       // Name of the current player
    private boolean gameOver = false;                   // Flag indicating if the game is over
    private JButton[][] buttons = new JButton[3][3];    // Buttons for the game board
    private JLabel turnLabel;
    // Label to display current player's turn

    // Constructor

    public joe()
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

    // ActionListener method
    @Override
    public void actionPerformed(ActionEvent press)
    {
        // Get the button that triggered the action event
        JButton clickedButton = (JButton) press.getSource();
        // Determine the location of which button was clicked (i.e., grid cell)
        int[] gameCoordinate = getCoordinate(clickedButton);

        int row = gameCoordinate[0];
        int col = gameCoordinate[1];
        // Check if the chosen cell is empty or not. If empty:
        // 1. Set the text of the grid cell
        if (!gameOver && buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText(currentPlayer);

            // 2. Check for win
            if (win())
            {
                JOptionPane.showMessageDialog(this, "Game Over! " + currentPlayer + " wins!");
                gameOver = true;
            }

            // 3. Check for draw
            else if (draw())
            {
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
            if(lineChecker(buttons[i][0].getText(), buttons[i][1].getText(), buttons[i][2].getText()) ||
                    lineChecker(buttons[0][i].getText(), buttons[1][i].getText(), buttons[2][i].getText()))
            {
                return true;
            }
        }
        return false;
    }

    // Method to check for draw
    public boolean draw()
    {
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

    public boolean lineChecker(String button1, String button2, String button3)
    {
        if(!button1.equals("") && button2.equals(button1) && button3.equals(button1))
        {
            return true;
        }
        return false;
    }

    private int[] getCoordinate(JButton button)
    {
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
        new joe();
    }
}
