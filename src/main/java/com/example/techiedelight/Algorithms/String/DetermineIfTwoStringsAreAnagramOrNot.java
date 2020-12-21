package com.example.techiedelight.Algorithms.String;

import java.util.HashMap;
import java.util.Map;
 
class DetermineIfTwoStringsAreAnagramOrNot
{
    // Function to check if X and Y are anagrams or not
    public static boolean isAnagram(String X, String Y)
    {
        // if X's length is not same as Y's, they can't be anagram
        if (X.length() != Y.length()) {
            return false;
        }
 
        // create an empty map
        Map<Character, Integer> freq = new HashMap<>();
 
        // maintain count of each character of X in the map
        for (char c: X.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
 
        // do for each character of Y
        for (char c: Y.toCharArray())
        {
            // if y is not found in map i.e. either y is not present
            // in String X or has more occurrences in String Y
            if (!freq.containsKey(c)) {
                return false;
            }
 
            // decrease the frequency of y in the map
            freq.put(c, freq.get(c) - 1);
 
            // if its frequency become 0, erase it from map
            if (freq.get(c) == 0) {
                freq.remove(c);
            }
        }
 
        // return true if map becomes empty
        return freq.isEmpty();
    }
 
    public static void main(String[] args)
    {
        String X = "tommarvoloriddle";    // Tom Marvolo Riddle
        String Y = "iamlordvoldemort";    // I am Lord Voldemort
 
        if (isAnagram(X, Y)) {
            System.out.print("Anagram");
        } else {
            System.out.print("Not a Anagram");
        }
    }
}


/*

Approach 1 –

        A simple solution would be to sort given strings. If the strings become equal after sorting, they are anagrams. The time
        complexity of above solution is O(nlog(n)).
*/




class DetermineIfTwoStringsAreAnagramOrNotA3
{
    // Function to check if X and Y are anagrams or not
    public static boolean isAnagram(String X, String Y)
    {
        // if X's length is not same as Y's, they can't be anagram
        if (X.length() != Y.length()) {
            return false;
        }

        // create an empty map
        Map<Character, Integer> freqX = new HashMap<>();

        // maintain count of each character of X in the map
        for (char c: X.toCharArray()) {
            freqX.put(c, freqX.getOrDefault(c, 0) + 1);
        }

        // create a second map
        Map<Character, Integer> freqY = new HashMap<>();

        // maintain count of each character of Y in the map
        for (char c: Y.toCharArray()) {
            freqY.put(c, freqY.getOrDefault(c, 0) + 1);
        }

        // return true if both map has same content
        return freqX.equals(freqY);
    }

    public static void main(String[] args)
    {
        String X = "tommarvoloriddle";    // Tom Marvolo Riddle
        String Y = "iamlordvoldemort";    // I am Lord Voldemort

        if (isAnagram(X, Y)) {
            System.out.print("Anagram");
        } else {
            System.out.print("Not a Anagram");
        }
    }
}