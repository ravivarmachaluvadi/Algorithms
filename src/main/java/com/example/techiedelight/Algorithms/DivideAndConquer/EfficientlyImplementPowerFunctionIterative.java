package com.example.techiedelight.Algorithms.DivideAndConquer;

//Naive iterative solution
class EfficientlyImplementPowerFunctionIterative
{
    // Naive iterative solution to calculate pow(x, n)
    public static int power(int x, int n)
    {
        // initialize result by 1
        int pow = 1;
 
        // multiply x exactly n times
        for (int i = 0; i < n; i++) {
            pow = pow * x;
        }
 
        return pow;
    }
 
    public static void main(String[] args)
    {
        int x = -2;
        int n = 10;
 
        System.out.println("pow(" + x + "," + n + ") = " + power(x, n));
    }
}



//Using Divide Conquer
class UsingDivideConquer
{
    // Naive recursive solution to calculate pow(x, n)
    // using Divide & Conquer
    public static int power(int x, int n)
    {
        // base condition
        if (n == 0) {
            return 1;
        }

        if ((n & 1) == 1) { // if n is odd
            return x * power(x, n / 2) * power(x, n / 2);
        }

        // else n is even
        return power(x, n / 2) * power(x, n / 2);
    }

    public static void main(String[] args)
    {
        int x = -2;
        int n = 10;

        System.out.println("pow(" + x + "," + n + ") = " + power(x, n));
    }
}



class UsingDivideConquerOpti
{
    // Optimized recursive solution to calculate pow(x, n)
    // using divide and conquer
    public static int power(int x, int n)
    {
        // base condition
        if (n == 0) {
            return 1;
        }

        // calculate sub-problem recursively
        int pow = power(x, n / 2);

        if ((n & 1) == 1) { // if y is odd
            return x * pow * pow;
        }

        // else y is even
        return pow * pow;
    }

    public static void main(String[] args)
    {
        int x = -2;
        int n = 10;

        System.out.println("pow(" + x + "," + n + ") = " + power(x, n));
    }
}




class UsingDivideConquerUsingLowLevelProgramming
{
    // Iterative solution to calculate pow(x, n) using binary operators
    public static int power(int x, int n)
    {
        int pow = 1;

        // do till n is zero
        while (n > 0)
        {
            // if n is odd, multiply result by x
            if ((n & 1) == 1) {
                pow *= x;
            }

            // divide n by 2
            n = n >> 1;

            // multiply x by itself
            x = x * x;
        }

        // return result
        return pow;
    }

    public static void main(String[] args)
    {
        int x = -2;
        int n = 10;

        System.out.println("pow(" + x + "," + n + ") = " + power(x, n));
    }
}