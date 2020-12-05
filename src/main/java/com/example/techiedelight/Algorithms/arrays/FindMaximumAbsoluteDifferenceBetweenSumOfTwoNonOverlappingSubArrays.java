package com.example.techiedelight.Algorithms.arrays;

class FindMaximumAbsoluteDifferenceBetweenSumOfTwoNonOverlappingSubArrays
{
    // Fill aux[k] with maximum sum of sub-array A(0, k) if diff is 1 or
    // maximum sum of sub-array A(k, n-1) if diff is -1, using Kadane's algo
 
    // diff --> counter for loop from i to j in A[] (diff can be +1 or -1)
    public static void maxSumSubarray(int[] A, int[] aux, int i, int j,
                                                            int diff)
    {
        int max_so_far = A[i];
        int max_ending_here = A[i];
        aux[i] = A[i];
 
        for (int k = i + diff; k != j; k += diff)
        {
            // update max sum of sub-array "ending" or "starting" at index k
            max_ending_here = Integer.max(A[k], max_ending_here + A[k]);
 
            // update result if current sub-array sum is found to be greater
            max_so_far = Integer.max(max_so_far, max_ending_here);
            aux[k] = max_so_far;
        }
    }
 
    public static void fillArrays(int[] A, int[] left_max, int[] right_max,
                    int[] left_min, int[] right_min, int n) {
 
        maxSumSubarray(A, left_max, 0, n - 1, 1);
        maxSumSubarray(A, right_max, n - 1, 0, -1);
 
        // negate A[] for finding the minimum sum of sub-arrays using
        // the same logic for finding maximum sum of sub-arrays
        for (int i = 0; i < n; i++) {
            A[i] = -A[i];
        }
 
        maxSumSubarray(A, left_min, 0, n - 1, 1);
        maxSumSubarray(A, right_min, n - 1, 0, -1);
 
        // negate left_min[] and right_min[] to get min sum of sub-arrays
        for (int i = 0; i < n; i++) {
            left_min[i] = -left_min[i];
        }
 
        for (int i = 0; i < n; i++) {
            right_min[i] = -right_min[i];
        }
 
        // restore the sign of A[]
        for (int i = 0; i < n; i++) {
            A[i] = -A[i];
        }
    }
 
    // Find maximum absolute difference between the sum of elements of
    // two non-overlapping sub-arrays in given array
    public static int maxAbsDiff(int[] A, int n)
    {
        // left_max[i] stores maximum sum of sub-array in A(0, i)
        // right_max[i] stores maximum sum of sub-array in A(i, n-1)
        // left_min[i] stores minimum sum of sub-array in A(0, i)
        // right_min[i] stores minimum sum of sub-array in A(i, n-1)
 
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        int[] left_min = new int[n];
        int[] right_min = new int[n];
 
        fillArrays(A, left_max, right_max, left_min, right_min, n);
 
        // stores maximum absolute difference
        int max_abs_diff = Integer.MIN_VALUE;
 
        // do for each index i of the array
        for (int i = 0; i < n - 1; i++) {
            int abs_diff = Integer.max(Math.abs(left_max[i] - right_min[i+1]),
                                    Math.abs(left_min[i] - right_max[i+1]));
            max_abs_diff = Integer.max(max_abs_diff, abs_diff);
        }
 
        return max_abs_diff;
    }
 
    public static void main(String[] args)
    {
        int[] A = { -3, -2, 6, -3, 5, -9, 3, 4, -1, -8, 2 };
 
        System.out.print("The maximum absolute difference is "
                        + maxAbsDiff(A, A.length));
    }
}