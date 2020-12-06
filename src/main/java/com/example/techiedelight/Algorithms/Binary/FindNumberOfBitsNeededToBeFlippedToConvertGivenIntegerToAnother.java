package com.example.techiedelight.Algorithms.Binary;


class FindNumberOfBitsNeededToBeFlippedToConvertGivenIntegerToAnother
{
    // Find number of bits needed to be flipped to convert x to y
    public static int findBits(int x, int y)
    {
        // take XOR of x and y and store in n
        int n = x ^ y;
 
        // Using Brian Kernighan's algorithm to count set bits
 
        // count stores the total bits set in n
        int count = 0;
 
        while (n != 0){
            n = n & (n - 1); // clear the least significant bit set
            count++;
        }
 
        return count;
    }
 
    public static void main(String[] args)
    {
        int x = 65;
        int y = 80;
 
        System.out.println(x + " in binary is " + Integer.toBinaryString(x));
        System.out.println(y + " in binary is " + Integer.toBinaryString(y));
 
        System.out.println("\nThe number of bits flipped is " + findBits(x, y));
    }
}



class CheckIfBinaryRepresentationOfANumberIsPalindromeOrNot
{
    // return true if binary representation of n is a palindrome
    public static boolean isPalindrome(int n)
    {
        // rev stores reverse of binary representation of n
        int rev = 0;

        // do till all bits of n are processed
        int k = n;
        while (k > 0)
        {
            // add rightmost bit to rev
            rev = (rev << 1) | (k & 1);
            k = k >> 1;        // drop last bit
        }

        // return true if reverse(n) is same as n
        return n == rev;
    }

    public static void main(String[] args)
    {
        int n = 9;    // 1001

        if (isPalindrome(n)) {
            System.out.println(n + " is Palindrome");
        }
        else {
            System.out.println(n + " is not a Palindrome");
        }
    }
}