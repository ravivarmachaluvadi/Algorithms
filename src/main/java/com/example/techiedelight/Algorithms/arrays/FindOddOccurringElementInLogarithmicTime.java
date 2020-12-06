package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class FindOddOccurringElementInLogarithmicTime
{
    // Function to find odd occurring element in a given array
    public static int findOddOccuring(int[] arr)
    {
        // sort the array
        Arrays.sort(arr);
 
        // traverse the array from the beginning
        int i = 0;
        while (i < arr.length)
        {
            // store the current element
            int curr = arr[i];
 
            // find count of the current element
            int count = 0;
            while (i < arr.length && arr[i] == curr) {
                count++;
                i++;
            }
 
            // if count of the current element is odd, return it
            if (count % 2 == 1) {
                return curr;
            }
        }
 
        // invalid input
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 2, 2, 1, 1, 3, 3, 2, 2, 4, 4, 3, 1, 1 };
        System.out.print("The odd occurring element is " + findOddOccuring(arr));
    }
}



class FindOddOccurringElementInLogarithmicTimeA1
{
    // Function to find odd occurring element in a given array
    public static int findOddOccuring(int[] arr)
    {
        int xor = 0;
        for (int i: arr) {
            xor = xor ^ i;
        }

        return xor;
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 2, 1, 1, 3, 3, 2, 2, 4, 4, 3, 1, 1 };

        System.out.println("The odd occurring element is " + findOddOccuring(arr));
    }
}



class FindOddOccurringElementInLogarithmicTimeA2
{
    // Recursive function to find an odd occurring element in an array
    // using binary search. This function assumes the input is valid.
    public static int findOddOccuring(int[] arr, int low, int high)
    {
        // base case
        if (low == high) {
            return low;
        }

        // find the middle index
        int mid = (low + high) / 2;

        // if mid is odd
        if (mid % 2 == 1)
        {
            // if element before mid is same as mid element, the odd element
            // lies on the right side; otherwise it lies on the left side
            if (arr[mid] == arr[mid - 1])
                return findOddOccuring(arr, mid + 1, high);
            else
                return findOddOccuring(arr, low, mid - 1);
        }

        // mid is even
        else
        {
            // if element next to mid is same as mid element, the odd element
            // lies on the right side; otherwise it lies on the left side
            if (arr[mid] == arr[mid + 1])
                return findOddOccuring(arr, mid + 2, high);
            else
                return findOddOccuring(arr, low, mid);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 2, 1, 1, 3, 3, 2, 2, 4, 4, 3, 1, 1 };

        int index = findOddOccuring(arr, 0, arr.length - 1);
        System.out.println("The odd occurring element is " + arr[index]);
    }
}


