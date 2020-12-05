package com.example.techiedelight.Algorithms.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FindSubarrayHavingGivenSumInGivenArrayOfIntegers
{
    // Function to print sub-array having given sum using
    // sliding window technique
    public static void findSubarray(int[] A, int sum)
    {
        // maintains sum of current window
        int windowSum = 0;
 
        // maintain a window [low, high-1]
        int high = 0;
 
        // consider every sub-array starting from low index
        for (int low = 0; low < A.length; low++)
        {
            // if current window's sum is less than the given sum,
            // then add elements to current window from right
            while (windowSum < sum && high < A.length)
            {
                windowSum += A[high];
                high++;
            }
 
            // if current window's sum is equal to the given sum
            if (windowSum == sum)
            {
                System.out.printf("Subarray found [%d-%d]", low, high - 1);
                return;
            }
 
            // At this point the current window's sum is more than the given sum
            // remove current element (leftmost element) from the window
            windowSum -= A[low];
        }
    }
 
    public static void main(String[] args)
    {
        // array of positive integers
        int[] A = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
        int sum = 15;
 
        findSubarray(A, sum);
    }
}



class FindSubarrayHavingGivenSumInGivenArrayOfIntegersUsingHashing
{
    // Function to check if sub-array with given sum exists in
    // the array or not
    public static boolean findSubarray(int[] A, int sum)
    {
        // create an empty set
        Set<Integer> set = new HashSet<>();

        // insert number 0 into the set to handle the case when
        // sub-array with given sum starts from index 0
        set.add(0);

        // maintains sum of elements so far
        int sum_so_far = 0;

        // traverse the given array
        for (int i: A)
        {
            // update sum_so_far
            sum_so_far += i;

            // if (sum_so_far - sum) is seen before, we have found
            // the sub-array with sum 'sum'
            if (set.contains(sum_so_far - sum)) {
                return true;
            }

            // else insert sum of elements so far into the set
            set.add(sum_so_far);
        }

        // we reach here when no sub-array exists
        return false;
    }

    public static void main(String[] args)
    {
        // array of integers
        int[] A = { 0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10 };
        int sum = -3;

        if (findSubarray(A, sum)) {
            System.out.print("Sub-array with given sum exists");
        }
        else {
            System.out.print("Sub-array with given sum do not exist");
        }
    }
}



class FindSubarrayHavingGivenSumInGivenArrayOfIntegersOpti
{
    // Function to print sub-array having given sum using Hashing
    public static void findSubarray(int[] A, int sum)
    {
        // create an empty map
        Map<Integer, Integer> map = new HashMap<>();

        // insert (0, -1) pair into the set to handle the case when
        // sub-array with given sum starts from index 0
        map.put(0, -1);

        // maintains sum of elements so far
        int sum_so_far = 0;

        // traverse the given array
        for (int i = 0; i < A.length; i++)
        {
            // update sum_so_far
            sum_so_far += A[i];

            // if (sum_so_far - sum) is seen before, we have found
            // the sub-array with sum 'sum'
            if (map.containsKey(sum_so_far - sum))
            {
                System.out.print("Subarray found [" +
                        (map.get(sum_so_far - sum) + 1) +
                        "-" + i + "]");
                return;
            }

            // insert current sum with index into the map
            map.put(sum_so_far, i);
        }
    }

    public static void main(String[] args)
    {
        // array of integers
        int[] A = { 0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10 };
        int sum = 15;

        findSubarray(A, sum);
    }
}