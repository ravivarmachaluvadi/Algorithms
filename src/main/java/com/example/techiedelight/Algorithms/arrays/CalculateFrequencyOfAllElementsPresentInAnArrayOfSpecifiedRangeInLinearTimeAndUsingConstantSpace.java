package com.example.techiedelight.Algorithms.arrays;

class CalculateFrequencyOfAllElementsPresentInAnArrayOfSpecifiedRangeInLinearTimeAndUsingConstantSpace
{
    // Function to calculate the frequency of all elements in the array
    public static void findFrequency(int[] A)
    {
        // create a count array of size n to store count of all array elements
        int[] freq = new int[A.length];
 
        // update frequency of each element
        for (int e: A) {
            freq[e]++;
        }
 
        // iterate through the array to print frequencies
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.printf("%d appears %d times\n", i, freq[i]);
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 2, 3, 3, 2, 1 };
        findFrequency(A);
    }
}


class CalculateFrequencyOfAllElementsPresentInAnArrayOfSpecifiedRangeInLinearTimeAndUsingConstantSpaceOpti
{
    // Function to calculate the frequency of all elements in the array
    // in linear time and without using any extra space
    public static void findFrequency(int[] A)
    {
        int n = A.length;

        // for each element A[i], increment value present at index
        // (A[i] % n) by n
        for (int i = 0; i < n; i++) {
            A[A[i] % n] += n;
        }

        // traverse the modified array and print their frequencies
        // if A[i] > n, then i appears in the array A[i]/n times
        for (int i = 0; i < n; i++) {
            if (A[i] / n != 0) {
                System.out.printf("Element %d appears %d times\n", i, A[i] / n);
            }
        }

        // restore the array
        for (int i = 0; i < n; i++) {
            A[i] = A[i] % n;
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 2, 3, 3, 2, 1 };
        findFrequency(A);
    }
}