package com.example.techiedelight.Algorithms.arraysGA;

import java.util.HashMap;
import java.util.Map;

class Knapsack01Problem
{
    // Values (stored in array v)
    // Weights (stored in array w)
    // Number of distinct items (n)
    // Knapsack capacity W
    public static int knapSack(int[] v, int[] w, int n, int W)
    {
        // base case: Negative capacity
        if (W < 0) {
            return Integer.MIN_VALUE;
        }
 
        // base case: no items left or capacity becomes 0
        if (n < 0 || W == 0) {
            return 0;
        }
 
        // Case 1. include current item n in knapSack (v[n]) and recur for
        // remaining items (n - 1) with decreased capacity (W - w[n])
 
        int include = v[n] + knapSack(v, w, n - 1, W - w[n]);
 
        // Case 2. exclude current item n from knapSack and recur for
        // remaining items (n - 1)
 
        int exclude = knapSack(v, w, n - 1, W);
 
        // return maximum value we get by including or excluding current item
        return Integer.max(include, exclude);
    }
 
    // 0-1 Knapsack problem
    public static void main(String[] args)
    {
        // Input: set of items each with a weight and a value
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = {  1, 2,  3,  8,  7, 4 };
 
        // Knapsack capacity
        int W = 10;
 
        System.out.println("Knapsack value is " +
                knapSack(v, w, v.length - 1, W));
    }
}


//DP
class Knapsack01ProblemA1
{
    // Values (stored in array v)
    // Weights (stored in array w)
    // Number of distinct items (n)
    // Knapsack capacity W
    public static int knapSack(int[] v, int[] w, int n, int W,
                               Map<String, Integer> lookup)
    {
        // base case: Negative capacity
        if (W < 0) {
            return Integer.MIN_VALUE;
        }

        // base case: no items left or capacity becomes 0
        if (n < 0 || W == 0) {
            return 0;
        }

        // construct an unique map key from dynamic elements of the input
        String key = n + "|" + W;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // Case 1. include current item n in knapSack (v[n]) & recur
            // for remaining items (n-1) with decreased capacity (W - w[n])
            int include = v[n] + knapSack(v, w, n - 1, W - w[n], lookup);

            // Case 2. exclude current item n from knapSack and recur for
            // remaining items (n-1)
            int exclude = knapSack(v, w, n - 1, W, lookup);

            // assign max value we get by including or excluding current item
            lookup.put(key, Integer.max(include, exclude));
        }

        // return solution to current sub-problem
        return lookup.get(key);
    }

    // 0-1 Knapsack problem
    public static void main(String[] args)
    {
        // Input: set of items each with a weight and a value
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = {  1, 2,  3,  8,  7, 4 };

        // Knapsack capacity
        int W = 10;

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("Knapsack value is " +
                knapSack(v, w, v.length - 1, W, lookup));
    }
}



class Knapsack01ProblemA2
{
    // Input:
    // Values (stored in array v)
    // Weights (stored in array w)
    // Number of distinct items (n)
    // Knapsack capacity (W)
    public static int knapSack(int[] v, int[] w, int W)
    {
        // T[i][j] stores the maximum value of knapsack having weight
        // less than equal to j with only first i items considered.
        int[][] T = new int[v.length + 1][W + 1];

        // do for ith item
        for (int i = 1; i <= v.length; i++)
        {
            // consider all weights from 0 to maximum capacity W
            for (int j = 0; j <= W; j++)
            {
                // don't include ith element if j-w[i-1] is negative
                if (w[i-1] > j) {
                    T[i][j] = T[i-1][j];
                }
                else {
                    // find maximum value we get by excluding or including
                    // the i'th item
                    T[i][j] = Integer.max(T[i-1][j],
                            T[i-1][j-w[i-1]] + v[i-1]);
                }
            }
        }

        // return maximum value
        return T[v.length][W];
    }

    public static void main(String[] args)
    {
        // Input: set of items each with a weight and a value
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = {  1, 2,  3,  8,  7, 4 };

        // Knapsack capacity
        int W = 10;

        System.out.println("Knapsack value is "
                + knapSack(v, w, W));
    }
}