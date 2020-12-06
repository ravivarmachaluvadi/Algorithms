package com.example.techiedelight.Algorithms.DivideAndConquer;

class MaximumSumSubarrayUsingDivideConquer
{
    // Naive solution to find Maximum sum subarray using
    // divide and conquer
    public static int MaximumSum(int[] A)
    {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
 
        // do for each subarray starting with i
        for (int i = 0; i < A.length - 1; i++)
        {
            // calculate sum of subarray A[i..j]
 
            sum = 0;    // reset sum
 
            // do for each subarray ending with j
            for (int j = i; j < A.length; j++)
            {
                sum += A[j];
 
                // if current subarray sum is greater than the maximum
                // sum calculated so far, update the maximum sum
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
 
        return maxSum;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 2, -4, 1, 9, -6, 7, -3 };
        System.out.println("The Maximum sum of the subarray is "
                            + MaximumSum(A));
    }
}





class MaximumSumSubarrayUsingDivideConquerA2
{
    // Function to find Maximum subarray sum using
    // divide and conquer
    public static int MaximumSum(int[] A, int left, int right)
    {
        // If array contains only one element
        if (right == left) {
            return A[left];
        }

        // Find middle element of the array
        int mid = (left + right) / 2;

        // Find maximum subarray sum for the left subarray
        // including the middle element
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--)
        {
            sum += A[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        // Find maximum subarray sum for the right subarray
        // excluding the middle element
        int rightMax = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int i = mid + 1; i <= right; i++)
        {
            sum += A[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }

        // Recursively find the maximum subarray sum for left
        // subarray and right subarray and tale maximum
        int maxLeftRight = Integer.max(MaximumSum(A, left, mid),
                MaximumSum(A, mid + 1, right));

        // return maximum of the three
        return Integer.max(maxLeftRight, leftMax + rightMax);
    }

    public static void main(String[] args)
    {
        int[] A = { 2, -4, 1, 9, -6, 7, -3 };

        System.out.println("The Maximum sum of the subarray is " +
                MaximumSum(A, 0, A.length - 1));

    }
}