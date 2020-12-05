package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class FindATripletHavingMaximumProductInAnArray
{
    // Find a triplet having maximum product in a given array
    public static void findTriplet(int[] A)
    {
        // Sort the given array in natural order
        Arrays.sort(A);
        int n = A.length;
 
        // wrong input
        if (n <= 2) {
            System.out.print("No triplet exists since the list has less than 3 elements");
        }
 
        // Consider maximum of last three elements or
        // first two element and last element
        if (A[n-1] * A[n-2] * A[n-3] > A[0] * A[1] * A[n-1]) {
            System.out.print("Triplet is (" + A[n-1] + ", " + A[n-2] + ", " + A[n-3] + ")");
        }
        else {
            System.out.print("Triplet is (" + A[0] + ", " + A[1] + ", " + A[n-1] + ")");
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { -4, 1, -8, 9, 6 };
        findTriplet(A);
    }
}



class FindATripletHavingMaximumProductInAnArrayOpti
{
    // Find a triplet having maximum product in an array
    public static void printTriplet(int[] A)
    {
        int n = A.length;

        // wrong input
        if (n <= 2) {
            System.out.print("No triplet exists since the array has less than 3 elements");
        }

        // 1. Find index of the largest, second largest and third largest
        // element in the array
        int max_index1 = 0, max_index2 = -1, max_index3 = -1;
        for (int i = 1; i < n; i++)
        {
            // if current element is less than the largest element found so far
            if (A[i] > A[max_index1]) {
                max_index3 = max_index2;
                max_index2 = max_index1;
                max_index1 = i;
            }

            // if current element is less than the second largest element
            // found so far
            else if (max_index2 == -1 || A[i] > A[max_index2]) {
                max_index3 = max_index2;
                max_index2 = i;
            }

            // if current element is less than the third largest element
            // found so far
            else if (max_index3 == -1 || A[i] > A[max_index3]) {
                max_index3 = i;
            }
        }

        // 2. Find index of the smallest and second smallest element in the array
        int min_index1 = 0, min_index2 = -1;
        for (int i = 1; i < n; i++)
        {
            // if current element is more than the smallest element found so far
            if (A[i] < A[min_index1]) {
                min_index2 = min_index1;
                min_index1 = i;
            }
            // if current element is more than the second smallest element
            // found so far
            else if (min_index2 == -1 || A[i] < A[min_index2]) {
                min_index2 = i;
            }
        }

        if (A[max_index1] * A[max_index2] * A[max_index3] >
                A[min_index1] * A[min_index2] * A[max_index1]) {
            System.out.print("Triplet is (" + A[max_index1] + ", " + A[max_index2]
                    + ", " + A[max_index3] + ")");
        }
        else {
            System.out.print("Triplet is (" + A[min_index1] + ", " + A[min_index2]
                    + ", " + A[max_index1] + ")");
        }
    }

    public static void main(String[] args)
    {
        int[] A = { -4, 1, -8, 9, 6 };
        printTriplet(A);
    }
}