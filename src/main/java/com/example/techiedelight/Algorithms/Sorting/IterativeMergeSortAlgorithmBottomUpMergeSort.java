package com.example.techiedelight.Algorithms.Sorting;

import java.util.Arrays;
 
class IterativeMergeSortAlgorithmBottomUpMergeSort
{
    // Merge two sorted sub-arrays A[from .. mid] and A[mid + 1 .. to]
    public static void merge(int[] A, int[] temp, int from, int mid, int to)
    {
        int k = from, i = from, j = mid + 1;
 
        // loop till there are elements in the left and right runs
        while (i <= mid && j <= to) {
            if (A[i] < A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }
 
        // Copy remaining elements
        while (i <= mid) {
            temp[k++] = A[i++];
        }
 
        // Don't need to copy second half
 
        // copy back to the original array to reflect sorted order
        for (i = from; i <= to; i++) {
            A[i] = temp[i];
        }
    }
 
    // Iteratively sort array A[low..high] using temporary array
    public static void mergesort(int[] A)
    {
        int low = 0;
        int high = A.length - 1;
 
        // sort array A[] using temporary array temp
        int[] temp = Arrays.copyOf(A, A.length);
 
        // divide the array into blocks of size m
        // m = [1, 2, 4, 8, 16...]
        for (int m = 1; m <= high - low; m = 2*m)
        {
            // for m = 1, i = 0, 2, 4, 6, 8...
            // for m = 2, i = 0, 4, 8, 12...
            // for m = 4, i = 0, 8, 16...
            // ...
            for (int i = low; i < high; i += 2*m)
            {
                int from = i;
                int mid = i + m - 1;
                int to = Integer.min(i + 2 * m - 1, high);
 
                merge(A, temp, from, mid, to);
            }
        }
    }
 
    // Iterative Implementation of Mergesort algorithm
    public static void main(String[] args)
    {
        int[] A = { 5, 7, -9, 3, -4, 2, 8 };
 
        System.out.println("Original Array : " + Arrays.toString(A));
        mergesort(A);
        System.out.println("Modified Array : " + Arrays.toString(A));
    }
}