package com.example.techiedelight.Algorithms.String;

class LongestEvenLengthPalindromicSumSubstring
{
    // Function to find maximum length of substring with equal sum
    // of left and right half
    public static int longestPalindrome(String str)
    {
        // sum[i] stores sum of digits of substring[0..i-1]
        int[] sum = new int[str.length() + 1];
 
        for (int i = 1; i <= str.length(); i++) {
            // '0' is subtracted to convert char to integer
            sum[i] = sum[i - 1] + (str.charAt(i - 1) - '0');
        }
 
        // stores maximum length of substring with equal sum
        // of left and right half
        int max = 0;
 
        // consider even length substring from index [i to j]
        for (int i = 0; i < str.length() - 1; i++)
        {
            for (int j = i+1; j < str.length(); j += 2)
            {
                // calculate length of the substring
                int range = j - i + 1;
 
                // find middle index of the substring
                int mid = i + range / 2;
 
                // if sum of left half and right half is same and length of
                // substring is more than maximum length found so far
                if ((sum[mid] - sum[i] == sum[j+1] - sum[mid])
                        && max < range) {
                    max = range;
                }
            }
        }
 
        return max;
    }
 
    public static void main(String[] args)
    {
        String str = "13267224";
 
        System.out.print("Longest length of palindromic sum substring is "
                + longestPalindrome(str));
    }
}




class LongestEvenLengthPalindromicSumSubstringA2
{
    // expand in both directions of low and high to find
    // maximum length palindrome
    public static int expand(String str, int low, int high, int max)
    {
        int leftsum = 0;
        int rightsum = 0;

        while (low >= 0 && high < str.length())
        {
            // update sum of left half and right half
            leftsum += str.charAt(low) - '0';
            rightsum += str.charAt(high) - '0';

            // update maximum length of palindrome if sum of left half
            // becomes same as sum of the right half
            if (leftsum == rightsum && (high - low + 1) > max) {
                max = high - low + 1;
            }

            // expand in both directions
            low--;
            high++;
        }

        return max;
    }

    // Function to find maximum length of substring with equal
    // sum of left and right half
    public static int longestPalindrome(String str)
    {
        // stores maximum length of substring with equal sum
        // of left and right half
        int max = 0;

        // an even length palindrome we will have two middle points

        // consider every adjacent pair of digits as mid points and
        // expand in both directions to find maximum length palindrome
        for (int i = 0; i < str.length() - 1; i++) {
            max = expand(str, i, i + 1, max);
        }

        return max;
    }

    public static void main(String[] args)
    {
        String str = "546374";

        System.out.print("Longest length of palindromic sum substring is "
                + longestPalindrome(str));
    }
}

