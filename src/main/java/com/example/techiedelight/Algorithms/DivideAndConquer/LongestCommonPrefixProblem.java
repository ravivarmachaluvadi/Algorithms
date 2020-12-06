package com.example.techiedelight.Algorithms.DivideAndConquer;

import java.util.Arrays;
import java.util.List;
 
class LongestCommonPrefixProblem
{
    // Function to find the longest common prefix between two Strings
    public static String LCP(String X, String Y)
    {
        int i = 0, j = 0;
        while (i < X.length() && j < Y.length())
        {
            if (X.charAt(i) != Y.charAt(j)) {
                break;
            }
            i++; j++;
        }
 
        return X.substring(0, i);
    }
 
    // Function to find the longest common prefix (LCP) between given set of Strings
    public static String findLCP(List<String> words)
    {
        String prefix = words.get(0);
        for (String s: words) {
            prefix = LCP(prefix, s);
        }
        return prefix;
    }
 
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("techie delight", "tech", "techie",
                                                    "technology", "technical");
 
        System.out.println("The longest common prefix is " + findLCP(words));
    }
}




class LongestCommonPrefixProblemA2
{
    // Function to find the longest common prefix between two Strings
    public static String LCP(String X, String Y)
    {
        int i = 0, j = 0;
        while (i < X.length() && j < Y.length()) {
            if (X.charAt(i) != Y.charAt(j)) {
                break;
            }

            i++; j++;
        }

        return X.substring(0, i);
    }

    // A recursive function to find the longest common prefix (LCP) between
    // given set of Strings
    public static String findLCP(List<String> words, int low, int high)
    {
        // base case: if low is more than high index, return an empty String
        if (low > high) {
            return "";
        }

        // base case: if low is equal to high, return the current String
        if (low == high) {
            return words.get(low);
        }

        // find the mid index
        int mid = (low + high) / 2;

        // partition the problem into sub-problems and recur for each sub-problem
        String X = findLCP(words, low, mid);
        String Y = findLCP(words, mid + 1, high);

        // return the longest common prefix of Strings X and Y
        return LCP(X, Y);
    }

    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("techie delight", "tech", "techie",
                "technology", "technical");

        System.out.print("The longest common prefix is " +
                findLCP(words, 0, words.size() - 1));
    }
}