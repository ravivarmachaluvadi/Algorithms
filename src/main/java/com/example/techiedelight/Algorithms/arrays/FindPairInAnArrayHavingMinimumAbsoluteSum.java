package com.example.techiedelight.Algorithms.arrays;

class FindPairInAnArrayHavingMinimumAbsoluteSum
{
    // Function to find a pair in an array with minimum absolute sum
    public static void findPair(int[] A)
    {
        if (A.length < 2) {
            return;
        }
 
        // sort the array if array is unsorted
        // Arrays.sort(A);
 
        // maintain two indexes pointing to end-points of the array
        int low = 0;
        int high = A.length - 1;
 
        // min stores minimum absolute difference
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
 
        // reduce search space A[low..high] at each iteration of the loop
 
        // loop till low is less than high
        while (low < high)
        {
            // update minimum if current absolute sum is less
            if (Math.abs(A[high] + A[low]) < min)
            {
                min = Math.abs(A[high] + A[low]);
                i = low;
                j = high;
            }
 
            // optimization - pair with 0 sum is found
            if (min == 0) {
                break;
            }
 
            // increment low index if total is less than 0
            // decrement high index is total is more than 0
            if (A[high] + A[low] < 0) {
                low++;
            }
            else {
                high--;
            }
        }
 
        // print the pair
        System.out.print("Pair found (" + A[i] + ", " + A[j] + ")");
    }
 
    // Find pair in an array having minimum absolute sum
    public static void main(String[] args)
    {
        int[] A = { -6, -5, -3, 0, 2, 4, 9 };
 
        findPair(A);
    }
}