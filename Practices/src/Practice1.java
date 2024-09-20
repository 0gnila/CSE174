import java.util.Arrays;

public class Practice1
{
    public static void main(String[] args)
    {
        // Sample string for demonstration
        String sampleString = "Hello, World!";

        // Getting the length of the string
        int length = sampleString.length();
        System.out.println("Length: " + length);

        // Accessing a character at a specific index
        char firstChar = sampleString.charAt(0);
        System.out.println("First Character: " + firstChar);

        // Extracting a substring
        String subString = sampleString.substring(7); // "World!"
        System.out.println("Substring: " + subString);

        // Converting to uppercase and lowercase
        String upperCase = sampleString.toUpperCase();
        String lowerCase = sampleString.toLowerCase();
        System.out.println("Uppercase: " + upperCase);
        System.out.println("Lowercase: " + lowerCase);

        // Removing whitespace from the beginning and end
        String trimmed = sampleString.trim();
        System.out.println("Trimmed: " + trimmed);

        // Checking for equality
        boolean isEqual = sampleString.equals("Hello, World!");
        System.out.println("Is Equal: " + isEqual);

        // Checking for equality (case-insensitive)
        boolean isEqualIgnoreCase = sampleString.equalsIgnoreCase("hello, world!");
        System.out.println("Is Equal (Case-Insensitive): " + isEqualIgnoreCase);

        // Checking if a substring exists
        boolean containsSubstring = sampleString.contains("World");
        System.out.println("Contains Substring: " + containsSubstring);

        // Checking if the string starts with a specific prefix
        boolean startsWithPrefix = sampleString.startsWith("Hello");
        System.out.println("Starts With Prefix: " + startsWithPrefix);

        // Checking if the string ends with a specific suffix
        boolean endsWithSuffix = sampleString.endsWith("!");
        System.out.println("Ends With Suffix: " + endsWithSuffix);

        // Replacing characters
        String replacedString = sampleString.replace('!', '?');
        System.out.println("Replaced String: " + replacedString);

        // Splitting the string
        String[] splitArray = sampleString.split(",");
        System.out.println("Split Array: " + Arrays.toString(splitArray));

        // Joining elements with a delimiter
        String joinedString = String.join(" ", "Hello,", "World!");
        System.out.println("Joined String: " + joinedString);

        // Checking if the string is empty
        boolean isEmpty = sampleString.isEmpty();
        System.out.println("Is Empty: " + isEmpty);

        // Finding the index of a character
        int indexOfChar = sampleString.indexOf('o');
        System.out.println("Index of 'o': " + indexOfChar);

        // Finding the last index of a character
        int lastIndexOfChar = sampleString.lastIndexOf('o');
        System.out.println("Last Index of 'o': " + lastIndexOfChar);

        // Comparing strings lexicographically
        int compareResult = sampleString.compareTo("Hello");
        System.out.println("Compare Result: " + compareResult);
    }
}