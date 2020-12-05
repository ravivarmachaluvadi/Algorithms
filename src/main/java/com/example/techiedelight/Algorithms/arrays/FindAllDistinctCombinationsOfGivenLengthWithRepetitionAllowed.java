package com.example.techiedelight.Algorithms.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

class FindAllDistinctCombinationsOfGivenLengthWithRepetitionAllowed
{
    // Function to print all distinct combinations of length k where
    // repetition of elements is allowed
    public static void recur(int[] A, Deque<Integer> out,
                             int k, int i, int n)
    {
        // base case: if combination size is k, print it
        if (out.size() == k)
        {
            System.out.println(out);
            return;
        }
 
        // start from previous element in the current combination
        // till last element
        for (int j = i; j < n; j++)
        {
            // add current element A[j] to the solution and recur with
            // same index j (as repeated elements are allowed in combinations)
            out.addLast(A[j]);
            recur(A, out, k, j, n);
 
            // backtrack - remove current element from solution
            out.pollLast();
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 1 };
        int k = 2;
 
        Deque<Integer> out = new ArrayDeque<>();
        recur(A, out, k, 0, A.length);
    }
}



class FindAllDistinctCombinationsOfGivenLengthWithRepetitionAllowedOpti
{
    // Function to print all distinct combinations of length k where
    // repetition of elements is allowed
    public static void recur(int[] A, int k, int i, Stack<Integer> output)
    {
        // base case: if combination size is k, print it
        if (output.size() == k) {
            System.out.println(output);
            return;
        }

        // start from previous element in the current combination
        // till last element
        for (int j = i; j < A.length; j++)
        {
            // add current element A[j] to the solution and recur with
            // same index j (as repeated elements are allowed in combinations)
            output.add(A[j]);
            recur(A, k, j, output);

            // backtrack - remove current element from solution
            output.pop();

            // code to handle duplicates - skip adjacent duplicate elements
            while (j < A.length - 1 && A[j] == A[j + 1]) {
                j++;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 1 };
        int k = 2;

        // if array contains repeated elements, sort the array to
        // handle duplicates combinations
        Arrays.sort(A);

        Stack<Integer> output = new Stack<>();
        recur(A, k, 0, output);
    }
}