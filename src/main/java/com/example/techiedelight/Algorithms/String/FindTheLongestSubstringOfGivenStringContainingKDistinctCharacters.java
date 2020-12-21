package com.example.techiedelight.Algorithms.String;

import java.util.HashSet;
import java.util.Set;
 
class FindTheLongestSubstringOfGivenStringContainingKDistinctCharacters
{
    // define character range
    public static final int CHAR_RANGE = 128;
 
    // Function to find longest substring of given string containing
    // k distinct characters using sliding window
    public static String longestSubstr(String str, int k)
    {
        // stores longest substring boundaries
        int end = 0, begin = 0;
 
        // set to store distinct characters in a window
        Set<Character> window = new HashSet<>();
 
        // count array to store frequency of characters present in
        // current window
        // we can also use a map instead of count array
        int[] freq = new int[CHAR_RANGE];
 
        // [low..high] maintain sliding window boundaries
        for (int low = 0, high = 0; high < str.length(); high++)
        {
            window.add(str.charAt(high));
            freq[str.charAt(high)]++;
 
            // if window size is more than k, remove characters from the left
            while (window.size() > k)
            {
                // if the frequency of leftmost character becomes 0 after
                // removing it in the window, remove it from set as well
                if (--freq[str.charAt(low)] == 0) {
                    window.remove(str.charAt(low));
                }
 
                low++;        // reduce window size
            }
 
            // update maximum window size if necessary
            if (end - begin < high - low)
            {
                end = high;
                begin = low;
            }
        }
 
        // return longest substring found at str[begin..end]
        return str.substring(begin, end + 1);
    }
 
    public static void main(String[] args)
    {
        String str = "abcbdbdbbdcdabd";
        int k = 2;
 
        System.out.print(longestSubstr(str, k));
 
    }
}