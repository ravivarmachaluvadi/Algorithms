package com.example.techiedelight.Algorithms.String;

import java.util.Arrays;
import java.util.Comparator;
 
class FindAllLexicographicallyPreviousPermutationsOfAStringSortedInDescendingOrder
{
    private static void swap(Character[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
 
    private static void reverse(Character[] chars, int start) {
        for (int i = start, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
    }
 
    // Function to find lexicographically previous permutations of a
    // String. It returns true if the String could be rearranged as
    // a lexicographically smaller permutation else it returns false
    public static boolean prev_permutation(Character[] chars)
    {
        // Find largest index i such that chars[i] is less than chars[i - 1]
        int i = chars.length - 1;
        while (chars[i - 1] <= chars[i])
        {
            // if i is first index of the String, that means we are already at
            // lowest possible permutation i.e. String is sorted in asc order
            if (--i == 0) {
                return false;
            }
        }
 
        // if we reach here, substring chars[i..n) is sorted in ascending order
        // i.e. chars[i-1] > chars[i] <= chars[i+1] <= chars[i+2] <= ... <= chars[n-1]
 
        // Find an index j to the right of index i such that chars[j] > chars[i–1]
        int j = i + 1;
        while (j < chars.length && chars[j] <= chars[i-1]) {
            j++;
        }
 
        // Swap characters at index i-1 with index j-1
        swap(chars, i-1, j-1);
 
        // Reverse the substring chars[i..n) and return true
        reverse(chars, i);
 
        return true;
    }
 
    // Function to find all lexicographically previous permutations of a
    // String sorted in descending order
    public static void permutations(String str)
    {
        // convert the string into a Character array and sort it in descending order
        Character[] chars = str.chars()
                .mapToObj(ch -> (char) ch)
                .sorted(Comparator.reverseOrder())
                .toArray(Character[]::new);
 
        while (true)
        {
            // print the current permutation
            System.out.println(Arrays.toString(chars));
 
            // find previous lexicographically ordered permutation
            if (!prev_permutation(chars)) {
                break;
            }
        }
    }
 
    public static void main(String[] args)
    {
        String str = "BADC";
        permutations(str);
    }
}