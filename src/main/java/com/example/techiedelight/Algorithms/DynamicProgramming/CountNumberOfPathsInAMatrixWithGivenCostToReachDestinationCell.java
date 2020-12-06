package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class CountNumberOfPathsInAMatrixWithGivenCostToReachDestinationCell
{
    // Naive recursive top-down function to count total number of paths
    // to reach cell (m, n) from cell (0, 0) and having given cost
    public static int countPaths(int mat[][], int m, int n, int cost)
    {
        // base case
        if (cost < 0) {
            return 0;
        }
 
        // if we're at first cell (0, 0)
        if (m == 0 && n == 0) {
            return (mat[0][0] - cost == 0) ? 1: 0;
        }
 
        // if we're at first row, we can only go left
        if (m == 0) {
            return countPaths(mat, 0, n - 1, cost - mat[m][n]);
        }
 
        // if we're at first column, we can only go up
        if (n == 0) {
            return countPaths(mat, m - 1, 0, cost - mat[m][n]);
        }
 
        // recur to count total paths by going both left and top
        return countPaths(mat, m - 1, n, cost - mat[m][n]) +
                countPaths(mat, m, n - 1, cost - mat[m][n]);
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 4, 7, 1, 6 },
            { 5, 7, 3, 9 },
            { 3, 2, 1, 2 },
            { 7, 1, 6, 3 }
        };
 
        int cost = 25;
 
        System.out.println("Total paths with cost " + cost + " are " +
                countPaths(mat, mat.length-1, mat[0].length-1, cost));
    }
}




class CountNumberOfPathsInAMatrixWithGivenCostToReachDestinationCellA2
{
    // Recursive top-down function to count total number of paths
    // to reach cell (m, n) from cell (0, 0) and having given cost
    public static int countPaths(int[][] mat, int m, int n, int cost,
                                 Map<String, Integer> lookup)
    {
        // base case
        if (cost < 0) {
            return 0;
        }

        // if we're at first cell (0, 0)
        if (m == 0 && n == 0)
        {
            if (mat[0][0] - cost == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        // construct an unique map key from dynamic elements of the input
        String key = m + "|" + n + "|" + cost;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if we're at first row, we can only go left
            if (m == 0) {
                lookup.put(key, countPaths(mat, 0, n - 1,
                        cost - mat[m][n], lookup));
            }
            // if we're at first column, we can only go up
            else if (n == 0) {
                lookup.put(key, countPaths(mat, m - 1, 0,
                        cost - mat[m][n], lookup));
            }
            // recur to count total paths by going both left and top
            else {
                lookup.put(key, countPaths(mat, m - 1, n,
                        cost - mat[m][n], lookup) +
                        countPaths(mat, m, n - 1, cost - mat[m][n], lookup));
            }
        }

        // return total number of paths to reach cell (m, n)
        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        { 4, 7, 1, 6 },
                        { 5, 7, 3, 9 },
                        { 3, 2, 1, 2 },
                        { 7, 1, 6, 3 }
                };

        int cost = 25;
        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("Total paths with cost " + cost + " are " +
                countPaths(mat, mat.length-1, mat[0].length-1, cost, lookup));
    }
}