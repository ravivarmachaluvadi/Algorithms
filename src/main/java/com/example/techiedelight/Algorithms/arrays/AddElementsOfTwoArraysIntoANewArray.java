package com.example.techiedelight.Algorithms.arrays;

import java.util.ArrayList;
import java.util.List;
 
class AddElementsOfTwoArraysIntoANewArray
{
    // Recursive function to separate the digits of a positive integer
    // and add them to a given list
    public static void split_number(int num, List<Integer> result)
    {
        if (num > 0) {
            split_number(num/10, result);
            result.add(num % 10);
        }
    }
 
    // Function to add two arrays
    public static void add(int[] a, int[] b, List<Integer> result)
    {
        int m = a.length, n = b.length;
 
        // loop till a or b runs out
        int i = 0;
        while (i < m && i < n)
        {
            // get sum of next element from each array
            int sum = a[i] + b[i];
 
            // separate the digits of sum and add them to output list
            split_number(sum, result);
            i++;
        }
 
        // process remaining elements of first list, if any
        while (i < m) {
            split_number(a[i++], result);
        }
 
        // process remaining elements of second list, if any
        while (i < n) {
            split_number(b[i++], result);
        }
    }
 
    public static void main(String[] args)
    {
        // input lists
        int[] a = { 23, 5, 2, 7, 87 };
        int[] b = { 4, 67, 2, 8 };
 
        // list to store the output
        List<Integer> result = new ArrayList<>();
        add(a, b, result);
 
        // print the output list
        System.out.print(result);
    }
}


class AddElementsOfTwoArraysIntoANewArrayOpti
{
    // Function to add two arrays
    public static void add(int[] a, int[] b, List<Integer> result) {
        int m = a.length, n = b.length;
        String str = "";

        // loop till a or b runs out
        int i = 0;
        while (i < m && i < n) {
            str += (a[i] + b[i]);
            i++;
        }

        // process remaining elements of first list, if any
        while (i < m) {
            str += (a[i++]);
        }

        // process remaining elements of second list, if any
        while (i < n) {
            str += (b[i++]);
        }

        // add characters of the output string to given list of integers
        char[] chars = str.toCharArray();
        for (char c : chars) {
            result.add(c - '0');
        }
    }

    public static void main(String[] args)
    {
        // input lists
        int[] a = { };
        int[] b = { 4, 67, 2, 8 };

        // list to store the output
        List<Integer> result = new ArrayList<>();
        add(a, b, result);

        // print the output list
        System.out.print(result);
    }
}