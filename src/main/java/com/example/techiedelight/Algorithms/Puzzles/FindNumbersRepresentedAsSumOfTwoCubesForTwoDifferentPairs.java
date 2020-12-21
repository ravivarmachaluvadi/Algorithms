package com.example.techiedelight.Algorithms.Puzzles;

import java.util.HashSet;
import java.util.Set;
 
class FindNumbersRepresentedAsSumOfTwoCubesForTwoDifferentPairs
{
    public static void findAllNumbers(int N)
    {
        // find cube root of N
        double cb = Math.pow(N, 1.0 / 3);
 
        // create an empty set
        Set<Integer> s = new HashSet<>();
 
        for (int i = 1; i < cb - 1; i++)
        {
            for (int j = i + 1; j < cb; j++)
            {
                // (i, j) forms a pair
                int sum = (i * i * i) + (j * j * j);
 
                // sum is seen before
                if (s.contains(sum)) {
                    System.out.println(sum);
                } else {
                    // sum is not seen before
                    s.add(sum);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        int N = 25000;
        findAllNumbers(N);
    }
}