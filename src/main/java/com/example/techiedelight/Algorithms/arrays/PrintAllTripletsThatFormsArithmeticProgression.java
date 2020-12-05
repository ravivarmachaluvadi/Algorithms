package com.example.techiedelight.Algorithms.arrays;

class PrintAllTripletsThatFormsArithmeticProgression
{
    // Function to print all triplets that forms Arithmetic Progression
    // in given sorted array
    public static void findAllTriplets(int[] A)
    {
        if (A.length < 3) {
            return;
        }
 
        // consider A[j] as middle element of AP
        for (int j = 1; j < A.length - 1; j++)
        {
            // start with left and right index of j
            int i = j - 1, k = j + 1;
 
             // Find all i and k such that (i, j, k) forms a triplet of AP
            while (i >= 0 && k < A.length)
            {
                // if (A[i], A[j], A[k]) forms a triplet
                if (A[i] + A[k] == 2 * A[j])
                {
                    // print the triplet
                    System.out.println(A[i] + " " + A[j] + " " + A[k]);
 
                    // Since the array is sorted and elements are distinct
                    k++; i--;
                }
                // else if (A[i] + A[k]) is less than 2*A[j] then
                // try next k. Else, try previous i.
                else if (A[i] + A[k] < 2 * A[j]) {
                    k++;
                } else {
                    i--;
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 3, 5, 6, 8, 9, 15 };
 
        findAllTriplets(A);
    }
}