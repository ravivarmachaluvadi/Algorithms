package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class FindMissingNumberInArrayWithoutUsingExtraSpace
{
    // Find missing number in a limited range array [1..n+1]
    public static int findMissingElement(int[] A)
    {
        int n = A.length;
 
        // calculate sum of all elements of the array A
        int sum = Arrays.stream(A).sum();
 
        // expected sum - actual sum
        return (n + 1) + n * (n + 1)/2 - sum;
    }
 
    public static void main(String[] args)
    {
        // input array contains n numbers between [1 to n + 1]
        // with one number missing and no duplicates
        int[] A = { 3, 2, 4, 6, 1 };
 
        System.out.print("The missing element is " + findMissingElement(A));
    }
}




class FindMissingNumberInArrayWithoutUsingExtraSpaceUsingXOR
{
    // Find missing number in a limited range array [1..n+1]
    public static int findMissingElement(int[] A, int n)
    {
        int xor = 0;

        // take xor of all array elements
        for (int i: A) {
            xor ^= i;
        }

        // take xor of numbers from 1 to n+1
        for (int i = 1; i <= n + 1; i++) {
            xor ^= i;
        }

        // same elements will cancel out each other as a ^ a = 0
        // Also 0 ^ 0 = 0 and a ^ 0 = a

        // xor will contain the missing number
        return xor;
    }

    public static void main(String[] args)
    {
        // input array contains n numbers between [1 to n + 1]
        // with one number missing and no duplicates
        int[] A = { 1, 2, 3, 4, 6 };
        int n = A.length;

        System.out.println("The missing element is " + findMissingElement(A, n));
    }
}



class FindMissingNumberInArrayWithoutUsingExtraSpaceOpti
{
    // Find missing number in a limited range array [1..n+1]
    // This method won't work for negative numbers
    public static int findMissingElement(int[] arr, int n)
    {
        // Case 1. Missing number is in range 1 to n

        // do for each element in the array
        for (int i = 0; i < n; i++) {
            // get absolute value of current element
            int absVal = Math.abs(arr[i]);

            // make element at index abs(arr[i]) - 1 negative
            if (absVal - 1 < n) {
                arr[absVal - 1] = -arr[absVal - 1];
            }
        }

        // System.out.println(Arrays.toString(arr));

        // check for missing numbers from 1 to n
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        // Case 2. If numbers from 1 to n are present in the array,
        // then the missing number is n + 1
        return n + 1;
    }

    public static void main(String[] args)
    {
        // input array contains n numbers between [1 to n + 1]
        // with one number missing and no duplicates
        int[] A = { 3, 2, 4, 5, 6 };
        int n = A.length;

        System.out.printf("The missing element is " + findMissingElement(A, n));
    }
}