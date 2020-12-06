package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class FindOptimalCostToConstructBinarySearchTree
{
    // Find optimal cost to construct binary search tree from keys
    // i to j where each key k occurs freq[k] number of times
    public static int findOptimalCost(int[] freq, int i, int j, int level)
    {
        // base case
        if (j < i) {
            return 0;
        }
 
        int optimalCost = Integer.MAX_VALUE;
 
        // consider each key as a root and recursively find optimal solution
        for (int k = i; k <= j; k++)
        {
            // recursively find the optimal cost of left subtree
            int leftOptimalCost = findOptimalCost(freq, i, k - 1, level + 1);
 
            // recursively find the optimal cost of right subtree
            int rightOptimalCost = findOptimalCost(freq, k + 1, j, level + 1);
 
            // current node's cost is freq[k]*level
            int cost = freq[k]*level + leftOptimalCost + rightOptimalCost;
 
            // update optimal cost
            optimalCost = Integer.min(optimalCost, cost);
        }
 
        // Return minimum value
        return optimalCost;
    }
 
    public static void main(String[] args)
    {
        int[] freq = { 25, 10, 20 };
 
        System.out.println("The optimal cost of constructing BST is "
                        + findOptimalCost(freq, 0, freq.length - 1, 1));
    }
}



class FindOptimalCostToConstructBinarySearchTreeA2
{
    // Find optimal cost to construct binary search tree from keys i to j
    // where each key k occurs freq[k] number of times
    public static int findOptimalCost(int[] freq, int i, int j, int level,
                                      Map<String, Integer> lookup)
    {
        // base case
        if (j < i) {
            return 0;
        }

        // construct an unique map key from dynamic elements of the input
        String key = i + "|" + j + "|" + level;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            lookup.put(key, Integer.MAX_VALUE);

            int leftOptimalCost, rightOptimalCost;

            // consider each key as root and recursively find optimal solution
            for (int k = i; k <= j; k++)
            {
                // recursively find the optimal cost of left subtree
                leftOptimalCost = findOptimalCost(freq, i, k - 1, level + 1,
                        lookup);

                // recursively find the optimal cost of right subtree
                rightOptimalCost = findOptimalCost(freq, k + 1, j, level + 1,
                        lookup);

                // current node's cost is freq[k]*level
                int cost = freq[k]*level + leftOptimalCost + rightOptimalCost;

                // update optimal cost
                lookup.put(key, Integer.min (lookup.get(key), cost));
            }
        }

        // return the sub-problem solution from the map
        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        int[] freq = { 25, 10, 20 };

        // create a map to store solutions of sub-problems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("The optimal cost of constructing BST is "
                + findOptimalCost(freq, 0, freq.length - 1, 1, lookup));
    }
}





class FindOptimalCostToConstructBinarySearchTreeA3
{
    // Function to find optimal cost to construct binary search tree
    public static int findOptimalCost(int[] freq)
    {
        int n = freq.length;

        // cost[i][j] stores the optimal cost to construct BST from keys i to j
        int cost[][] = new int[n + 1][n + 1];

        // Base case: cost is equal to frequency for i = j (single key)
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        // All sizes of sequences
        for (int size = 1; size <= n; size++)
        {
            // All starting points of sequences
            for (int i = 0; i <= n - size + 1; i++)
            {
                int j = Math.min(i + size - 1, n - 1);
                cost[i][j] = Integer.MAX_VALUE;

                //  consider each key as root and calculate optimal cost
                for (int r = i; r <= j; r++)
                {
                    // get current node's cost
                    int total = IntStream.rangeClosed(i, j).map(k -> freq[k]).sum();

                    // add the optimal cost of left subtree
                    if (r != i) {
                        total += cost[i][r - 1];
                    }

                    // add the optimal cost of right subtree
                    if (r != j) {
                        total += cost[r + 1][j];
                    }

                    // update the cost matrix if needed
                    cost[i][j] = Math.min(total, cost[i][j]);
                }
            }
        }

        // return the resultant cost
        return cost[0][n - 1];
    }

    public static void main(String[] args)
    {
        int[] freq = { 25, 10, 20 };

        System.out.println("The optimal cost of constructing BST is "
                + findOptimalCost(freq));
    }
}