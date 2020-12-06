package com.example.techiedelight.Algorithms.Binary;

class CheckIfAdjacentBitsAreSetInBinaryRepresentationOfAGivenNumber
{
    // return true if adjacent bits are set in binary representation of n
    public static boolean check(int n) {
        return (n & (n << 1)) != 0;
    }
 
    public static void main(String[] args)
    {
        int n = 67;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
 
        if (check(n)) {
            System.out.println("Adjacent pair of set bits found");
        }
        else {
            System.out.println("No adjacent pair of set bits found");
        }
    }
}