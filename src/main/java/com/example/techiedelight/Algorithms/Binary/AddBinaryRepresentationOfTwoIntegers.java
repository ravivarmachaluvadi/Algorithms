package com.example.techiedelight.Algorithms.Binary;

class AddBinaryRepresentationOfTwoIntegers
{
    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n))
                       .replaceAll(" ", "0");
    }
 
    // Function to add x and y in binary
    public static int[] add(int x, int y)
    {
        int carry = 0;
        int n = Integer.SIZE;
 
        // create an array to store binary sum
        int[] arr = new int[n];
 
        for (int i = 0; i < n; i++)
        {
            // if x is 1
            if ((x & (1 << i)) != 0)
            {
                if ((y & (1 << i)) != 0) // if both x and y are 1
                {
                    if (carry == 1) {
                        arr[n - i - 1] = 1; // carry = 1
                    } else
                    {
                        arr[n - i - 1] = 0;
                        carry = 1;
                    }
                }
                else // x is 1, y is 0
                {
                    if (carry == 1) {
                        arr[n - i - 1] = 0; // carry = 1
                    }
                    else {
                        arr[n - i - 1] = 1; // carry = 0
                    }
                }
            }
            // if x is 0
            else
            {
                if ((y & (1 << i)) != 0) // x is 0, y is 1
                {
                    if (carry == 1) {
                        arr[n - i - 1] = 0; // carry = 1
                    }
                    else {
                        arr[n - i - 1] = 1; // carry = 0
                    }
                }
                else // both x and y are 0
                {
                    if (carry == 1) {
                        arr[n - i - 1] = 1;
                        carry = 0;
                    }
                    else {
                        arr[n - i - 1] = 0; // carry = 0
                    }
                }
            }
        }
 
        return arr;
    }
 
    public static void main(String[] args)
    {
        int x = 12731, y = 38023;
 
        System.out.println("x (" + x + ") in binary is " + toBinaryString(x));
        System.out.println("y (" + y + ") in binary is " + toBinaryString(y));
 
        int[] arr = add(x, y);
 
        System.out.print("x + y is ");
        for (int i = 0; i < Integer.SIZE; i++) {
            System.out.printf("%d", arr[i]);
        }
    }
}