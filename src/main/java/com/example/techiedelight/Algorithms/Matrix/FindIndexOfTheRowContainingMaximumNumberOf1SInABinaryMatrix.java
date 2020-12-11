package com.example.techiedelight.Algorithms.Matrix;

class FindIndexOfTheRowContainingMaximumNumberOf1SInABinaryMatrix
{
    public static int findRowIndex(int mat[][]) {
        // stores row number with maximum index
        int row = -1;
 
        // i, j stores current row and column index
 
        // start from top-rightmost cell of the matrix
        int i = 0, j = mat[0].length - 1;
 
        while (i <= mat.length - 1 && j >= 0) {
            // move left if current cell has value 1
            if (mat[i][j] == 1) {
                j--;
                row = i;    // update row number
            }
            // else move down
            else {
                i++;
            }
        }
        return row + 1;
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 0, 0, 0, 1, 1 },
            { 0, 0, 1, 1, 1 },
            { 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 1 }
        };
 
        int rowIndex = findRowIndex(mat);
 
        // rowIndex = 0 means no 1's are present in the matrix
        if (rowIndex != 0) {
            System.out.print("Maximum 1's are present in the row " + rowIndex);
        }
    }
}