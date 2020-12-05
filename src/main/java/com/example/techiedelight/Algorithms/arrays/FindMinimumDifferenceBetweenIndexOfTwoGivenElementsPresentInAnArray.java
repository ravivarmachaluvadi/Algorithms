package com.example.techiedelight.Algorithms.arrays;

class FindMinimumDifferenceBetweenIndexOfTwoGivenElementsPresentInAnArray
{
    // Function to find minimum difference between index of two
    // elements x and y present in the array
    public static int findMinDifference(int[] A, int x, int y)
    {
        int n = A.length;
        int x_index = n, y_index = n;
        int min_diff = Integer.MAX_VALUE;
 
        // traverse the given array
        for (int i = 0; i < n; i++)
        {
            // if current element is x
            if (A[i] == x)
            {
                // set x_index to current index
                x_index = i;
 
                // if y is seen before, update the result if required
                if (y_index != n) {
                    min_diff = Integer.min(min_diff,
                                           Math.abs(x_index - y_index));
                }
            }
 
            // if current element is y
            if (A[i] == y)
            {
                // set y_index to current index
                y_index = i;
 
                // if x is seen before, update the result if required
                if (x_index != n) {
                    min_diff = Integer.min(min_diff,
                                           Math.abs(x_index - y_index));
                }
            }
        }
 
        return min_diff;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 3, 5, 4, 8, 2, 4, 3, 6, 5 };
        int x = 2, y = 5;
 
        int diff = findMinDifference(A, x, y);
 
        if (diff != Integer.MAX_VALUE) {
            System.out.print("Minimum difference is " + diff);
        }
        else {
            System.out.print("Invalid input");
        }
    }
}