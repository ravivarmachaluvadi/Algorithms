package com.example.techiedelight.Algorithms.Binary;
//Bit Hacks – Part 3 (Playing with rightmost set bit of a number)

//Find position of the rightmost set bit
class BitHacksPart3
{
    // returns position of the rightmost set bit of n
    public static int rightmostSetBitPos(int n)
    {
        // if number is odd, return 1
        if ((n & 1) == 1) {
            return 1;
        }
 
        // unset rightmost bit and xor with number itself
        n = n ^ (n & (n - 1));
 
        // System.out.println(Integer.toBinaryString(n));
 
        // find the position of the only set bit in the result
        // we can directly return log2(n) + 1 from the function
        int pos = 0;
        while (n != 0)
        {
            n = n >> 1;
            pos++;
        }
 
        return pos;
    }
 
    public static void main(String[] args)
    {
        int n = 20;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Position of the rightmost set bit is " +
                            rightmostSetBitPos(n));
    }
}



class AlternateSolution
{
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    // returns position of the rightmost set bit of n
    public static int rightmostSetBitPos(int n)
    {
        // if number is odd, return 1
        if ((n & 1) == 1) {
            return 1;
        }

        return log(n & -n, 2) + 1;
    }

    public static void main(String[] args)
    {
        int n = 20;

        System.out.println("Position of the rightmost set bit is " +
                rightmostSetBitPos(n));
    }
}




class FindPositionOfTheOnlySetBitInANumber
{
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    // returns position of the only set bit of n
    public static int setBitPos(int n)
    {
        // unset rightmost bit and check if the number is non-zero
        if ((n & (n - 1)) == 1)
        {
            System.out.println("Wrong input");
            return 1;
        }

        return log(n, 2) + 1;
    }

    public static void main(String[] args)
    {
        int n = 16;

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Position of the only set bit is " + setBitPos(n));
    }
}



//(NaiveSolution)
class ComputingParityOfANumber
{
    // find parity of number n
    public static boolean findParity(int n)
    {
        boolean parity = false;

        // run till n is zero
        while (n != 0)
        {
            // invert the parity flag
            if ((n & 1) == 1) {
                parity = !parity;
            }

            // right shift n by 1 (divide by 2)
            n = n >> 1;
        }

        return parity;
    }

    public static void main(String[] args)
    {
        int n = 31;

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));

        if (findParity(n)) {
            System.out.println("Parity of " + n + " is odd");
        }
        else {
            System.out.println("Parity of " + n + " is even");
        }
    }
}




class Main2
{
    public static boolean findParity(int n)
    {
        boolean parity = false;

        // run till n is zero
        while (n != 0)
        {
            // invert the parity flag
            parity = !parity;

            // turn off rightmost set bit
            n = n & (n - 1);
        }

        return parity;
    }

    public static void main(String[] args)
    {
        int n = 31;

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));

        if (findParity(n)) {
            System.out.println("Parity of " + n + " is odd");
        } else {
            System.out.println("Parity of " + n + " is even");
        }
    }
}