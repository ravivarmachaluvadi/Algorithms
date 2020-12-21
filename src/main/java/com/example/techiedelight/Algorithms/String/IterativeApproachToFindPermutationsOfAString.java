package com.example.techiedelight.Algorithms.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IterativeApproachToFindPermutationsOfAString
{
    // Utility function to swap two characters in a character array
    private static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
 
    // Utility function to reverse a char array between specified indices
    private static void reverse(char[] arr, int i, int j)
    {
        // do till two end-points intersect
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
 
    // Iterative function to find permutations of a String in Java
    public static void permutations(String str, int n)
    {
        // sort the string in natural order
        char[] s = str.toCharArray();
        Arrays.sort(s);
 
        while (true)
        {
            // Print current permutation
            System.out.print(String.valueOf(s) + " ");
 
            /* Below code will rearrange the string to next lexicographically
             ordered permutation (if any) or return if we are already at
             highest possible permutation */
 
            // Find largest index i such that s[i-1] is less than s[i]
            int i = n - 1;
            while (s[i-1] >= s[i])
            {
                // if i is first index of the string, that means we are
                // already at last possible permutation
                // (string is sorted in reverse order)
                if (--i == 0)
                    return;
            }
 
            // find highest index j to the right of index i such that
            // s[j] > s[i–1] (s[i..n-1] is sorted in reverse order)
 
            int j = n - 1;
            while (j > i && s[j] <= s[i-1])
                j--;
 
            // Swap characters at index i-1 with index j
            swap(s, i-1, j);
 
            // reverse the substring s[i..n-1] and return true
            reverse (s, i, n-1);
        }
    }
 
    // Iterative program to find permutations of a String in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations(s, s.length());
    }
}




//Using controller array
class IterativeApproachToFindPermutationsOfAStringA2
{
    // Utility function to swap two characters in a character array
    private static void swap(char[] a, int i, int j) {
        char ch = a[i];
        a[i] = a[j];
        a[j] = ch;
    }

    // Iterative function to find permutations of a String in Java
    public static void permutations(String s)
    {
        // convert string to a character array (Since String is immutable)
        char[] chars = s.toCharArray();

        // Weight index control array
        int[] p = new int[s.length()];

        // i, j represents upper and lower bound index resp. for swapping
        int i = 1, j = 0;

        // Print given string, as only its permutations will be printed later
        System.out.print(s);

        while (i < s.length())
        {
            if (p[i] < i)
            {
                // if i is odd then j = p[i], otherwise j = 0
                j = (i % 2) * p[i];

                // swap(a[j], a[i])
                swap(chars, i, j);

                // Print current permutation
                System.out.print(" " + String.valueOf(chars));

                p[i]++;    // increase index "weight" for i by one
                i = 1;    // reset index i to 1
            }
            // otherwise p[i] == i
            else {
                // reset p[i] to zero
                p[i] = 0;

                // set new index value for i (increase by one)
                i++;
            }
        }
    }

    // Iterative program to find permutations of a String in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations(s);
    }
}




//Using STL/Collections
class IterativeApproachToFindPermutationsOfAStringA3
{
    // Iterative function to find permutations of a String in Java
    // using Collections
    public static void permutations(String s)
    {
        // create an empty ArrayList to store (partial) permutations
        // and initialize it with first character of the string
        List<String> partial = new ArrayList<>();
        partial.add(String.valueOf(s.charAt(0)));

        // do for every character of the specified string
        for (int i = 1; i < s.length(); i++)
        {
            // consider previously constructed partial permutation one by one
            // (we're iterating backwards in the list to avoid
            // ConcurrentModificationException)
            for (int j = partial.size() - 1; j >= 0 ; j--)
            {
                // remove current partial permutation from the ArrayList
                String str = partial.remove(j);

                // Insert next character of the specified string in all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed string in the list
                for (int k = 0; k <= str.length(); k++)
                {
                    // Please note that String concatenation is costly in
                    // Java, use StringBuilder instead
                    partial.add(str.substring(0, k) + s.charAt(i) +
                            str.substring(k));
                }
            }
        }

        System.out.println(partial);
    }

    // Iterative program to find permutations of a String in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations(s);
    }
}





