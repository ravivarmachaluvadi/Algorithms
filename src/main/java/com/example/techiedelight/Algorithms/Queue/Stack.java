package com.example.techiedelight.Algorithms.Queue;

import java.util.ArrayDeque;
import java.util.Queue;
 
// Implement Stack using two queues
class Stack<T>
{
    Queue<T> q1, q2;
 
    // Constructor
    public Stack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
 
    // Insert an item into the stack
    void add(T data)
    {
        // Move all elements from the first queue to the second queue
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.poll();
        }
 
        // Push item into the first queue
        q1.add(data);
 
        // Move all elements back to the first queue from the second queue
        while (!q2.isEmpty()) {
            q1.add(q2.peek());
            q2.poll();
        }
    }
 
    // Remove the top item from the stack
    public T poll()
    {
        // if first queue is isEmpty
        if (q1.isEmpty()) {
            System.out.println("Underflow!!");
            System.exit(0);
        }
 
        // return the front item from the first queue
        T front = q1.peek();
        q1.poll();
 
        return front;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5 };
 
        // insert above keys into the stack
        Stack s = new Stack();
        for (int key : keys) {
            s.add(key);
        }
 
        for (int i = 0; i <= keys.length; i++) {
            System.out.println(s.poll());
        }
    }
}






//Using one queue with recursive call stack
class StackR<T>
{
    Queue<T> q;

    // Constructor
    public StackR() {
        q = new ArrayDeque<>();
    }

    // Insert an item into the stack
    public void add(T data) {
        q.add(data);
    }

    // Utility function to reverse contents of a queue
    private void reverseQueue()
    {
        // base case
        if (q.isEmpty()) {
            return;
        }

        // hold front element in recursion call stack and insert
        // it back into the queue after recursive call is over

        T front = q.peek();
        q.poll();

        reverseQueue();

        q.add(front);
    }

    // Remove the top item from the stack
    public T poll()
    {
        // if the queue is isEmpty
        if (q.isEmpty()) {
            System.out.println("Underflow!!");
            System.exit(0);
        }

        // reverse the queue
        reverseQueue();

        // pop front element of reversed queue
        T front = q.peek();
        q.poll();

        // revert the queue to original state
        reverseQueue();

        return front;
    }

    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5 };

        // insert above keys into the stack
        Stack s = new Stack();
        for (int key : keys) {
            s.add(key);
        }

        for (int i = 0; i <= keys.length; i++) {
            System.out.println(s.poll());
        }
    }
}