package com.example.techiedelight.Algorithms.arrays;

class MaximumProfitEarnedByBuyingAndSellingSharesAnyNumberOfTimes
{
    // Function to find maximum profit that can be earned by buying and
    // selling shares any number of times
    public static int maxProfit(int[] price)
    {
        // store maximum profit gained
        int profit = 0;
 
        // initialize local minimum to first element's index
        int j = 0;
 
        // start from second element
        for (int i = 1; i < price.length; i++)
        {
            // update local minimum if decreasing sequence is found
            if (price[i - 1] > price[i]) {
                j = i;
            }
 
            // sell shares if current element is peak
            // i.e. (previous <= current > next)
            if (price[i - 1] <= price[i] &&
                (i + 1 == price.length || price[i] > price[i + 1]))
            {
                profit += (price[i] - price[j]);
                System.out.printf("Buy on day %d and sell on day %d\n", j + 1, i + 1);
            }
        }
 
        return profit;
    }
 
    public static void main(String[] args)
    {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
 
        System.out.print("\nTotal profit earned is " + maxProfit(price));
    }
}
