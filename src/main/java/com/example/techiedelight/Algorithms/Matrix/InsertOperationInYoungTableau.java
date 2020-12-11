package com.example.techiedelight.Algorithms.Matrix;

import java.util.Arrays;
 
class InsertOperationInYoungTableau
{
    private static final int M = 4;
    private static final int N = 4;
 
    // Recursive function to insert a new element into a non-full MxN Young tableau.
    // The new element is initially placed at the bottom right corner of the tableau.
    // The function works by swapping the smaller of [i-1,j] and [i,j-1] with [i,j]
    // and recur for the smaller value.
 
    public static void insert(int[][] tableau, int i, int j)
    {
        // base case
        if (i == 0 && j == 0) {
            return;
        }
 
        // handle separately for the first row
        if (i == 0)
        {
            if (tableau[i][j] < tableau[i][j-1]) {
                // swap tableau[i][j] and tableau[i][j-1]
                int temp = tableau[i][j];
                tableau[i][j] = tableau[i][j-1];
                tableau[i][j-1] = temp;
 
                insert(tableau, i, j - 1);
            }
            return;
        }
 
        // handle separately for the first column
        if (j == 0)
        {
            if (tableau[i][j] < tableau[i-1][j])
            {
                // swap tableau[i][j] and tableau[i-1][j]
 
                int temp = tableau[i][j];
                tableau[i][j] = tableau[i-1][j];
                tableau[i-1][j] = temp;
 
                insert(tableau, i - 1, j);
            }
            return;
        }
 
        if (tableau[i][j] < tableau[i-1][j])    // go up
        {
            // swap tableau[i][j] and tableau[i-1][j]
 
            int temp = tableau[i][j];
            tableau[i][j] = tableau[i-1][j];
            tableau[i-1][j] = temp;
 
            insert(tableau, i - 1, j);
        }
 
        if (tableau[i][j] < tableau[i][j-1])    // go left
        {
            // swap tableau[i][j] and tableau[i][j-1]
 
            int temp = tableau[i][j];
            tableau[i][j] = tableau[i][j-1];
            tableau[i][j-1] = temp;
 
            insert(tableau, i, j - 1);
        }
    }
 
    // Utility function to print a Young tableau
    public static void printTableau(int tableau[][])
    {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tableau[i][j] + " ");
            }
            System.out.println();
        }
    }
 
    // Recursive function to insert a new element into a non-full MxN Young tableau.
    public static void insert(int[][] tableau, int[] keys)
    {
        // initialize the Young tableau by infinity
        for (int i = 0; i < M; i++) {
            Arrays.fill(tableau[i], Integer.MAX_VALUE);
        }
 
        // do for each key
        for (int key: keys)
        {
            // check for overflow
            if (tableau[M-1][N-1] != Integer.MAX_VALUE) {
                System.out.print("Young tableau is full. Skipping key " + key);
            }
            else {
                // place key at the bottom right corner of the tableau
                tableau[M-1][N-1] = key;
 
                // move the key to its correct position in the tableau
                insert(tableau, M-1, N-1);
            }
        }
    }
 
    public static void main(String[] args)
    {
        // construct a M x N Young tableau
        int[][] tableau = new int[M][N];
 
        // construct a Young tableau from below keys
        int[] keys = { 12, 10, 20, 22, 25, 30, 34, 11,
                        44, 27, 16, 40, 35, 15, 18, 45 };
 
        insert(tableau, keys);
        printTableau(tableau);
    }
}






class SearchOperationInYoungTableau
{
    // A utility function to search an element in a Young Tableau.
    public static boolean search(int[][] tableau, int key)
    {
        // start from the top-rightmost cell of matrix i.e. (0, N-1) cell
        int i = 0, j = tableau[0].length - 1;

        // run till matrix boundary is reached
        while (i < tableau.length && j >= 0)
        {
            // if current element is less than the key, increment the row index
            if (tableau[i][j] < key) {
                i++;
            }

            // if current element is more than the key, decrement the column index
            else if (tableau[i][j] > key) {
                j--;
            }

            // current element is equal to the key
            else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        // M x N Young tableau
        int[][] tableau =
                {
                        { 10, 12, 15, 16 },
                        { 11, 18, 20, 25 },
                        { 22, 27, 30, 35 },
                        { 34, 40, 44, 45 }
                };

        int[] keys = { 20, 23, 25, 29 };

        // do for each key
        for (int key: keys) {
            if (search(tableau, key)) {
                System.out.println("Key " + key + " found in tableau");
            }
        }
    }
}





class ExtractMinOperationInYoungTableau
{
    // M x N matrix
    private static int M, N;

    // Recursive function to fix the tableau property in a MxN Young tableau.
    // An infinite value is initially placed at the first cell (0,0) of the tableau.
    // The function works by swapping the smaller of [i+1,j] and [i,j+1] with [i,j]
    // and recur for the smaller value.

    public static void fixTableau(int[][] tableau, int i, int j)
    {
        // get the values present at the bottom and right cell of the current cell
        int bottom = (i + 1 < M) ? tableau[i + 1][j] : Integer.MAX_VALUE;
        int right = (j + 1 < N) ? tableau[i][j + 1] : Integer.MAX_VALUE;

        if (bottom < right)    // go down
        {
            // swap tableau[i][j] with tableau[i + 1][j]
            int temp = tableau[i][j];
            tableau[i][j] = tableau[i + 1][j];
            tableau[i + 1][j] = temp;

            fixTableau(tableau, i + 1, j);
        }

        if (bottom > right)    // go right
        {
            // swap tableau[i][j] with tableau[i][j + 1]
            int temp = tableau[i][j];
            tableau[i][j] = tableau[i][j + 1];
            tableau[i][j + 1] = temp;

            fixTableau(tableau, i, j + 1);
        }
    }

    // Function to extract next minimum element from the Young tableau
    public static int extractMin(int[][] tableau)
    {
        // the first cell of tableau stores the minimum element
        int min = tableau[0][0];

        // make the first element as infinity
        tableau[0][0] = Integer.MAX_VALUE;

        // fix the young tableau property
        fixTableau(tableau, 0, 0);

        return min;
    }

    public static void main(String[] args)
    {
        // M x N Young tableau
        int[][] tableau =
                {
                        { 10, 12, 15, 16 },
                        { 11, 18, 20, 25 },
                        { 22, 27, 30, 35 },
                        { 34, 40, 44, 45 }
                };

        M = tableau.length;
        N = tableau[0].length;

        // repeat M*N times
        for (int i = 0; i < M*N; i++) {
            System.out.print(extractMin(tableau) + " ");
        }
    }
}






class DeleteOperationInYoungTableau
{
    // M x N matrix
    private static int M, N;

    // Recursive function to fix the tableau property in a MxN Young tableau
    public static void fixTableau(int[][] tableau, int i, int j)
    {
        // get the values present at the bottom and right cell of the current cell
        int bottom = (i + 1 < M) ? tableau[i + 1][j] : Integer.MAX_VALUE;
        int right = (j + 1 < N) ? tableau[i][j + 1] : Integer.MAX_VALUE;

        if (bottom < right)    // go down
        {
            // swap tableau[i][j] with tableau[i + 1][j]

            int temp = tableau[i][j];
            tableau[i][j] = tableau[i + 1][j];
            tableau[i + 1][j] = temp;

            fixTableau(tableau, i + 1, j);
        }

        if (bottom > right)    // go right
        {
            // swap tableau[i][j] with tableau[i][j + 1]

            int temp = tableau[i][j];
            tableau[i][j] = tableau[i][j + 1];
            tableau[i][j + 1] = temp;

            fixTableau(tableau, i, j + 1);
        }
    }

    // Function to delete given element from the Young tableau
    public static void deletion(int[][] tableau, int i, int j)
    {
        // to delete the element at cell (i, j), make it as infinity
        tableau[i][j] = Integer.MAX_VALUE;

        // fix the young tableau property
        fixTableau(tableau, i, j);
    }

    public static void main(String[] args)
    {
        // M x N Young tableau
        int[][] tableau =
                {
                        { 10, 12, 15, 16 },
                        { 11, 18, 20, 25 },
                        { 22, 27, 30, 35 },
                        { 34, 40, 44, 45 }
                };

        M = tableau.length;
        N = tableau[0].length;

        deletion(tableau, 1, 2);    // delete 20

        // print Young tableau
        for (int[] r: tableau) {
            System.out.println(Arrays.toString(r));
        }
    }
}






class ReplaceOperationInYoungTableau
{
    private static int M, N;

    // Recursive function to fix the tableau property in a MxN Young tableau
    public static void fixTableau(int[][] tableau, int i, int j)
    {
        // get the values present at the bottom and right cell of the current cell
        int bottom = (i + 1 < M) ? tableau[i + 1][j] : Integer.MAX_VALUE;
        int right = (j + 1 < N) ? tableau[i][j + 1] : Integer.MAX_VALUE;

        if (bottom < right)    // go down
        {
            // swap tableau[i][j] with tableau[i + 1][j]

            int temp = tableau[i][j];
            tableau[i][j] = tableau[i + 1][j];
            tableau[i + 1][j] = temp;

            fixTableau(tableau, i + 1, j);
        }

        if (bottom > right)    // go right
        {
            // swap tableau[i][j] with tableau[i][j + 1]

            int temp = tableau[i][j];
            tableau[i][j] = tableau[i][j + 1];
            tableau[i][j + 1] = temp;

            fixTableau(tableau, i, j + 1);
        }
    }

    // Recursive function to insert a new element into a non-full MxN Young tableau.
    public static void insert(int[][] tableau, int i, int j)
    {
        // base case
        if (i == 0 && j == 0) {
            return;
        }

        // handle separately for the first row
        if (i == 0)
        {
            if (tableau[i][j] < tableau[i][j-1]) {

                // swap tableau[i][j] with tableau[i][j - 1]
                int temp = tableau[i][j];
                tableau[i][j] = tableau[i][j - 1];
                tableau[i][j - 1] = temp;

                insert(tableau, i, j - 1);
            }
            return;
        }

        // handle separately for the first column
        if (j == 0)
        {
            if (tableau[i][j] < tableau[i-1][j]) {

                // swap tableau[i][j] with tableau[i-1][j]
                int temp = tableau[i][j];
                tableau[i][j] = tableau[i-1][j];
                tableau[i-1][j] = temp;

                insert(tableau, i - 1, j);
            }
            return;
        }

        if (tableau[i][j] < tableau[i-1][j])    // go up
        {
            // swap tableau[i][j] with tableau[i-1][j]
            int temp = tableau[i][j];
            tableau[i][j] = tableau[i-1][j];
            tableau[i-1][j] = temp;

            insert(tableau, i - 1, j);
        }

        if (tableau[i][j] < tableau[i][j-1])    // go left
        {
            // swap tableau[i][j] with tableau[i][j - 1]
            int temp = tableau[i][j];
            tableau[i][j] = tableau[i][j - 1];
            tableau[i][j - 1] = temp;

            insert(tableau, i, j - 1);
        }
    }

    // Function to replace a given element in the Young tableau
    public static void replace(int[][] tableau, int i, int j, int key)
    {
        // delete element at cell (i, j)
        tableau[i][j] = Integer.MAX_VALUE;

        // fix the young tableau property
        fixTableau(tableau, i, j);

        // place the given key at the bottom right corner of the tableau
        tableau[M-1][N-1] = key;

        // move the key to its correct position in the tableau
        insert(tableau, M-1, N-1);
    }

    // A utility function to search an element in a Young tableau.
    public static boolean search(int[][] tableau, int key, int value)
    {
        // start from the top-rightmost cell of tableau i.e. (0, N-1) cell
        int i = 0, j = N - 1;

        // run till tableau boundary is reached
        while (i < M && j >= 0)
        {
            // if current element is less than the key, increment the row index
            if (tableau[i][j] < key) {
                i++;
            }

            // if current element is more than the key, decrement the column index
            else if (tableau[i][j] > key) {
                j--;
            }

            // current element is equal to the key
            else {
                replace(tableau, i, j, value);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        // M x N Young tableau
        int[][] tableau =
                {
                        { 10, 12, 15, 16 },
                        { 11, 18, 20, 25 },
                        { 22, 27, 30, 35 },
                        { 34, 40, 44, 45 }
                };

        M = tableau.length;
        N = tableau[0].length;

        search(tableau, 20, 14);    // replace 20 by 14

        // print Young tableau
        for (int[] r: tableau) {
            System.out.println(Arrays.toString(r));
        }
    }
}





class SortAnArrayUsingYoungTableau
{
    private static final int N = 3;

    // Recursive function to fix the tableau property in a NxN Young tableau.
    // An infinite value is initially placed at the first cell (0,0) of the tableau.
    // The function works by swapping the smaller of [i+1,j] and [i,j+1] with [i,j]
    // and recur for the smaller value.

    public static void fixTableau(int[][] tableau, int i, int j)
    {
        // get the values present at the bottom and right cell of the current cell
        int bottom = (i + 1 < N) ? tableau[i + 1][j] : Integer.MAX_VALUE;
        int right = (j + 1 < N) ? tableau[i][j + 1] : Integer.MAX_VALUE;

        if (bottom < right)    // go down
        {
            // swap tableau[i][j] and tableau[i + 1][j]

            int temp = tableau[i][j];
            tableau[i][j] = tableau[i + 1][j];
            tableau[i + 1][j] = temp;

            fixTableau(tableau, i + 1, j);
        }

        if (bottom > right)    // go right
        {
            // swap tableau[i][j] and tableau[i][j + 1]

            int temp = tableau[i][j];
            tableau[i][j] = tableau[i][j + 1];
            tableau[i][j + 1] = temp;

            fixTableau(tableau, i, j + 1);
        }
    }

    // Function to extract next minimum element from the Young tableau
    public static int extractMin(int[][] tableau)
    {
        // the first cell of tableau stores the minimum element
        int min = tableau[0][0];

        // make the first element as infinity
        tableau[0][0] = Integer.MAX_VALUE;

        // fix the young tableau property
        fixTableau(tableau, 0, 0);

        return min;
    }

    // Recursive function to insert a new element into a non-full NxN Young tableau.
    // The new element is initially placed at the bottom right corner of the tableau.
    // The function works by swapping the smaller of [i-1,j] and [i,j-1] with [i,j]
    // and recur for the smaller value.

    public static void insert(int[][] tableau, int i, int j)
    {
        // base case
        if (i == 0 && j == 0) {
            return;
        }

        // handle separately for the first row
        if (i == 0)
        {
            if (tableau[i][j] < tableau[i][j-1]) {
                // swap tableau[i][j] and tableau[i][j-1]
                int temp = tableau[i][j];
                tableau[i][j] = tableau[i][j-1];
                tableau[i][j-1] = temp;

                insert(tableau, i, j - 1);
            }
            return;
        }

        // handle separately for the first column
        if (j == 0)
        {
            if (tableau[i][j] < tableau[i-1][j])
            {
                // swap tableau[i][j] and tableau[i-1][j]

                int temp = tableau[i][j];
                tableau[i][j] = tableau[i-1][j];
                tableau[i-1][j] = temp;

                insert(tableau, i - 1, j);
            }
            return;
        }

        if (tableau[i][j] < tableau[i-1][j])    // go up
        {
            // swap tableau[i][j] and tableau[i-1][j]

            int temp = tableau[i][j];
            tableau[i][j] = tableau[i-1][j];
            tableau[i-1][j] = temp;

            insert(tableau, i - 1, j);
        }

        if (tableau[i][j] < tableau[i][j-1])    // go left
        {
            // swap tableau[i][j] and tableau[i][j-1]

            int temp = tableau[i][j];
            tableau[i][j] = tableau[i][j-1];
            tableau[i][j-1] = temp;

            insert(tableau, i, j - 1);
        }
    }

    // Function construct a NxN Young tableau from given keys
    public static void insert(int[][] tableau, int[] keys)
    {
        // initialize the Young tableau by infinity
        // initialize the Young tableau by infinity
        for (int i = 0; i < N; i++) {
            Arrays.fill(tableau[i], Integer.MAX_VALUE);
        }

        // do for each key
        for (int key: keys)
        {
            // check for overflow
            if (tableau[N-1][N-1] != Integer.MAX_VALUE) {
                System.out.print("Young tableau is full. Increase value of N.");
                break;
            }

            // place key at the bottom right corner of the tableau
            tableau[N-1][N-1] = key;

            // move the key to its correct position in the tableau
            insert(tableau, N-1, N-1);
        }
    }

    // Function to sort given keys using Young tableau
    public static void sort(int[] keys)
    {
        // construct a Young tableau from above keys
        int[][] tableau = new int[N][N];
        insert(tableau, keys);

        // call extractMin() N*N times and fill keys[] with the returned values
        for (int i = 0; i < keys.length; i++) {
            keys[i] = extractMin(tableau);
        }
    }

    public static void main(String[] args)
    {
        // unsorted input - input length should be <= N*N
        int[] keys = { 6, 4, 8, 7, 2, 3, 1, 5 };

        // sort the input keys
        sort(keys);

        // print the sorted input
        System.out.println(Arrays.toString(keys));
    }
}