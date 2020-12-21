package com.example.techiedelight.Algorithms.String;

class CheckIfAStringIsRotatedPalindromeOrNot
{
    // Recursive function to check if str[low..high] is a palindrome or not
    public static boolean isPalindrome(String str, int low, int high)
    {
        return (low >= high) || (str.charAt(low) == str.charAt(high) &&
                                isPalindrome(str, low + 1, high - 1));
    }
 
    // Function to check if given string is a rotated palindrome or not
    public static boolean isRotatedPalindrome(String str)
    {
        // length of the given string
        int m = str.length();
 
        // check for all rotations of the given string if it
        // is palindrome or not
        for (int i = 0; i < m; i++)
        {
            // in-place rotate the string by 1 unit
            str = str.substring(1) + str.charAt(0);
 
            // return true if the rotation is a palindrome
            if (isPalindrome(str, 0, m - 1)) {
                return true;
            }
        }
 
        // return false if no rotation is a palindrome
        return false;
    }
 
    // Check if given string is a rotated palindrome or not
    public static void main(String[] args) {
        // palindromic string
        String str = "ABCDCBA";
 
        // rotate it by 2 units
        str = str.substring(2) + str.substring(0, 2);
 
        if (isRotatedPalindrome(str)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}




class CheckIfAStringIsRotatedPalindromeOrNotA2
{
    // expand in both directions of low and high to find
    // palindrome of length k
    private static boolean expand(String str, int low, int high, int k)
    {
        while (low >= 0 && high < str.length() &&
                (str.charAt(low) == str.charAt(high)))
        {
            // return true palindrome of length k is found
            if (high - low + 1 == k) {
                return true;
            }

            // expand in both directions
            low--;
            high++;
        }

        // return false if palindrome of length k is not found
        return false;
    }

    // Function to check if palindromic substring of length k exists or not
    private static boolean LongestPalindromicSubString(String str, int k)
    {
        for (int i = 0; i < str.length() - 1; i++) {
            // check if odd length or even length palindrome of length k
            // having str.charAt(i) as its mid point exists
            if (expand(str, i, i, k) || expand(str, i, i + 1, k)) {
                return true;
            }
        }

        return false;
    }

    // Function to check if given string is a rotated palindrome or not
    public static boolean isRotatedPalindrome(String str)
    {
        // length of given string
        int m = str.length();

        // return true if longest palindromic substring of length m
        // exists in the string (str + str)
        return LongestPalindromicSubString(str + str, m);
    }

    public static void main(String[] args) {
        // palindromic string
        String str = "ABCCBA";

        // rotate it by 2 units
        str = "CCBAAB";

        if (isRotatedPalindrome(str)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}