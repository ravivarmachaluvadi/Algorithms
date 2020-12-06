package com.example.techiedelight.Algorithms.Binary;

class RoundUpToTheNextHighestPowerOf2
{
    // compute power of two greater than or equal to n
    public static int nextPowerOf2(int n)
    {
        // decrement n (to handle cases when n itself
        // is a power of 2)
        n = n - 1;
 
        // do till only one bit is left
        while ((n & n - 1) != 0) {
            n = n & n - 1;    // unset rightmost bit
        }
 
        // n is now a power of two (less than n)
 
        // return next power of 2
        return n << 1;
    }
 
    public static void main(String[] args)
    {
        int n = 127;
 
        System.out.println("Next power of 2 is " + nextPowerOf2(n));
    }
}




class RoundUpToTheNextHighestPowerOf2A2
{
    // compute power of two greater than or equal to n
    public static int nextPowerOf2(int n)
    {
        // decrement n (to handle cases when n itself
        // is a power of 2)
        n = n - 1;

        // initialize result by 2
        int k = 2;

        // double k and divide n in half till it becomes 0
        while ((n >>= 1) != 0) {
            k = k << 1; // double k
        }

        return k;
    }

    /*public static int nextPowerOf2(int n)
    {
        int k = 1;
        while (k < n) {
            k = k << 1;
        }
        return k;
    }*/

    public static void main(String[] args)
    {
        int n = 127;
        System.out.println("Next power of 2 is " + nextPowerOf2(n));
    }
}




class RoundUpToTheNextHighestPowerOf2A3
{
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    // compute power of two greater than or equal to n
    public static int nextPowerOf2(int n)
    {
        // decrement n (to handle the case when n itself
        // is a power of 2)
        n = n - 1;

        // calculate position of last set bit of n
        int lg = log(n, 2);

        // next power of two will have bit set at position (lg + 1)
        return 1 << lg + 1;
    }

    public static void main(String[] args)
    {
        int n = 20;

        System.out.println("Next power of 2 is " + nextPowerOf2(n));
    }
}




class RoundUpToTheNextHighestPowerOf2A4
{
    // compute the next highest power of 2 of 32-bit n
    public static int nextPowerOf2(int n)
    {
        // decrement n (to handle cases when n itself is a power of 2)
        n--;

        // Set all bits after the last set bit
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        // increment n and return
        return ++n;
    }

    public static void main(String[] args)
    {
        int n = 131;
        System.out.println("Next power of 2 is " + nextPowerOf2(n));
    }
}