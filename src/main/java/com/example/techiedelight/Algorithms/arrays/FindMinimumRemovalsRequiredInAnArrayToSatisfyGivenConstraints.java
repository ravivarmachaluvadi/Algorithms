package com.example.techiedelight.Algorithms.arrays;

class FindMinimumRemovalsRequiredInAnArrayToSatisfyGivenConstraints
{
    public static int findMin(int[] arr)
    {
        // Stores the length of the maximum size sub-array
        int max_range = 0;
 
        // To keep track of the min and max elements in a sub-array
        int min, max;
 
        // Traverse the array and consider each element as a starting point
        // of a sub-array
        for (int i = 0; i < arr.length && arr.length - i > max_range; i++)
        {
            // Reset the min and max elements (from previous iteration of loop)
            min = max = arr[i];
 
            /*
                Sub-array invariant: max < 2*min
            */
 
            // Find the maximum size sub-array `arr[i..j]` that satisfies
            // the above invariant
            for (int j = i; j < arr.length; j++)
            {
                // Find the min and max elements in the current sub-array.
                // We must do this in constant time.
                min = Integer.min(min, arr[j]);
                max = Integer.max(max, arr[j]);
 
                // Discard the sub-array if the invariant is violated
                if (2 * min <= max) {
                    break;
                }
 
                // Update max_range when a bigger sub-array is found
                max_range = Integer.max(max_range, j - i + 1);
            }
        }
 
        // Return size of the array - length of the maximum size sub-array
        return arr.length - max_range;
    }
 
    public static void main(String[] args) {
        int[] arr = { 4, 6, 1, 7, 5, 9, 2 };
        System.out.println("The minimum number of removals are " + findMin(arr));
    }
}