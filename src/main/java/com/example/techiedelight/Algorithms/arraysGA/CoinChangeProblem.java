package com.example.techiedelight.Algorithms.arraysGA;

import java.util.HashMap;
import java.util.Map;

class CoinChangeProblem
{
    // Function to find the total number of ways to get change
    // of N from unlimited supply of coins in set S
    public static int count(int[] S, int N)
    {
        // if total is 0, return 1
        if (N == 0) {
            return 1;
        }
 
        // return 0 if total become negative
        if (N < 0) {
            return 0;
        }
 
        // initialize total number of ways to 0
        int res = 0;
 
        // do for each coin
        for (int i = 0; i < S.length; i++)
        {
            // recur to see if total can be reached by including
            // current coin S[i]
            res += count(S, N - S[i]);
        }
 
        // return total number of ways
        return res;
    }
 
    public static void main(String[] args)
    {
        // n coins of given denominations
        int[] S = { 1, 2, 3 };
 
        // Total Change required
        int N = 4;
 
        System.out.println("Total number of ways to get desired change is "
                + count(S, N));
    }
}



class CoinChangeProblemA2
{
    // Function to find the total number of distinct ways to get
    // change of N from unlimited supply of coins in set S
    public static int count(int[] S, int n, int N)
    {
        // if total is 0, return 1 (solution found)
        if (N == 0) {
            return 1;
        }

        // return 0 (solution do not exist) if total become negative or
        // no elements are left
        if (N < 0 || n < 0) {
            return 0;
        }

        // Case 1. include current coin S[n] in solution and recur
        // with remaining change (N - S[n]) with same number of coins
        int incl = count(S, n, N - S[n]);

        // Case 2. exclude current coin S[n] from solution and recur
        // for remaining coins (n - 1)
        int excl = count(S, n - 1, N);

        // return total ways by including or excluding current coin
        return incl + excl;
    }

    // Coin Change Problem
    public static void main(String[] args)
    {
        // n coins of given denominations
        int[] S = { 1, 2, 3 };

        // Total Change required
        int N = 4;

        System.out.print("Total number of ways to get desired change is "
                + count(S, S.length - 1, N));
    }
}



class CoinChangeProblemA3
{
    // Function to find the total number of distinct ways to get change of N
    // from unlimited supply of coins in set S
    public static int count(int[] S, int n, int N, Map<String, Integer> lookup)
    {
        // if total is 0, return 1 (solution found)
        if (N == 0) {
            return 1;
        }

        // return 0 (solution do not exist) if total become negative or
        // no elements are left
        if (N < 0 || n < 0) {
            return 0;
        }

        // construct an unique map key from dynamic elements of the input
        String key = n + "|" + N;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // Case 1. include current coin S[n] in solution and recur
            // with remaining change (N - S[n]) with same number of coins
            int include = count(S, n, N - S[n], lookup);

            // Case 2. exclude current coin S[n] from solution and recur
            // for remaining coins (n - 1)
            int exclude = count(S, n - 1, N, lookup);

            // assign total ways by including or excluding current coin
            lookup.put(key, include + exclude);
        }

        // return solution to current sub-problem
        return lookup.get(key);
    }

    // Coin Change Problem
    public static void main(String[] args)
    {
        // n coins of given denominations
        int[] S = { 1, 2, 3 };

        // Total Change required
        int N = 4;

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.print("Total number of ways to get desired change is "
                + count(S, S.length - 1, N, lookup));
    }
}



class CoinChangeProblemA4
{
    // Function to find the total number of distinct ways to get change of N
    // from unlimited supply of coins in set S
    public static int count(int S[], int N) {

        int n = S.length;

        int T[][] = new int[n + 1][N + 1];

        for (int i = 0 ; i <= n; i++) {
            T[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) {
                if (S[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                }
                else {
                    T[i][j] = T[i - 1][j] + T[i][j - S[i - 1]];
                }
            }
        }

        return T[n][N];
    }

    public static void main(String[] args)
    {
        // n coins of given denominations
        int[] S = { 1, 2, 3 };

        // Total Change required
        int N = 4;

        System.out.println("Total number of ways to get desired change is "
                + count(S, N));
    }
}




class CoinChangeProblemA5
{
    // Function to find the total number of distinct ways to get change of N
    // from unlimited supply of coins in set S
    public static int count(int S[], int N) {

        int T[] = new int[N+1];
        T[0] = 1;

        for (int i = 0; i < S.length; i++) {
            for (int j = S[i]; j <= N; j++) {
                T[j] += T[j - S[i]];
            }
        }

        return T[N];
    }

    public static void main(String[] args)
    {
        // n coins of given denominations
        int[] S = { 1, 2, 3 };

        // Total Change required
        int N = 4;

        System.out.println("Total number of ways to get desired change is "
                + count(S, N));
    }
}