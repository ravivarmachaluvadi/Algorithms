package com.example.techiedelight.Algorithms.Matrix;

import java.util.ArrayList;
import java.util.List;

class FindAllOccurrencesOfGivenStringInACharacterMatrix
{
    // Below arrays details all 8 possible movements from a cell
    private static final int[] row = { -1, -1, -1,  0, 0,  1, 1, 1 };
    private static final int[] col = { -1,  0,  1, -1, 1, -1, 0, 1 };
 
    // Function to check if it is possible to go to position next
    // from current position. The function returns false if next is
    // not a valid position or it is already visited
    public static boolean isValid(Node next, List<Node> path, int M, int N)
    {
        return (next.x >= 0) && (next.x < M) &&
                       (next.y >= 0) && (next.y < N) &&
                       (!path.contains(next));
    }
 
    public static void DFS(char mat[][], String word, Node next,
                           List<Node> path, int index)
    {
        int i = next.x;
        int j = next.y;
        int n = word.length();
 
        // return if characters don"t match
        if (mat[i][j] != word.charAt(index)) {
            return;
        }
 
        // if all words are matched, print the result and return
        if (index == n - 1)
        {
            for (int k = 0; k < path.size(); k++) {
                System.out.print("'" + word.charAt(k) + "'" + path.get(k));
            }
            System.out.println("'" + word.charAt(path.size()) + "'"
                                + new Node(i, j));
            return;
        }
 
        // include current cell in the path
        path.add(new Node(i, j));
 
        // check all 8 possible movements from current cell
        // and recur for each valid movement
        for (int k = 0; k < 8; k++)
        {
            // calculate next position
            next = new Node(i + row[k], j + col[k]);
 
            // check if it is possible to go to next position
            // from current position
            if (isValid(next, path, mat.length, mat[0].length)) {
                DFS(mat, word, next, path, index + 1);
            }
        }
 
        // remove current cell from the path
        path.remove(path.size() - 1);
 
    }
 
    public static void main(String[] args)
    {
        char mat[][] =
        {
            "DEMXB".toCharArray(),
            "AOEPE".toCharArray(),
            "DDCOD".toCharArray(),
            "EBEDS".toCharArray(),
            "CPYEN".toCharArray()
        };
 
        String word = "CODE";
        List<Node> path = new ArrayList<>();
 
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                DFS(mat, word, new Node(i, j), path, 0);
            }
        }
    }
}