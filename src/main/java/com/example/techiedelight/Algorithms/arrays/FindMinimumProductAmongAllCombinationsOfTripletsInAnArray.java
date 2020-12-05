package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;

class FindMinimumProductAmongAllCombinationsOfTripletsInAnArray
{
    // Find the minimum product among all combinations of triplets in the array
    public static int minimumProductTriplet(int[] A)
    {
        int n = A.length;
        if (n <= 2) {
            return Integer.MAX_VALUE;
        }
 
        // Sort the given array in natural order
        Arrays.sort(A);
 
        // Consider minimum of first three elements or
        // first element and last two elements
        return Integer.min(A[n-1] * A[n-2] * A[0], A[0] * A[1] * A[2]);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 4, -1, 3, 5, 9 };
 
        int min = minimumProductTriplet(A);
 
        if (min == Integer.MAX_VALUE) {
            System.out.print("No triplet exists since the list has less than 3 elements");
        } else {
            System.out.print("The minimum product is " + min);
        }
    }
}



class FindMinimumProductAmongAllCombinationsOfTripletsInAnArrayA1
{
    public static int min(int a, int b, int c, int d) {
        return Integer.min(Integer.min(a, b), Integer.min(a, d));
    }

    // Find the minimum product among all combinations of triplets
    // in the array
    public static int minimumProductTriplet(int[] A)
    {
        // get size of the array
        int n = A.length;

        // Take four auxiliary arrays of size n
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        int[] left_min = new int[n];
        int[] right_min = new int[n];

        // left_min[i] contains minimum element to the left of A[i]
        // left_max[i] contains maximum element to the left of A[i]
        // right_min[i] contains minimum element to the right of A[i]
        // right_max[i] contains maximum element to the right of A[i]

        // fill left_min[] and left_max[]
        int min_so_far = Integer.MAX_VALUE, max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            left_min[i] = min_so_far;
            left_max[i] = max_so_far;

            min_so_far = Integer.min(min_so_far, A[i]);
            max_so_far = Integer.max(max_so_far, A[i]);
        }

        // fill left_min[] and left_max[]
        min_so_far = Integer.MAX_VALUE;
        max_so_far = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--)
        {
            right_min[i] = min_so_far;
            right_max[i] = max_so_far;

            min_so_far = Integer.min(min_so_far, A[i]);
            max_so_far = Integer.max(max_so_far, A[i]);
        }

        // Consider each array element (except first and last)
        // as middle element of the triplet and find the minimum
        // by considering all combinations
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n - 2; i++)
        {
            int _min = min(A[i] * left_min[i] * right_min[i],
                    A[i] * left_min[i] * right_max[i],
                    A[i] * left_max[i] * right_min[i],
                    A[i] * left_max[i] * right_max[i]);
            result = Integer.min(result, _min);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] A = { 4, -1, 3, 5, 9 };

        int min = minimumProductTriplet(A);

        if (min == Integer.MAX_VALUE) {
            System.out.print("No triplet exists since the array has less than 3 elements");
        } else {
            System.out.print("The minimum product is " + min);
        }
    }
}




class FindMinimumProductAmongAllCombinationsOfTripletsInAnArrayA2
{
    // Find the minimum product among all combinations of triplets in the array
    public static int minimumProductTriplet(int[] A)
    {
        // explicitly handle the wrong input
        if (A.length <= 2) {
            return Integer.MAX_VALUE;
        }

        // 1. Find the smallest, second smallest and third smallest element
        // in the array
        int min1 = A[0], min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
        for (int value : A)
        {
            // if current element is less than the smallest element found so far
            if (value < min1) {
                min3 = min2;
                min2 = min1;
                min1 = value;
            }
            // if current element is less than the second smallest element
            else if (value < min2) {
                min3 = min2;
                min2 = value;
            }
            // if current element is less than the third smallest element
            else if (value < min3) {
                min3 = value;
            }
        }

        // 2. Find the largest and second largest element in the array
        int max1 = A[0], max2 = Integer.MIN_VALUE;
        for (int value : A) {
            // if current element is more than the largest element found so far
            if (value > max1) {
                max2 = max1;
                max1 = value;
            }
            // if current element is more than the second largest element
            else if (value > max2) {
                max2 = value;
            }
        }

        return Integer.min(min1 * min2 * min3, max1 * max2 * min1);
    }

    public static void main(String[] args)
    {
        int[] A = { 4, -1, 3, 5, 9 };

        int min = minimumProductTriplet(A);

        if (min == Integer.MAX_VALUE) {
            System.out.print("No triplet exists since the array has less than 3 elements");
        } else {
            System.out.print("The minimum product is " + min);
        }
    }
}