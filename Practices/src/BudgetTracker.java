/**
 * You have a credit card with a balance, an annual interest rate, and a monthly
 payment you can make.
 * Write a program that calculates how many months it will take to pay off the
 credit card balance and the total amount paid, considering interest.
 */
import java.util.Scanner;
public class BudgetTracker
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double totalIncome = 0.0;
        double totalExpenses = 0.0;
        double amount, balance;
        String input = "", type = "";
        System.out.println("Welcome to the Budget Tracker!");
        while (true)
        {
            System.out.print("Enter an income or expense amount (or 'done' to finish): $");
            input = scanner.next();
            if (input.equals("done"))
                break;
// Convert the user-input from 'String' to 'double' format
            amount = Double.parseDouble(input);
            System.out.print("Is this an income or an expense? (income/expense): ");
                    type = scanner.next();
            if (type.equals("income"))
                totalIncome += amount;
            else if (type.equals("expense"))
                totalExpenses += amount;
            else
                System.out.println("Invalid entry. Please enter 'income' or 'expense'.");
        }
// Calculate the remaining balance for the month
        balance = totalIncome - totalExpenses;
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Remaining Balance: $" + balance);
        scanner.close();
    }
}
