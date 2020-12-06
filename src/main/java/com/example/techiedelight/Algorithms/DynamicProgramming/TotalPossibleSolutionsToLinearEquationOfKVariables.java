package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class TotalPossibleSolutionsToLinearEquationOfKVariables
{
    // Function to count total number of possible solutions of a
    // linear equation of k variables
    public static int count(int[] coeff, int k, int rhs)
    {
        // if rhs becomes 0, solution is found
        if (rhs == 0)
            return 1;
 
        // return 0 if rhs becomes negative or no coefficient is left
        if (rhs < 0 || k < 0)
            return 0;
 
        // Case 1. include current coefficient coeff[k] in solution and
        // recur with remaining value (rhs - coeff[k])
        int include = count(coeff, k, rhs - coeff[k]);
 
        // Case 2. exclude current coefficient coeff[k] from solution and
        // recur for remaining coefficients (k - 1)
        int exclude = count(coeff, k - 1, rhs);
 
        // return total ways by including or excluding current coefficient
        return include + exclude;
    }
 
    public static void main (String[] args)
    {
        // k coefficients of given equation
        int[] coeff = { 1, 2, 3 };
        final int k = coeff.length;
 
        int rhs = 4;
 
        System.out.println("Total number of solutions are " +
            count(coeff, k - 1, rhs));
    }
}




class TotalPossibleSolutionsToLinearEquationOfKVariablesA2
{
    // Function to count total number of possible solutions of a
    // linear equation of k variables
    public static int count(int[] coeff, int k, int rhs,
                            Map<String, Integer> lookup)
    {
        // if rhs becomes 0, solution is found
        if (rhs == 0)
            return 1;

        // return 0 if rhs becomes negative or no coefficient is left
        if (rhs < 0 || k < 0)
            return 0;

        // construct an unique map key from dynamic elements of the input
        String key = k + "|" + rhs;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (lookup.get(key) == null)
        {
            int include = count(coeff, k, rhs - coeff[k], lookup);    // Case 1

            int exclude = count(coeff, k - 1, rhs, lookup);            // Case 2

            // return total ways by including or excluding current coefficient
            lookup.put(key, include + exclude);
        }

        // return solution to current sub-problem
        return lookup.get(key);
    }

    public static void main (String[] args)
    {
        // k coefficients of given equation
        int[] coeff = { 1, 2, 3 };
        int k = coeff.length;

        int rhs = 4;

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap();

        System.out.println("Total number of solutions are " +
                count(coeff, k - 1, rhs, lookup));
    }
}





class TotalPossibleSolutionsToLinearEquationOfKVariablesA3
{
    public static int count(int[] coeff, int rhs)
    {
        int k = coeff.length;

        int T[][] = new int[k + 1][rhs + 1];

        for (int i = 0 ; i <= k; i++) {
            T[i][0] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= rhs; j++) {
                if (coeff[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                }
                else {
                    T[i][j] = T[i - 1][j] + T[i][j - coeff[i - 1]];
                }
            }
        }

        return T[k][rhs];
    }

    public static void main(String[] args)
    {
        int[] coeff = {1, 3, 5, 7};
        int rhs = 8;

        System.out.println("Total number of solutions are " + count(coeff, rhs));
    }
}





class TotalPossibleSolutionsToLinearEquationOfKVariablesA4
{
    public static int count(int[] coeff, int rhs)
    {
        int k = coeff.length;

        int T[] = new int[rhs + 1];
        T[0] = 1;

        for (int i = 0; i < k; i++) {
            for (int j = coeff[i]; j <= rhs; j++) {
                T[j] += T[j - coeff[i]];
            }
        }

        return T[rhs];
    }

    public static void main(String[] args)
    {
        int[] coeff = {1, 3, 5, 7};
        int rhs = 8;

        System.out.println("Total number of solutions are " + count(coeff, rhs));
    }
}