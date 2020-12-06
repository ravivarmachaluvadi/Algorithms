package com.example.techiedelight.Algorithms.arrays;

class FindMaximumSumOfSubsequenceWithNoAdjacentElements
{
    // Function to calculate maximum sum in the given array
    // with no adjacent elements considered
    // i --> index of current element
    // prev --> index of previous element included in sum
    public static int maxSumSubseq(int[] arr, int i, int n, int prev)
    {
        // base case: all elements are processed
        if (i == n) {
            return 0;
        }
 
        // recur by excluding current element
        int excl = maxSumSubseq(arr, i + 1, n, prev);
 
        int incl = 0;
 
        // include current element only if it is not adjacent
        // to previous element considered
        if (prev + 1 != i) {
            incl = maxSumSubseq(arr, i + 1, n, i) + arr[i];
        }
 
        // return maximum sum we get by including or excluding
        // current item
        return Integer.max(incl, excl);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        System.out.print("Maximum sum is "
                + maxSumSubseq(A, 0, A.length, Integer.MIN_VALUE));
    }
}



class FindMaximumSumOfSubsequenceWithNoAdjacentElementsA1
{
    // DP solution to calculate maximum sum in the given array with
    // no adjacent elements considered (Function uses extra space)
    public static int maxSumSubseq(int[] A)
    {
        int n = A.length;

        // base case
        if (n == 1) {
            return A[0];
        }

        // create an auxiliary array to store solution of sub-problems
        int[] lookup = new int[n];

        // lookup[i] stores the maximum sum possible till index i

        // trivial case
        lookup[0] = A[0];
        lookup[1] = Integer.max(A[0], A[1]);

        // traverse array from index 2
        for (int i = 2; i < n; i++)
        {
            // lookup[i] stores the maximum sum we get by

            // 1. excluding current element & take maximum sum till index i-1
            // 2. including current element A[i] and take maximum sum
            //    till index i-2
            lookup[i] = Integer.max(lookup[i - 1], lookup[i - 2] + A[i]);

            // if current element is more than max sum till current element
            lookup[i] = Integer.max(lookup[i], A[i]);
        }

        // return maximum sum
        return lookup[n - 1];
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        System.out.print("Maximum sum is " + maxSumSubseq(A));
    }
}



class FindMaximumSumOfSubsequenceWithNoAdjacentElementsA2
{
    // Constant space DP-solution to calculate maximum sum in the given
    // array with no adjacent elements considered
    public static int maxSumSubseq(int[] A)
    {
        // base case
        if (A.length == 1) {
            return A[0];
        }

        // store maximum sum till index i-2
        int prev_prev = A[0];

        // stores maximum sum till index i-1
        int prev = Integer.max(A[0], A[1]);

        // start from index 2
        for (int i = 2; i < A.length; i++)
        {
            // curr stores the maximum sum till index i
            int curr = Integer.max(A[i], Integer.max(prev, prev_prev + A[i]));
            prev_prev = prev;
            prev = curr;
        }

        // return maximum sum
        return prev;
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };

        System.out.println("Maximum sum is " + maxSumSubseq(A));
    }
}