package com.example.techiedelight.Algorithms.arrays;

class FindMinimumAndMaximumElementInAnArrayUsingMinimumComparisons
{
    // Naive solution to find minimum and maximum number in an array
    public static void findMinAndMax(int[] A)
    {
        // initialize minimum and maximum element by first element
        int max = A[0];
        int min = A[0];
 
        // do for each element in the array
        for (int i = 1; i < A.length; i++)
        {
            // if current element is greater than maximum found so far
            if (A[i] > max) {
                max = A[i];
            }
 
            // if current element is smaller than minimum found so far
            else if (A[i] < min) {
                min = A[i];
            }
        }
 
        System.out.println("The minimum element in the array is " + min);
        System.out.println("The maximum element in the array is " + max);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 5, 7, 2, 4, 9, 6 };
 
        // find minimum and maximum element respectively
        findMinAndMax(A);
    }
}


class FindMinimumAndMaximumElementInAnArrayUsingMinimumComparisonsOpti
{
    // Optimized solution to find minimum and maximum number in an array
    public static void findMinAndMax(int[] A, int n)
    {
        // initialize minimum element by infinity and the maximum
        // element by minus infinity
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // if the array has odd number of elements, ignore last
        // element and consider it later
        boolean odd = (n & 1) == 1;
        if (odd) n--;

        // compare elements in pairs i.e. A[i] and A[i+1]
        for (int i = 0; i < n; i = i + 2)
        {
            int maximum, minimum;

            // find maximum and minimum among A[i], A[i+1]

            if (A[i] > A[i + 1])    // 1st comparison
            {
                minimum = A[i + 1];
                maximum = A[i];
            }
            else {
                minimum = A[i];
                maximum = A[i + 1];
            }

            // update max
            if (maximum > max) {        // 2nd comparison
                max = maximum;
            }

            // update min
            if (minimum < min) {        // 3rd comparison
                min = minimum;
            }
        }

        // handle last element if the array has odd number of elements
        if (odd)
        {
            if (A[n] > max) {
                max = A[n];
            }

            if (A[n] < min) {
                min = A[n];
            }
        }

        System.out.println("The minimum element in the array is " + min);
        System.out.println("The maximum element in the array is " + max);
    }

    public static void main(String[] args)
    {
        int[] A = { 4, 7, 5, 1, 3 };

        findMinAndMax(A, A.length);
    }
}