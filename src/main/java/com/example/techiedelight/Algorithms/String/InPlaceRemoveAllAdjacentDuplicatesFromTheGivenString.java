package com.example.techiedelight.Algorithms.String;

class InPlaceRemoveAllAdjacentDuplicatesFromTheGivenString
{
    // Function to in-place remove all adjacent duplicates from
    // the given String
    public static String removeAdjDup(String str, int n)
    {
        char[] chars = str.toCharArray();
 
        // k maintains the index of next free location in the result
        // and i maintains the current index in the String
        int i, k = 0;
        int len = chars.length;
 
        // start from second character
        for (i = 1; i < len; i++)
        {
            // if current character is not same as the
            // previous character, add it to result
            if (chars[i - 1] != chars[i]) {
                chars[k++] = chars[i - 1];
            }
            else
            {
                // remove adjacent duplicates
                while (i < len && chars[i - 1] == chars[i]) {
                    i++;
                }
            }
        }
 
        // Add last character to result
        chars[k++] = chars[i - 1];
 
        // construct the String with first k chars
        str = new String(chars).substring(0, k);
 
        // start again if any duplicate is removed
        if (k != n) {
            return removeAdjDup(str, k); // Shlemiel Painter's Algorithm
        }
 
        // if the algorithm didn't change the input String, that means
        // all the adjacent duplicates are removed
        return str;
    }
 
    public static void main(String[] args)
    {
        String str = "DBAABDAB";
 
        System.out.print("The String left after removal of all adjacent duplicates is "
                                + removeAdjDup(str, str.length()));
    }
}





class InPlaceRemoveAllAdjacentDuplicatesFromTheGivenStringA2
{
    // Efficient function to in-place remove all adjacent duplicates
    // from the given String
    public static String removeAdjDup(String str)
    {
        // As String is Immutable in Java, convert it to character array
        char[] chars = str.toCharArray();

        // stores previous valid character
        char prev = chars[0];

        // k maintains the index of last filled location in the result
        int k = 0;

        // start from second character
        int i = 1;

        // do till end of the String is reached
        while (i < chars.length)
        {
            // if the current character is not same as the previous character
            if (prev != chars[i])
            {
                chars[++k] = chars[i++];    // update result
                prev = chars[k];            // update prev
            }
            else
            {
                // remove adjacent duplicates
                while (i < chars.length && prev == chars[i]) {
                    i++;
                }

                prev = chars[--k];        // update prev
            }
        }

        // delete str[k+1, n) as result lies in str[0..k]
        return new String(chars).substring(0, k + 1);
    }

    public static void main(String[] args)
    {
        String str = "ABDAADBDAABB";

        str = removeAdjDup(str);
        System.out.println("The String left after removal of all adjacent duplicates is "
                + str);
    }
}