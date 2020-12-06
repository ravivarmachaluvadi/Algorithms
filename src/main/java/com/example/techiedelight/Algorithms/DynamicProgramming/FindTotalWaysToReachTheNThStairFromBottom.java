package com.example.techiedelight.Algorithms.DynamicProgramming;

class FindTotalWaysToReachTheNThStairFromBottom
{
    // Recursive function to find total ways to reach the n'th stair from bottom
    // when a person is allowed to climb either 1 or 2 or 3 stairs at a time
    public static int totalWays(int n)
    {
        // base case
        if (n < 0) {
            return 0;
        }
 
        // base case: there is one way to cover it with no steps
        if (n == 0) {
            return 1;
        }
 
        // combine results of taking 1 step or 2 steps or 3 steps at a time
        return totalWays(n - 1) + totalWays(n - 2) + totalWays(n - 3);
    }
 
    public static void main(String[] args)
    {
        int n = 4;
        System.out.printf("Total ways to reach the %d'th stair are %d",
                            n, totalWays(n));
    }
}



class FindTotalWaysToReachTheNThStairFromBottomTopDown
{
    // Recursive DP function to find total ways to reach the n'th stair from bottom
    // when a person is allowed to climb either 1 or 2 or 3 stairs at a time
    public static int totalWays(int n, int[] dp)
    {
        // base case
        if (n < 0) {
            return 0;
        }

        // base case: there is one way to cover it with no steps
        if (n == 0) {
            return 1;
        }

        // if the sub-problem is not seen before
        if (dp[n] == 0) {
            // combine results of taking 1 step or 2 steps or 3 steps at a time
            dp[n] = totalWays(n-1, dp) + totalWays(n-2, dp) + totalWays(n-3, dp);
        }

        // return the sub-problem solution
        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 4;

        // create an array of n+1 size for storing solution to the sub-problems
        // and initialized by 0
        int[] dp = new int[n + 1];

        System.out.printf("Total ways to reach the %d'th stair are %d",
                n, totalWays(n, dp));
    }
}





class BottomUpApproach
{
    // DP function to find total ways to reach the n'th stair from bottom
    // when a person is allowed to climb either 1 or 2 or 3 stairs at a time
    public static int totalWays(int n)
    {
        // create an array of n+1 size for storing solutions to the sub-problems
        int[] lookup = new int[n + 1];

        // base case: 1 way (with no steps)
        lookup[0] = 1;

        // There is only 1 way to reach the 1st stair
        lookup[1] = 1;

        // There are 2 ways to reach the 2nd stair
        lookup[2] = 2;

        // Fill the lookup table in bottom-up manner
        for (int i = 3; i <= n; i++) {
            lookup[i] = lookup[i - 1] + lookup[i - 2] + lookup[i - 3];
        }

        return lookup[n];
    }

    public static void main(String[] args)
    {
        int n = 4;
        System.out.print("Total ways to reach the " + n + "'th stair are "
                + totalWays(n));
    }
}




class FindTotalWaysToReachTheNThStairFromBottomA4
{
    // DP function to find total ways to reach the n'th stair from bottom
    // when a person is allowed to climb either 1 or 2 or 3 stairs at a time
    public static int totalWays(int n)
    {
        if (n <= 1) {
            return 1;
        }

        // base case: 1 way (with no steps)
        int a = 1;

        // There is only 1 way to reach the 1st stair
        int b = 1;

        // There are 2 ways to reach the 2nd stair
        int c = 2;

        for (int i = 3; i <= n; i++)
        {
            int result = a + b + c;

            a = b;
            b = c;
            c = result;
        }

        return c;
    }

    public static void main(String[] args)
    {
        int n = 4;
        System.out.printf("Total ways to reach the %d'th stair are %d",
                n, totalWays(n));
    }
}