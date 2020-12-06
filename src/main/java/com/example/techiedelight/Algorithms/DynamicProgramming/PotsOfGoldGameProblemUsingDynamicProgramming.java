package com.example.techiedelight.Algorithms.DynamicProgramming;

class PotsOfGoldGameProblemUsingDynamicProgramming
{
    // Recursive function to maximize the number of coins collected by a player,
    // assuming that opponent also plays optimally
    public static int optimalStrategy(int[] coin, int i, int j)
    {
        // base case: one pot left, only one choice possible
        if (i == j) {
            return coin[i];
        }
 
        // if we're left with only two pots, choose one with maximum coins
        if (i + 1 == j) {
            return Integer.max(coin[i], coin[j]);
        }
 
        // if player chooses front pot i, opponent is left to choose
        // from [i+1, j].
        // 1. if opponent chooses front pot i+1, recur for [i+2, j]
        // 2. if opponent chooses rear pot j, recur for [i+1, j-1]
 
        int start = coin[i] + Integer.min(optimalStrategy(coin, i + 2, j),
                                        optimalStrategy(coin, i + 1, j - 1));
 
        // if player chooses rear pot j, opponent is left to choose
        // from [i, j-1].
        // 1. if opponent chooses front pot i, recur for [i+1, j-1]
        // 2. if opponent chooses rear pot j-1, recur for [i, j-2]
 
        int end = coin[j] + Integer.min(optimalStrategy(coin, i + 1, j - 1),
                                        optimalStrategy(coin, i, j - 2));
 
        // return maximum of two choices
        return Integer.max(start, end);
    }
 
    // Pots of Gold Game using Dynamic Programming
    public static void main(String[] args)
    {
        // pots of gold (even number) arranged in a line
        int[] coin = { 4, 6, 2, 3 };
 
        System.out.print("Maximum coins collected by player is "
                        + optimalStrategy(coin, 0, coin.length - 1));
    }
}



class PotsOfGoldGameProblemUsingDynamicProgrammingA2
{
    // Function to maximize the number of coins collected by a player,
    // assuming that opponent also plays optimally
    public static int optimalStrategy(int[] coin, int i, int j,
                                      int[][] lookup)
    {
        // base case: one pot left, only one choice possible
        if (i == j) {
            return coin[i];
        }

        // if we're left with only two pots, choose one with maximum coins
        if (i + 1 == j) {
            return Integer.max(coin[i], coin[j]);
        }

        // if sub-problem is seen for the first time, solve it and
        // store its result in a lookup table
        if (lookup[i][j] == 0)
        {
            // if player chooses front coin i, opponent is left to choose
            // from [i+1, j].
            // 1. if opponent chooses front coin i+1, recur for [i+2, j]
            // 2. if opponent chooses rear coin j, recur for [i+1, j-1]

            int start = coin[i] + Integer.min(optimalStrategy(coin, i + 2,
                    j, lookup),
                    optimalStrategy(coin, i + 1, j - 1, lookup));

            // if player chooses rear coin j, opponent is left to choose
            // from [i, j-1].
            // 1. if opponent chooses front coin i, recur for [i+1, j-1]
            // 2. if opponent chooses rear coin j-1, recur for [i, j-2]

            int end = coin[j] + Integer.min(optimalStrategy(coin, i + 1,
                    j - 1, lookup),
                    optimalStrategy(coin, i, j - 2, lookup));

            // assign maximum of two choices
            lookup[i][j] = Integer.max(start, end);
        }

        // return the subproblem solution from the map
        return lookup[i][j];
    }

    public static void main(String[] args)
    {
        // pots of gold arranged in a line
        int[] coin = { 4, 6, 2, 3 };

        // Create a table to store solutions of subproblems
        int[][] lookup = new int[coin.length][coin.length];

        System.out.println("Maximum coins collected by player is "
                + optimalStrategy(coin, 0, coin.length - 1, lookup));
    }
}




class PotsOfGoldGameProblemUsingDynamicProgrammingA3
{
    public static int calculate(int[][] T, int i, int j) {
        if (i <= j) {
            return T[i][j];
        }

        return 0;
    }

    public static int optimalStrategy(int[] coin)
    {
        int n = coin.length;

        // base case: one pot left, only one choice possible
        if (n == 1) {
            return coin[0];
        }

        // if we're left with only two pots, choose one with maximum coins
        if (n  == 2) {
            return Integer.max(coin[0], coin[1]);
        }

        // create a dynamic 2D matrix to store sub-problem solutions
        int[][] T = new int[n][n];

        for (int iteration = 0; iteration < n ; iteration++)
        {
            for (int i = 0, j = iteration; j < n ; i++, j++)
            {
                int start = coin[i] + Integer.min(calculate(T, i + 2, j),
                        calculate(T, i + 1, j - 1));

                int end = coin[j] + Integer.min(calculate(T, i + 1, j - 1),
                        calculate(T, i, j - 2));

                T[i][j] = Integer.max(start, end);
            }
        }

        return T[0][n - 1];
    }

    // Pots of Gold Game using Dynamic Programming
    public static void main(String[] args)
    {
        // pots of gold arranged in a line
        int[] coin = { 4, 6, 2, 3 };

        System.out.println("Maximum coins collected by player is "
                + optimalStrategy(coin));
    }
}