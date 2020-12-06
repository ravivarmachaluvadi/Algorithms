package com.example.techiedelight.Algorithms.arraysGA;

class LongestAlternatingSubsequenceProblem
{
    // Util function to find length of longest subsequence
    // if flag is true, next element should be greater
    // if flag is false, next element should be smaller
    public static int Util(int[] A, int start, int end, boolean flag)
    {
        int res = 0;
        for (int i = start; i <= end; i++)
        {
            // include A[i] as next high in subsequence and flip flag
            // for next subsequence
            if (flag && A[i - 1] < A[i]) {
                res = Integer.max(res, 1 + Util(A, i + 1, end, !flag));
            }
            // include A[i] as next low in subsequence and flip flag
            // for next subsequence
            else if (!flag && A[i - 1] > A[i]) {
                res = Integer.max(res, 1 + Util(A, i + 1, end, !flag));
            }
            // don't include A[i] in subsequence
            else {
                res = Integer.max(res, Util(A, i + 1, end, flag));
            }
        }
 
        return res;
    }
 
    // Function to find length of longest subsequence with alternate
    // low and high elements. It uses Util() method.
    public static int findLongestSequence(int[] arr)
    {
        // Fix first element and recur for remaining elements as first
        // element will always be part of longest subsequence (why?)
 
        // There are two possibilities -
 
        // 1. Next element is greater (pass true)
        // 2. Next element is smaller (pass false)
        return 1 + Integer.max(Util(arr, 1, arr.length - 1, true),
                            Util(arr, 1, arr.length  - 1, false));
 
        // instead of fixing first element, we can also directly call
        // return max(Util(arr, 0, n, true), Util(arr, 0, n, false));
    }
 
    public static void main(String[] args)
    {
        int[] A = { 8, 9, 6, 4, 5, 7, 3, 2, 4 };
 
        System.out.println("The length of Longest Subsequence is "
                + findLongestSequence(A));
    }
}



class LongestAlternatingSubsequenceProblemA2
{
    // Util function to find length of longest subsequence
    // if flag is true, next element should be greater
    // if flag is false, next element should be smaller
    public static int Util(int[] A, int start, int end, int flag,
                           int[][] lookup)
    {
        if (start >= A.length) {
            return 0;
        }

        // if sub-problem is seen for the first time, solve it and
        // store its result in lookup table
        if (lookup[start][flag] == 0)
        {
            int res = 0;
            for (int i = start; i <= end; i++)
            {
                // include A[i] as next high in subsequence and flip flag
                // for next subsequence
                if (flag == 1 && A[i - 1] < A[i]) {
                    res = Integer.max(res, 1 + Util(A, i + 1, end, 0, lookup));
                }
                // include A[i] as next low in subsequence and flip flag
                // for next subsequence
                else if (flag == 0 && A[i - 1] > A[i]) {
                    res = Integer.max(res, 1 + Util(A, i + 1, end, 1, lookup));
                }
                // don't include A[i] in subsequence
                else {
                    res = Integer.max(res, Util(A, i + 1, end, flag, lookup));
                }
            }

            lookup[start][flag] = res;
        }

        // return solution to current sub-problem
        return lookup[start][flag];
    }

    // Function to find length of longest subsequence with alternate
    // low and high elements. It uses Util() method.
    public static int findLongestSequence(int[] A, int[][] lookup)
    {
        // Fix first element and recur for remaining elements as first
        // element will always be part of longest subsequence (why?)

        // There are two possibilities -

        // 1. Next element is greater (pass true)
        // 2. Next element is smaller (pass false)
        return 1 + Integer.max(Util(A, 1, A.length - 1, 1, lookup),
                Util(A, 1, A.length  - 1, 0, lookup));
    }

    public static void main(String[] args)
    {
        int[] A = { 8, 9, 6, 4, 5, 7, 3, 2, 4 };

        // lookup table to store solutions of subproblem
        // max(lookup[i][0], lookup[i][1]) stores longest sequence
        // till A[0..i]
        int[][] lookup = new int[A.length][2];

        System.out.println("The length of Longest Subsequence is "
                + findLongestSequence(A, lookup));
    }
}



class LongestAlternatingSubsequenceProblemA3
{
    // Function to find length of longest subsequence with alternate
    // low and high elements.
    public static int findLongestSequence(int[] A)
    {
        // lookup table to store solutions of sub-problems
        int T[][] = new int[A.length][2];

        /*
            T[i][0] stores longest alternating subsequence till A[0..i]
              where A[i] is greater than A[i-1]

            T[i][1] stores longest alternating subsequence till A[0..i]
             where A[i] is smaller than A[i-1]
        */

        // stores result
        int res = 0;

        // base case: first element will always be the part of LAS
        T[0][0] = T[0][1] = 1;

        // fill the lookup table in bottom-up manner
        for (int i = 1; i < A.length; i++)
        {
            // do for each element A[j] before A[i]
            for (int j = 0; j < i; j++)
            {
                // If A[i] is greater than A[j], update T[i][0]
                if (A[i] > A[j]) {
                    T[i][0] = Math.max(T[i][0], T[j][1] + 1);
                }

                // If A[i] is smaller than A[j], update T[i][1]
                if (A[i] < A[j]) {
                    T[i][1] = Math.max(T[i][1], T[j][0] + 1);
                }
            }

            // update result by maximum of both values
            if (res < Math.max(T[i][0], T[i][1])) {
                res = Math.max(T[i][0], T[i][1]);
            }
        }

        // return result
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = { 8, 9, 6, 4, 5, 7, 3, 2, 4 };

        System.out.println("The length of Longest Subsequence is "
                + findLongestSequence(A));
    }
}