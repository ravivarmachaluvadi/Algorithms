package com.example.techiedelight.Algorithms.String;

class FindAllNDigitBinaryNumbersWithEqualSumOfBitsInItsTwoHalves
{
    // Function to find all N-digit binary numbers with equal sum of first
    // and second half bits in Bottom-up manner
    public static void recur(String left, String right, int n, int diff)
    {
        // return if invalid
        if (n > 9) {
            return;
        }
 
        // if number is less than N-digit and we can cover the difference
        // with n-digits left
        if (n > 0 && (2 * Math.abs(diff) <= n))
        {
            // if N is odd, recur with mid as '0' and '1'
            if (n == 1)
            {
                recur(left, '0' + right, 0, diff);
                recur(left, '1' + right, 0, diff);
                return;
            }
 
            // special case - binary number should not start with 0
            if (!left.equals(""))
            {
                // append 0 to both left and right half
                // both left and right sum remains unchanged
                recur(left + '0', right + '0', n - 2, diff);
 
                // append 0 to left half and 1 to the right half
                // minus 1 from diff as right sum is increased by 1
                recur(left + '0', right + '1', n - 2, diff - 1);
            }
 
            // append 1 to left half and 0 to the right half
            // add 1 to diff as left sum is increased by 1
            recur(left + '1', right + '0', n - 2, diff + 1);
 
            // append 1 to both left and right half
            // both left and right sum remains unchanged
            recur(left + '1', right + '1', n - 2, diff);
        }
 
        // if number becomes N-digit with equal sum of left and right
        // digits, print it
        else if (n == 0 && diff == 0) {
            System.out.print(left + right + " ");
        }
    }
 
    public static void main(String[] args)
    {
        // N-digit number
        final int n = 6;
 
        // stores left and right half of binary number
        String left = "", right = "";
 
        // difference between left and right half
        int diff = 0;
 
        recur(left, right, n, diff);
    }
}