package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
class CountDistinctAbsoluteValuesInASortedArray
{
    // Returns the number of distinct absolute values in the given input
    public static int findDistinct(List<Integer> input)
    {
        Set<Integer> set = new HashSet<>();
        for (int i: input) {
            set.add(Math.abs(i));
        }
 
        return set.size();
    }
 
    public static void main(String[] args)
    {
        List<Integer> input = Arrays.asList(-1, -1, 0, 1, 1, 1);
 
        System.out.print("The number of distinct absolute values are "
                                + findDistinct(input));
    }
}


class CountDistinctAbsoluteValuesInASortedArrayOpti
{
    // Returns the number of distinct absolute values in the given input
    public static int findDistinct(int[] A)
    {
        // initialize the distinct count as A size
        int distinct_count = A.length;

        // points to left and right boundary of the current window
        // i.e. current window is formed by A[left, right]
        int left = 0;
        int right = A.length - 1;

        // loop until left index of the current window is
        // less than right index
        while (left < right)
        {
            // remove any duplicate elements from the left and right
            // of the curr window and decrease the distinct count
            // for each duplicate found
            while (left < right && A[left] == A[left+1]) {
                distinct_count--;
                left++;
            }
            while (right > left && A[right] == A[right-1]) {
                distinct_count--;
                right--;
            }

            // if only one element is left, break the loop
            if (left == right) {
                break;
            }

            int sum = A[left] + A[right];

            // decrease the distinct count if zero sum pair is encountered
            if (sum == 0) {
                distinct_count--;
                left++;
                right--;
            }
            // if sum is negative, incrementing left index might still lead
            // to zero sum pair
            else if (sum < 0) {
                left++;
            }
            // if sum is positive, decrementing right index might still lead
            // to zero sum pair
            else {
                right--;
            }
        }

        return distinct_count;
    }

    public static void main(String[] args)
    {
        int[] input = { -1, -1, 0, 1, 1, 1 };

        System.out.print("The number of distinct absolute values are "
                + findDistinct(input));
    }
}