package com.example.techiedelight.Algorithms.Stack;

import java.util.Arrays;
import java.util.Stack;

class FindNextGreaterElementForEveryElementInTheArray {
 
    // Find the next greater element for every element in the array
    public static void findNextGreaterElements(int[] arr)
    {
        // do for each element
        for (int i = 0; i < arr.length; i++)
        {
            // keep track of the next greater element for element `arr[i]`
            int next = -1;
 
            // process elements on the right of element `arr[i]`
            for (int j = i + 1; j < arr.length; j++)
            {
                // break the inner loop at the first larger element on the
                // right of element `arr[i]`
                if (arr[j] > arr[i])
                {
                    next = arr[j];
                    break;
                }
            }
 
            System.out.print(next + " ");
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 2, 7, 3, 5, 4, 6, 8 };
        findNextGreaterElements(arr);
    }
}




class FindNextGreaterElementForEveryElementInTheArrayA2 {

    // Find the next greater element for every element in the array
    public static int[] findNextGreaterElements(int[] arr)
    {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        // create an empty stack
        Stack<Integer> s = new Stack<>();

        // do for each element
        for (int i = 0; i < arr.length; i++)
        {
            // loop till we have a greater element on top or stack becomes empty

            // Keep popping elements from the stack that are smaller than the current
            // element, and set their next greater element to the current element

            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                result[s.pop()] = arr[i];
            }

            // push current "index" to stack
            s.push(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 7, 3, 5, 4, 6, 8 };

        int[] result = findNextGreaterElements(arr);
        System.out.println(Arrays.toString(result));
    }
}





class FindNextGreaterElementForEveryElementInTheArrayA3
{
    public static int[] findNextGreaterElements(int[] arr)
    {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // create an empty stack
        Stack<Integer> s = new Stack<>();

        // process each element from right to left
        for (int i = n - 1; i >= 0; i--)
        {
            // loop till we have a greater element on top or stack becomes empty
            while (!s.empty())
            {
                // pop elements that aren't greater than the current element
                if (s.peek() <= arr[i]) {
                    s.pop();
                }
                // the next greater element is now on the top of the stack
                else {
                    result[i] = s.peek();
                    break;
                }
            }

            // push current element to stack
            s.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 7, 3, 5, 4, 6, 8 };

        int[] result = findNextGreaterElements(arr);
        System.out.println(Arrays.toString(result));
    }
}