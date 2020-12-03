package com.example.techiedelight.Algorithms.arrays;

import java.util.Set;
import java.util.HashSet;
 
class SubarrayWithZeroSum
{
    // Function to check if sub-array with 0 sum is present
    // in the given array or not
    public static Boolean zeroSumSubarray(int[] A)
    {
        // create an empty set to store sum of elements of each
        // sub-array A[0..i] where 0 <= i < arr.length
        Set<Integer> set = new HashSet<>();
 
        // insert 0 into set to handle the case when sub-array with
        // 0 sum starts from index 0
        set.add(0);
 
        int sum = 0;
 
        // traverse the given array
        for (int value : A) {
            // sum of elements so far
            sum += value;
 
            // if sum is seen before, we have found a sub-array with 0 sum
          /*  if (set.contains(sum)) {
                return true;
            }*/

            if (sum==0) {
                return true;
            }
 
            // insert sum so far into set
            set.add(sum);
        }
 
        // we reach here when no sub-array with 0 sum exists
        return false;
    }
 
    public static void main (String[] args)
    {
        int[] A = { 4, -6, 3, -1, 4, 2, 7 };
 
        if (zeroSumSubarray(A)) {
            System.out.println("Subarray exists");
        } else {
            System.out.println("Subarray do not exist");
        }
    }
}

 

