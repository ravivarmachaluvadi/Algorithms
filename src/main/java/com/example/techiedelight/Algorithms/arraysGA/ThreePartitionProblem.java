package com.example.techiedelight.Algorithms.arraysGA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ThreePartitionProblem
{
    // Helper function for solving 3 partition problem
    // It return true if there exists three subsets with given sum
    public static boolean subsetSum(int[] S, int n, int a, int b, int c)
    {
        // return true if subset is found
        if (a == 0 && b == 0 && c == 0) {
            return true;
        }
 
        // base case: no items left
        if (n < 0) {
            return false;
        }
 
        // Case 1. current item becomes part of first subset
        boolean A = false;
        if (a - S[n] >= 0) {
            A = subsetSum(S, n - 1, a - S[n], b, c);
        }
 
        // Case 2. current item becomes part of second subset
        boolean B = false;
        if (!A && (b - S[n] >= 0)) {
            B = subsetSum(S, n - 1, a, b - S[n], c);
        }
 
        // Case 3. current item becomes part of third subset
        boolean C = false;
        if ((!A && !B) && (c - S[n] >= 0)) {
            C = subsetSum(S, n - 1, a, b, c - S[n]);
        }
 
        // return true if we get solution
        return A || B || C;
    }
 
    // Function for solving 3-partition problem. It return true if given
    // set S[0..n-1] can be divided into three subsets with equal sum
    public static boolean partition(int[] S)
    {
        if (S.length < 3) {
            return false;
        }
 
        // get sum of all elements in the set
        int sum = Arrays.stream(S).sum();
 
        // return true if sum is divisible by 3 and the set can can
        // be divided into three subsets with equal sum
        return (sum % 3) == 0 &&
                subsetSum(S, S.length - 1, sum/3, sum/3, sum/3);
    }
 
    // main function for 3-partition problem
    public static void main(String[] args)
    {
        // Input: set of integers
        int[] S = { 7, 3, 2, 1, 5, 4, 8 };
 
        if (partition(S)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}



class ThreePartitionProblemA1
{
    // Helper function for solving 3 partition problem
    // It return true if there exists three subsets with given sum
    public static boolean subsetSum(int[] S, int n, int a, int b, int c,
                                    Map<String, Boolean> lookup)
    {
        // return true if subset is found
        if (a == 0 && b == 0 && c == 0) {
            return true;
        }

        // base case: no items left
        if (n < 0) {
            return false;
        }

        // construct an unique map key from dynamic elements of the input
        String key = a + "|" + b + "|" + c + "|" + n;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // Case 1. current item becomes part of first subset
            boolean A = false;
            if (a - S[n] >= 0) {
                A = subsetSum(S, n - 1, a - S[n], b, c, lookup);
            }

            // Case 2. current item becomes part of second subset
            boolean B = false;
            if (!A && (b - S[n] >= 0)) {
                B = subsetSum(S, n - 1, a, b - S[n], c, lookup);
            }

            // Case 3. current item becomes part of third subset
            boolean C = false;
            if ((!A && !B) && (c - S[n] >= 0)) {
                C = subsetSum(S, n - 1, a, b, c - S[n], lookup);
            }

            // return true if we get solution
            lookup.put(key, A || B || C);
        }

        // return the subproblem solution from the map
        return lookup.get(key);
    }

    // Function for solving 3-partition problem. It return true if given
    // set S can be divided into three subsets with equal sum
    public static boolean partition(int[] S)
    {
        if (S.length < 3) {
            return false;
        }

        // create a map to store solutions of subproblems
        Map<String, Boolean> lookup = new HashMap<>();

        // get sum of all elements in the set
        int sum = Arrays.stream(S).sum();

        // return true if sum is divisble by 3 and the set can can
        // be divided into three subsets with equal sum
        return (sum % 3) == 0 && subsetSum(S, S.length - 1, sum/3,
                sum/3, sum/3, lookup);
    }

    // main function for 3-partition problem
    public static void main(String[] args)
    {
        // Input: set of integers
        int[] S = { 7, 3, 2, 1, 5, 4, 8 };

        if (partition(S)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}