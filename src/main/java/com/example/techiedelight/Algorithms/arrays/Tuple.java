package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
// Tuple class
class Tuple<X,Y,Z>
{
    public final X first;        // first field of a Tuple
    public final Y second;         // second field of a Tuple
    public final Z third;         // third field of a Tuple
 
    // Constructs a new Tuple with specified values
    private Tuple(X first, Y second, Z third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
 
    // Factory method for creating a Typed Tuple immutable instance
    public static <X,Y,Z> Tuple <X,Y,Z> of(X a, Y b, Z c)
    {
        // calls private constructor
        return new Tuple<>(a, b, c);
    }
}
 
class FindASortedTripletInTheGivenArray
{
    // Find a sorted triplet in the given array
    public static Tuple findTriplet(int[] arr)
    {
        // size of the input array
        int n = arr.length;
 
        // sorted triplet is not possible on input having less than 3 elements
        if (n < 3) {
            return null;
        }
 
        // min[i] = j where 0 <= j < i and arr[j] < arr[i]
        // min[i] = -1 when arr[j] > arr[i] for every index j < i
        int[] min = new int[n];
        Arrays.fill(min, -1);
 
        // keep an index to the minimum element found so far
        // while traversing the array from left to right
        int min_index_so_far = 0;
 
        // start from the 1st index as min[0] would be -1
        for (int i = 1; i < n; i++) {
            // update min_index_so_far if current index has less value, else
            // update min[i] with the smallest index to its left
            if (arr[i] < arr[min_index_so_far]) {
                min_index_so_far = i;
            } else {
                min[i] = min_index_so_far;
            }
        }
 
        // max[i] = j where i < j < n and arr[i] < arr[j]
        // max[i] = -1 when arr[j] < arr[i] for every index j > i
        int[] max = new int[n];
        Arrays.fill(max, -1);
 
        // keep an index to the maximum element found so far
        // while traversing the array from right to left
        int max_index_so_far = n - 1;
 
        // start from the second last index as max[n-1] would be -1
        for (int i = n - 2; i >= 0; i--)
        {
            // update max_index_so_far if current index has more value, else
            // update max[i] with the greatest index to its right
            if (arr[i] > arr[max_index_so_far]) {
                max_index_so_far = i;
            }
            else
                max[i] = max_index_so_far;
        }
 
        // traverse the array again and find an index which has both a min
        // element on its left and a max element on its right
        for (int i = 0; i < n; i++)
        {
            if (min[i] != -1 && max[i] != -1)
            {
                // create a tuple of the found triplet and returns true
                return Tuple.of(min[i], i, max[i]);
            }
        }
 
        // no triplet found
        return null;
    }
 
    public static void main(String[] args)
    {
        // input array
        int[] input = { 5, 4, 3, 7, 6, 1, 9 };
 
        // create a tuple to store the triplet
        Tuple<Integer, Integer, Integer> triplet = findTriplet(input);
 
        // find the triplet
        if (triplet != null) {
            System.out.print("Triplet found: ("
                                    + input[triplet.first] + ", "
                                    + input[triplet.second] + ", "
                                    + input[triplet.third] + ")");
        }
        else {
            System.out.print("Triplet not found");
        }
    }
}



class FindASortedTripletInTheGivenArrayOpti
{
    // Find a sorted triplet in the given array
    public static Tuple findTriplet(int[] arr)
    {
        // size of the input array
        int n = arr.length;

        // sorted triplet is not possible on input having less than 3 elements
        if (n < 3) {
            return null;
        }

        // keep an index to the minimum element found so far
        // while traversing the array from left to right
        int min_index = 0;

        // stores the index of first two items in the sorted sub-sequence
        int low = 0, mid = -1;

        // traverse the array from left to right starting from the 1st index
        for (int i = 1; i < n; i++)
        {
            // if current element is less than the minimum element found so far
            if (arr[i] <= arr[min_index]) {
                min_index = i;
            }

            // initialize low and mid index since arr[i] > arr[min_index]
            else if (mid == -1) {
                low = min_index;
                mid = i;
            }

            // smaller candidate found for the middle element
            else if (arr[i] <= arr[mid]) {
                low = min_index;
                mid = i;
            }

            // triplet is found since arr[low] < arr[mid] < arr[i]
            else {
                // create a tuple of the found triplet and returns true
                return Tuple.of(arr[low], arr[mid], arr[i]);
            }
        }

        // no triplet found
        return null;
    }

    public static void main(String[] args)
    {
        // input array
        int[] input = { 5, 4, 3, 7, 6, 1, 9 };

        // create a tuple to store the triplet
        Tuple<Integer, Integer, Integer> triplet = findTriplet(input);

        // find the triplet
        if (triplet != null) {
            System.out.print("Triplet found: ("
                    + triplet.first + ", "
                    + triplet.second + ", "
                    + triplet.third + ")");
        }
        else {
            System.out.print("Triplet not found");
        }
    }
}