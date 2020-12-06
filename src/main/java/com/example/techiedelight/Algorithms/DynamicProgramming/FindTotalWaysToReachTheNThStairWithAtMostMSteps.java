package com.example.techiedelight.Algorithms.DynamicProgramming;

class FindTotalWaysToReachTheNThStairWithAtMostMSteps
{
    // Recursive function to find total ways to reach the n'th stair from bottom
    // when a person is allowed to take at-most m steps at a time
    public static int totalWays(int n, int m)
    {
        // base case: invalid input
        if (n < 0) {
            return 0;
        }
 
        // base case: 1 way (with no steps)
        if (n == 0) {
            return 1;
        }
 
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += totalWays(n - i, m);
        }
 
        return count;
    }
 
    public static void main(String[] args)
    {
        int n = 4, m = 3;
 
        System.out.printf("Total ways to reach the %d'th stair with at-most " +
                                "%d steps are %d", n, m, totalWays(n, m));
    }
}




class FindTotalWaysToReachTheNThStairWithAtMostMStepsTopDown
{
    // Recursive DP function to find total ways to reach the n'th stair from bottom
    // when a person is allowed to take at-most m steps at a time
    public static int totalWays(int n, int m, int[] dp)
    {
        // base case: invalid input
        if (n < 0) {
            return 0;
        }

        // base case: 1 way (with no steps)
        if (n == 0) {
            return 1;
        }

        // if the sub-problem is not seen before
        if (dp[n] == 0) {
            for (int i = 1; i <= m; i++)
                dp[n] += totalWays(n - i, m, dp);
        }

        // return the sub-problem solution
        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 4, m = 3;

        // create an array of n+1 size for storing solution to the sub-problems
        int[] dp = new int[n+1];

        System.out.printf("Total ways to reach the %d'th stair with at-most " +
                "%d steps are %d", n, m, totalWays(n, m, dp));
    }
}




class FindTotalWaysToReachTheNThStairWithAtMostMStepsBottomUp
{
    // Recursive function to find total ways to reach the n'th stair from bottom
    // when a person is allowed to take at-most m steps at a time
    public static int totalWays(int n, int m)
    {
        // create an array of n+1 size for storing solutions to the sub-problems
        int[] lookup = new int[n + 1];

        // base case: 1 way (with no steps)
        lookup[0] = 1;

        // 1 way to reach the 1st stair
        lookup[1] = 1;

        // 2 ways to reach the 2nd stair
        lookup[2] = 2;

        // Fill the lookup table in bottom-up manner
        for (int i = 3; i <= n; i++)
        {
            lookup[i] = 0;
            for (int j = 1; j <= m && (i - j) >= 0; j++) {
                lookup[i] += lookup[i - j];
            }
        }

        return lookup[n];
    }

    public static void main(String[] args)
    {
        int n = 4, m = 3;

        System.out.printf("Total ways to reach the %d'th stair with at-most " +
                "%d steps are %d", n, m, totalWays(n, m));
    }
}
