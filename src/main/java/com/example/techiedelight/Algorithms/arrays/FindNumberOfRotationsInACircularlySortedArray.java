package com.example.techiedelight.Algorithms.arrays;

class FindNumberOfRotationsInACircularlySortedArray
{
    // Function to find the number of times the array is rotated
    public static int findRotationCount(int[] A)
    {
        // search space is A[left..right]
        int left = 0;
        int right = A.length - 1;
 
        // iterate till search space contains at-least one element
        while (left <= right)
        {
            // if the search space is already sorted, we have
            // found the minimum element (at index left)
            if (A[left] <= A[right]) {
                return left;
            }
 
            int mid = (left + right) / 2;
 
            // find next and previous element of the mid element
            // (in circular manner)
            int next = (mid + 1) % A.length;
            int prev = (mid - 1 + A.length) % A.length;
 
            // if mid element is less than both its next and previous
            // neighbor, then it is the minimum element of the array
 
            if (A[mid] <= A[next] && A[mid] <= A[prev]) {
                return mid;
            }
 
            // if A[mid..right] is sorted and mid is not the min element,
            // then pivot element cannot be present in A[mid..right] and
            // we can discard A[mid..right] and search in the left half
 
            else if (A[mid] <= A[right]) {
                right = mid - 1;
            }
 
            // if A[left..mid] is sorted then pivot element cannot be
            // present in it and we can discard A[left..mid] and search
            // in the right half
 
            else if (A[mid] >= A[left]) {
                left = mid + 1;
            }
        }
 
        // invalid input
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };
 
        System.out.println("The array is rotated " + findRotationCount(A) + " times");
    }
}