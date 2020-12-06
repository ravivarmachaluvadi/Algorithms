package com.example.techiedelight.Algorithms.Binary;

class FindAbsoluteValueOfAnIntegerWithoutBranching
{
    public static void main(String[] args)
    {
        int n = -6;
        final int mask = n >> Integer.SIZE * 8 - 1;
 
        System.out.println("n (" + n + ") in binary is "
                            + Integer.toBinaryString(n));
 
        System.out.println("mask (" + mask + ") in binary is "
                            + Integer.toBinaryString(mask));
 
        System.out.println("n + mask (" + n + mask + ") in binary is "
                            + Integer.toBinaryString(n + mask));
 
        System.out.println("abs(" + n + ") is " + ((n + mask) ^ mask));
    }
}