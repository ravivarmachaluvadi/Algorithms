package com.example.techiedelight.Algorithms.String;

class FindAllNDigitBinaryNumbersHavingMore1SThan0SForAnyPrefix
{
    // Function to find all N-digit binary numbers having
    // more 1's than 0's at any position
    public static void find(String str, int n, int zeros, int ones)
    {
        // continue only if number of ones are more than equal
        // to number of zeroes
        if (ones < zeros) {
            return;
        }
 
        // if number becomes N-digit, print it
        if (n == 0)
        {
            System.out.println(str);
            return;
        }
 
        // append 1 to the result and recur with one less digit
        find(str + '1', n - 1, zeros, ones + 1);
 
        // append 0 to the result and recur with one less digit
        find(str + '0', n - 1, zeros + 1, ones);
    }
 
    public static void main(String[] args)
    {
        // given number of digits
        int n = 4;
 
        String str = "";
        find(str, n, 0, 0);
    }
}





class FindAllNDigitBinaryNumbersHavingMore1SThan0SForAnyPrefixA2
{
    // Function to find all N-digit binary numbers having
    // more 1's than 0's at any position
    public static void solution(String currentNumber, int extraOnes,
                                int remainingPlaces)
    {
        // If the number is completed, print it
        if (0 == remainingPlaces)
        {
            System.out.println(currentNumber);
            return;
        }

        // Append 1 to the current number and reduce the remaining places by one
        solution(currentNumber + '1', extraOnes + 1, remainingPlaces - 1);

        // If there are more ones than zeroes, append 0 to the current number
        // and reduce the remaining places by one
        if (0 < extraOnes)
        {
            solution(currentNumber + '0', extraOnes - 1, remainingPlaces - 1);
        }
    }

    public static void main(String[] args)
    {
        final int numberOfDigits = 4;
        String str = "";

        solution(str, 0, numberOfDigits);
    }
}

