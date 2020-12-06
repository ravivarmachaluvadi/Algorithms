package com.example.techiedelight.Algorithms.arraysGA;

import java.util.*;

//Using Recursion
class PrintAllDistinctSubsetsOfAGivenSet
{
    // Recursive function to print all distinct subsets of S
    // S    --> input set
    // out  --> list to store subset
    // i    --> index of next element in set S to be processed
    public static void findPowerSet(int[] S, Deque<Integer> out, int i)
    {
        // if all elements are processed, print the current subset
        if (i < 0) {
            System.out.println(out);
            return;
        }
 
        // include current element in the current subset and recur
        out.addLast(S[i]);
        findPowerSet(S, out, i - 1);
 
        // backtrack: exclude current element in the current subset
        out.pollLast();
 
        // remove adjacent duplicate elements
        while (i > 0 && S[i] == S[i - 1]) {
            i--;
        }
 
        // exclude current element in the current subset and recur
        findPowerSet(S, out, i - 1);
    }
 
    // Program to generate all distinct subsets of given set
    public static void main(String[] args)
    {
        int[] S = { 1, 3, 1 };
 
        // sort the set
        Arrays.sort(S);
 
        // create an empty list to store elements of a subset
        Deque<Integer> out = new ArrayDeque<>();
        findPowerSet(S, out, S.length - 1);
    }
}



class PrintAllDistinctSubsetsOfAGivenSetA2
{
    // Iterative function to print all distinct subsets of S
    public static void findPowerSet(int[] S)
    {
        // N stores total number of subsets
        int N = (int)Math.pow(2, S.length);
        Set<List<Integer>> set = new HashSet<>();

        // generate each subset one by one
        for (int i = 0; i < N; i++)
        {
            List<Integer> subset = new ArrayList<>();

            // check every bit of i
            for (int j = 0; j < S.length; j++) {
                // if j'th bit of i is set, append S[j] to subset
                if ((i & (1 << j)) != 0) {
                    subset.add(S[j]);
                }
            }

            // insert the subset into the set
            set.add(subset);
        }

        // print all subsets present in the set
        for (List<Integer> subset: set) {
            System.out.println(subset);
        }
    }

    // Program to generate all distinct subsets of given set
    public static void main(String[] args)
    {
        int[] S = { 1, 2, 1 };

        // sort the set
        Arrays.sort(S);

        findPowerSet(S);
    }
}