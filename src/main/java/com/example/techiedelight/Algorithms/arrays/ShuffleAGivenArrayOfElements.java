package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.Random;

//Shuffle a given array of elements (Fisher–Yates shuffle)
//same effect with the two below algos TC - O(N) , SC - O(1)
class ShuffleAGivenArrayOfElements
{
    // Utility function to swap two elements A[i] and A[j] in the array
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 
    // Function to shuffle an array A[]
    public static void shuffle(int[] A)
    {
        // read array from highest index to lowest
        for (int i = A.length - 1; i >= 1; i--)
        {
            Random rand = new Random();
 
            // generate a random number j such that 0 <= j <= i
            int j = rand.nextInt(i + 1);
 
            // swap current element with randomly generated index
            swap(A, i, j);
        }
    }
 
    public static void main (String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6 };
        shuffle(A);
        // print the shuffled array
        System.out.println(Arrays.toString(A));
    }
}



class ShuffleAGivenArrayOfElementsOpti
{
    // Utility function to swap two elements A[i] and A[j] in the array
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Function to shuffle an array A[]
    public static void shuffle(int[] A)
    {
        // read array from lowest index to highest
        for (int i = 0; i <= A.length - 2; i++)
        {
            Random rand = new Random();

            // generate a random number j such that i <= j < n
            int j = i + rand.nextInt(A.length - i);

            // swap current element with randomly generated index
            swap(A, i, j);
        }
    }

    public static void main (String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6 };

        shuffle(A);

        // print the shuffled array
        System.out.println(Arrays.toString(A));
    }
}

