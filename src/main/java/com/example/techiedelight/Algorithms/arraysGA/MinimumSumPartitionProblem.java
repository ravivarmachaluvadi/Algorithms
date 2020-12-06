package com.example.techiedelight.Algorithms.arraysGA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MinimumSumPartitionProblem
{
    // Partition the set S into two subsets S1, S2 such that the
    // difference between the sum of elements in S1 and the sum
    // of elements in S2 is minimized
    public static int minPartition(int[] S, int n, int S1, int S2)
    {
        // base case: if list becomes empty, return the absolute
        // difference between two sets
        if (n < 0) {
            return Math.abs(S1 - S2);
        }
 
        // Case 1. include current item in the subset S1 and recur
        // for remaining items (n - 1)
        int inc = minPartition(S, n - 1, S1 + S[n], S2);
 
        // Case 2. exclude current item from subset S1 and recur for
        // remaining items (n - 1)
        int exc = minPartition(S, n - 1, S1, S2 + S[n]);
 
        return Integer.min(inc, exc);
    }
 
    public static void main(String[] args)
    {
        // Input: set of items
        int[] S = { 10, 20, 15, 5, 25 };
 
        System.out.println("The minimum difference is "
                + minPartition(S, S.length - 1, 0, 0));
    }
}



class MinimumSumPartitionProblemA1
{
    // Partition the set S into two subsets S1, S2 such that the
    // difference between the sum of elements in S1 and the sum
    // of elements in S2 is minimized
    public static int minPartition(int[] S, int n, int S1, int S2,
                                   Map<String, Integer> lookup)
    {
        // base case: if list becomes empty, return the absolute
        // difference between two sets
        if (n < 0) {
            return Math.abs(S1 - S2);
        }

        // construct an unique map key from dynamic elements of the input
        // Note that can uniquely identify the subproblem with n & S1 only,
        // as S2 is nothing but S - S1 where S is sum of all elements
        String key = n + "|" + S1;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // Case 1. include current item in the subset S1 and recur
            // for remaining items (n - 1)
            int inc = minPartition(S, n - 1, S1 + S[n], S2, lookup);

            // Case 2. exclude current item from subset S1 and recur for
            // remaining items (n - 1)
            int exc = minPartition(S, n - 1, S1, S2 + S[n], lookup);

            lookup.put(key, Integer.min(inc, exc));
        }

        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        // Input: set of items
        int[] S = { 10, 20, 15, 5, 25 };

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("The minimum difference is "
                + minPartition(S, S.length - 1, 0, 0, lookup));
    }
}




class MinimumSumPartitionProblemA2
{
    public static int minPartition(int[] S)
    {
        // Find sum of all elements
        int sum = Arrays.stream(S).sum();

        // create a boolean table to store solutions of sub-problems
        boolean T[][] = new boolean[S.length + 1][sum + 1];

        // fill the lookup table in bottom-up manner
        for (int i = 0; i <= S.length; i++)
        {
            // elements with sum 0 is always true
            T[i][0] = true;

            for (int j = 1; i > 0 && j <= sum; j++)
            {
                // exclude i'th element
                T[i][j] = T[i - 1][j];

                // include i'th element
                if (S[i - 1] <= j) {
                    T[i][j] |= T[i - 1][j - S[i - 1]];
                }
            }
        }

        // Find maximum value of j between 0 and sum/2 for which last row is true
        int j = sum / 2;
        while (j >= 0 && !T[S.length][j]) {
            j--;
        }
        return sum - 2 * j;
    }

    public static void main (String[] args)
    {
        // Input: set of items
        int[] S = { 10, 20, 15, 5, 25 };

        System.out.println("The minimum difference is " + minPartition(S));
    }
}