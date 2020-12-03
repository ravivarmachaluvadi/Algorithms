package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;

class MaximumProductOfTwoIntegers
{
    // Naive solution to find maximum product of two integers
    // in an array
    public static void findMaximumProduct(int[] A)
    {
        int max_product = Integer.MIN_VALUE;
        int max_i = -1, max_j = -1;
 
        // consider every pair of elements
        for (int i = 0; i < A.length - 1; i++)
        {
            for (int j = i + 1; j < A.length; j++)
            {
                // update maximum product if required
                if (max_product < A[i] * A[j])
                {
                    max_product = A[i] * A[j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
 
        System.out.print("Pair is (" + A[max_i] + ", " + A[max_j] + ")");
    }
 
        public static void main (String[] args)
    {
        int[] A = { -10, -3, 5, 6, -2 };
 
        findMaximumProduct(A);
    }
}



class MaximumProductOfTwoIntegersSort
{
    // Naive solution to find maximum product of two integers
    // in an array
    public static void findMaximumProduct(int[] A)
    {
        // n is length of the array
        int n = A.length;

        // sort array in ascending order
        Arrays.sort(A);

        // maximum product is formed by maximum of
        // 1. product of first two elements or
        // 2. product of last two elements

        if ((A[0] * A[1]) > (A[n - 1] * A[n - 2])) {
            System.out.print("Pair is (" + A[0] + ',' + A[1] + ')');
        } else {
            System.out.print("Pair is (" + A[n - 1] + ',' + A[n - 2] + ')');
        }
    }

    public static void main (String[] args)
    {
        int[] A = { -10, -3, 5, 6, -20 };

        findMaximumProduct(A);
    }
}

//The time complexity of above solution is O(nlog(n)) and auxiliary space used by the program is O(1).



//O(N)
class MaximumProductOfTwoIntegersAlgo
{
    // Function to find maximum product of two integers in an array
    public static void findMaximumProduct(int[] A)
    {
        // to store maximum and second maximum element in an array
        int max1 = A[0], max2 = Integer.MIN_VALUE;

        // to store minimum and second minimum element in an array
        int min1 = A[0], min2 = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++)
        {
            // if current element is more than the maximum element,
            // update maximum and second maximum element
            if (A[i] > max1) {
                max2 = max1;
                max1 = A[i];
            }

            // if current element is less than maximum but greater than
            // second maximum element, update second maximum element
            else if (A[i] > max2) {
                max2 = A[i];
            }

            // if current element is more than the minimum element,
            // update minimum and second minimum element
            if (A[i] < min1) {
                min2 = min1;
                min1 = A[i];
            }

            // if current element is less than minimum but greater than
            // second minimum element, update second minimum element
            else if (A[i] < min2) {
                min2 = A[i];
            }

            // else ignore the element
        }

        // Maximum product is formed by maximum of
        // 1. product of maximum and second maximum element or
        // 2. product of minimum and second minimum element
        if (max1 * max2 > min1 * min2) {
            System.out.print("Pair is (" + max1 + ", " + max2 + ")");
        }
        else {
            System.out.print("Pair is (" + min1 + ", " + min2 + ")");
        }
    }

    public static void main (String[] args)
    {
        int[] arr = { -10, -3, 5, 6, -2 };

        findMaximumProduct(arr);
    }
}