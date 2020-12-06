package com.example.techiedelight.Algorithms.arrays;

class CountOccurrencesOfANumberInSortedArrayWithDuplicates
{
    // If searchFirst is true, we return the first occurrence of a number
    // in sorted array of integers; else we return its last occurrence
    public static int binarySearch(int[] A, int x, boolean searchFirst)
    {
        // search space is A[left..right]
        int left = 0;
        int right = A.length - 1;
 
        // initialize the result by -1
        int result = -1;
 
        // iterate till search space contains at-least one element
        while (left <= right)
        {
            // find the mid value in the search space and
            // compares it with key value
            int mid = (left + right) / 2;
 
            // if key is found, update the result
            if (x == A[mid])
            {
                result = mid;
 
                // go on searching towards left (lefter indices)
                if (searchFirst) {
                    right = mid - 1;
                }
                // go on searching towards right (higher indices)
                else {
                    left = mid + 1;
                }
            }
 
            // if key is less than the mid element, discard right half
            else if (x < A[mid]) {
                right = mid - 1;
            }
                // if key is more than the mid element, discard left half
            else {
                left = mid + 1;
            }
        }
 
        // return the found index or -1 if the element is not found
        return result;
    }
 
    public static void main(String[] args)
    {
        int[] A = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int key = 5;
 
        // pass true for first occurrence
        int first = binarySearch(A, key, true);
 
        // pass false for last occurrence
        int last = binarySearch(A, key, false);
 
        int c = last - first + 1;
 
        if (first != -1) {
            System.out.println("Element " + key + " occurs " + c + " times");
        } else {
            System.out.println("Element not found in the array");
        }
    }
}