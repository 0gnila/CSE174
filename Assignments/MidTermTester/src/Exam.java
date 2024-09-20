
public class Exam
{
    static double investment (double amount, double interest,double period, double years)
    {

        if (years == 0)
        {
            return amount;
        }

         double value = amount * Math.pow(1 + (interest / period), period);
         return investment(value,interest,period,years - 1 );
    }
    public static void main (String args[])
    {
        double value = investment(1000,.05,4,5);
        System.out.println(value);
    }
}
