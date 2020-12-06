package com.example.techiedelight.Algorithms.arraysGA;

class CoinChangeMakingProblemUnlimitedSupplyOfCoins
{
    // Function to find the minimum number of coins required
    // to get total of N from set S
    public static int findMinCoins(int[] S, int N)
    {
        // if total is 0, no coins are needed
        if (N == 0) {
            return 0;
        }
 
        // return INFINITY if total become negative
        if (N < 0) {
            return Integer.MAX_VALUE;
        }
 
        // initialize minimum number of coins needed to infinity
        int coins = Integer.MAX_VALUE;
 
        // do for each coin
        for (int c: S)
        {
            // recur to see if total can be reached by including
            // current coin S[i]
            int res = findMinCoins(S, N - c);
 
            // update minimum number of coins needed if choosing current
            // coin resulted in solution
            if (res != Integer.MAX_VALUE) {
                coins = Integer.min(coins, res + 1);
            }
        }
 
        // return minimum number of coins needed
        return coins;
    }
 
    public static void main(String[] args)
    {
        // n coins of given denominations
        int[] S = { 1, 3, 5, 7 };
 
        // Total Change required
        int N = 18;
 
        int coins = findMinCoins(S, N);
        if (coins != Integer.MAX_VALUE) {
            System.out.print("Minimum number of coins required to get desired change is "
                + coins);
        }
    }
}




class CoinChangeMakingProblemUnlimitedSupplyOfCoinsA2
{
    // Function to find the minimum number of coins required
    // to get total of N from set S
    public static int findMinCoins(int[] S, int N)
    {
        // T[i] stores minimum number of coins needed to get total of i
        int[] T = new int[N + 1];

        for (int i = 1; i <= N; i++)
        {
            // initialize minimum number of coins needed to infinity
            T[i] = Integer.MAX_VALUE;
            int res = Integer.MAX_VALUE;

            // do for each coin
            for (int c: S)
            {
                // check if index doesn't become negative by including
                // current coin c
                if (i - c >= 0) {
                    res = T[i - c];
                }

                // if total can be reached by including current coin c,
                // update minimum number of coins needed T[i]
                if (res != Integer.MAX_VALUE) {
                    T[i] = Integer.min(T[i], res + 1);
                }
            }
        }

        // T[N] stores the minimum number of coins needed to get total of N
        return T[N];
    }

    public static void main(String[] args)
    {
        // n coins of given denominations
        int[] S = { 1, 2, 3, 4 };

        // Total Change required
        int N = 15;

        int coins = findMinCoins(S, N);
        if (coins != Integer.MAX_VALUE) {
            System.out.print("Minimum number of coins required to get desired change is "
                    + coins);
        }
    }
}