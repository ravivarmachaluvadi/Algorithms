package com.example.techiedelight.Algorithms.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FindDuplicatesWithinGivenRangeKInAnArray
{
    public static boolean hasDuplicates(int[] arr, int k)
    {
        // stores (element, index) pairs as (key, value) pairs
        Map<Integer, Integer> map = new HashMap<>();
 
        // traverse the array
        for (int i = 0; i < arr.length; i++)
        {
            // if the current element already exists in the map
            if (map.containsKey(arr[i])) {
 
                // return true if current element is repeated within range of k
                if (i - map.get(arr[i]) <= k) {
                    return true;
                }
            }
 
            // store elements along with their indices
            map.put(arr[i], i);
        }
 
        // we reach here when no element is repeated within range k
        return false;
    }
 
    public static void main(String[] args) {
        int[] arr = { 5, 6, 8, 2, 4, 6, 9 };
        int k = 4;
 
        if (hasDuplicates(arr, k)) {
            System.out.println("Duplicates found");
        }
        else {
            System.out.println("No Duplicates found");
        }
    }
}



class FindDuplicatesWithinGivenRangeKInAnArrayOpti
{
    public static boolean hasDuplicates(int[] arr, int k)
    {
        // create an empty set to store elements within range k
        Set<Integer> window = new HashSet<>();

        // traverse the array
        for (int i = 0; i < arr.length; i++)
        {
            // if the current element already exists in the window,
            // then it is repeated within range of k
            if (window.contains(arr[i])) {
                return true;
            }

            // add current element to the window
            window.add(arr[i]);

            // remove the element at k'th range from the current element
            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }

        // we reach here when no element is repeated within range k
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 8, 2, 4, 6, 9 };
        int k = 4;

        if (hasDuplicates(arr, k)) {
            System.out.println("Duplicates found");
        }
        else {
            System.out.println("No Duplicates found");
        }
    }
}