package com.example.techiedelight.Algorithms.arrays;

import java.util.stream.IntStream;

//TC - O(N) , SC - O(N)  Hashing
class DuplicateElementInALimitedRangeArray
{
    // Function to find a duplicate element in a limited range array
    public static int findDuplicate(int[] A)
    {
        // create a visited array of size n+1
        // we can also use map instead of visited array
        boolean visited[] = new boolean[A.length + 1];
 
        // for each element of the array mark it as visited and
        // return the element if it is seen before
        for (int value : A) {
            // if element is seen before
            if (visited[value]) {
                return value;
            }
 
            // mark element as visited
            visited[value] = true;
        }
 
        // no duplicate found
        return -1;
    }
 
    public static void main (String[] args)
    {
        // input array contains n numbers between [1 to n - 1]
        // with one duplicate, where n = A.length
        int[] A = { 1, 2, 3, 4, 4 };
 
        System.out.println("Duplicate element is " + findDuplicate(A));
    }
}



class ByNegativeAndPositive
{
    // Function to find a duplicate element in a limited range array
    public static int findDuplicate(int[] A)
    {
        int duplicate = -1;

        // do for each element in the array
        for (int i: A)
        {
            // get value of the current element
            int val = (i < 0) ? -i : i;

            // make element at index (val-1) negative if it is positive
            if (A[val-1] >= 0) {
                A[val-1] = -A[val-1];
            }
            else
            {
                // if element is already negative, it is repeated
                duplicate = val;
                break;
            }
        }
        // restore original array before returning
        for (int i = 0; i < A.length; i++) {
            // make negative elements positive
            if (A[i] < 0) {
                A[i] = -A[i];
            }
        }

        // return duplicate element
        return duplicate;
    }

    public static void main (String[] args)
    {
        // input array contains n numbers between [1 to n - 1]
        // with one duplicate, where n = A.length
        int[] A = { 1, 2, 3, 4, 2 };

        System.out.println("Duplicate element is " + findDuplicate(A));
    }
}

// The time complexity of above and below solution is O(n) and auxiliary space used by the program is O(1).


class UsingXOR
{
    // Function to find a duplicate element in a limited range array
    public static int findDuplicate(int[] A)
    {
        int xor = 0;

        // take xor of all array elements
        for (int value : A) {
            xor ^= value;
        }

        // take xor of numbers from 1 to n-1
        for (int i = 1; i <= A.length - 1; i++) {
            xor ^= i;
        }

        // same elements will cancel out each other as a ^ a = 0,
        // 0 ^ 0 = 0 and a ^ 0 = a

        // xor will contain the missing number
        return xor;
    }

    public static void main(String[] args)
    {
        // input array contains n numbers between [1 to n - 1]
        // with one duplicate, where n = A.length
        int[] A = { 1, 2, 3, 4, 4 };

        System.out.println("Duplicate element is " + findDuplicate(A));
    }
}



class FindDuplicate
{
    public static int findDuplicate(int[] A)
    {
        int actual_sum = IntStream.of(A).sum();
        int expected_sum = A.length * (A.length - 1) / 2;

        return actual_sum - expected_sum;
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 4 };
        System.out.println("The duplicate element is " + findDuplicate(A));
    }
}