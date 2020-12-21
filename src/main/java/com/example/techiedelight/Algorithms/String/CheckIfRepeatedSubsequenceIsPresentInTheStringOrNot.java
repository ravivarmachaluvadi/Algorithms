package com.example.techiedelight.Algorithms.String;

import java.util.HashMap;
import java.util.Map;
 
class CheckIfRepeatedSubsequenceIsPresentInTheStringOrNot
{
    // Recursive function to check if str[low..high] is a palindrome or not
    public static boolean isPalindrome(String str, int low, int high)
    {
        // base case
        if (low >= high) {
            return true;
        }
 
        return (str.charAt(low) == str.charAt(high)) &&
                isPalindrome(str, low + 1, high - 1);
    }
 
    // Function to checks if repeated subsequence is present in the String
    public static boolean repeatedSubsequence(String str)
    {
        // map to store frequency of each distinct character
        // of given String
        Map<Character, Integer> freq = new HashMap<>();
 
        // update map with frequency
        for (char c: str.toCharArray())
        {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
 
            // if frequency of any character becomes 3,
            // we have found the repeated subsequence
            if (freq.get(c) >= 3) {
                return true;
            }
        }
 
        StringBuilder sb = new StringBuilder() ;
 
        // consider all repeated elements (frequency 2 or more)
        // and discard all non-repeating elements (frequency 1)
        for (char c: str.toCharArray()) {
            if (freq.get(c) >= 2) {
                sb.append(c);
            }
        }
 
        // return false if temp is a Palindrome
        return !isPalindrome(sb.toString(), 0, sb.length() - 1);
    }
 
    public static void main(String[] args)
    {
        String str = "XYBYAXB";        // XB is repeated subsequence
 
        if (repeatedSubsequence(str))
            System.out.println("Repeated Subsequence present");
        else
            System.out.println("No Repeated Subsequence");
    }
}