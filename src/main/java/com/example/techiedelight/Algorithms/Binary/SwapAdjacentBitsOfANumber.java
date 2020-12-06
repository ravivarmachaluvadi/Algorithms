package com.example.techiedelight.Algorithms.Binary;

class SwapAdjacentBitsOfANumber
{
    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n))
                       .replaceAll(" ", "0");
    }
 
    // Function to swap adjacent bits of a given number
    public static int swapAdjacentBits(int n)
    {
        return (((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1));
    }
 
    public static void main(String[] args)
    {
        int n = 761622921;
 
        System.out.println(n + " in binary is " + toBinaryString(n));
        n = swapAdjacentBits(n);
        System.out.println("After swapping");
        System.out.println(n + " in binary is " + toBinaryString(n));
    }
}