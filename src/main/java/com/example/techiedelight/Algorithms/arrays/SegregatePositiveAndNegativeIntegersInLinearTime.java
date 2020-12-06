package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class SegregatePositiveAndNegativeIntegersInLinearTime
{
    public static void partition(int[] a, int start, int end)
    {
        int pIndex = start;
 
        // each time we find a negative number, pIndex is incremented
        // and that element would be placed before the pivot
        for (int i = start; i <= end; i++)
        {
            if (a[i] < 0)   // pivot is 0
            {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
    }
 
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
 
    public static void main(String[] args)
    {
        int[] a = { 9, -3, 5, -2, -8, -6, 1, 3 };
 
        partition(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}