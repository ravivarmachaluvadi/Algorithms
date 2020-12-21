package com.example.techiedelight.Algorithms.String;

class BreakAStringIntoAllPossibleCombinationsOfNonOverlappingSubstrings
{
    private static final String OPEN_BRACKET = "{";
    private static final String CLOSED_BRACKET = "}";
    private static final String EMPTY_STRING = "";
 
    // Function to break a string into all possible combinations of
    // non-overlapping substrings enclosed within a parenthesis.
    public static void recur(String s, int i, String out)
    {
        if (i == s.length()) {
            System.out.println(out);
        }
 
        // consider each substring S[i, j]
        for (int j = s.length() - 1; j >= i; j--)
        {
            String sub_str = OPEN_BRACKET + s.substring(i, j + 1)
                            + CLOSED_BRACKET;
 
            // append the substring to the result and recur with index of
            // the next character to be processed and result string so far
            recur(s, j + 1, out + sub_str);
        }
    }
 
    public static void main(String[] args)
    {
        // input string
        final String s = "ABCD";
 
        int starting_index = 0;
        recur(s, starting_index, EMPTY_STRING);
    }
}