package com.example.techiedelight.Algorithms.String;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class DetermineIfCharactersOfAStringFollowASpecifiedOrderOrNot
{
    // Determine if characters of a given string follows specific order as
    // defined by characters of the given pattern
    public static boolean checkPattern(String input, String pattern)
    {
        // invalid input
        if (input.length() < pattern.length()) {
            return false;
        }
 
        // stores previous seen character (initially NULL)
        char prev = '\0';
 
        // loop through all chars of the pattern
        for (char curr: pattern.toCharArray())
        {
            // return false if last occurrence of previous character is after
            // the first occurrence of current character in the input string
 
            int firstIndex = input.indexOf(curr);
            int lastIndex = input.lastIndexOf(prev);
 
            if (firstIndex == -1 || (prev != '\0' && lastIndex > firstIndex)) {
                return false;
            }
 
            // set current char as previous char for next iteration
            prev = curr;
        }
 
        // we reach here if the given string matches the pattern
        return true;
    }
 
    public static void main(String[] args)
    {
        String input = "Techie Delight";
        String pattern = "el";
 
        if (checkPattern(input, pattern)) {
            System.out.println("Pattern found");
        } else {
            System.out.println("Pattern not found");
        }
    }
}





class DetermineIfCharactersOfAStringFollowASpecifiedOrderOrNotA2
{
    // Function to remove characters from a string that are not present in
    // the specified pattern
    public static String removeChars(String s, final String allowed) {
        Set<String> allow = Arrays.stream(allowed.split(""))
                .collect(Collectors.toSet());

        return Arrays.stream(s.split(""))
                .filter(i -> allow.contains(i))
                .collect(Collectors.joining(""));
    }

    // Function to remove adjacent duplicates characters from a string
    public static String removeDuplicates(char[] chars)
    {
        char prev = '\0';
        int k = 0;

        for (int i = 0; i < chars.length; i++)
        {
            if (prev != chars[i]) {
                chars[k++] = chars[i];
                prev = chars[i];
            }
        }

        return new String(chars).substring(0, k);
    }

    // Determine if characters of a given string follows specific order as
    // defined by characters of the given pattern
    public static boolean checkPattern(String s, String pattern)
    {
        return removeDuplicates(removeChars(s, pattern).toCharArray())
                .compareTo(pattern) == 0;
    }

    public static void main(String[] args)
    {
        String string = "Techie Delight";
        String pattern = "el";

        if (checkPattern(string, pattern)) {
            System.out.println("Pattern found");
        } else {
            System.out.println("Pattern not found");
        }
    }
}