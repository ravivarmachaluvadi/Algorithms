package com.example.techiedelight.Algorithms.Matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class FindShortestDistanceOfEveryCellFromLandmineInAMaze
{
    // M x N matrix
    private static final int M = 6;
    private static final int N = 5;
 
    // check if specified row and column are valid matrix index
    private static boolean isValid(int i, int j)
    {
        return (i >= 0 && i < M) && (j >= 0 && j < N);
    }
 
    // check if current cell is an open area and its
    // distance from mine is not yet calculated
    private static boolean isSafe(int i, int j, char[][] mat, int[][] result)
    {
        return mat[i][j] == 'O' && result[i][j] == -1;
    }
 
    // Replace all O's in the matrix with their shortest distance
    // from the nearest mine
    private static void updateDistance(char[][] mat, int[][] result)
    {
        // initialize an empty queue
        Queue<Node> Q = new ArrayDeque<>();
 
        // find all mines location and add them to the queue
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // if current cell represents a mine
                if (mat[i][j] == 'M')
                {
                    Q.add(new Node(i, j, 0));
 
                    // update mine distance as 0
                    result[i][j] = 0;
                }
                // else initialize mine distance by as -1
                else result[i][j] = -1;
            }
        }
 
        // arrays to get indices of 4 adjacent cells of a given cell
        int[] R = { 0, -1, 0, 1 };
        int[] C = { -1, 0, 1, 0 };
 
        // do for each Node in the queue
        while (!Q.isEmpty())
        {
            // process front cell in the queue
            int x = Q.peek().x;
            int y = Q.peek().y;
            int distance = Q.peek().level;
 
            // dequeue the front cell
            Q.poll();
 
            // update the 4 adjacent cells of the front node in the queue
            for (int i = 0; i < 4; i++)
            {
                // enqueue the adjacent cell if it is valid, unvisited,
                // and has a path through it
                if (isValid(x + R[i], y + C[i]) && isSafe(x + R[i], y + C[i], mat, result))
                {
                    result[x + R[i]][y + C[i]] = distance + 1;
                    Q.add(new Node(x + R[i], y + C[i], distance + 1));
                }
            }
        }
    }
 
    // Find shortest distance of every cell from land mine in a Maze
    public static void main(String[] args)
    {
        char[][] mat =
        {
            {'O', 'M', 'O', 'O', 'X'},
            {'O', 'X', 'X', 'O', 'M'},
            {'O', 'O', 'O', 'O', 'O'},
            {'O', 'X', 'X', 'X', 'O'},
            {'O', 'O', 'M', 'O', 'O'},
            {'O', 'X', 'X', 'M', 'O'}
        };
 
        int[][] result = new int[M][N];
        updateDistance(mat, result);
 
        // print results
        for (int[] r: result) {
            System.out.println(Arrays.toString(r));
        }
    }
}