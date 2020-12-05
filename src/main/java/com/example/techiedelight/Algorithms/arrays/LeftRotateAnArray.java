package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;

//Rotating r times
class LeftRotateAnArray
{
    // Function to left rotate an array by one position
    public static void leftRotateByOne(int[] arr)
    {
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
 
        arr[arr.length - 1] = first;
    }
 
    // Function to left rotate an array by r positions
    public static void leftRotate(int[] arr, int r)
    {
        for (int i = 0; i < r; i++) {
            leftRotateByOne(arr);
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };
        int r = 2;
 
        leftRotate(arr, r);
 
        System.out.println(Arrays.toString(arr));
    }
}


//Using Auxiliary array
class LeftRotateAnArrayA1
{
    // Function to left rotate an array by r positions
    public static void leftRotate(int[] arr, int r)
    {
        // get length of the array
        int n = arr.length;

        // construct an auxiliary array of size r and
        // fill it with first r elements of the input array
        int[] aux = new int[r];
        for (int i = 0; i < r; i++) {
            aux[i] = arr[i];
        }

        // shift the remaining 'n-r' elements of the input array to the beginning
        for (int i = r; i < n; i++) {
            arr[i - r] = arr[i];
        }

        // put the elements of the auxiliary array at their
        // correct positions in the input array
        for (int i = n-r; i < n; i++) {
            arr[i] = aux[i - (n - r)];
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };
        int r = 2;

        leftRotate(arr, r);
        System.out.println(Arrays.toString(arr));
    }
}


//By reversing array
class LeftRotateAnArrayA2
{
    // Function to exchange data of two given indices in an array
    public static void swap(int[] arr, int i, int j)
    {
        int data = arr[i];
        arr[i] = arr[j];
        arr[j] = data;
    }

    // Function to reverse a given sub-array
    public static void reverse(int[] arr, int low, int high)
    {
        for (int i = low, j = high; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }

    // Function to left rotate an array by r positions
    public static void leftRotate(int[] arr, int r)
    {
        // Reverse the first 'r' elements
        reverse(arr, 0, r - 1);

        // Reverse the remaining 'n-r' elements
        reverse(arr, r, arr.length - 1);

        // Reverse the whole array
        reverse(arr, 0, arr.length - 1);
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };
        int r = 2;

        leftRotate(arr, r);
        System.out.println(Arrays.toString(arr));
    }
}