package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
 
class ReplaceEachElementOfAnArrayByItsCorrespondingRank
{
    // Function to replace each element of the array by its rank in the array
    public static void transform(int[] arr)
    {
        // create an empty TreeMap
        Map<Integer, Integer> map = new TreeMap<>();
 
        // store (element, index) pair in TreeMap
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
 
        // keys are stored in sorted order in TreeMap
 
        // rank starts from 1
        int rank = 1;
 
        // iterate through the map and replace each element by its rank
        for (Integer val : map.values()) {
            arr[val] = rank++;
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 10, 8, 15, 12, 6, 20, 1 };
 
        // transform the array
        transform(A);
 
        // print the transformed array
        System.out.println(Arrays.toString(A));
    }
}



// Pair class
class Pair1<U, V>
{
    public final U first;       // first field of a Pair
    public final V second;      // second field of a Pair

    // Constructs a new Pair with specified values
    private Pair1(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair1<U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair1<>(a, b);
    }
}

class ReplaceEachElementOfAnArrayByItsCorrespondingRankOpti
{
    // Function to replace each element of the array by its rank in the array
    public static void transform(int[] arr)
    {
        // create a max-heap of Pairs using PriorityQueue class
        PriorityQueue<Pair1<Integer, Integer>> pq;
        pq = new PriorityQueue<>((a, b) -> b.first - a.first);

        // push all input elements with their corresponding index in the priority queue
        for (int i = 0; i < arr.length; i++) {
            pq.add(Pair1.of(arr[i], i));
        }

        // get input size
        int rank = arr.length;

        // run until max-heap is empty
        while (!pq.isEmpty())
        {
            // take next maximum element from heap and replace its value
            // in the input vector with its corresponding rank
            arr[pq.poll().second] = rank;

            // decrement rank for next maximum element
            --rank;
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 10, 8, 15, 12, 6, 20, 1 };

        // transform the array
        transform(A);

        // print the transformed array
        System.out.println(Arrays.toString(A));
    }
}

