package com.example.techiedelight.Algorithms.Matrix;

import java.util.HashMap;
import java.util.Map;
 
class FindCommonElementsPresentInAllRowsOfAMatrix
{
    // R x C matrix
    private static final int R = 4;
    private static final int C = 5;
 
    //  Find the common elements in all the rows of specified matrix
    private static void findCommon(int[][] mat)
    {
        Map<Integer, Integer> map = new HashMap<>();
 
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                // insert elements of the first row into the map and
                // initialize them with value of 1
                if (i == 0) {
                    map.put(mat[0][j], 1);
                }
 
                // from second row onwards, check if the current element
                // exists in the map and first in the current row
                if (i > 0 && map.containsKey(mat[i][j])
                    && map.get(mat[i][j]) == i)
                {
                    // increment the count of the element by 1
                    map.put(mat[i][j], i + 1);
 
                    // if i represent the last row, print the element
                    if (i == R - 1) {
                        System.out.print(mat[i][j] + " ");
                    }
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 2, 4, 3, 8, 7 },
            { 4, 7, 1, 3, 6 },
            { 3, 5, 2, 1, 3 },
            { 4, 5, 0, 2, 3 },
        };
 
        findCommon(mat);
    }
}