package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
 
class nThFibonaccinumber
{
    // Function to find nth Fibonacci number
    public static int fib(int n, Map<Integer, Integer> lookup)
    {
        if (n <= 1) {
            return n;
        }
 
        // if sub-problem is seen for the first time
        if (!lookup.containsKey(n)) {
            int val = fib(n - 1, lookup) + fib(n - 2, lookup);
            lookup.put(n, val);
        }
 
        return lookup.get(n);
    }
 
    public static void main(String[] args)
    {
        int n = 8;
        Map<Integer, Integer> lookup = new HashMap<>();
 
        System.out.println(fib(n, lookup));
 
    }
}




class nThFibonaccinumberA2
{
    // Function to find n'th fibonacci number
    public static int fib(int n)
    {
        if (n <= 1) {
            return n;
        }

        int previousFib = 0, currentFib = 1;
        for (int i = 0; i < n - 1; i++) {
            int newFib = previousFib + currentFib;
            previousFib = currentFib;
            currentFib = newFib;
        }

        return currentFib;
    }

    public static void main(String[] args)
    {
        System.out.print(fib(8));
    }
}