package com.example.techiedelight.Algorithms.arrays;

class FindWaysToCalculateATargetFromElementsOfSpecifiedArray
{
    // Count ways to calculate a target from elements of specified array
    public static int countWays(int[] arr, int n, int target)
    {
        // base case: if target is found
        if (target == 0)
            return 1;
 
        // base case: No elements are left
        if (n < 0)
            return 0;
 
        // 1. Ignore current element
        int exclude = countWays(arr, n - 1, target);
 
        // 2. Consider current element
 
        // 2.1. Subtract current element from the target
        // 2.2. Add current element to the target
        int include = countWays(arr, n - 1, target - arr[n]) +
                    countWays(arr, n - 1, target + arr[n]);
 
        // Return total count
        return exclude + include;
    }
 
    public static void main(String[] args)
    {
        // input array and target number
        int[] arr = { 5, 3, -6, 2 };
        int target = 6;
 
        System.out.println(countWays(arr, arr.length - 1, target) + " ways");
    }
}



