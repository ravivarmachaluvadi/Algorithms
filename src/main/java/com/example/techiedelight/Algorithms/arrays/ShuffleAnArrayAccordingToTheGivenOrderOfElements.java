package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ShuffleAnArrayAccordingToTheGivenOrderOfElements
{
    // Function to shuffle an array according to the given order of elements
    public static void rearrange(int[] arr, int[] pos)
    {
        // create an auxiliary array of size n
        int[] aux = new int[arr.length];
 
        // fill the auxiliary array with correct order of elements
        for (int i = 0; i < arr.length; i++) {
            aux[pos[i]] = arr[i];
        }
 
        // copy the auxiliary array back to the given array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = aux[i];
        }
    }
 
    public static void main(String[] args)
    {
        // input array
        int[] arr = { 1, 2, 3, 4, 5 };
 
        // position array
        int[] pos = { 3, 2, 4, 1, 0 };
 
        rearrange(arr, pos);
 
        System.out.println(Arrays.toString(arr));
    }
}



class ShuffleAnArrayAccordingToTheGivenOrderOfElementsA1
{
    // Function to shuffle an array according to the given order of elements
    public static void rearrange(int[] arr, int[] pos)
    {
        // create an empty unordered map
        Map<Integer, Integer> map = new HashMap<>();

        // fill the map with required mappings
        for (int i = 0; i < arr.length; i++) {
            map.put(pos[i], arr[i]);
        }

        // iterate through the map and replace the array elements
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            arr[entry.getKey()] = entry.getValue();
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };    // input array
        int[] pos = { 3, 2, 4, 1, 0 };    // position array

        rearrange(arr, pos);
        System.out.println(Arrays.toString(arr));
    }
}




class ShuffleAnArrayAccordingToTheGivenOrderOfElementsA2
{
    // Function to exchange data of two given indices in an array
    public static void swap(int[] arr, int i, int j)
    {
        int data = arr[i];
        arr[i] = arr[j];
        arr[j] = data;
    }

    // Function to shuffle an array according to the given order of elements
    public static void rearrange(int[] arr, int[] pos)
    {
        // traverse the array from left to right
        for (int i = 0; i < arr.length; i++)
        {
            // loop till current set is swapped
            while (pos[i] != i)
            {
                // update arr[] and pos[] with correct order of elements
                swap(arr, pos[i], i);
                swap(pos, pos[i], i);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };    // input array
        int[] pos = { 3, 2, 4, 1, 0 };    // position array

        rearrange(arr, pos);
        System.out.println(Arrays.toString(arr));
    }
}