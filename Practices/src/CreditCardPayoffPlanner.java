/**
        * You have a credit card with a balance, an annual interest rate, and a monthly
        payment you can make.
        * Write a program that calculates how many months it will take to pay off the
        credit card balance and the total amount paid, considering interest.
        */
import java.util.Scanner;
public class CreditCardPayoffPlanner
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the credit card balance: $");
        double balance = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in decimal form, e.g., 0.18 for 18%): ");
        double annualInterestRate = scanner.nextDouble();
        System.out.print("Enter the monthly payment: $");
        double monthlyPayment = scanner.nextDouble();
        int months = 0;
        double monthlyInterest;
        while (balance > 0)
        {
            monthlyInterest = (annualInterestRate / 12) * balance;
            balance += monthlyInterest;
            balance -= monthlyPayment;
            months++;
        }
        double totalAmountPaid = months * monthlyPayment;
        System.out.println("Months to Pay Off: " + months + " months");
        System.out.println("Total Amount Paid: $" + totalAmountPaid);
        scanner.close();
    }
}
