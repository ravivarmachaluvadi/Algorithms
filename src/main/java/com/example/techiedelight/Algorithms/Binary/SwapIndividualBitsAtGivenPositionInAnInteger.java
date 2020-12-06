package com.example.techiedelight.Algorithms.Binary;

class SwapIndividualBitsAtGivenPositionInAnInteger
{
    public static String toBinaryString(int n) {
        return String.format("%8s", Integer.toBinaryString(n))
                       .replaceAll(" ", "0");
    }
 
    // Function to swap b-bits starting from position p and q in an integer n
    public static int swap(int n, int p, int q, int b)
    {
        // take XOR of bits to be swapped
        int x = ((n >> p) ^ (n >> q));
 
        // consider only last b-bits of x
        x = x & ((1 << b) - 1);
 
        // replace the bits to be swapped with the XOR bits
        // and take its XOR with n
        return n ^ ((x << p) | (x << q));
    }
 
    public static void main(String[] args)
    {
        int n = 15;
        int p = 2, q = 5; // (3rd and 6th bit from the right)
        int b = 2;    // number of consecutive bits in each sequence
 
        System.out.println(n + " in binary is " + toBinaryString(n));
        n = swap (n, p, q, b);
        System.out.println(n + " in binary is " + toBinaryString(n));
    }
}