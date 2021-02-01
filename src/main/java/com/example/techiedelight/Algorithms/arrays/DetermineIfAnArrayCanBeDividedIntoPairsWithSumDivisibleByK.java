package com.example.techiedelight.Algorithms.arrays;

class DetermineIfAnArrayCanBeDividedIntoPairsWithSumDivisibleByK {
 
    // Determine if an array can be divided into pairs such that the sum of elements
    // in each pair is divisible by the given integer `k`
    public static int findPairsWithSumK(int[] arr, int k)
    {
        // base case: input contains an odd number of elements
        // (an odd number of elements cannot be paired)
        if (arr.length % 2 == 1) {
            return 0;
        }
 
        // create a boolean array to mark elements that formed a pair
        int[] visited = new int[arr.length];
 
        // initialize visited array by value 0
        for (int i = 0; i < arr.length; i++) {
            visited[i] = 0;
        }
 
        // consider each element as the first element of a pair
        for (int i = 0; i < arr.length - 1; i++)
        {
            // ignore the current element if it is already part of another pair
            if (visited[i] != 0) {
                continue;
            }
 
            // find the first non-visited element `arr[j]` that forms a pair with `arr[i]`
            int j = i + 1;
            while (j < arr.length) {
                if (visited[j] == 0 && (arr[j] + arr[i]) % k == 0) {
                    // pair found `(arr[i], arr[j])`
                    visited[j] = 1;
                    break;
                }
                j++;
            }
 
            // return 0 if pair not found for the current element
            if (j == arr.length) {
                return 0;
            }
        }
 
        // we reach here only when each element forms a pair
        return 1;
    }
 
    public static void main(String[] args) {
        int[] arr = { 2, 9, 4, 1, 3, 5 };
        int k = 6;
 
        if (findPairsWithSumK(arr, k) != 0) {
            System.out.println("Pairs can be formed");
        }
        else {
            System.out.println("Pairs cannot be formed");
        }
    }
}





//Hashing Solution
class DetermineIfAnArrayCanBeDividedIntoPairsWithSumDivisibleByKA2 {

    // Determine if an array can be divided into pairs such that the sum of elements
    // in each pair is divisible by the given integer `k`
    public static boolean findPairsWithSumK(int[] arr, int k)
    {
        // base case: input contains an odd number of elements
        // (an odd number of elements cannot be paired)
        if ((arr.length & 1) == 1) {
            return false;
        }

        // create a count array to keep track of the remainder of
        // input elements with `k`
        int[] freq = new int[k];

        // consider each element
        for (int i = 0; i < arr.length; i++)
        {
            // calculate the remainder of the current element with `k`
            int r = arr[i] % k;

            // increment the count array
            freq[r]++;
        }

        // the frequency of elements directly divisible by `k` must be even
        if (freq[0] % 2 != 0) {
            return false;
        }

        // for each element with remainder `r`, there should be an element with
        // remainder `k-r`
        for (int r = 1; r <= k / 2; r++) {
            if (freq[r] != freq[k - r]) {
                return false;
            }
        }

        // we reach here only when each element forms a pair
        return true;
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 9, 4, 1, 3, 5 };
        int k = 6;

        if (findPairsWithSumK(arr, k)) {
            System.out.println("Pairs can be formed");
        }
        else {
            System.out.println("Pairs cannot be formed");
        }
    }
}





