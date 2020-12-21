package com.example.techiedelight.Algorithms.String;

class LongestSubstringOfGivenStringContainingDistinctCharacters
{
    // define character range
    private static final int CHAR_RANGE = 128;
 
    // Function to find longest substring of with all
    // distinct characters using sliding window
    public static String longestSubstr(String str)
    {
        // boolean array to mark characters present in current window
        boolean[] window = new boolean[CHAR_RANGE];
 
        // stores longest substring boundaries
        int begin = 0, end = 0;
 
        // [low..high] maintain sliding window boundaries
        for (int low = 0, high = 0; high < str.length(); high++)
        {
            // if current character is present in current window
            if (window[str.charAt(high)])
            {
                // remove characters from the left of the window till
                // we encounter current character
                while (str.charAt(low) != str.charAt(high)) {
                    window[str.charAt(low)] = false;
                    low++;
                }
 
                low++;        // remove current character
            }
            else
            {
                // if current character is not present in the current
                // window, include it
                window[str.charAt(high)] = true;
 
                // update maximum window size if necessary
                if (end - begin < high - low)
                {
                    begin = low;
                    end = high;
                };
            }
        }
 
        // return longest substring found at str[begin..end]
        return str.substring(begin, end + 1);
    }
 
    public static void main(String[] args)
    {
        String str = "abbcdafeegh";
 
        System.out.print(longestSubstr(str));
    }
}