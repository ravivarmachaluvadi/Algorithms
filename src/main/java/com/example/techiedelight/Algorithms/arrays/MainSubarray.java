package com.example.techiedelight.Algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
class MainSubarray
{
    // Function to print all sub-arrays of the specified array
    public static void printallSubarrays(List<Integer> arr)
    {
        // consider all sub-arrays starting from i
        for (int i = 0; i < arr.size(); i++)
        {
            // consider all sub-arrays ending at j
            for (int j = i; j < arr.size(); j++)
            {
                // Function to print a sub-array formed by [i, j]
                System.out.println(arr.subList(i, j + 1));
            }
        }
    }
 
    // Program to print all sub-arrays of the specified array
    public static void main(String[] args)
    {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        printallSubarrays(arr);
    }
}


class MainSubstring
{
    // Function to print all non-empty sub-strings of the specified String
    public static void printallSubStrings(String str)
    {
        int n = str.length();

        // consider all sub-strings starting from i
        for (int i = 0; i < n; i++) {
            // consider all sub-strings ending at j
            for (int j = i; j < n; j++) {
                System.out.print("'" + str.substring(i, j + 1) + "', ");
            }
        }
    }

    // Program to print all non-empty sub-strings of the specified String
    public static void main(String[] args)
    {
        String str = "techie";
        printallSubStrings(str);
    }
}



class MainSubsequence
{
    // Function to print all sub-sequences of the specified String
    public static void findPowerSet(String str)
    {
        int n = str.length();

        // N stores total number of subsets
        int N = (int)Math.pow(2, n);
        List<String> result = new ArrayList<>();

        // generate each subset one by one
        for (int i = 0; i < N; i++)
        {
            StringBuilder sb = new StringBuilder();

            // check every bit of i
            for (int j = 0; j < n; j++)
            {
                // if j'th bit of i is set, print S[j]
                if ((i & (1 << j)) != 0) {
                    sb.append(str.charAt(j));
                }
            }
            result.add("'" + sb.toString() + "'");
        }

        System.out.println(result);
    }

    // Program to print all sub-sequences of the specified String
    public static void main(String[] args)
    {
        String str = "apple";
        findPowerSet(str);
    }
}