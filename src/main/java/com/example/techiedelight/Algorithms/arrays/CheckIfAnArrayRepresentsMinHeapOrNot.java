package com.example.techiedelight.Algorithms.arrays;

class CheckIfAnArrayRepresentsMinHeapOrNot
{
    // Function to check if given array represents Min-Heap or not
    public static boolean checkMinHeap(int[] A, int i)
    {
        // if i is a leaf node, return true as every leaf node is a heap
        if (2*i + 2 > A.length) {
            return true;
        }
 
        // if i is an internal node
 
        // recursively check if left child is heap
        boolean left = (A[i] <= A[2*i + 1]) && checkMinHeap(A, 2*i + 1);
 
        // recursively check if right child is heap (to avoid array out
        // of bound, we first check if right child exists or not)
        boolean right = (2*i + 2 == A.length) ||
                        (A[i] <= A[2*i + 2] && checkMinHeap(A, 2*i + 2));
 
        // return true if both left and right child are heap
        return left && right;
    }
 
    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 4, 5, 6};
 
        // start with index 0 (root of the heap)
        int index = 0;
 
        if (checkMinHeap(A, index)) {
            System.out.println("Given array is a min heap");
        } else {
            System.out.println("Given array is not a min heap");
        }
    }
}



class CheckIfAnArrayRepresentsMinHeapOrNotA1
{
    // Iterative function to check if given array represents
    // Min-Heap or not
    public static boolean checkMinHeap(int[] A)
    {
        // check for all internal nodes that their left child and
        // right child (if present) holds min-heap property or not

        // start with index 0 (root of the heap)
        for (int i = 0; i <= (A.length - 2) / 2; i++) {
            if (A[i] > A[2*i + 1] || (2*i + 2 != A.length && A[i] > A[2*i + 2])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 4, 5, 6};

        if (checkMinHeap(A)) {
            System.out.println("Given array is a min heap");
        } else {
            System.out.println("Given array is not a min heap");
        }
    }
}