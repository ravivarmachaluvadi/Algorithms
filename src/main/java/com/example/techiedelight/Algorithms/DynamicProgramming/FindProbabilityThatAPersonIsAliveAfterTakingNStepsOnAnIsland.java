package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
 
class FindProbabilityThatAPersonIsAliveAfterTakingNStepsOnAnIsland
{
    private static final int N = 3;
 
    // Find the probability that person is alive after he walks n steps
    // from location (x, y) on the island
    public static Double aliveProbability(int x, int y, int n,
                                        Map<String, Double> dp)
    {
        // base case
        if (n == 0) {
            return 1.0;
        }
 
        // calculate unique map key from current coordinates(x, y)
        // of person and number of steps(n) left
        String key = x + "|" + y + "|" + n;
 
        // if sub-problem is seen for the first time
        if (!dp.containsKey(key))
        {
            Double p = 0.0;
 
            // move one step up
            if (x > 0) {
                p += 0.25 * aliveProbability(x - 1, y, n - 1, dp);
            }
 
            // move one step down
            if (x < N - 1) {
                p += 0.25 * aliveProbability(x + 1, y, n - 1, dp);
            }
 
            // move one step left
            if (y > 0) {
                p += 0.25 * aliveProbability(x, y - 1, n - 1, dp);
            }
 
            // move one step right
            if (y < N - 1) {
                p += 0.25 * aliveProbability(x, y + 1, n - 1, dp);
            }
 
            dp.put(key, p);
        }
 
        return dp.get(key);
    }
 
    public static void main(String[] args)
    {
        int n = 3;           // number of steps to be taken
        int x = 0, y = 0;    // starting coordinates
 
        // map to store solution to already computed subproblems
        Map<String, Double> dp = new HashMap<>();
 
        // calculate alive Probability
        System.out.println("Alive probability is "
                + aliveProbability(x, y, n, dp));
    }
}