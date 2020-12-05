package com.example.techiedelight.Algorithms.arrays;

class CountNumberOfStrictlyIncreasingSubArraysInAnArray
{
    // Function to count the number of strictly increasing sub-arrays in an array
    public static int getCount(int[] arr)
    {
        // stores the count of strictly increasing sub-arrays
        int count = 0;
 
        // consider all sub-arrays arr[i, j] starting from index i
        // and ending at index j
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                // if previous element is not less than the current element,
                // then the sub-array arr[i, j] is not strictly increasing
                if (arr[j - 1] >= arr[j])
                {
                    // don't consider index from j+1 onwards
                    break;
                }
 
                // if the sub-array arr[i, j] is strictly increasing,
                // increment the total count
                ++count;
            }
        }
 
        // return the count of strictly increasing sub-arrays
        return count;
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 4, 4, 5 };
 
        System.out.print("The number of strictly increasing sub-arrays are "
                                + getCount(arr));
    }
}



class CountNumberOfStrictlyIncreasingSubArraysInAnArrayOpti
{
    // Function to count the number of strictly increasing sub-arrays in an array
    public static int getCount(int[] arr)
    {
        // stores the count of strictly increasing sub-arrays
        int count = 0;

        // stores the length of current strictly increasing sub-array
        int len = 1;

        // traverse the array from left to right starting from the 1st index
        for (int i = 1; i < arr.length; i++)
        {
            // if previous element is less than the current element
            if (arr[i - 1] < arr[i])
            {
                // add the length of current strictly increasing sub-array
                // to the answer and increment it
                count += (len++);
            }
            else
            {
                // reset the length to 1
                len = 1;
            }
        }

        // return the count of strictly increasing sub-arrays
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 2, 4, 5 };

        System.out.print("The number of strictly increasing sub-arrays are "
                + getCount(arr));
    }
}