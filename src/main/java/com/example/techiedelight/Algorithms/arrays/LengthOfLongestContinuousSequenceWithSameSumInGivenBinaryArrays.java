package com.example.techiedelight.Algorithms.arrays;

import java.util.HashMap;
import java.util.Map;
 
class LengthOfLongestContinuousSequenceWithSameSumInGivenBinaryArrays
{
    // Given two binary arrays X and Y, find the length of longest
    // continuous sequence that starts and ends at same index in both
    // arrays and have same sum
    public static int findMaxSubarrayLength(int[] X, int[] Y)
    {
        // create an empty map
        Map<Integer, Integer> map = new HashMap<>();
 
        // to handle the case when required sequence starts from index 0
        map.put(0, -1);
 
        // stores length of longest continuous sequence
        int res = 0;
 
        // sum_x, sum_y stores sum of elements of X[] and Y[] respectively
        // till current index
        int sum_x = 0, sum_y = 0;
 
        // traverse both lists simultaneously
        for (int i = 0; i < X.length; i++)
        {
            // update sum_x and sum_y
            sum_x += X[i];
            sum_y += Y[i];
 
            // calculate difference between sum of elements in two lists
            int diff = sum_x - sum_y;
 
            // if difference is seen for the first time, then store the
            // difference and current index in a map
            if (!map.containsKey(diff)) {
                map.put(diff, i);
            }
 
            // if difference is seen before, then update the result
            else {
                res = Integer.max(res, i - map.get(diff));
            }
        }
 
        return res;
    }
 
    public static void main(String[] args)
    {
        int[] X = { 0, 0, 1, 1, 1, 1 };
        int[] Y = { 0, 1, 1, 0, 1, 0 };
 
        System.out.print("The length of longest continuous sequence " +
                        "with same sum is " + findMaxSubarrayLength(X, Y));
    }
}