package com.example.techiedelight.Algorithms.Binary;

class CheckIfGivenNumberIsPowerOf4OrNot
{
    // returns true if n is power of four
    public static boolean checkPowerof4(int n)
    {
        // find log4(n)
        double i = Math.log(n) / Math.log(4);
 
        // return true if log4(n) is an integer
        return i == Math.floor(i);
    }
 
    public static void main(String[] args)
    {
        int n = 256;
 
        if (checkPowerof4(n)) {
            System.out.println(n + " is power of 4");
        }
        else {
            System.out.println(n + " is not a power of 4");
        }
    }
}




class CheckIfGivenNumberIsPowerOf4OrNotA2
{
    // returns true if n is power of four
    public static boolean checkPowerof4(int n)
    {
        // return true if n is power of 2 and its only
        // set bit is present at even position
        return n != 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }

    public static void main(String[] args)
    {
        int n = 256;

        if (checkPowerof4(n)) {
            System.out.println(n + " is power of 4");
        }
        else {
            System.out.println(n + " is not a power of 4");
        }
    }
}




class CheckIfGivenNumberIsPowerOf4OrNotA3
{
    // returns true if n is power of four
    public static boolean checkPowerof4(int n)
    {
        // return true if n is power of 2 and
        // remainder is 1 when it is divided by 3
        return ((n & (n - 1)) == 0) && (n % 3 == 1);
    }

    public static void main(String[] args)
    {
        int n = 256;

        if (checkPowerof4(n)) {
            System.out.println(n + " is power of 4");
        }
        else {
            System.out.println(n + " is not a power of 4");
        }
    }
}