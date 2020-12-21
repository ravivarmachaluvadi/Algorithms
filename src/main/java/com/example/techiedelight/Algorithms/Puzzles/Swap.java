package com.example.techiedelight.Algorithms.Puzzles;

//Using Bitwise XOR(^) Operator
class Swap
{
    public static void main (String[] args)
    {
        int x = 5, y = 10;
        x = x ^ y ^ (y = x);
 
        System.out.println("Values of x and y after swapping are "
                            + x + " and " + y);
    }
}



//Using Addition and Subtraction Operator
class Swap2
{
    public static void main (String[] args)
    {
        int x = 5, y = 10;
        x = x + y - (y = x);

        System.out.println("Values of x and y after swapping are "
                + x + " and " + y);
    }
}




//Using Multiplication and Division Operator
class Swap3
{
    public static void main (String[] args)
    {
        int x = 5, y = 10;
        x = (x * y) / (y = x);

        System.out.println("Values of x and y after swapping are "
                + x + " and " + y);
    }
}