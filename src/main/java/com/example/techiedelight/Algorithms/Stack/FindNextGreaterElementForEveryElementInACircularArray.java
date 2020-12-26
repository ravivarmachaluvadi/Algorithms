package com.example.techiedelight.Algorithms.Stack;

import java.util.Arrays;
import java.util.Stack;
 
class FindNextGreaterElementForEveryElementInACircularArray {
    public static int[] findNextGreater(int[] input) {
        int n = input.length;
        int[] out = new int[n];
        Arrays.fill(out, -1);
        Stack<Integer> s = new Stack<>();
 
        for (int i = 0; i < 2*n; i++) {
            while (!s.isEmpty() && input[s.peek()] < input[i % n]) {
                out[s.pop()] = input[i % n];
            }
            s.add(i % n);
        }
        return out;
    }
 
    public static void main(String[] args)
    {
        int[] input = { 3, 5, 2, 4 };
 
        int[] out = findNextGreater(input);
        System.out.println(Arrays.toString(out));
    }
}






class FindNextGreaterElementForEveryElementInACircularArrayA2 {

    public static int[] findNextGreater(int[] input)
    {
        int n = input.length;
        int[] out = new int[n];
        Arrays.fill(out, -1);
        Stack<Integer> s = new Stack<>();

        for (int i = 2*n - 1; i >= 0; i--) {
            while (!s.isEmpty()) {
                if (s.peek() <= input[i % n]) {
                    s.pop();
                }
                else {
                    out[i % n] = s.peek();
                    break;
                }
            }
            s.add(input[i % n]);
        }

        return out;
    }

    public static void main(String[] args)
    {
        int[] input = { 3, 5, 2, 4 };

        int[] out = findNextGreater(input);
        System.out.println(Arrays.toString(out));
    }
}