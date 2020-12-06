package com.example.techiedelight.Algorithms.Binary;

class SwapTwoBitsAtGivenPositionInAnInteger
{
    // Function to swap bits are position p and q in integer n
    public static int swap(int n, int p, int q)
    {
        // if bits are different at position p and q
        if ((((n & (1 << p)) >> p) ^ ((n & (1 << q)) >> q)) == 1)
        {
            n ^= (1 << p);
            n ^= (1 << q);
        }
        return n;
    }
 
    public static void main (String[] args)
    {
        int n = 31;
        int p = 2, q = 6;    // (3rd and 7th bit from the right)
 
        System.out.println(n + " in binary is " +
                String.format("%08d", Integer.parseInt(Integer.toBinaryString(n))));
 
        n = swap (n, p, q);
 
        System.out.println(n + " in binary is " +
                String.format("%08d", Integer.parseInt(Integer.toBinaryString(n))));
    }
}