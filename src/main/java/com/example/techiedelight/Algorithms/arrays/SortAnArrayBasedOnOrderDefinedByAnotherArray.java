package com.example.techiedelight.Algorithms.arrays;

import java.util.*;

//1. Using Hashing
class SortAnArrayBasedOnOrderDefinedByAnotherArray
{
    public static void customSort(int[] first, int[] second)
    {
        // map to store frequency of each element of first array
        Map<Integer, Integer> freq = new TreeMap<>();
 
        // freq frequency of each element of first array and
        // store it in a map.
        for (int i: first) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
 
        // Note that once we have the frequencies of all elements of
        // first array, we can overwrite elements of first array
 
        int index = 0;
 
        // do for every element of second array
        for (int i: second)
        {
            // If current element is present in the map, print it n times
            // where n is the frequency of that element in first array
            int n = freq.getOrDefault(i, 0);
            while (n-- > 0) {
                first[index++] = i;
            }
 
            // erase the element from map
            freq.remove(i);
        }
 
        // Now we are only left with elements that are only present
        // in the first array but not present in the second array
        // We need to sort the remaining elements present in the map
        // Since we use a TreeMap, keys are already sorted
 
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                first[index++] = entry.getKey();
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] first = { 5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4 };
        int[] second = { 3, 5, 7, 2 };
 
        customSort(first, second);
        System.out.println("After sorting the array is : " + Arrays.toString(first));
    }
}


//Using Comparator
class CustomComparator implements Comparator<Integer>
{
    private Map<Integer, Integer> map;
    public CustomComparator(Map<Integer, Integer> map) {
        this.map = map;
    }

    public int compare(Integer x, Integer y)
    {
        if (map.containsKey(x) && map.containsKey(y)) {
            return map.get(x) - map.get(y);
        }
        else if (map.containsKey(y)) {
            return 1;
        }
        else if (map.containsKey(x)) {
            return -1;
        }
        else {
            return x - y;
        }
    }
}

class SortAnArrayBasedOnOrderDefinedByAnotherArrayA1
{
    public static void main(String[] args)
    {
        // Wrapper class used
        Integer[] first = { 5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4 };
        Integer[] second = { 3, 5, 7, 2 };

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < second.length; i++) {
            map.put(second[i], i);
        }

        // Arrays.sort method doesn't work with primitive array
        // when used with user defined comparator
        Arrays.sort(first, new CustomComparator(map));
        System.out.println(Arrays.toString(first));
    }
}