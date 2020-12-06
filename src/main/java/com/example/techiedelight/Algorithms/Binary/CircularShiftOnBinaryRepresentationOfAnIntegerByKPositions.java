package com.example.techiedelight.Algorithms.Binary;

class CircularShiftOnBinaryRepresentationOfAnIntegerByKPositions
{
    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n))
                       .replaceAll(" ", "0");
    }
 
    // Function to perform left circular shift or right circular
    // shift on integer n by k positions based on flag leftShift
    public static int circularShift(int n, int k, boolean leftShift)
    {
        // left shift by k
        if (leftShift) {
            return (n << k) | (n >> (Integer.SIZE - k));
        }
 
        // right shift by k
        return (n >> k) | (n << (Integer.SIZE - k));
    }
 
    public static void main(String[] args)
    {
        int n = 127;
        int shift = 3;
 
        System.out.println("No Shift    " + toBinaryString(n));
        System.out.println("Left Shift  " + toBinaryString(circularShift(n, shift, true)));
        System.out.println("Right Shift " + toBinaryString(circularShift(n, shift, false)));
    }
}


