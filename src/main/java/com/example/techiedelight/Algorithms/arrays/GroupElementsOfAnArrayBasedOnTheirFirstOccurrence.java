package com.example.techiedelight.Algorithms.arrays;

import java.util.HashMap;
import java.util.Map;
 
class GroupElementsOfAnArrayBasedOnTheirFirstOccurrence
{
    // Function to group elements of the given array based on first
    // occurrence of each element
    public static void rearrange(int[] A)
    {
        // create an empty map to store frequency of each element
        // present in the input array
        Map<Integer, Integer> freq = new HashMap<>();
 
        // traverse the input array and update frequency of each element
        for (int i: A) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
 
        for (int i: A)
        {
            // if i exists in the map (first occurrence of i)
            if (freq.containsKey(i))
            {
                // print i n times where n = freq[i]
                int n = freq.get(i);
                while (n-- != 0) {
                    System.out.print(i + " ");
                }
 
                // delete the element from the map so it would not
                // get processed again
                freq.remove(i);
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 5, 4, 5, 5, 3, 1, 2, 2, 4 };
 
        rearrange(A);
    }
}