package com.example.techiedelight.Algorithms.arrays;

class FindMaximumProductSubarrayInAGivenArray
{
    // Function to return maximum product of a sub-array of given array
    public static int maxProduct(int[] A)
    {
        // maintain two variables to store maximum and minimum product
        // ending at current index
        int max_ending = 0, min_ending = 0;
 
        // to store maximum product sub-array found so far
        int max_so_far = 0;
 
        // traverse the given array
        for (int i: A)
        {
            int temp = max_ending;
 
            // update maximum product ending at current index
            max_ending = Integer.max(i, Integer.max(i * max_ending,
                                                    i * min_ending)
                                    );
 
            // update minimum product ending at current index
            min_ending = Integer.min(i, Integer.min(i * temp, i * min_ending));
 
            max_so_far = Integer.max(max_so_far, max_ending);
        }
 
        // return maximum product
        return max_so_far;
    }
 
    public static void main(String[] args)
    {
        int[] A = { -6, 4, -5, 8, -10, 0, 8 };
 
        System.out.print("The maximum product of a sub-array is " +
                                 maxProduct(A));
    }
}