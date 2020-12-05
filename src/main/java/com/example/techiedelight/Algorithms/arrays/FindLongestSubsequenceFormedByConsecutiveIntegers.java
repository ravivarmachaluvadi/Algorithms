package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
 
import java.util.stream.Collectors;
import java.util.stream.IntStream;
 
class FindLongestSubsequenceFormedByConsecutiveIntegers
{
    // Function to find the length of largest subsequence formed by consecutive integers
    public static int findMaxLenSubSeq(int[] arr)
    {
        // construct a set out of input elements
        Set<Integer> S = IntStream.of(arr)      // returns IntStream
                                .boxed()
                                .collect(Collectors.toSet());
 
        // initialize result by 1
        int maxLen = 1;
 
        // do for each element of the input sequence
        for (int e: arr)
        {
            // check if current element e is candidate for starting of a sequence
            // i.e. previous element (e - 1) don't exist in the set
            if (!S.contains(e - 1))
            {
                // len stores the length of subsequence starting with current element
                int len = 1;
 
                // check for presence of elements e+1, e+2, e+3.. e+len in the set
                while (S.contains(e + len)) {
                    len++;
                }
 
                // update the result with the length of current consecutive subsequence
                maxLen = Math.max(maxLen, len);
            }
        }
 
        // return result
        return maxLen;
    }
 
    public static void main (String[] args)
    {
        int[] arr = { 2, 0, 6, 1, 5, 3, 7 };
 
        System.out.println("The length of maximum length consecutive subsequence is " +
                findMaxLenSubSeq(arr));
    }
}