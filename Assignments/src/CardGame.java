/*****************************************************
 * This program is to play a card game with the users
 * @author cole.lingo
 ****************************************************/

//So we cant get random card count and ask for the users input
import java.util.Scanner;
import java.util.Random;

public class CardGame
{
    public static void main(String[] args)
    {
        //the size of a deck of cards never changes, it is always 52
        final int deckSize = 52;
        Random r = new Random();

        //making array of the symbols/suits and the ranks
        String [] suits = {"\u2663", "\u2666" , "\u2665" , "\u2660"};
        String [] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String [] deck = new String [deckSize];

        //keep this variables for later
         int index;
         String temp = "";

         // the making of the deck
        for(int i = 0; i < suits.length; i++)
        {
            for(int j= 0; j < ranks.length; j++)
            {
                index = ranks.length * i + j;
                deck[index] = suits[i] + ranks[j];
            }
        }

        // printing out the deck
        System.out.println ("The original deck is arranged as below:");
        for (int i = 0; i <= deckSize-1; i++)
        {
            System.out.print(deck[i] + " ");
        }
        System.out.println(" ");

        System.out.println (" ");

        //shuffling the deck
        for (int i = deck.length -1; i >= 0; i--)
        {
            index = r.nextInt (i+1);
            temp = deck [index];
            deck[index] = deck [i];
            deck[i] = temp;
        }

        //printing out the shuffled deck
        System.out.print ("The Shuffled deck is arranged as below:");
        System.out. println (" ");
        for (int i = 0; i <= deckSize -1; i++)
        {
            System.out.print(deck[i]+ " ");
        }

        System.out.println (" ");

        //asking user to ender the number of winning cards they want
        Scanner keyboard = new Scanner(System.in);
        System.out.print ("Before the beginning of the game, enter the number of winning cards: ");
        int cardNum = keyboard.nextInt();

        String [] winningCards = new String [cardNum];
        Boolean [] isDrawn = new Boolean[deckSize];

        //putting data into the isDrawn array
        for (int i =0; i <= deckSize -1; i++)
        {
            isDrawn[i]= false;
        }

        int counter = 0;

        //Getting the winning cards
        for (int i = 0 ; i <= winningCards.length -1; i++)
        {
            int randNum = r.nextInt(deckSize -1);

                if (isDrawn [randNum] == false)
                {
                    temp = deck[randNum];
                    winningCards [counter] = temp;
                    isDrawn [randNum] = true;
                    counter++;
                }
                if (isDrawn [randNum] == true)
                {
                    continue;
                }
        }

        System.out.println (" ");

        //print out winning cards
        System.out.println ("The winning cards are arranged as below:");
        for (int i = 0; i <= cardNum -1; i++)
        {
            System.out.print(winningCards[i] + " ");
        }

        Boolean [] isFound = new Boolean[deckSize];
        int collectedCards = 0;
        int distinctCards = 0;
        String [] winningCard = new String [cardNum];

        //adding data to the isFound array
        for (int i =0; i <= deckSize -1; i++)
        {
            isFound[i]= false;
        }

        System.out.println (" ");

        //seeing how many cards it takes to get all the winning cards
        while (distinctCards < cardNum)
        {
            int randNum = r.nextInt(0,deckSize-1);
            if (isFound[randNum] == false)
            {
                for (int i = 0; i < cardNum; i++)
                {
                    if (winningCards[i] == deck[randNum])
                    {
                        distinctCards++;
                        isFound [randNum] = true;
                        break;
                    }
                }
                collectedCards++;
            }
        }
        System.out.print ("Number of drawn cards to match the set of winning cards = " + collectedCards);


    }
}
