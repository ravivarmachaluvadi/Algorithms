package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class RightRotateAnArrayKTimes
{
    // Function to right rotate an array by one position
    public static void rightRotateByOne(int[] A)
    {
        int last = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            A[i + 1] = A[i];
        }
 
        A[0] = last;
    }
 
    // Function to right rotate an array by k positions
    public static void rightRotate(int[] A, int k)
    {
        for (int i = 0; i < k; i++) {
            rightRotateByOne(A);
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
 
        rightRotate(A, k);
 
        System.out.println(Arrays.toString(A));
    }
}



class RightRotateAnArrayKTimesA1
{
    // Function to right rotate an array by k positions
    public static void rightRotate(int[] A, int k)
    {
        int n = A.length;

        // construct an auxiliary array of size k and
        // fill it with last k elements of the input array
        int[] aux = new int[k];
        for (int i = 0; i < k; i++) {
            aux[i] = A[n - k + i];
        }

        // shift the first 'n-k' elements of the input array to the end
        for (int i = n - k - 1; i >= 0; i--) {
            A[i + k] = A[i];
        }

        // put the elements of the auxiliary array at their
        // correct positions in the input array
        for (int i = 0; i < k; i++) {
            A[i] = aux[i];
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        rightRotate(A, k);

        System.out.println(Arrays.toString(A));
    }
}




class RightRotateAnArrayKTimesA2
{
    // Function to exchange data of two given indices in an array
    public static void swap(int[] A, int i, int j)
    {
        int data = A[i];
        A[i] = A[j];
        A[j] = data;
    }

    // Function to reverse a given sub-array
    public static void reverse(int[] A, int low, int high)
    {
        for (int i = low, j = high; i < j; i++, j--) {
            swap(A, i, j);
        }
    }

    // Function to right rotate an array by k positions
    public static void rightRotate(int[] A, int k, int n)
    {
        // Reverse the last 'k' elements
        reverse(A, n - k, n - 1);

        // Reverse the first 'n-k' elements
        reverse(A, 0, n - k - 1);

        // Reverse the whole array
        reverse(A, 0, n - 1);
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        rightRotate(A, k, A.length);
        System.out.println(Arrays.toString(A));
    }
}

