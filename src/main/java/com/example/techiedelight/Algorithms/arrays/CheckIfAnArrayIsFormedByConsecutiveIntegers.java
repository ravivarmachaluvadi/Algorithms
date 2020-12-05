package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class CheckIfAnArrayIsFormedByConsecutiveIntegers
{
    // Function to check if array is formed by consecutive integers
    public static boolean checkConsecutive(int[] A)
    {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
 
        // compute minimum and maximum element in an array
        for (int i: A) {
            if (i < min) { min = i; }
            if (i > max) { max = i; }
        }
 
        // in order for an array to contain consecutive integers, the difference
        // between maximum and element element in it should be exactly n-1
        if (max - min != A.length - 1) {
            return false;
        }
 
        // create an empty set (we can also use a visited array)
        Set<Integer> visited = new HashSet<>();
 
        // traverse the array and checks if each element appears only once
        for (int i: A)
        {
            // if element is seen before, return false
            if (visited.contains(i)) {
                return false;
            }
 
            // mark element as seen
            visited.add(i);
        }
 
        // we reach here when all elements in array are distinct
        return true;
    }
 
    // Check if an array is formed by consecutive integers
    public static void main(String[] args)
    {
        int[] A = { -1, 5, 4, 2, 0, 3, 1 };
 
        if (checkConsecutive(A)) {
            System.out.print("Array contains consecutive integers");
        } else {
            System.out.print("Array do not contain consecutive integers");
        }
    }
}



class CheckIfAnArrayIsFormedByConsecutiveIntegersOpti
{
    // Function to check if array is formed by consecutive integers
    public static boolean checkConsecutive(int[] A)
    {
        // 1. Check if all elements in the array are distinct

        Set<Integer> set = Arrays.stream(A).boxed()
                .collect(Collectors.toCollection(TreeSet::new));
        if (set.size() != A.length)
            return false;

        // 2. Check if all elements present in the set is consecutive
        int prev = Integer.MAX_VALUE;

        // iterate through set and check if difference between
        // consecutive elements in it is 1
        // (Note that TreeSet stores the elements in sorted order)

        for (int curr: set)
        {
            if (prev != Integer.MAX_VALUE && (curr != prev + 1)) {
                return false;
            }

            prev = curr;
        }

        return true;
    }

    // Check if an array is formed by consecutive integers
    public static void main(String[] args)
    {
        int[] A = { -1, 5, 4, 2, 0, 3, 1 };

        if (checkConsecutive(A)) {
            System.out.print("Array contains consecutive integers");
        } else {
            System.out.print("Array do not contain consecutive integers");
        }
    }
}


