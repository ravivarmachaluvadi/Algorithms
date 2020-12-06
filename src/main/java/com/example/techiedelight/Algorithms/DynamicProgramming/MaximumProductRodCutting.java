package com.example.techiedelight.Algorithms.DynamicProgramming;

class MaximumProductRodCutting
{
    // Function to find best way to cut a rod of length n
    // where rod of length i has price i
    public static int rodCut(int n)
    {
        // base case
        if (n <= 1) {
            return n;
        }
 
        // rod of length n has at-least cost of n
        int maxValue = n;
 
        // one by one partition the given rod of length n into
        // two parts of length (1, n-1), (2, n-2), ....
        // (n-1 , 1), (n, 0) and take maximum
        for (int i = 1; i <= n; i++) {
            maxValue = Integer.max(maxValue, i * rodCut(n - i));
        }
 
        return maxValue;
    }
 
    public static void main(String[] args)
    {
        int n = 15;        // 3 x 5 times
        System.out.println("Maximum Profit is " + rodCut(n));
    }
}




class MaximumProductRodCuttingA2
{
    public static int rodCut(int n)
    {
        // T[i] stores maximum profit achieved from rod of length i
        int[] T = new int[n + 1];

        // rod of len i has at-least cost i
        for (int i = 0; i <= n; i++)
            T[i] = i;

        // consider rod of length i
        for (int i = 2; i <= n; i++)
        {
            // divide the rod of length i into two rods of length j
            // and i-j each and take maximum
            for (int j = 1; j <= i; j++)
                T[i] = Integer.max(T[i], j * T[i - j]);
        }

        // T[n] stores maximum profit achieved from rod of length n
        return T[n];
    }

    public static void main(String[] args)
    {
        // rod length
        int n = 15;

        System.out.println("Maximum Profit is " + rodCut(n));
    }
}