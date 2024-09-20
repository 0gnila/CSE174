/**
 * This class is to find the accuracy rate in the measurement of length values of a rectangular box
 * CSE 174
 * D
 * @author ColeLingo
 */

public class AccuracyRateCalculator
{
    public static void main(String[] args)
    {
        // Declare a variable 'actualValue' representing the true/theoretical value and initialize it to 22.58
        double actualValue = 22.58;

        // Declare a variable 'measuredValue' representing the observed/measured value and initialize it to 22.52
        double measuredValue = 22.52;

        // Declare a variable 'errorRate' to hold the computed error rate from the 'actualValue' and 'measuredValue'
        double errorRate = ((actualValue - measuredValue)/actualValue) * 100;

        // Declare a variable 'accuracyRate' to hold the computed accuracy rate from the computed error rate
        double accuracyRate = 100 - errorRate;

        // Display the actual value
        System.out.println("Actual Value: " + actualValue);

        // Display the measured value
        System.out.println("Measured Value: " + measuredValue);

        // Display the error rate
        System.out.println("Error Rate: " + errorRate);

        // Display the accuracy rate
        System.out.println("Accuracy Rate: " + accuracyRate);
    }
}
