package com.example.techiedelight.Algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FourSumProblemQuadrupletsWithGivenSum
{
    // Naive recursive function to check if Quadruplet exists in an array
    // with given sum
    public static boolean quadTuple(int[] A, int n, int sum, int count)
    {
        // if desired sum is reached with 4 elements, return true
        if (sum == 0 && count == 4) {
            return true;
        }
 
        // return false if sum is not possible with current configuration
        if (count > 4 || n == 0) {
            return false;
        }
 
        // Recur with
        // 1. including current element
        // 2. excluding current element
 
        return quadTuple(A, n - 1, sum - A[n - 1], count + 1) ||
                        quadTuple(A, n - 1, sum, count);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int sum = 20;
 
        if (quadTuple(A, A.length, sum, 0)) {
            System.out.print("Quadruplet Exists");
        } else {
            System.out.print("Quadruplet Don't Exist");
        }
    }
}



class Pair {
    public int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class FourSumProblemQuadrupletsWithGivenSumOpti
{
    // Function to check if Quadruplet exists in an array with given sum
    public static boolean quadTuple(int[] A, int n, int sum)
    {
        // create an empty map
        // key -> sum of a pair of elements in the array
        // value -> list storing index of every pair having that sum
        Map<Integer, List<Pair>> map = new HashMap<>();

        // consider each element except last element
        for (int i = 0; i < n - 1; i++)
        {
            // start from i'th element till last element
            for (int j = i + 1; j < n; j++)
            {
                // calculate remaining sum
                int val = sum - (A[i] + A[j]);

                // if remaining sum is found in the map,
                // we have found a Quadruplet
                if (map.containsKey(val))
                {
                    // check every pair having sum equal to remaining sum
                    for (Pair pair1 : map.get(val))
                    {
                        int x = pair1.x;
                        int y = pair1.y;

                        // if Quadruplet don't overlap, print it and
                        // return true
                        if ((x != i && x != j) && (y != i && y != j))
                        {
                            System.out.print("Quadruplet Found ("
                                    + A[i] + ", " + A[j] + ", "
                                    + A[x] + ", " + A[y] + ")");
                            return true;
                        }
                    }
                }

                // insert current pair into the map

                // null check (Java 8)
                map.putIfAbsent(A[i] + A[j], new ArrayList<>());
                map.get(A[i] + A[j]).add(new Pair(i, j));
            }
        }

        // return false if Quadruplet don't exist
        return false;
    }

    public static void main(String[] args)
    {
        int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int sum = 20;

        if (!quadTuple(A, A.length, sum)) {
            System.out.print("Quadruplet Don't Exist");
        }
    }
}


