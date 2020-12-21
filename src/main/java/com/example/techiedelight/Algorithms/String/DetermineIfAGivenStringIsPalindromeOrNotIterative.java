package com.example.techiedelight.Algorithms.String;

class DetermineIfAGivenStringIsPalindromeOrNotIterative
{
    public static boolean isPalindrome(String str)
    {
        if (str == null || str.length() == 0)
            return false;
 
        for (int i = 0, j = str.length() - 1; i < j; ++i, --j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main (String[] args)
    {
        String str = "XYBYBYX";
 
        if (isPalindrome(str))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}





class DetermineIfAGivenStringIsPalindromeOrNotRecursive
{
    // Recursive function to check if str[low..high] is a palindrome or not
    public static boolean isPalindrome(String str, int low, int high)
    {
        // base case
        if (low >= high) {
            return true;
        }

        // return false if mismatch happens
        if (str.charAt(low) != str.charAt(high)) {
            return false;
        }

        // move to the next pair
        return isPalindrome(str, low + 1, high - 1);
    }

    public static void main(String[] args)
    {
        String str = "XYBYBYX";

        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.print("Palindrome");
        } else {
            System.out.print("Not Palindrome");
        }
    }
}





class SingleLineRecursiveVersion
{
    // Recursive function to check if str[low..high] is a palindrome or not
    public static boolean isPalindrome(String str, int low, int high)
    {
        return (low >= high) || (str.charAt(low) == str.charAt(high) &&
                isPalindrome(str, low + 1, high - 1));
    }

    public static void main(String[] args)
    {
        String str = "XYBYBYX";

        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.print("Palindrome");
        } else {
            System.out.print("Not Palindrome");
        }
    }
}

