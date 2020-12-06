package com.example.techiedelight.Algorithms.arraysGA;

import java.util.HashMap;
import java.util.Map;

class SubsetSumProblem
{
    // Return true if there exists a subsequence of A[0..n] with given sum
    public static boolean subsetSum(int[] A, int n, int sum)
    {
        // return true if sum becomes 0 (subset found)
        if (sum == 0) {
            return true;
        }
 
        // base case: no items left or sum becomes negative
        if (n < 0 || sum < 0) {
            return false;
        }
 
        // Case 1. include current item in the subset (A[n]) and recur
        // for remaining items (n - 1) with remaining sum (sum - A[n])
        boolean include = subsetSum(A, n - 1, sum - A[n]);
 
        // Case 2. exclude current item n from subset and recur for
        // remaining items (n - 1)
        boolean exclude = subsetSum(A, n - 1, sum);
 
        // return true if we can get subset by including or excluding the
        // current item
        return include || exclude;
    }
 
    // Subset Sum Problem
    public static void main(String[] args)
    {
        // Input: set of items and a sum
        int[] A = { 7, 3, 2, 5, 8 };
        int sum = 14;
 
        if (subsetSum(A, A.length - 1, sum)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }
}



class SubsetSumProblemA1
{
    // Return true if there exists a subsequence of A[0..n] with given sum
    public static boolean subsetSum(int[] A, int n, int sum,
                                    Map<String, Boolean> lookup)
    {
        // return true if sum becomes 0 (subset found)
        if (sum == 0) {
            return true;
        }

        // base case: no items left or sum becomes negative
        if (n < 0 || sum < 0) {
            return false;
        }

        // construct an unique map key from dynamic elements of the input
        String key = n + "|" + sum;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // Case 1. include current item in the subset (A[n]) & recur
            // for remaining items (n - 1) with decreased sum (sum - A[n])
            boolean include = subsetSum(A, n - 1, sum - A[n], lookup);

            // Case 2. exclude current item n from subset and recur for
            // remaining items (n - 1)
            boolean exclude = subsetSum(A, n - 1, sum, lookup);

            // assign true if we get subset by including or excluding
            // current item
            lookup.put(key, include || exclude);
        }

        // return solution to current sub-problem
        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        // Input: set of items and a sum
        int[] A = { 7, 3, 2, 5, 8 };
        int sum = 14;

        // create a map to store solutions of subproblems
        Map<String, Boolean> lookup = new HashMap<>();

        if (subsetSum(A, A.length - 1, sum, lookup)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}



class SubsetSumProblemA2
{
    // Return true if there exists a subsequence of array A with given sum
    public static boolean subsetSum(int[] A, int sum)
    {
        int n = A.length;

        // T[i][j] stores true if subset with sum j can be attained
        // with using items up to first i items
        boolean[][] T = new boolean[n + 1][sum + 1];

        // if sum is zero
        for (int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        // do for ith item
        for (int i = 1; i <= n; i++)
        {
            // consider all sum from 1 to sum
            for (int j = 1; j <= sum; j++)
            {
                // don't include ith element if j-A[i-1] is negative
                if (A[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                }
                else {
                    // find subset with sum j by excluding or including
                    // the ith item
                    T[i][j] = T[i - 1][j] || T[i - 1][j - A[i - 1]];
                }
            }
        }

        // return maximum value
        return T[n][sum];
    }

    public static void main(String[] args)
    {
        // Input: set of items and a sum
        int[] A = { 7, 3, 2, 5, 8 };
        int sum = 18;

        if (subsetSum(A, sum))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}