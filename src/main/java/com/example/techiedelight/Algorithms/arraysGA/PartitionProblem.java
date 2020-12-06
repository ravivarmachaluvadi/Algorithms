package com.example.techiedelight.Algorithms.arraysGA;

import java.util.Arrays;

class PartitionProblem
{
    // Return true if there exists a subarray of array[0..n]
    // with given sum
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
 
        // return true if we get subset by including the current item
        if (include)
            return true;
 
        // Case 2. exclude current item n from subset and recur for
        // remaining items (n - 1)
        boolean exclude = subsetSum(A, n - 1, sum);
 
        // return true if we get subset by excluding the current item
        return exclude;
    }
 
    // Return true if given array A[0..n-1] can be divided into two
    // subarrays with equal sum
    public static boolean partition(int[] A)
    {
        int sum = Arrays.stream(A).sum();
 
        // return true if sum is even and array can can be divided into
        // two subarrays with equal sum
        return (sum & 1) == 0 && subsetSum(A, A.length - 1, sum/2);
    }
 
    public static void main(String[] args)
    {
        // Input: set of items
        int[] A = { 7, 3, 1, 5, 4, 8 };
 
        System.out.println(partition(A));
    }
}



class PartitionProblemA1
{
    // Return true if there exists a subarray of array A[0..n)
    // with given sum
    public static boolean subsetSum(int[] A, int n, int sum)
    {
        // T[i][j] stores true if subset with sum j can be attained with
        // using items up to first i items
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

    // Return true if given array A[0..n-1] can be divided into two
    // subarrays with equal sum
    public static boolean partition(int[] A)
    {
        int sum = Arrays.stream(A).sum();

        // return true if sum is even and array can can be divided into
        // two sub-arrays with equal sum
        return (sum & 1) == 0 && subsetSum(A, A.length, sum/2);
    }

    public static void main(String[] args)
    {
        // Input: set of items
        int[] A = { 7, 3, 1, 5, 4, 8 };

        if (partition(A)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}