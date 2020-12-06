package com.example.techiedelight.Algorithms.arraysGA;

import java.util.Arrays;
 
class FindMissingNumberAndDuplicateElementsInAnArray
{
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
 
    // Function to find the missing number and duplicate element
    // using XOR operator in an array of size n and range of
    // elements between [1 to n]
    public static void findMissingAndDuplicate(int[] arr)
    {
        int n = arr.length;
 
        // take XOR of all array elements from index [0 to n-1]
        // and all numbers in range [1 to n]
        int res = n;
        for (int i = 0; i < n; i++) {
            res = res ^ arr[i] ^ i;
        }
 
        // x, y stores the duplicate element and missing number
        int x = 0, y = 0;
 
        // res stores (x ^ y)
 
        // find position of the rightmost set bit in res
        int k = log(res & -res, 2);
 
        // split the array into two sub-arrays
        for (int value : arr) {
            // array elements that have k'th bit 1
            if ((value & (1 << k)) == 1) {
                x = x ^ value;
            }
 
            // array elements that have k'th bit 0
            else {
                y = y ^ value;
            }
        }
 
        // split the range [1-n] into two sub-range
        for (int i = 1; i <= n; i++) {
            // number i have k'th bit 1
            if ((i & (1 << k)) == 1) {
                x = x ^ i;
            }
 
            // number i have k'th bit 0
            else {
                y = y ^ i;
            }
        }
 
        // linear search for missing element
        System.out.print("Duplicate and missing elements are ");
        if (Arrays.asList(arr).contains(x)) {
            System.out.println(x + " and " + y);
        }
        else {
            System.out.println(y + " and " + x);
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 3, 6, 5, 2, 4 };
 
        findMissingAndDuplicate(arr);
    }
}