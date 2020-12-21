package com.example.techiedelight.Algorithms.String;

import java.util.ArrayList;
import java.util.List;

class GenerateAllPermutationsOfAStringRecursive
{
    // Utility function to swap two characters in a character array
    private static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
 
    // Recursive function to generate all permutations of a String
    private static void permutations(char[] ch, int currentIndex)
    {
        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
        }
 
        for (int i = currentIndex; i < ch.length; i++)
        {
            swap(ch, currentIndex, i);
            permutations(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }
 
    // generate all permutations of a String in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations(s.toCharArray(), 0);
    }
}





class GenerateAllPermutationsOfAStringRecursiveA2
{
    // Recursive function to generate all permutations of a String
    private static void permutations(String candidate, String remaining)
    {
        if (remaining.length() == 0) {
            System.out.println(candidate);
        }

        for (int i = 0; i < remaining.length(); i++)
        {
            String newCandidate = candidate + remaining.charAt(i);

            String newRemaining = remaining.substring(0, i) +
                    remaining.substring(i + 1);

            permutations(newCandidate, newRemaining);
        }
    }

    // Find Permutations of a String in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations("", s);
    }
}




// Iterative Approach: (Using Collection)
class GenerateAllPermutationsOfAStringIterative
{
    // Iterative function to generate all permutations of a String in Java
    // using Collections
    public static void permutations(String s)
    {
        // create an empty ArrayList to store (partial) permutations
        List<String> partial = new ArrayList<>();

        // initialize the list with the first character of the string
        partial.add(String.valueOf(s.charAt(0)));

        // do for every character of the specified string
        for (int i = 1; i < s.length(); i++)
        {
            // consider previously constructed partial permutation one by one

            // (iterate backwards to avoid ConcurrentModificationException)
            for (int j = partial.size() - 1; j >= 0 ; j--)
            {
                // remove current partial permutation from the ArrayList
                String str = partial.remove(j);

                // Insert next character of the specified string in all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed string in the list

                for (int k = 0; k <= str.length(); k++)
                {
                    // Advice: use StringBuilder for concatenation
                    partial.add(str.substring(0, k) + s.charAt(i) +
                            str.substring(k));
                }
            }
        }

        System.out.println(partial);
    }

    // Iterative program to generate all permutations of a String in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations(s);
    }
}


