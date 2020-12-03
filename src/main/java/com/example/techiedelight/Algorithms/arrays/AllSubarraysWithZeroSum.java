package com.example.techiedelight.Algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Naive O(n*n)
class AllSubarraysWithZeroSum
{
    // Function to print all sub-arrays with 0 sum present
    // in the given array
    public static void printallSubarrays(int[] A)
    {
        // consider all sub-arrays starting from i
        for (int i = 0; i < A.length; i++)
        {
            int sum = 0;
 
            // consider all sub-arrays ending at j
            for (int j = i; j < A.length; j++)
            {
                // sum of elements so far
                sum += A[j];
 
                // if sum is seen before, we have found a subarray with 0 sum
                if (sum == 0) {
                    System.out.println("Subarray [" + i + ".." + j + "]");
                }
            }
        }
    }
 
        public static void main (String[] args)
    {
        int[] A = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
 
        printallSubarrays(A);
    }
}



//Using MultiMap
//O(N)
class UsingMultiMap
{
    // Utility function to insert <key, value> into the Multimap
    private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }

    // Function to print all sub-arrays with 0 sum present
    // in the given array
    public static void printallSubarrays(int[] A)
    {
        // create an empty Multi-map to store ending index of all
        // sub-arrays having same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when
        // sub-array with 0 sum starts from index 0
        insert(hashMap, 0, -1);

        int sum = 0;

        // traverse the given array
        for (int i = 0; i < A.length; i++)
        {
            // sum of elements so far
            sum += A[i];

            // if sum is seen before, there exists at-least one
            // sub-array with 0 sum
            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);

                // find all sub-arrays with same sum
                for (Integer value: list) {
                    System.out.println("Subarray [" + (value + 1) + ".." +
                            i + "]");
                }
            }

            // insert (sum so far, current index) pair into the Multi-map
            insert(hashMap, sum, i);
        }
    }

    public static void main (String[] args)
    {
        int[] A = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

        printallSubarrays(A);
    }
}
 

