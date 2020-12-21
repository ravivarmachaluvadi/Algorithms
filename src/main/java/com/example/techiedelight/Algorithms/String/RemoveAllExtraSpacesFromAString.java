package com.example.techiedelight.Algorithms.String;

class RemoveAllExtraSpacesFromAString
{
    // Function to remove all extra whitespace from a string
    public static String removeSpace(String str)
    {
        char[] chars = str.toCharArray();
 
        // space is true when a space character is found and
        // false when any non-space character is found
        boolean space = false;
 
        // k points to next free position
        int k = 0;
 
        // iterate through the characters of the string
        for (int i = 0; i < str.length(); i++)
        {
            // handle leading spaces in the string
            while (k == 0 && i < str.length() && chars[i] == ' ') {
                i++;
            }
 
            // if the current character is a space
            if (Character.isSpaceChar(chars[i]))
            {
                // if flag was 0 earlier, i.e. first occurrence of a
                // space after a word
                if (!space)
                {
                    // copy current char (a whitespace) at next free index
                    // and set the flag
                    chars[k++] = chars[i];
                    space = true;
                }
            }
            // if the current character is a punctuation mark
            else if (ispunct(chars[i]))
            {
                // if last assigned character was a space, overwrite it
                // with the current character
                if (k > 0 && chars[k-1] == ' ') {
                    chars[k-1] = chars[i];
                }
                else {
                    // copy the current character at next free index
                    chars[k++] = chars[i];
                }
                space = false;
            }
            else {
                // copy the current character at next free index
                chars[k++] = chars[i];
                space = false;
            }
        }
 
        // handle trailing spaces in the string
        return new String(chars).substring(0, k);
    }
 
    private static boolean ispunct(char c) {
        return Character.toString(c).matches("\\p{Punct}");
    }
 
    public static void main(String[] args)
    {
        String str = " Hello .    This is    C++    program    !! ";
 
        str = removeSpace(str);
        System.out.printf(str);
    }
}