package com.example.techiedelight.Algorithms.Puzzles;

import java.util.Random;
 
class GenerateNumbersFrom1To7WithEqualProbabilityUsingSpecifiedFunction
{
    // Generates a pseudo-random integer in the range [min, max]
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
 
        return new Random().nextInt(max - min + 1) + min;
    }
 
    // Function to generate a random number from 1 to 7 with equal probability
    // by using the specified function
    public static int generate()
    {
        int r;
        do
        {
            r = 5 * (rand(1, 5) - 1) + rand(1, 5);
        } while (r > 7);
 
        return r;
    }
 
    public static void main(String[] args)
    {
        // count array to validate the results
        int[] count = new int[8];
 
        // make 1000000 calls to the generate() function and store the results
        for (int i = 1; i <= 1000000; i++) {
            int val = generate();
            count[val]++;
        }
 
        // print the results
        for (int i = 1; i <= 7; i++) {
            System.out.println(i + " ~ " + (count[i] / 10000.0) + "%");
        }
    }
}