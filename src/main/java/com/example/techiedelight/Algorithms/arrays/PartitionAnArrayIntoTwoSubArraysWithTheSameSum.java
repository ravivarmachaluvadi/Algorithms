package com.example.techiedelight.Algorithms.arrays;

import java.util.*;

class PartitionAnArrayIntoTwoSubArraysWithTheSameSum
{
    // Function to find the count of distinct elements in every sub-array
    // of size k in the array
    public static void findDistinctCount(int[] arr, int k)
    {
        // consider every sub-array of size k
        for (int x = 0; x <= arr.length - k; x++)
        {
            // maintains counter for distinct elements in current sub-array
            int distinct = 0;
 
            // current sub-array is formed by the sub-array [x, x+k)
            for (int i = x; i < x + k; i++)
            {
                // increase distinct count for arr[i] in current sub-array
                distinct++;
 
                // check if arr[i] is present in the sub-array arr[x,i-1] or not
                for (int j = x; j < i; j++)
                {
                    // if duplicate element found in current sub-array
                    if (arr[i] == arr[j])
                    {
                        // un-mark element arr[i] as distinct - decrease count
                        distinct--;
                        break;
                    }
                }
            }
 
            System.out.printf("The count of distinct elements in the sub-array [%d, %d]"
                                + " is %d\n", x, x + k - 1, distinct);
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 2, 1, 2, 3, 2, 1, 4, 5 };
        int k = 5;
 
        findDistinctCount(arr, k);
    }
}


class PartitionAnArrayIntoTwoSubArraysWithTheSameSumA2
{
    // Function to find all distinct elements present in each sub-array
    // of size k in the array
    public static void findDistinctCount(List<Integer> v, int k)
    {
        // loop through the list
        for (int i = 0; i < v.size() - (k-1); i++)
        {
            Set<Integer> distinct = new HashSet<>();
            distinct.addAll(v.subList(i, i + k));

            System.out.println("The count of distinct elements in the "
                    + "sub-array [" + i + ", "  + (i + k - 1) + "] is "
                    + distinct.size());
        }
    }

    public static void main(String[] args)
    {
        List<Integer> input = Arrays.asList( 2, 1, 2, 3, 2, 1, 4, 5 );
        int k = 5;

        findDistinctCount(input, k);
    }
}


class PartitionAnArrayIntoTwoSubArraysWithTheSameSumA3
{
    // Function to find the count of distinct elements in every sub-array
    // of size k in the array
    public static void findDistinctCount(int[] A, int k)
    {
        // map to store frequency of elements in current window of size k
        Map<Integer, Integer> freq = new HashMap<>();

        // maintains count of distinct elements in every sub-array of size k
        int distinct = 0;

        // loop through the array
        for (int i = 0; i < A.length; i++)
        {
            // ignore first k elements
            if (i >= k)
            {
                // Remove first element from the sub-array by reducing its
                // frequency in the map
                freq.put(A[i-k], freq.getOrDefault(A[i-k], 0) - 1);

                // reduce distinct count if we're left with 0
                if (freq.get(A[i-k]) == 0) {
                    distinct--;
                }
            }

            // add current element to the sub-array by incrementing its
            // count in the map
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);

            // increment distinct count by 1 if element occurs for the first
            // time in current window
            if (freq.get(A[i]) == 1) {
                distinct++;
            }

            // print count of distinct elements in current sub-array
            if (i >= k-1) {
                System.out.println("The count of distinct elements in the sub-array [" +
                        (i - k + 1) + ", " + i + "]" + " is " + distinct);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] input = { 1, 1, 2, 1, 3 };
        int k = 3;

        findDistinctCount(input, k);
    }
}