package com.example.techiedelight.Algorithms.Binary;

//Bit Hacks – Part 2 (Playing with k’th bit)

//Turn off k’th bit in a number
class BitHacksPart2
{
    // Function to turn off k'th bit in n
    public static int turnOffKthBit(int n, int k) {
        return n & ~(1 << (k - 1));
    }
 
    public static void main(String[] args)
    {
        int n = 20;
        int k = 3;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Turning k'th bit off..");
        n = turnOffKthBit(n, k);
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
    }
}


//Turn on k’th bit in a number
class TurnOnKThBitInANumber
{
    // Function to turn on k'th bit in n
    public static int turnOnKthBit(int n, int k)
    {
        return n | (1 << (k - 1));
    }

    public static void main(String[] args)
    {
        int n = 20;
        int k = 4;

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Turning k'th bit on..");
        n = turnOnKthBit(n, k);
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
    }
}



//Check if k’th bit is set for a number
class CheckIfKThBitIsSetForANumber
{
    // Function to check if k'th bit is set for n or not
    public static boolean isKthBitset(int n, int k) {
        return (n & (1 << (k - 1))) != 0;
    }

    public static void main(String[] args)
    {
        int n = 20;
        int k = 3;

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));

        if (isKthBitset(n, k)) {
            System.out.println("k-th bit is set");
        }
        else {
            System.out.println("k-th bit is not set");
        }
    }
}



//Toggle the k-th bit
class ToggleTheKThBit
{
    // Function to toggle k'th bit of n
    public static int toggleKthBit(int n, int k)
    {
        return n ^ (1 << (k - 1));
    }

    public static void main(String[] args)
    {
        int n = 20;
        int k = 3;

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Toggling k'th bit of n..");
        n = toggleKthBit(n, k);

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
    }
}