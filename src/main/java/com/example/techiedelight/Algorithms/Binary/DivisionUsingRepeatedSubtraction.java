package com.example.techiedelight.Algorithms.Binary;

//Perform Division of two numbers without using division operator (/)

class DivisionUsingRepeatedSubtraction
{
    // Function to perform division (x / y) of two numbers x and y without
    // using division operator in the code
    public static int divide(int x, int y)
    {
        // handle divisibility by 0
        if (y == 0)
        {
            System.out.printf("Error!! Divisible by 0");
            System.exit(1);
        }
 
        // store sign of the result
        int sign = 1;
        if (x * y < 0) {
            sign = -1;
        }
 
        // convert both dividend and divisor to positive
        x = Math.abs(x);
        y = Math.abs(y);
 
        // initialize quotient by 0
        int quotient = 0;
 
        // loop till dividend x is more than the divisor y
        while (x >= y) {
            x = x - y;        // perform reduction on dividend
            quotient++;        // increase quotient by 1
        }
 
        System.out.println("Remainder is " + x);
        return sign * quotient;
    }
 
    // main function to perform division of two numbers
    public static void main(String[] args)
    {
        int dividend = 22;
        int divisor = -7;
 
        System.out.println("Quotient is " + divide(dividend, divisor));
    }
}




//Recursive version of above one
class DivisionUsingRepeatedSubtractionRecursive
{
    // Recursive function to perform division (x / y) of two positive numbers
    // x and y without using division operator in the code
    public static int division(int x, int y)
    {
        if (x < y) {
            System.out.printf("Remainder is %d\n", x);
            return 0;
        }

        return 1 + division(x - y, y);
    }

    // Wrapper over division() function to handle negative dividend or divisor
    public static int divide(int x, int y)
    {
        // handle divisibility by 0
        if (y == 0)
        {
            System.out.printf("Error!! Divisible by 0");
            System.exit(1);
        }

        // store sign of the result
        int sign = 1;
        if (x * y < 0)
            sign = -1;

        return sign * division(Math.abs(x), Math.abs(y));
    }

    // main function to perform division of two numbers
    public static void main(String[] args)
    {
        int dividend = 22;
        int divisor = -7;

        System.out.printf("Quotient is %d\n", divide(dividend, divisor));
    }
}




class DivisionUsingRepeatedSubtractionA3
{
    // Function to perform division (x / y) of two numbers x and y
    // without using division operator in the code
    public static int divide(int x, int y)
    {
        // handle divisibility by 0
        if (y == 0) {
            System.out.printf("Error!! Divisible by 0");
            System.exit(1);
        }

        // store sign of the result
        int sign = 1;
        if (x * y < 0) {
            sign = -1;
        }

        // convert both dividend and divisor to positive
        x = Math.abs(x);
        y = Math.abs(y);

        // initialize denominator by y
        int denominator = y;

        // initialize quotient by 1
        int quotient = 1;

        // Double denominator and quotient value until denominator is more than
        // the dividend x
        while (x > denominator)
        {
            denominator *= 2;
            quotient *= 2;
        }

        // Subtract divisor y from denominator and reduce quotient by 1 until
        // denominator is less than the dividend x
        while (denominator > x)
        {
            denominator -= y;
            quotient -= 1;
        }

        System.out.println("Remainder is " + (x - denominator));
        return sign * quotient;
    }

    // main function to perform division of two numbers
    public static void main(String[] args)
    {
        int dividend = 22;
        int divisor = -7;

        System.out.println("Quotient is " + divide(dividend, divisor));
    }
}




class DivisionUsingBinaryOperator
{
    // Function to perform division (x / y) of two numbers x and y
    // without using division operator in the code
    public static int divide(int x, int y)
    {
        // handle divisibility by 0
        if (y == 0)
        {
            System.out.printf("Error!! Divisible by 0");
            System.exit(1);
        }

        // store sign of the result
        int sign = 1;
        if (x * y < 0) {
            sign = -1;
        }

        // convert both dividend and divisor to positive
        x = Math.abs(x);
        y = Math.abs(y);

        int mask = 1;
        int quotient = 0;

        while (y <= x) {
            y <<= 1;
            mask <<= 1;
        }

        while (mask > 1) {
            y >>= 1;
            mask >>= 1;
            if (x >= y) {
                x -= y;
                quotient |= mask;
            }
        }

        System.out.printf("Remainder is %d\n", x);
        return sign * quotient;
    }

    // Division of two numbers using low level bits
    public static void main(String[] args)
    {
        int dividend = 22;
        int divisor = -7;

        System.out.printf("Quotient is %d\n", divide(dividend, divisor));
    }
}