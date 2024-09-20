import javax.swing.event.DocumentEvent;

interface Electronics
{
   default void display()
   {
       System.out.println("This is an Electronic");
   }
}
interface Clothing
{
    default void display()
    {
        System.out.println("This is Clothing");
    }
}
class product implements Electronics, Clothing
{
    public void display()
    {

    }

    public static void main (String args[])
    {
        product product = new product();
        Clothing.product.display();
    }

}