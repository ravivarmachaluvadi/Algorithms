package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
 
class PrintAllCombinationsOfPositiveIntegersInIncreasingOrderThatSumToAGivenNumber
{
    // Recursive function to print all combination of positive integers
    // in increasing order that sum to a given number
    public static void printCombinations(int[] A, int i, int sum, int sum_left)
    {
        // To maintain the increasing order, start the loop from
        // previous number stored in A[]
        int prev_num = (i > 0) ? A[i - 1] : 1;
        for (int k = prev_num; k <= sum ; k++)
        {
            // set next element of the array to k
            A[i] = k;
 
            // recur with the sum left and next location in the array
            if (sum_left > k) {
                printCombinations(A, i + 1, sum, sum_left - k);
            }
 
            // if sum is found
            if (sum_left == k) {
                System.out.println(Arrays.stream(A).limit(i + 1).boxed()
                                .collect(Collectors.toList()));
            }
        }
    }
 
    // Wrapper over printCombinations() function
    public static void findCombinations(int sum)
    {
        // create a temporary array for storing the combinations
        int[] A = new int[sum];
 
        // recur for all combinations
        int starting_index = 0;
        printCombinations(A, starting_index, sum, sum);
    }
 
    public static void main(String[] args)
    {
        int sum = 5;
        findCombinations(sum);
    }
}