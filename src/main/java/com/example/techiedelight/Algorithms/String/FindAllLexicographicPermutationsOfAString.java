package com.example.techiedelight.Algorithms.String;

import java.util.Arrays;
 
class FindAllLexicographicPermutationsOfAString
{
    // Function to find all lexicographic permutations of given
    // string where repetition of characters is allowed
    public static void lexicographic (char[] chars, String output)
    {
        // base condition (permutation found)
        if (output.length() == chars.length)
        {
            // print the permutation and return
            System.out.print(output + " ");
            return;
        }
 
        // consider all characters of the string one by one
        for (char c : chars) {
            lexicographic(chars, output + c);
        }
    }
 
    public static void main(String[] args)
    {
        String str = "ACB";
 
        // sort the string to print in lexicographically order
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
 
        lexicographic(chars, "");
    }
}