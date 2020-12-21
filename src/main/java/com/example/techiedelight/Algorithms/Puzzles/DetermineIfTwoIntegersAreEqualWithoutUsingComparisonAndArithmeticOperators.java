package com.example.techiedelight.Algorithms.Puzzles;

import java.util.HashMap;
import java.util.Map;

//Using Bitwise XOR operator
class DetermineIfTwoIntegersAreEqualWithoutUsingComparisonAndArithmeticOperators
{
    // Determine if two integers are equal without using comparison operators
    // and arithmetic operators
    public static boolean checkForEquality(int x, int y)
    {
        return (x ^ y) == 0;
    }
 
    public static void main(String[] args) {
        int x = 10, y = 10;
 
        if (checkForEquality(x, y)) {
            System.out.printf("x=%d is equal to y=%d\n", x, y);
        } else {
            System.out.printf("x=%d is not equal to y=%d\n", x, y);
        }
    }
}




//Using Array Index + Ternary Operator
class DetermineIfTwoIntegersAreEqualWithoutUsingComparisonAndArithmeticOperatorsA2
{
    // Determine if two integers are equal without using comparison operators
    // and arithmetic operators
    public static boolean checkForEquality(int x, int y)
    {
        short[] arr = new short[x+1];
        arr[x] = 0;

        return (arr[y] == 0);
    }

    public static void main(String[] args)
    {
        int x = 10, y = 10;

        if (checkForEquality(x, y)) {
            System.out.printf("x=%d is equal to y=%d\n", x, y);
        }
        else {
            System.out.printf("x=%d is not equal to y=%d\n", x, y);
        }
    }
}





class DetermineIfTwoIntegersAreEqualWithoutUsingComparisonAndArithmeticOperatorsA3
{
    // Determine if two integers are equal without using comparison operators
    // and arithmetic operators
    public static boolean checkForEquality(int x, int y)
    {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(x, true);

        return map.containsKey(y);
    }

    public static void main(String[] args)
    {
        int x = 0, y = 2;

        if (checkForEquality(x, y)) {
            System.out.print("x is equal to y");
        }
        else {
            System.out.print("x is not equal to y");
        }
    }
}





class DetermineIfTwoIntegersAreEqualWithoutUsingComparisonAndArithmeticOperatorsA4
{
    // Determine if two integers are equal without using comparison operators
    // and arithmetic operators
    public static boolean checkForEquality(int x, int y)
    {
        while (--x > 0 && --y > 0);
        return !(x != 0 || y - 1 != 0);
    }

    public static void main(String[] args)
    {
        int x = 5, y = 8;

        if (checkForEquality(x, y)) {
            System.out.printf("x=%d is equal to y=%d\n", x, y);
        }
        else {
            System.out.printf("x=%d is not equal to y=%d\n", x, y);
        }
    }
}






class DetermineIfTwoIntegersAreEqualWithoutUsingComparisonAndArithmeticOperatorsA5
{
    // Determine if two integers are equal without using comparison operators
    public static boolean checkForEquality(int x, int y)
    {
        return (x - y) == 0;
    }

    public static void main(String[] args) {
        int x = 10, y = 10;

        if (checkForEquality(x, y)) {
            System.out.printf("x=%d is equal to y=%d\n", x, y);
        } else {
            System.out.printf("x=%d is not equal to y=%d\n", x, y);
        }
    }
}

