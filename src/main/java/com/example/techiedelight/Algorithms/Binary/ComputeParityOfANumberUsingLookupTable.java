package com.example.techiedelight.Algorithms.Binary;

class ComputeParityOfANumberUsingLookupTable
{
    // Function to find parity of number x
    public static boolean findParity(int x)
    {
        // Hexacedimal to Binary conversion can be checked here
        // www.binaryhexconverter.com/hex-to-binary-converter
 
        // recursively divide the (32-bit) integer into two equal
        // halves and take their XOR until only 1 bit is left
 
        x = (x & 0x0000FFFF)^(x >> 16);
        x = (x & 0x000000FF)^(x >> 8);
        x = (x & 0x0000000F)^(x >> 4);
        x = (x & 0x00000003)^(x >> 2);
        x = (x & 0x00000001)^(x >> 1);
 
        // return the last bit
        return (x & 1) == 1;
    }
 
    public static void main(String[] args)
    {
        int x = 127;
 
        System.out.println(x + " in binary is " + Integer.toBinaryString(x));
 
        if (findParity(x)) {
            System.out.println(x + " contains odd bits");
        }
        else {
            System.out.println(x + " contains even bits");
        }
    }
}




class ComputeParityOfANumberUsingLookupTableA2
{
    // Function to find parity of number x
    public static boolean findParity(int x)
    {
        // recursively divide the (32-bit) integer into two equal
        // halves and take their XOR until only 1 bit is left

        x ^= x >> 16;
        x ^= x >> 8;
        x ^= x >> 4;
        x ^= x >> 2;
        x ^= x >> 1;

        // return the last bit
        return (x & 1) == 1;
    }

    public static void main(String[] args)
    {
        int x = 15;

        System.out.println(x + " in binary is " + Integer.toBinaryString(x));

        if (findParity(x)) {
            System.out.println(x + " contains odd number of bits");
        }
        else {
            System.out.println(x + " contains even number of bits");
        }
    }
}