package com.example.techiedelight.Algorithms.Binary;

class CheckIfGivenNumberIsPowerOf8OrNot
{
    // returns true if n is power of 8
    public static boolean checkPowerof8(int n)
    {
        // find log8(n)
        double i = Math.log(n) / Math.log(8);
 
        // return true if log8(n) is an integer
        return i - Math.floor(i) < 0.000001;
    }
 
    public static void main(String[] args)
    {
        int n = 512*64;
 
        if (checkPowerof8(n)) {
            System.out.println(n + " is power of 8");
        }
        else {
            System.out.println(n + " is not a power of 8");
        }
    }
}



class CheckIfGivenNumberIsPowerOf8OrNotA2
{
    // returns true if n is power of 8
    public static boolean checkPowerof8(int n)
    {
        // return true if n is power of 2 and its only
        // set bit is present at (0, 3, 6, ... ) position
        return n != 0 && (n & (n - 1)) == 0 && (n & 0xB6DB6DB6) == 0;
    }

    public static void main(String[] args)
    {
        int n = 512;

        if (checkPowerof8(n)) {
            System.out.println(n + " is power of 8");
        }
        else {
            System.out.println(n + " is not a power of 8");
        }
    }
}