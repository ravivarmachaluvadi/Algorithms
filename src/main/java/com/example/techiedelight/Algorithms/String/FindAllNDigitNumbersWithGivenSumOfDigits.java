package com.example.techiedelight.Algorithms.String;

class FindAllNDigitNumbersWithGivenSumOfDigits
{
    // Function to find all N-digit numbers with sum of digits equal to sum
    // in Bottom-up manner
    public static void findNdigitNums(String res, int n, int sum)
    {
        // if number is less than N-digit and its sum of digits is
        // less than the given sum
        if (n > 0 && sum >= 0)
        {
            char d = '0';
            if (res.equals("")) {    // special case - number can't start from 0
                d = '1';
            }
 
            // consider every valid digit and put it in the current index
            // and recur for next index
            while (d <= '9') {
                findNdigitNums(res + d, n - 1, sum - (d - '0'));
                d++;
            }
        }
 
        // if number becomes N-digit and its sum of digits is
        // equal to given sum, print it
        else if (n == 0 && sum == 0) {
            System.out.print(res + " ");
        }
    }
 
    public static void main(String[] args)
    {
        int n = 3;            // N-digit
        int sum = 6;        // given sum
 
        String res = "";
        findNdigitNums(res, n, sum);
    }
}