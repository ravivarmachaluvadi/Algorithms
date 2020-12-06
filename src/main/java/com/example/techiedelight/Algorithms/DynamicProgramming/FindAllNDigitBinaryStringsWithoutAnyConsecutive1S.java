package com.example.techiedelight.Algorithms.DynamicProgramming;

class FindAllNDigitBinaryStringsWithoutAnyConsecutive1S
{
    // count all n-digit binary strings without any consecutive 1’s
    public static int countStrings(int n, int lastDigit)
    {
        // base case
        if (n == 0) {
            return 0;
        }
 
        // if only one digit is left
        if (n == 1) {
            return (lastDigit == 1) ? 1: 2;
        }
 
        // if last digit is 0, we can have both 0 and 1 at current pos
        if (lastDigit == 0) {
            return countStrings(n - 1, 0) + countStrings(n - 1, 1);
        }
        // if last digit is 1, we can have only 0 at current position
        else {
            return countStrings(n - 1, 0);
        }
    }
 
    public static void main(String[] args)
    {
        // given number of digits
        int n = 5;
 
        System.out.println("Number of " + n + "-digit binary strings " +
                "without any consecutive 1’s are " + countStrings(n, 0));
    }
}




class FindAllNDigitBinaryStringsWithoutAnyConsecutive1SA2
{
    // count all n-digit binary strings without any consecutive 1's
    public static int countStrings(int n)
    {
        int[][] T = new int[n+1][2];

        // if only one digit is left
        T[1][0] = 2;
        T[1][1] = 1;

        for (int i = 2; i <= n; i++)
        {
            // if last digit is 0, we can have both 0 and 1 at current pos
            T[i][0] = T[i-1][0] + T[i-1][1];

            // if last digit is 1, we can have only 0 at current position
            T[i][1] = T[i-1][0];
        }

        return T[n][0];

    }

    public static void main(String[] args)
    {
        // given number of digits
        int n = 5;

        System.out.print("Number of " + n + "-digit binary strings " +
                "without any consecutive 1's are " + countStrings(n));
    }
}




class FindAllNDigitBinaryStringsWithoutAnyConsecutive1SA3
{
    // print all n-digit binary strings without any consecutive 1's
    public static void countStrings(int n, String out, int last_digit)
    {
        // if number becomes N-digit, print it
        if (n == 0)
        {
            System.out.println(out);
            return;
        }

        // append 0 to the result and recur with one less digit
        countStrings(n - 1, out + '0', 0);

        // append 1 to the result and recur with one less digit
        // only if last digit is 0
        if (last_digit == 0) {
            countStrings(n - 1, out + '1', 1);
        }
    }

    public static void main(String[] args)
    {
        // given number of digits
        int n = 5;
        String out = "";

        countStrings(n, out, 0);
    }
}