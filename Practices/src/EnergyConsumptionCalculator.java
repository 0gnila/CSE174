/**
 * You want to calculate the energy consumption of your household appliances to
 estimate your monthly electricity bill.
 * Write a Java program that allows you to input the power consumption (in watts)
 and usage duration (in hours) for each appliance.
 * Calculate and display the total monthly energy consumption and cost.
 */
import java.util.Scanner;
public class EnergyConsumptionCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double powerConsumption, usageDuration, monthlyUsage, monthlyConsumption,
                monthlyCost;
        double totalConsumption = 0.0;
        String applianceName = "";
        while (true)
        {
            System.out.print("Enter the name of the appliance (or 'done' to finish): ");
            applianceName = scanner.nextLine();
            if (applianceName.equals("done"))
                break;
            System.out.print("Enter the power consumption of " + applianceName + " (in watts): ");
            powerConsumption = scanner.nextDouble();
            System.out.print("Enter the daily usage duration of " + applianceName +
                    " (in hours): ");
            usageDuration = scanner.nextDouble();
            monthlyUsage = usageDuration * 30;
// Assuming an average month of 30 days
            monthlyConsumption = (powerConsumption / 1000) * monthlyUsage;
// Convert watts to kilowatts
            monthlyCost = monthlyConsumption * 0.12;
// Assuming an electricity cost of $0.12 per kWh
            System.out.println(applianceName + " consumes " + monthlyConsumption +
                    " kWh per month.");
            System.out.println("Monthly cost for " + applianceName + ": $" +
                    monthlyCost);
            totalConsumption += monthlyConsumption;
        }
        System.out.println("Total Monthly Energy Consumption: " + totalConsumption
                + " kWh");
        scanner.close();
    }
}
