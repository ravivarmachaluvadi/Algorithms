package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
 
class FindPairsWithGivenDifferenceKInAnArray
{
    // Function to find pair with given difference in the array
    // This method do not handle duplicates in the array
    public static void findPair(int[] A, int diff)
    {
        // array is unsorted
 
        // take an empty set
        Set<Integer> set = new HashSet<>();
 
        // do for each element in the array
        for (int i: A)
        {
            // check if pair with given difference (i, i-diff) exists
            if (set.contains(i - diff)) {
                System.out.println("(" + i + ", " + (i - diff) + ")");
            }
 
            // check if pair with given difference (i+diff, i) exists
            if (set.contains(i + diff)) {
                System.out.println("(" + (i + diff) + ", " + i + ")");
            }
 
            // insert element into the set
            set.add(i);
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 5, 2, 2, 2, 5, 5, 4};
        int diff = 3;
 
        findPair(A, diff);
    }
}



class FindPairsWithGivenDifferenceKInAnArrayOpti
{
    // Function to find pair with given difference in the array
    // This method handles duplicates in the array
    public static void findPair(int[] A, int diff)
    {
        // sort array in ascending order
        Arrays.sort(A);

        // take an empty set
        Set<Integer> set = new HashSet<>();

        // do for each element in the array
        for (int i = 0; i < A.length; i++)
        {
            // to avoid printing duplicates (skip adjacent duplicates)
            while (i + 1 < A.length && A[i] == A[i+1]) {
                i++;
            }

            // check if pair with given difference (A[i], A[i] - diff) exists
            if (set.contains(A[i] - diff)) {
                System.out.println("(" + A[i] + ", " + (A[i] - diff) + ")");
            }

            // check if pair with given difference (A[i] + diff, A[i]) exists
            if (set.contains(A[i] + diff)) {
                System.out.println("(" + (A[i] + diff) + ", " + A[i] + ")");
            }

            // insert element into the set
            set.add(A[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 5, 2, 2, 2, 5, 5, 4};
        int diff = -3;

        findPair(A, diff);
    }
}
