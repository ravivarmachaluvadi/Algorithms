package com.example.techiedelight.Algorithms.DynamicProgramming;

class FindNumberOfWaysToFillANX4MatrixWith1X4Tiles
{
    // Recursive function to find number of ways to fill a n x 4 matrix with 1 x 4 tiles
    public static int totalWays(int n)
    {
        // base cases
        if (n < 1) {
            return 0;
        }
 
        if (n < 4) {
            return 1;
        }
 
        if (n == 4) {
            return 2;
        }
 
        // combine results of placing a tile horizontally and placing 4 tiles vertically
        return totalWays(n - 1) + totalWays(n - 4);
    }
 
    public static void main(String[] args)
    {
        int n = 5;
        System.out.print("Total number of ways are " + totalWays(n));
    }
}




class FindNumberOfWaysToFillANX4MatrixWith1X4TilesA2
{
    // Function to find number of ways to fill a n x 4 matrix with 1 x 4 tiles
    public static int totalWays(int n)
    {
        // base case
        if (n < 1) {
            return 0;
        }

        if (n < 4) {
            return 1;
        }

        // construct a temporary array T[] such that T[i] stores the
        // number of ways to fill an (i x 4) grid
        int[] T = new int[n + 1];

        // handle separately for n <= 4
        T[1] = T[2] = T[3] = 1;
        T[4] = 2;

        // fill the array in bottom-up fashion
        for (int i = 5; i <= n; i++)
        {
            // place a single tile horizontally or 4 tiles vertically together
            T[i] = T[i - 1] + T[i - 4];
        }

        return T[n];
    }

    public static void main(String[] args)
    {
        int n = 5;
        System.out.println("Total number of ways are " + totalWays(n));
    }
}