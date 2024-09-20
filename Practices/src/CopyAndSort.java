import java.util.Arrays;

public class CopyAndSort
{
    public static void main(String[] args)
    {
        int[ ] originalArray = { 5, 2, 9, 1, 5, 6 };

        // Using copyOf() method to create a new array with a copy of the original array's contents
        int[ ] copiedArray = Arrays.copyOf(originalArray, originalArray.length);

        // Print the elements of the copiedArray
        System.out.println("Elements of copiedArray are:");
        for(int i = 0; i < copiedArray.length; i++)
            System.out.println(copiedArray[i]);

        // Using sort() method to sort the contents of the copied array in ascending order
        Arrays.sort(copiedArray);

        // Print the elements of the copiedArray after sorting
        System.out.println("Sorted Elements of copiedArray are:");
        for(int i = 0; i < copiedArray.length; i++)
            System.out.println(copiedArray[i]);
    }
}
