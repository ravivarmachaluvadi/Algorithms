package com.example.techiedelight.Algorithms.Matrix;

import java.util.Stack;
 
class FindAllPathsFromFirstCellToLastCellOfAMatrix
{
    public static void findPaths(int[][] mat, Stack<Integer> path,
                                 int i, int j)
    {
        int M = mat.length;
        int N = mat[0].length;
 
        // if we have reached the last cell, print the route
        if (i == M - 1 && j == N - 1)
        {
            path.add(mat[i][j]);
            System.out.println(path);
            path.pop();
 
            return;
        }
 
        // include current cell in path
        path.add(mat[i][j]);
 
        // move right
        if ((i >= 0 && i < M && j + 1 >= 0 && j + 1 < N)) {
            findPaths(mat, path, i, j + 1);
        }
 
        // move down
        if ((i + 1 >= 0 && i + 1 < M && j >= 0 && j < N)) {
            findPaths(mat, path, i + 1, j);
        }
 
        // remove current cell from path
        path.pop();
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
 
        Stack<Integer> path = new Stack<>();
 
        // start from (0, 0) cell
        int x = 0, y = 0;
 
        findPaths(mat, path, x, y);
    }
}