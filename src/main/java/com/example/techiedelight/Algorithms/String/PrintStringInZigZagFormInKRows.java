package com.example.techiedelight.Algorithms.String;

class PrintStringInZigZagFormInKRows
{
    // Function to print given string in zig-zag form in k rows
    public static void printZigZag(String str, int k)
    {
        // base case
        if (k == 1) {
            System.out.print(str);
            return;
        }
 
        // print first row
        for (int i = 0; i < str.length(); i += (k-1)*2) {
            System.out.print(str.charAt(i));
        }
 
        // print middle rows
        for (int j = 1; j < k - 1; j++)
        {
            boolean down = true;
            for (int i = j; i < str.length();)
            {
                System.out.print(str.charAt(i));
                if (down) // going down
                    i += (k - j - 1) * 2;
                else // going up
                    i += (k - 1) * 2 - (k - j - 1) * 2;
 
                down = !down; // switch direction
            }
        }
 
        // print last row
        for (int i = k - 1; i < str.length(); i += (k - 1) * 2) {
            System.out.print(str.charAt(i));
        }
    }
 
    public static void main(String[] args)
    {
        String str = "THISPROBLEMISAWESOME";
        int k = 4;
 
        printZigZag(str, k);
    }
}