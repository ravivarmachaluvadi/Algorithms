package com.example.techiedelight.Algorithms.Binary;

import java.util.ArrayDeque;
import java.util.Deque;
 
class GeneratePowerSetOfAGivenSet
{
    // Function to generate power set of given set S
    public static void findPowerSet(int[] S, Deque<Integer> set, int n)
    {
        // if we have considered all elements
        if (n == 0) {
            System.out.println(set);
            return;
        }
 
        // consider nth element
        set.addLast(S[n - 1]);
        findPowerSet(S, set, n - 1);
 
        // or don't consider nth element
        set.removeLast();
        findPowerSet(S, set, n - 1);
    }
 
    public static void main(String[] args)
    {
        int[] S = { 1, 2, 3 };
        Deque<Integer> set = new ArrayDeque<>();
        findPowerSet(S, set, S.length);
    }
}



class GeneratePowerSetOfAGivenSetA2
{
    public static void findPowerSet(int[] S)
    {
        // N stores total number of subsets
        int N = (int) Math.pow(2, S.length);

        // generate each subset one by one
        for (int i = 0; i < N; i++) {
            // check every bit of i
            for (int j = 0; j < S.length; j++) {
                // if j'th bit of i is set, print S[j]
                if ((i & (1 << j)) != 0) {
                    System.out.print(S[j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] S = { 1, 2, 3 };
        findPowerSet(S);
    }
}