package com.example.techiedelight.Algorithms.Sorting;

import java.util.Arrays;
 
class QuickSortAlgorithmUsingHoareSPartitioningScheme
{
    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // Partition using Hoare's Partitioning scheme
    public static int Partition(int[] a, int low, int high)
    {
        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;
 
        while (true) {
            do {
                i++;
            } while (a[i] < pivot);
 
            do {
                j--;
            } while (a[j] > pivot);
 
            if (i >= j)
                return j;
 
            swap(a, i, j);
        }
    }
 
    // Quicksort routine
    public static void quickSort(int[] a, int low, int high)
    {
        // base condition
        if (low >= high) {
            return;
        }
 
        // rearrange the elements across pivot
        int pivot = Partition(a, low, high);
 
        // recur on sub-array containing elements less than the pivot
        quickSort(a, low, pivot);
 
        // recur on sub-array containing elements more than the pivot
        quickSort(a, pivot + 1, high);
    }
 
    // Quick Sort using Hoare's Partitioning scheme
    public static void main(String[] args)
    {
        int[] a = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };
 
        quickSort(a, 0, a.length - 1);
 
        // print the sorted array
        System.out.println(Arrays.toString(a));
    }
}