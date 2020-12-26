package com.example.techiedelight.Algorithms.DynamicProgramming;

class FindMaximumProfitThatCanBeEarnedByConditionallySellingStocks
{
    // Recursive function to find the maximum profit that can be earned by selling stocks.
    // Here, arrays `x[0…n]` and `y[0…n]` contains the future price predictions of the
    // two different stocks for the next n-days
    public static int maxProfit(int[] x, int[] y, int n)
    {
        // base case
        if (n < 0) {
            return 0;
        }
 
        // store the maximum profit gained
        int profit = 0;
 
        // sell the first stock on the n'th day, and recur for the (n-1)'th day
        profit = Integer.max(profit, x[n] + maxProfit(x, y, n - 1));
 
        // sell the second stock on the n'th day, and recur for the (n-2)'th day
        // (no transaction can be made on the (n-1)'th day)
        profit = Integer.max(profit, y[n] + maxProfit(x, y, n - 2));
 
        // return the maximum profit
        return profit;
    }
 
    public static void main(String[] args)
    {
        int[] x = { 5, 3, 4, 6, 3 };
        int[] y = { 8, 4, 3, 5, 10 };
 
        System.out.println("Maximum profit earned is " + maxProfit(x, y, x.length - 1));
    }
}





class FindMaximumProfitThatCanBeEarnedByConditionallySellingStocksA2 {

    // Function to find the maximum earnings that can be earned by selling the stocks.
    // Here, arrays `x[0…n-1]` and `y[0…n-1]` contains the future price predictions
    // of the two different stocks for the next n-days
    public static int maxProfit(int[] x, int[] y)
    {
        // Create an auxiliary array `T[]` to save solutions to the subproblems
        // Here, `T[i]` stores the maximum earnings till day `i`
        int[] T = new int[x.length + 1];

        // Base cases
        T[0] = 0;
        T[1] = Integer.max(x[0], y[0]);

        // Fill the auxiliary array `T[]` in bottom-up manner
        for (int i = 2; i <= x.length; i++) {
            T[i] = Integer.max(x[i - 1] + T[i - 1], y[i - 1] + T[i - 2]);
        }

        // T[n] stores the maximum earnings till day `n`
        return T[x.length];
    }

    public static void main(String[] args) {
        int[] x = { 5, 3, 4, 6, 3 };
        int[] y = { 8, 4, 3, 5, 10 };

        System.out.println("Maximum profit earned is " + maxProfit(x, y));
    }
}





class FindMaximumProfitThatCanBeEarnedByConditionallySellingStocksA3 {

    // Function to find the maximum profit that can be earned by selling the stocks.
    // Here, arrays `x[0…n-1]` and `y[0…n-1]` contains the future price predictions
    // of the two different stocks for the next n-days
    public static int maxProfit(int[] x, int[] y)
    {
        // Base cases
        int prev_of_prev = 0;
        int prev = Integer.max(x[0], y[0]);

        // Find the maximum profit in bottom-up manner
        for (int i = 1; i < x.length; i++)
        {
            int curr = Integer.max(x[i] + prev, y[i] + prev_of_prev);
            prev_of_prev = prev;
            prev = curr;
        }

        // `prev` stores the maximum profit gained till day `n`
        return prev;
    }

    public static void main(String[] args)
    {
        int[] x = { 5, 3, 4, 6, 3 };
        int[] y = { 8, 4, 3, 5, 10 };

        System.out.println("Maximum profit earned is " + maxProfit(x, y));
    }
}