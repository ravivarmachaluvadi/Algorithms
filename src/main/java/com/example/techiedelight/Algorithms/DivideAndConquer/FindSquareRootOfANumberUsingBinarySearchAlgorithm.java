package com.example.techiedelight.Algorithms.DivideAndConquer;

class FindSquareRootOfANumberUsingBinarySearchAlgorithm
{
    // Function to find floor of square root of x
    public static int sqrt(int x)
    {
        // find first positive number i such that i*i is greater than x
        int i = 1;
        while (i*i <= x) {
            i++;
        }
 
        return i - 1;
    }
 
    public static void main(String[] args)
    {
        for (int i = 0; i <= 16; i++) {
            System.out.printf("sqrt(%d) = %d\n", i, sqrt(i));
        }
    }
}



class FindSquareRootOfANumberUsingBinarySearchAlgorithmA2
{
    // Function to find square root of x using binary search algorithm
    // If x is not a perfect square, return floor of the square root
    public static int sqrt(int x)
    {
        // base case
        if (x < 2) {
            return x;
        }

        // to store floor of sqrt(x)
        int result = 0;

        // square root of x cannot be more than x/2 for x > 1
        int start = 1;
        int end = x/2;

        while (start <= end)
        {
            // find mid element
            int mid = (start + end) / 2;
            long sqr = mid*mid;

            // return mid if x is a perfect square
            if (sqr == x) {
                return mid;
            }

            // if mid*mid is less than x
            else if (sqr < x)
            {
                // discard left search space
                start = mid + 1;

                // update result since we need floor
                result = mid;
            }

            // if mid*mid is more than x
            else
            {
                // discard right search space
                end = mid - 1;
            }
        }

        // return result
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 16; i++) {
            System.out.printf("sqrt(%d) = %d\n", i, sqrt(i));
        }
    }
}