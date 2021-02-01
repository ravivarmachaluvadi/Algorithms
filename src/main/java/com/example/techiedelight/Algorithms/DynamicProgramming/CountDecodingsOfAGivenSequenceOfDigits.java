package com.example.techiedelight.Algorithms.DynamicProgramming;

class CountDecodingsOfAGivenSequenceOfDigits {
 
    // Function to count the total decodings of a given sequence of digits
    public static int count(char[] seq, int n)
    {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
 
        int sum = 0;
 
        // consider single-digit numbers (1, 2, … 8, 9)
        if (seq[n - 1] >= '1' && seq[n - 1] <= '9') {
            sum = count(seq, n - 1);
        }
 
        // consider 2-digit numbers (10, 11, … 19, 20, … 25, 26)
        if (seq[n - 2] == '1' || (seq[n - 2] == '2' && seq[n - 1] <= '6')) {
            sum += count(seq, n - 2);
        }
 
        return sum;
    }
 
    public static void main(String[] args)
    {
        int x = 1221;
 
        char[] chars = String.valueOf(x).toCharArray();
        System.out.println("The total number of decodings are " +
            count(chars, chars.length));
    }
}




class CountDecodingsOfAGivenSequenceOfDigitsA2 {

    // Function to count the total decodings of a given sequence of digits
    public static int count(int x)
    {
        // convert `x` to a string
        String seq = String.valueOf(x);

        // create an auxiliary array to store results to the subproblems
        int[] T = new int[seq.length() + 1];

        // base case
        T[0] = 1;
        T[1] = 1;

        // fill the auxiliary array `T[]` in a bottom-up manner
        for (int i = 2; i <= seq.length(); i++)
        {
            // consider single-digit numbers (1, 2, … 8, 9)
            if (seq.charAt(i - 1) > '0') {
                T[i] = T[i - 1];
            }

            // consider 2-digit numbers (10, 11, … 19, 20, … 25, 26)
            if (seq.charAt(i - 2) == '1' || (seq.charAt(i - 2) == '2' &&
                    seq.charAt(i - 1) <= '6')) {
                T[i] += T[i - 2];
            }
        }

        // last element in the auxiliary array stores the result
        return T[seq.length()];
    }

    public static void main(String[] args)
    {
        int x = 1221;

        System.out.println("The total number of decodings are " + count(x));
    }
}




class CountDecodingsOfAGivenSequenceOfDigitsA3 {

    // Function to count the total decodings of a given sequence of digits
    public static int count(int x)
    {
        // convert `x` to a sequence of digits
        char[] chars = String.valueOf(x).toCharArray();

        // keep track of the results of only the last two subproblems
        int prev_of_prev = 1;
        int prev = 1;

        for (int i = 2; i <= chars.length; i++)
        {
            int curr = 0;

            // consider single-digit numbers (1, 2, … 8, 9)
            if (chars[i - 1] > '0') {
                curr = prev;
            }

            // consider 2-digit numbers (10, 11, … 19, 20, … 25, 26)
            if (chars[i - 2] == '1' || (chars[i - 2] == '2' &&
                    chars[i - 1] <= '6')) {
                curr += prev_of_prev;
            }

            prev_of_prev = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args)
    {
        int x = 1221;
        System.out.println("The total number of decodings are " + count(x));
    }
}
