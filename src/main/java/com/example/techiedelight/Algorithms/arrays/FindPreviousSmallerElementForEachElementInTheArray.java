package com.example.techiedelight.Algorithms.arrays;

import java.util.Stack;

//Brute-Force Approach
class FindPreviousSmallerElementForEachElementInTheArray {
 
    // Find the previous smaller element for every array element
    public static void findPrevSmaller(int[] arr)
    {
        // do for each element
        for (int i = 0; i < arr.length; i++)
        {
            // keep track of the previous smaller element for element `arr[i]`
            int prev = -1;
 
            // process elements on the left of the element `arr[i]`
            for (int j = i - 1; j >= 0; j--)
            {
                // break the inner loop at the first smaller element on the
                // left of the element `arr[i]`
                if (arr[j] < arr[i])
                {
                    prev = arr[j];
                    break;
                }
            }
 
            System.out.print(prev + " ");
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 2, 5, 3, 7, 8, 1, 9 };
        findPrevSmaller(arr);
    }
}



//Using Stack
class FindPreviousSmallerElementForEachElementInTheArrayA2 {

    // Find the previous smaller element for every array element
    public static void findPrevSmaller(int[] arr)
    {
        // create an empty stack
        Stack<Integer> s = new Stack<>();

        // do for each element
        for (int i = 0; i < arr.length; i++)
        {
            // loop till stack is empty
            while (!s.empty())
            {
                // If the stack's top element is less than the current element,
                // it is the previous smaller element
                if (s.peek() < arr[i]) {
                    System.out.print(s.peek() + " ");
                    break;
                }
                // remove the stack's top element is less if it is greater or equal
                // to the current element
                else {
                    s.pop();
                }
            }

            // If the stack becomes empty, all elements to the left
            // of the current element are greater
            if (s.empty()) {
                System.out.print(-1 + " ");
            }

            // push current element into the stack
            s.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 7, 8, 1, 9 };
        findPrevSmaller(arr);
    }
}




