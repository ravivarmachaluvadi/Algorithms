package com.example.techiedelight.Algorithms.Matrix;

import java.util.HashMap;
import java.util.Map;
 
class FindAllCommonElementsPresentInEveryRowOfGivenMatrix
{
    // find all common elements present in every row
    // of given matrix
    public static void findCommonElements(int[][] mat)
    {
        // R x C matrix
        int R = mat.length;
        int C = mat[0].length;
 
        // create an empty map
        Map<Integer, Integer> map = new HashMap<>();
 
        // insert all elements of the first row in the map
        // with their value set as 1
 
        for (int c = 0; c < C; c++) {
            map.put(mat[0][c], 1);
        }
 
        // do for remaining rows
        for (int r = 1; r < R; r++)
        {
            for (int c = 0; c < C; c++)
            {
                // get current element
                int curr = mat[r][c];
 
                // if current element is present in the map and its value
                // is same as row index, increment its value by 1
                // This check also handles duplicate entries in same row
 
                if (map.containsKey(curr) && map.get(curr) == r) {
                    map.put(curr, r + 1);
                }
            }
        }
 
        // iterate over each entry in map and print keys having
        // their value equal to ROW (number of rows in the matrix)
 
        System.out.print("Common elements are: ");
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == R) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 7, 1, 3, 5, 3, 6 },
            { 2, 3, 6, 1, 1, 6 },
            { 6, 1, 7, 2, 1, 4 },
            { 6, 6, 7, 1, 3, 3 },
            { 5, 5, 6, 1, 5, 4 },
            { 3, 5, 6, 2, 7, 1 },
            { 4, 1, 4, 3, 6, 4 },
            { 4, 6, 1, 7, 4, 3 }
        };
 
        findCommonElements(mat);
    }
}