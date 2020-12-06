package com.example.techiedelight.Algorithms.Binary;

class ReverseBitsOfAGivenInteger
{
    // Function to reverse bits of a given integer
    public static int reverseBits(int n)
    {
        int pos = Integer.SIZE - 1;        // maintains shift
 
        // store reversed bits of n. Initially all bits are set to 0
        int reverse = 0;
 
        // do till all bits are processed
        while (pos >= 0 && n != 0)
        {
            // if current bit is 1, then set corresponding bit in result
            if ((n & 1) != 0) {
                reverse = reverse | (1 << pos);
            }
 
            n >>= 1;    // drop current bit (divide by 2)
            pos--;        // decrement shift by 1
        }
 
        return reverse;
    }
 
    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n))
                       .replaceAll(" ", "0");
    }
 
    public static void main(String[] args)
    {
        int n = -100;
 
        System.out.println(n + " in binary is " + toBinaryString(n));
        System.out.println("On reversing bits " + toBinaryString(reverseBits(n)));
    }
}




class ReverseBitsOfAGivenIntegerA2
{
    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n))
                .replaceAll(" ", "0");
    }

    public static double log(int x, int base) {
        return (Math.log(x) / Math.log(base));
    }

    // Function to reverse bits of a given integer
    public static int reverseBits(int n)
    {
        // store reversed bits of n. Initially all bits are set to 0
        int reverse = 0;

        // do till all set bits are processed
        while (n != 0)
        {
            // find position of the rightmost set bit
            double pos = log(n & -n, 2) + 1;

            // set corresponding bit in result (set leftmost bit at position pos)
            reverse = reverse | (1 << (Integer.SIZE - (int)pos));

            // unset the rightmost set bit of a number
            n = n & (n - 1);
        }

        return reverse;
    }

    public static void main(String[] args)
    {
        int n = -100;

        System.out.println(n + " in binary is " + toBinaryString(n));
        System.out.println("On reversing bits " + toBinaryString(reverseBits(n)));
    }
}



