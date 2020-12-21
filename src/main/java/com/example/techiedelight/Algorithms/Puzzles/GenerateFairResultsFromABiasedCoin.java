package com.example.techiedelight.Algorithms.Puzzles;

import java.util.Random;
 
class GenerateFairResultsFromABiasedCoin
{
    private static final int HEADS = 1;
    private static final int TAILS = 0;
 
    // Generates a pseudo-random integer in the range [min, max]
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
 
        return new Random().nextInt(max - min + 1) + min;
    }
 
    // Biased function that returns TAILS with 80% probability and
    // HEADS with 20% probability
    public static int biased()
    {
        // generate random number between 0-99, both inclusive
        int r = rand(0, 99);
 
        // return TAILS if we got number between [0-79], else return HEADS
        return (r <= 79) ? TAILS: HEADS;
    }
 
    // Return HEADS and TAILS with equal probability using the specified function
    public static int generate()
    {
        while (true)
        {
            int first = biased();
            int second = biased();
 
            if (first != second) {
                return first;    // or return second
            }
        }
    }
 
    // Program to generate fair results from a biased coin
    public static void main(String[] args)
    {
        int x = 0, y = 0;
 
        for (int i = 0; i < 100000; i++) {
            int val = generate();
            if (val > 0) { x++; } else { y++; }
        }
 
        System.out.println("HEADS ~ " + x / 1000.0 + "%");        // ~50%
        System.out.println("TAILS ~ " + y / 1000.0 + "%");        // ~50%
    }
}