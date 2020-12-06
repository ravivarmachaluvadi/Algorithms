package com.example.techiedelight.Algorithms.Binary;

class BitHacksPart1
        {
    public static void main(String[] args) {
        int n = 5;
 
        if ((n & 1) == 1) {
            System.out.println(n + " is odd");
        } else {
            System.out.println(n + " is even");
        }
    }
}



// Detect if two integers have opposite signs or not
class DetectIfTwoIntegersHaveOppositeSignsOrNot
{
    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n))
                .replaceAll(" ", "0");
    }

    public static void main(String[] args)
    {
        int x = 4;
        int y = -8;

        System.out.println(x + " in binary is  " + toBinaryString(x));
        System.out.println(y + " in binary is " + toBinaryString(y));

        // true if x and y have opposite signs
        boolean isOpposite = ((x ^ y) < 0);

        if (isOpposite) {
            System.out.println(x + " and " + y + " have opposite signs");
        }
        else {
            System.out.println(x + " and " + y + " don't have opposite signs");
        }
    }
}



class Add1ToAGivenInteger
{
    public static void main(String[] args)
    {
        int x = 4;
        System.out.println(x + " + " + 1 + " is " + -~x);

        x = -5;
        System.out.println(x + " + " + 1 + " is " + -~x);

        x = 0;
        System.out.println(x + " + " + 1 + " is " + -~x);
    }
}


//Swap two numbers without using any third variable
/*
#include <iostream>
using namespace std;

        void swap(int &x, int &y)
        {
        if (x != y)
        {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        }
        }

        int main()
        {
        int x = 3, y = 4;

        cout << "Before swap: x = " << x << " and y = " << y;
        swap(x, y);
        cout << "\nAfter swap: x = " << x << " and y = " << y;

        return 0;
        }
        */
