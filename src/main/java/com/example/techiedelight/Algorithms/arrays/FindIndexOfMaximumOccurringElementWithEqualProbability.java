package com.example.techiedelight.Algorithms.arrays;

import java.util.*;
 
class FindIndexOfMaximumOccurringElementWithEqualProbability
{
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(max - min + 1) + min;
    }
 
    // Return index of maximum occurring element with equal probability
    public static int findIndex(List<Integer> input)
    {
        // store count of each element present in the list in a Map
        Map<Integer, Integer> count = new HashMap<>();
        for (int val: input) {
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
 
        // traverse the Map and find the maximum occurring element
        int max_occurring = input.get(0);
        for (Map.Entry<Integer, Integer> pair: count.entrySet()) {
            if (count.get(max_occurring) < pair.getValue()) {
                max_occurring = pair.getKey();
            }
        }
 
        // generate a random number k between 1 and count of maximum occurring element
        int k = rand(1, count.get(max_occurring));
 
        // traverse the input list and return index of the k'th occurrence
        // of maximum occurring element
        int index = 0;
        while (k != 0 && index < input.size()) {
            if (input.get(index) == max_occurring) {
                k--;
            }
            index++;
        }
 
        return index - 1;
    }
 
    // Find index of maximum occurring element with equal probability
    public static void main(String[] args)
    {
        List<Integer> input = Arrays.asList(4, 3, 6, 8, 4, 6, 2, 4, 5, 9, 7, 4);
 
        for (int i = 0; i < 5; i++) {
            System.out.println("Index of maximum occurring element: " + findIndex(input));
        }
    }
}