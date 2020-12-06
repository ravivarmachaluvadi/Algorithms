package com.example.techiedelight.Algorithms.DivideAndConquer;

class TernarySearchVsBinarySearch
{
    public static int ternarySearch(int[] A, int x)
    {
        int left = 0, right = A.length - 1;
 
        while (left <= right)
        {
            int leftMid = left + (right - left) / 3;
            int rightMid = right - (right - left) / 3;
 
            // int leftMid = (2*left + right) / 3;
            // int rightMid = (left + 2*right) / 3;
 
            if (A[leftMid] == x) {
                return leftMid;
 
            } else if (A[rightMid] == x) {
                return rightMid;
            }
            else if (A[leftMid] > x) {
                right = leftMid - 1;
            }
            else if (A[rightMid] < x) {
                left = rightMid + 1;
            }
            else {
                left = leftMid + 1;
                right = rightMid - 1;
            }
        }
        return -1;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 2, 5, 6, 8, 9, 10 };
        int key = 6;
 
        int index = ternarySearch(A, key);
 
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}