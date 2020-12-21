package com.example.techiedelight.Algorithms.String;

import java.util.Arrays;
 
class FindAllLexicographicallyNextPermutationsOfAStringSortedInAscendingOrder
{
    private static void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
 
    private static void reverse(char[] chars, int start) {
        for (int i = start, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
    }
 
    // Function to find lexicographically next permutations of a
    // string. It returns true if the string could be rearranged as
    // a lexicographically greater permutation else it returns false
    public static boolean next_permutation(char[] chars)
    {
        // Find largest index i such that chars[i - 1] is less than chars[i]
        int i = chars.length - 1;
        while (chars[i - 1] >= chars[i])
        {
            // if i is first index of the string, that means we are already at
            // highest possible permutation i.e. string is sorted in desc order
            if (--i == 0) {
                return false;
            }
        }
 
        // if we reach here, substring chars[i..n) is sorted in descending order
        // i.e. chars[i-1] < chars[i] >= chars[i+1] >= chars[i+2] >= ... >= chars[n-1]
 
        // Find highest index j to the right of index i such that
        // chars[j] > chars[i–1]
        int j = chars.length - 1;
        while (j > i && chars[j] <= chars[i - 1]) {
            j--;
        }
 
        // swap characters at index i-1 with index j
        swap(chars, i-1, j);
 
        // reverse the substring chars[i..n) and return true
        reverse(chars, i);
 
        return true;
    }
 
    // Function to find all lexicographically next permutations of a
    // String sorted in ascending order
    public static void permutations(String str)
    {
        // convert the string into a char array and sort it in ascending order
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
 
        while (true)
        {
            // print current permutation
            System.out.print(new String(chars) + " ");
 
            // find next lexicographically ordered permutation
            if (!next_permutation(chars)) {
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