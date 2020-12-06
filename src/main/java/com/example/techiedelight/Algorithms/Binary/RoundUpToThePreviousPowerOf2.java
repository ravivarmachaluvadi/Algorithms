package com.example.techiedelight.Algorithms.Binary;

//Round up to the previous power of 2
class RoundUpToThePreviousPowerOf2A1
{
    // compute power of two less than or equal to n
    public static int previousPowerOf2(int n)
    {
        // do till only one bit is left
        while ((n & n - 1) != 0) {
            n = n & n - 1;    // unset rightmost bit
        }
 
        // n is now a power of two (less than or equal to n)
        return n;
    }
 
    public static void main(String[] args)
    {
        int n = 128;
 
        System.out.println("Previous power of 2 is " + previousPowerOf2(n));
    }
}



class RoundUpToThePreviousPowerOf2A2
{
    // compute power of two less than or equal to n
    public static int previousPowerOf2(int n)
    {
        // initialize result by 1
        int k = 1;

        // double k and divide n in half till it becomes 0
        while ((n >>= 1) != 0) {
            k = k << 1; // double k
        }

        return k;
    }

    public static void main(String[] args)
    {
        int n = 127;

        System.out.println("Previous power of 2 is " + previousPowerOf2(n));
    }
}




class RoundUpToThePreviousPowerOf2A3
{
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    // compute power of two less than or equal to n
    public static int previousPowerOf2(int n)
    {
        // drop all set bits from n except its last set bit
        return 1 << log(n, 2);
    }

    public static void main(String[] args)
    {
        int n = 20;
        System.out.println("Previous power of 2 is " + previousPowerOf2(n));
    }
}




class RoundUpToThePreviousPowerOf2A4
{
    // compute power of two less than or equal to n
    public static int previousPowerOf2(int n)
    {
        // Set all bits after the last set bit
        n = n | (n >> 1);
        n = n | (n >> 2);
        n = n | (n >> 4);
        n = n | (n >> 8);
        n = n | (n >> 16);

        // drop all bits but the last set bit from n
        return n - (n >> 1);
    }

    public static void main(String[] args)
    {
        int n = 131;

        System.out.println("Previous power of 2 is " + previousPowerOf2(n));
    }
}