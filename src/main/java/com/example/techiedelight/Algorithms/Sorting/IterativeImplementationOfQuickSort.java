package com.example.techiedelight.Algorithms.Sorting;

import java.util.Arrays;
import java.util.Stack;

class IterativeImplementationOfQuickSort
{
    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    public static int Partition(int a[], int start, int end)
    {
        // Pick rightmost element as pivot from the array
        int pivot = a[end];
 
        // elements less than pivot will go to the left of pIndex
        // elements more than pivot will go to the right of pIndex
        // equal elements can go either way
        int pIndex = start;
 
        // each time we finds an element less than or equal to pivot,
        // pIndex is incremented and that element would be placed
        // before the pivot.
        for (int i = start; i < end; i++)
        {
            if (a[i] <= pivot)
            {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
        // swap pIndex with Pivot
        swap (a, pIndex, end);
 
        // return pIndex (index of pivot element)
        return pIndex;
    }
 
    // Iterative Quicksort routine
    public static void iterativeQuickSort(int[] a)
    {
        // stack for storing subarray start and end index
        Stack<Pair> stack = new Stack<>();
 
        // get starting and ending index of given array (vector)
        int start = 0;
        int end = a.length - 1;
 
        // push array start and end index to the stack
        stack.push(new Pair(start, end));
 
        // loop till stack is empty
        while (!stack.empty())
        {
            // pop top pair from the list and get sub-array starting
            // and ending indices
            start = stack.peek().getX();
            end = stack.peek().getY();
            stack.pop();
 
            // rearrange the elements across pivot
            int pivot = Partition(a, start, end);
 
            // push sub-array indices containing elements that are
            // less than current pivot to stack
            if (pivot - 1 > start) {
                stack.push(new Pair(start, pivot - 1));
            }
 
            // push sub-array indices containing elements that are
            // more than current pivot to stack
            if (pivot + 1 < end) {
                stack.push(new Pair(pivot + 1, end));
            }
        }
    }
 
    // Iterative Implementation of Quicksort
    public static void main(String[] args)
    {
        int a[] = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };
 
        iterativeQuickSort(a);
 
        // print the sorted array
        System.out.println(Arrays.toString(a));
    }
}




// Simple pair class in Java
class Pair {
    private final int x;
    private final int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}