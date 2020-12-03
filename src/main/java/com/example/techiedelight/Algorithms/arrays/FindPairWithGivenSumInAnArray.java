package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenSumInAnArray {

    public static void main(String[] args) {

        int[] intArray= {8,7,5,2,1};
        int sum=10;

        findSumElements(intArray,sum);
    }

    private static void findSumElements(int[] intArray, int sum) {

        Map map = new HashMap();
        for (int i = 0; i < intArray.length; i++) {

            if(map.containsKey(sum-intArray[i])){
                System.out.println("Pair Found "+map.get(sum-intArray[i])+" "+i);
            }

            map.put(intArray[i],i);
        }
    }

}



//O(nlog(n))
class BySorting
{
    // Naive method to find a pair in an array with given sum
    public static void findPair(int[] A, int sum)
    {
        // sort the array in ascending order
        Arrays.sort(A);

        // maintain two indices pointing to end-points of the array
        int low = 0;
        int high = A.length - 1;

        // reduce search space arr[low..high] at each iteration of the loop

        // loop till low is less than high
        while (low < high)
        {
            // sum found
            if (A[low] + A[high] == sum)
            {
                System.out.println("Pair found");
                return;
            }

            // increment low index if total is less than the desired sum
            // decrement high index is total is more than the sum
            if (A[low] + A[high] < sum) {
                low++;
            } else{
                high--;
            }
        }

        // No pair with given sum exists in the array
        System.out.println("Pair not found");
    }

    // Find pair with given sum in the array
    public static void main (String[] args)
    {
        int[] A = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;

        findPair(A, sum);
    }
}



//O(n*n)
class Naive
{
    // Naive method to find a pair in an array with given sum
    public static void findPair(int[] A, int sum)
    {
        // consider each element except last element
        for (int i = 0; i < A.length - 1; i++)
        {
            // start from i'th element till last element
            for (int j = i + 1; j < A.length; j++)
            {
                // if desired sum is found, print it and return
                if (A[i] + A[j] == sum)
                {
                    System.out.println("Pair found at index " + i + " and " + j);
                    return;
                }
            }
        }

        // No pair with given sum exists in the array
        System.out.println("Pair not found");
    }

    public static void main (String[] args)
    {
        int[] A = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;

        findPair(A, sum);
    }
}


