package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class FindPairsWithDifferenceKInAnArrayConstantSpaceSolution
{
    // Function to find pair with given difference in the array
    // This method handles duplicates in the array
    public static void findPair(int[] A, int diff)
    {
        // sort array in ascending order
        Arrays.sort(A);
 
        // do for each element in the array
        for (int i = 0; i < A.length; i++)
        {
            // to avoid printing duplicates (skip adjacent duplicates)
            while (i < A.length - 1 && A[i] == A[i+1]) {
                i++;
            }
 
            // perform binary search for element (A[i] - diff)
            if (Arrays.binarySearch(A, A[i] - diff) >= 0) {
                System.out.println("(" + A[i] + ", " + (A[i] - diff) + ")");
            }
        }
    }
 
    // Find pairs with given difference k in the array
    public static void main(String[] args)
    {
        int[] A = { 1, 5, 2, 2, 2, 5, 5, 4};
        int diff = 3;
 
        findPair(A, diff);
    }
}



class FindPairsWithDifferenceKInAnArrayConstantSpaceSolutionOpti
{
    // Function to find pair with given difference in the array
    // This method handles duplicates in the array
    public static void findPair(int[] A, int diff)
    {
        // sort array in ascending order
        Arrays.sort(A);

        // maintain two indices in the array
        int i = 0, j = 0;
        int n = A.length;

        // run till end of array is reached
        while (i < n && j < n)
        {
            // to avoid printing duplicates
            while (i < n - 1 && A[i] == A[i+1]) {
                i++;
            }

            while (j < n - 1 && A[j] == A[j+1]) {
                j++;
            }

            // increment i if current difference is more than
            // the desired difference
            if (A[j] - A[i] > diff) {
                i++;
            }

            // increment j if current difference is less than
            // the desired difference
            else if (A[j] - A[i] < diff) {
                j++;
            }

            // print the pair and increment both i, j if current
            // difference is same as the desired difference
            else
            {
                System.out.println("(" + A[j] + ", " + A[i] + ")");
                i++;
                j++;
            }
        }
    }

    // Find pairs with given difference k in the array
    public static void main(String[] args)
    {
        int[] A = { 1, 5, 2, 2, 2, 5, 5, 4 };
        int diff = 3;

        findPair(A, diff);
    }
}