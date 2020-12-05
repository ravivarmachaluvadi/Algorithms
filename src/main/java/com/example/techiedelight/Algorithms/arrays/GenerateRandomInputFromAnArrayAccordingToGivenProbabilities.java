package com.example.techiedelight.Algorithms.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
 
class GenerateRandomInputFromAnArrayAccordingToGivenProbabilities
{
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
 
        return new Random().nextInt(max - min + 1) + min;
    }
 
    // Function to generate random input from a list according to
    // given probabilities
    public static int random(int[] input, int[] probability)
    {
        int n = input.length;
        if (n != probability.length) {
            return -1;        // error
        }
 
        // construct a sum list from given probabilities
        int[] prob_sum = new int[n];
 
        // prob_sum[i] holds sum of all probability[j] for 0 <= j <=i
        prob_sum[0] = probability[0];
        for (int i = 1; i < n; i++) {
            prob_sum[i] = prob_sum[i - 1] + probability[i];
        }
 
        // generate a random integer from 1 to 100
        // and check where it lies in prob_sum[]
        int r = rand(1, 100);
 
        // based on the comparison result, return corresponding
        // element from the input list
 
        if (r <= prob_sum[0]) {    // handle 0'th index separately
            return input[0];
        }
 
        for (int i = 1; i < n; i++) {
            if (r > prob_sum[i-1] && r <= prob_sum[i]) {
                return input[i];
            }
        }
 
        return -1;
    }
 
    public static void main(String[] args)
    {
        // Input: list of integers and their probability
        // Goal: generate input[i] with probability equal to probability[i]
 
        int[] input = { 1, 2, 3, 4, 5 };
        int[] probability = { 30, 10, 20, 15, 25 };
 
        // maintain a frequency map to validate the results
        Map<Integer, Integer> freq = new HashMap<>();
 
        // make 1000000 calls to the random() function and store results in a map
        for (int i = 0; i < 1000000; i++) {
            int val = random(input, probability);
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
 
        // print the results
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + " ~ " + freq.get(input[i]) / 10000.0 + "%");
        }
    }
}


