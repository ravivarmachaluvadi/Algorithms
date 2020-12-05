package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
 
class PrintAllCombinationOfNumbersFrom1ToNHavingSumN
{
    // Recursive function to print all combination of numbers from i to n
    // having sum n. index denotes the next free slot in output array out
    public static void recur(int i, int n, int[] out, int index)
    {
        // if sum becomes n, print the combination
        if (n == 0) {
            System.out.println(Arrays.stream(out).limit(index)
                    .boxed().collect(Collectors.toList()));
        }
 
        // start from previous element in the combination till n
        for (int j = i; j <= n; j++)
        {
            // place current element at current index
            out[index] = j;
 
            // recur with reduced sum
            recur(j, n - j, out, index + 1);
        }
    }
 
    public static void main(String[] args)
    {
        int n = 5;
        int[] out = new int[n];
 
        // print all combination of numbers from 1 to n having sum n
        recur(1, n, out, 0);
    }
}


