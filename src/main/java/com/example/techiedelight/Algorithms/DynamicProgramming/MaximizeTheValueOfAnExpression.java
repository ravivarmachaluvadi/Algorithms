package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.Arrays;
 
class MaximizeTheValueOfAnExpression
{
    // Function to find maximum value of the expression
    // (A[l] - A[k] + A[j] - A[i]) where l > k > j > i
    public static int maximizeExpression(int[] A)
    {
        // create 4 lookup tables and initialize them to Integer.MIN_VALUE
        int[] first = new int[A.length + 1];
        Arrays.fill(first, Integer.MIN_VALUE);
 
        int[] second = new int[A.length];
        Arrays.fill(second, Integer.MIN_VALUE);
 
        int[] third = new int[A.length - 1];
        Arrays.fill(third, Integer.MIN_VALUE);
 
        int[] fourth = new int[A.length - 2];
        Arrays.fill(fourth, Integer.MIN_VALUE);
 
        // first[] stores the maximum value of A[l]
        for (int i = A.length - 1; i >= 0; i--) {
            first[i] = Integer.max(first[i + 1], A[i]);
        }
 
        // second[] stores the maximum value of A[l] - A[k]
        for (int i = A.length - 2; i >= 0; i--) {
            second[i] = Integer.max(second[i + 1], first[i + 1] - A[i]);
        }
 
        // third[] stores the maximum value of A[l] - A[k] + A[j]
        for (int i = A.length - 3; i >= 0; i--) {
            third[i] = Integer.max(third[i + 1], second[i + 1] + A[i]);
        }
 
        // fourth[] stores the maximum value of A[l] - A[k] + A[j] - A[i]
        for (int i = A.length - 4; i >= 0; i--) {
            fourth[i] = Integer.max(fourth[i + 1], third[i + 1] - A[i]);
        }
 
        // maximum value would be present at fourth[0]
        return fourth[0];
    }
 
    public static void main(String[] args)
    {
        int[] A = { 3, 9, 10, 1, 30, 40 };
 
        // array should have atleast 4 elements
        if (A.length >= 4) {
            System.out.println(maximizeExpression(A));
        }
    }
}