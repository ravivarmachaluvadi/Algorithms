package com.example.techiedelight.Algorithms.String;

class FindLexicographicallyMinimalStringRotation
{
    // Function to find Lexicographically minimal string rotation
    public static String findLexicalMinRotation(String str)
    {
        // To store lexicographic minimum string
        String min = str;
 
        for (int i = 0; i < str.length(); i++)
        {
            // left rotate string by 1 unit
            str = str.substring(1) + str.charAt(0);
 
            // check if the rotation is minimum so far
            if (str.compareTo(min) < 0) {
                min = str;
            }
        }
 
        return min;
    }
 
    public static void main(String[] args)
    {
        String str = "bbaaccaadd";
 
        System.out.println("The lexicographically minimal rotation of " + str
                        + " is " + findLexicalMinRotation(str));
    }
}