package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class CountTotalPossibleCombinationsOfNDigitNumbersInAMobileKeypad
{
    // Maximum N-digit number allowed
    private static final int N = 8;
 
    // mobile keypad
    private static char key[][] =
    {
        { '1', '2', '3' },
        { '4', '5', '6' },
        { '7', '8', '9' },
        { '*', '0', '#' }
    };
 
    // Below arrays details all 4 possible movements from current cell
    private static int[] row = { 0, -1, 0, 1 };
    private static int[] col = { -1, 0, 1, 0 };
 
    // The function returns false if (i, j) is not a valid position
    public static boolean isValid(int i, int j)
    {
        // for handling '*' or '#' (present in 4th row and 1st
        // & 3rd column)
        if (i == 3 && (j == 0 || j == 2)) {
            return false;
        }
 
        return (i >= 0 && i <= 3 && j >= 0 && j <= 2);
    }
 
    // Function to fill a multimap that stores the mapping of cells
    // reachable from current cell
    public static void fillMap(Map<Integer, List<Integer>> keypad)
    {
        // do for each row
        for (int i = 0; i < 4; i++)
        {
            // do for each column of row i
            for (int j = 0; j < 3; j++)
            {
                // move in all four possible directions of current
                // digit key[i][j]
                for (int k = 0; k < 4; k++)
                {
                    int r = i + row[k];
                    int c = j + col[k];
 
                    // insert adjacent cell to multimap if valid
                    if (isValid(i, j) && isValid(r, c)) {
                        keypad.putIfAbsent(key[i][j] - '0', new ArrayList<>());
                        keypad.get(key[i][j] - '0').add(key[r][c] - '0');
                    }
                }
            }
        }
    }
 
    // Function to count all numbers starting from digit i and
    // having length n
    public static int getCount(Map<Integer, List<Integer>> keypad,
                               int i, int n, int[][] lookup)
    {
        if (n == 1) { // reached end of digit
            return 1;
        }
 
        // if sub-problem is seen for the first time, solve it and
        // store its result in an array
        if (lookup[i][n] == 0)
        {
            // recur for digit i
            lookup[i][n] = getCount(keypad, i, n - 1, lookup);
 
            // recur for all digits reachable from i
            for (Integer e: keypad.get(i)) {
                lookup[i][n] += getCount(keypad, e, n - 1, lookup);
            }
        }
 
        // return the subproblem solution
        return lookup[i][n];
    }
 
    public static void main(String[] args)
    {
        int n = 2;
 
        // use a multimap to store mapping of cells reachable
        // from current cell
        Map<Integer, List<Integer>> keypad = new HashMap<>();
        fillMap(keypad);
 
        // create a lookup table to store solutions of sub-problems
        // lookup[i][j] stores count of all numbers starting from digit i
        // having length n
        int[][] lookup = new int[10][N];
 
        // get count of of each digit
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            count += getCount(keypad, i, n, lookup);
        }
 
        System.out.print("Total possible combinations are " + count);
    }
}

