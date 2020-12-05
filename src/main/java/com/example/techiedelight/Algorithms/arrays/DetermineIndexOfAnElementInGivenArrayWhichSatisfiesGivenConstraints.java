package com.example.techiedelight.Algorithms.arrays;

class DetermineIndexOfAnElementInGivenArrayWhichSatisfiesGivenConstraints
{
    // Determine index of an element in the array before which all elements
    // are smaller and after which all are greater
    public static int findIndex(int[] arr)
    {
        // get length of the array
        int n = arr.length;
 
        // left[i] stores the maximum element in the sub-array A[0..i-1]
        int[] left = new int[n];
 
        // initialize left[0] to the minimum value
        left[0] = Integer.MIN_VALUE;
 
        // traverse the array from left to right and fill left[]
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i - 1]);
        }
 
        // right[i] stores the minimum element in the sub-array A[i+1, n-1]
        int[] right = new int[n];
 
        // initialize right[0] to the maximum value
        right[n-1] = Integer.MAX_VALUE;
 
        // traverse the array from right to left and fill right[]
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], arr[i + 1]);
        }
 
        // traverse the array and return the desired index
        for (int i = 1; i < n-1 ; i++) {
            // index found
            if (left[i] < arr[i] && arr[i] < right[i]) {
                return i;
            }
        }
 
        // return some invalid index if the input is invalid
        return n;
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 3, 5, 1, 6, 9, 7 };
 
        int index = findIndex(arr);
 
        if (index >= 0 && index < arr.length) {
            System.out.println("The required index is " + index);
        }
        else {
            System.out.println("Invalid Input");
        }
    }
}



class DetermineIndexOfAnElementInGivenArrayWhichSatisfiesGivenConstraintsOpti
{
    // Determine index of an element in the array before which all elements
    // are smaller and after which all are greater
    public static int findIndex(int[] arr)
    {
        // left[i] stores the max element in the sub-array A[0..i-1]
        int[] left = new int[arr.length];

        // initialize left[0] to minimum value
        left[0] = Integer.MIN_VALUE;

        // traverse the array from left to right and fill left[]
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i - 1]);
        }

        // stores minimum element found so far to the right
        int min_so_far = arr[arr.length-1];

        // traverse the array from right to left
        for (int i = arr.length - 2; i > 0; i--)
        {
            // desired index found
            if (left[i] < arr[i] && arr[i] < min_so_far) {
                return i;
            }

            // update minimum element so far if required
            if (min_so_far > arr[i]) {
                min_so_far = arr[i];
            }
        }

        // return some invalid index if the input is invalid
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 3, 5, 1, 6, 9, 7 };

        int index = findIndex(arr);

        if (index >= 0 && index < arr.length) {
            System.out.println("The required index is " + index);
        }
        else {
            System.out.println("Invalid Input");
        }
    }
}