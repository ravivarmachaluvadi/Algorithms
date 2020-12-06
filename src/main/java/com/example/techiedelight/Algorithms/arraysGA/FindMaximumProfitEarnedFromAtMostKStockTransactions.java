package com.example.techiedelight.Algorithms.arraysGA;

class FindMaximumProfitEarnedFromAtMostKStockTransactions
{
    // Find maximum profit earned from at most k stock transactions
    // Input to the function are stock prices of n days and positive number k
    public static int maxProfit(int[] price, int k)
    {
        // get number of days n
        int n = price.length;
 
        // profit[i][j] stores the maximum profit gained by doing
        // at most i transactions till j'th day
        int[][] profit = new int[k + 1][n];
 
        // fill profit[][] matrix in bottom-up fashion
        for (int i = 0; i <= k; i++)
        {
            for (int j = 0; j < n; j++)
            {
                // profit is 0 when:
                // i = 0 i.e. for 0'th day
                // j = 0 i.e. no transaction is being performed
 
                if (i == 0 || j == 0) {
                    profit[i][j] = 0;
                }
                else
                {
                    int max_so_far = 0;
                    for (int x = 0; x < j; x++)
                    {
                        int curr_price = price[j] - price[x] + profit[i-1][x];
                        if (max_so_far < curr_price) {
                            max_so_far = curr_price;
                        }
                    }
 
                    profit[i][j] = Math.max(profit[i][j-1], max_so_far);
                }
            }
        }
 
        return profit[k][n-1];
    }
 
    public static void main(String[] args)
    {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
        int k = 3;
 
        System.out.print("The maximum possible profit is: " + maxProfit(price, k));
    }
}




class FindMaximumProfitEarnedFromAtMostKStockTransactionsA2
{
    // Find maximum profit earned from at most k stock transactions
    // Input to the function are stock prices of n days and positive number k
    public static int maxProfit(int[] price, int k)
    {
        // get number of days n
        int n = price.length;

        // profit[i][j] stores the maximum profit gained by doing
        // at most i transactions till j'th day
        int[][] profit = new int[k+1][n+1];

        // fill profit[][] matrix in bottom-up fashion
        for (int i = 0; i <= k; i++)
        {
            // initialize prev diff to minus infinity
            int prev_diff = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++)
            {
                // profit is 0 when:
                // i = 0 i.e. for 0'th day
                // j = 0 i.e. no transaction is being performed
                if (i == 0 || j == 0) {
                    profit[i][j] = 0;
                }
                else {
                    prev_diff = Math.max(prev_diff, profit[i - 1][j - 1] - price[j - 1]);
                    profit[i][j] = Math.max(profit[i][j - 1], price[j] + prev_diff);
                }
            }
        }

        return profit[k][n - 1];
    }

    public static void main(String[] args)
    {
        int[] price = {1, 5, 2, 3, 7, 6, 4, 5};
        int k = 3;

        System.out.print("The maximum possible profit is: " + maxProfit(price, k));
    }
}