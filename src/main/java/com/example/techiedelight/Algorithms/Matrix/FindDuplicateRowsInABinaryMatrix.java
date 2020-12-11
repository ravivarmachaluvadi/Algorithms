package com.example.techiedelight.Algorithms.Matrix;

import java.util.HashSet;
import java.util.Set;

//Approach 1 (Using Trie) –
class FindDuplicateRowsInABinaryMatrix
{
    // Iterative function to insert array in Trie.
    public static boolean insert(Trie head, int[] A)
    {
        // start from root node
        Trie curr = head;
 
        for (int i: A)
        {
            // create a new node if path doesn't exists
            if (curr.character[i] == null) {
                curr.character[i] = new Trie();
            }
 
            // go to next node
            curr = curr.character[i];
        }
 
        // if row is inserted before, return false
        if (curr.isLeaf) {
            return false;
        }
 
        // mark leaf node and return true
        return (curr.isLeaf = true);
    }
 
    public static void main (String[] args)
    {
        Trie head = new Trie();
 
        int mat[][] =
        {
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0}
        };
 
        // insert all rows into trie
        for (int i = 0; i < mat.length; i++) {
            if (!insert(head, mat[i])) {
                System.out.println("Duplicate row found: Row #" + (i + 1));
            }
        }
    }
}


// A class representing a Trie node
class Trie
{
    boolean isLeaf;    // set when node is a leaf node
    Trie[] character = new Trie[2];

    // Constructor
    Trie()
    {
        isLeaf = false;
    }
}




//Approach 2 (Converting to Decimal) –
class FindDuplicateRowsInABinaryMatrixA2
{
    public static void main(String[] args)
    {
        int M[][] =
                {
                        {0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0},
                        {0, 1, 1, 0, 0}
                };

        Set<Integer> set = new HashSet<>();

        // do for each row i
        for (int i = 0; i < M.length; i++)
        {
            int decimal = 0;

            // convert binary row i into its decimal equivalent
            for (int j = 0; j < M[i].length; j++) {
                decimal += M[i][j] * Math.pow(2, j);
            }

            // if decimal value is seen before
            if (set.contains(decimal)) {
                System.out.println("Duplicate row found : Row #" + (i + 1));
            }
            else {
                set.add(decimal);
            }
        }
    }
}