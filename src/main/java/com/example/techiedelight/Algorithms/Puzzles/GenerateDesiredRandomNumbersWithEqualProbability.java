package com.example.techiedelight.Algorithms.Puzzles;

import java.util.Random;
 
class GenerateDesiredRandomNumbersWithEqualProbability
{
    // Generates a pseudo-random integer in the range [min, max]
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(max - min + 1) + min;
    }
 
    // Generate random numbers between 1 to 12 with equal probability using a
    // function that generates random numbers from 1 to 6 with equal probability
    public static int generate()
    {
        // generate two random numbers from 1 to 6 with equal probability
        int x = rand(1, 6);
        int y = rand(1, 6);
 
        return 2*x - (y & 1);
    }
 
    public static void main(String[] args)
    {
        int[] freq = new int[13];
 
        for (int i = 0; i < 1000000; i++) {
            int val = generate();
            freq[val]++;
        }
 
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " ~ " + freq[i] / 10000.0);
        }
    }
}





class GenerateDesiredRandomNumbersWithEqualProbabilityA2
{
    // Generates a pseudo-random integer in the range [min, max]
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }

        return new Random().nextInt(max - min + 1) + min;
    }

    // Generate random numbers between 1 to 12 with equal probability using a
    // function that generates random numbers from 1 to 6 with equal probability
    public static int generate()
    {
        int x = rand(1, 6);
        int y = rand(1, 6);

        return x + (y & 1) * 6;
    }

    public static void main(String[] args)
    {
        int[] freq = new int[13];

        for (int i = 0; i < 1000000; i++) {
            int val = generate();
            freq[val]++;
        }

        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " ~ " + (freq[i] / 10000.0) + "%");
        }
    }
}