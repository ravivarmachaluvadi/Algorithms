package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElementsToAGivenValueInAnArray
{
    // Function to find the `k` closest elements to `x` in a sorted list `arr`
    public static List<Integer> findKClosestElements(List<Integer> arr, int k, int x)
    {
        // find the insertion point using binary search algorithm
        int i = Collections.binarySearch(arr, x);
 
        // Collections.binarySearch() returns `-(insertion point) - 1`
        // if key is not contained in the list
        if (i < 0) {
            i = -(i + 1);
        }
 
        int left = i - 1;
        int right = i;
 
        // run `k` times
        while (k-- > 0)
        {
            // compare the elements on both sides of the insertion point `i`
            // to get the first `k` closest elements
 
            if (left < 0 || (right < arr.size() &&
                    Math.abs(arr.get(left) - x) > Math.abs(arr.get(right) - x))) {
                right++;
            }
            else {
                left--;
            }
        }
 
        // return `k` closest elements
        return arr.subList(left + 1, right);
    }
 
    public static void main(String[] args) {
 
        List<Integer> arr = Arrays.asList(10, 12, 15, 17, 18, 20, 25);
        int x = 16, k = 4;
 
        System.out.println(findKClosestElements(arr, k, x));
    }
}





class FindKClosestElementsToAGivenValueInAnArrayA2
{
    // Function to find the `k` closest elements to `x` in a sorted integer array `arr`
    public static List<Integer> findKClosestElements(int[] arr, int k, int x)
    {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k)
        {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        return Arrays.stream(arr, left, right + 1).boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        int[] arr = {10, 12, 15, 17, 18, 20, 25 };
        int x = 16, k = 4;

        System.out.println(findKClosestElements(arr, k, x));
    }
}