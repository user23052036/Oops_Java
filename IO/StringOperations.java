import java.util.Scanner;

public class StringOperations 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Input strings and character
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        System.out.print("Enter a character to search: ");
        char searchChar = scanner.next().charAt(0);

        // 1. Change the case of the string
        System.out.println("Lowercase: " + str1.toLowerCase());
        System.out.println("Uppercase: " + str1.toUpperCase());

        // 2. Reverse the string using StringBuffer
        StringBuffer stringBuffer = new StringBuffer(str1);
        System.out.println("Reversed string: " + stringBuffer.reverse());

        // 3. Compare two strings
        int comparisonResult = str1.compareTo(str2);
        if (comparisonResult == 0) 
            System.out.println("Strings are equal.");
        else if (comparisonResult < 0) 
            System.out.println("First string is lexicographically smaller than the second.");
        else
            System.out.println("First string is lexicographically greater than the second.");
    

        // 4. Insert one string into another
        System.out.print("Enter the index to insert the second string into the first: ");
        int index = scanner.nextInt();
        StringBuffer insertBuffer = new StringBuffer(str1);
        insertBuffer.insert(index, str2);
        System.out.println("String after insertion: " + insertBuffer);

        // 5. Convert to uppercase and lowercase
        System.out.println("Uppercase version: " + str1.toUpperCase());
        System.out.println("Lowercase version: " + str1.toLowerCase());

        // 6. Check if a character is present and its position
        char[] charArray = str1.toCharArray();
        boolean found = false;
        for (int i = 0; i < charArray.length; i++) 
        {
            if (charArray[i] == searchChar) 
            {
                System.out.println("Character '" + searchChar + "' found at position: " + i);
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Character '" + searchChar + "' not found in the string.");

        // 7. Check if the string is a palindrome
        String reversedStr = new StringBuilder(str1).reverse().toString();
        if (str1.equals(reversedStr))
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome.");


        // 8. Count words, vowels, and consonants in the string
        int wordCount = str1.trim().isEmpty() ? 0 : str1.trim().split("\\s+").length;
        int vowelCount = 0, consonantCount = 0;
        
        for (char c : str1.toLowerCase().toCharArray()) 
        {
            if (c >= 'a' && c <= 'z') 
            {
                if ("aeiou".indexOf(c) != -1) vowelCount++;
                else consonantCount++;
            }
        }

        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);

        scanner.close();
    }
}
