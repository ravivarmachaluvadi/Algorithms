package com.example.techiedelight.Algorithms.Binary;

class FindXOROfTwoNumbersWithoutUsingXOROperator
{
    // Function to find XOR of two numbers without using XOR operator
    public static int findBits(int x, int y)
    {
        return (x | y) - (x & y);
    }
 
    public static void main(String[] args)
    {
        int x = 65;
        int y = 80;
 
        System.out.println("First number in binary is  " + Integer.toBinaryString((x | y)));
        System.out.println("Second number in binary is " + Integer.toBinaryString((x & y)));
 
        System.out.println("\nXOR is " + Integer.toBinaryString(findBits(x, y)));
    }
}