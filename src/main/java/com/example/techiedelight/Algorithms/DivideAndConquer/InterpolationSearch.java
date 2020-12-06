package com.example.techiedelight.Algorithms.DivideAndConquer;

class InterpolationSearch
{
    // Find out if a key x exists in the sorted array A
    // or not using Interpolation search algorithm
    public static int interpolationSearch(int[] A, int x)
    {
        // search space is A[left..right]
        int left = 0;
        int right = A.length - 1;
 
        while (A[right] != A[left] && x >= A[left] && x <= A[right])
        {
            // estimate mid
            int mid = left + ((x - A[left]) * (right - left) /
                            (A[right] - A[left]));
 
            // key value is found
            if (x == A[mid]) {
                return mid;
            }
 
            // discard all elements in the right search space
            // including the mid element
            else if (x < A[mid]) {
                right = mid - 1;
            }
 
            // discard all elements in the left search space
            // including the mid element
            else {
                left = mid + 1;
            }
        }
 
        // if key is found
        if (x == A[left]) {
            return left;
        }
 
        // x doesn't exist in the array
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] A = {2, 5, 6, 8, 9, 10};
        int key = 5;
 
        int index = interpolationSearch(A, key);
 
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found in the array");
    }
}