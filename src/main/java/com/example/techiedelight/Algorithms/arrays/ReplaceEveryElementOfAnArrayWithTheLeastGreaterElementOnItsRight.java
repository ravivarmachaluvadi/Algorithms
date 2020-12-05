package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class ReplaceEveryElementOfAnArrayWithTheLeastGreaterElementOnItsRight
{
    // Replace each element of the specified array with the
    // least greater element on its right
    public static void findInorderSuccessor(int[] arr)
    {
        // traverse the array from the beginning
        for (int i = 0; i < arr.length; i++)
        {
            int successor = -1;
            int diff = Integer.MAX_VALUE;
 
            // check every element on right of current element for successor
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] > arr[i] && (arr[j] - arr[i] < diff))
                {
                    successor = arr[j];
                    diff = arr[j] - arr[i];
                }
            }
            arr[i] = successor;
        }
 
        // print the resultant array
        System.out.println(Arrays.toString(arr));
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6};
 
        findInorderSuccessor(arr);
    }
}


// Data structure to store a Binary Search Tree node
class Node
{
    int key;
    Node left = null, right = null;

    Node(int key) {
        this.key = key;
    }
}

class ReplaceEveryElementOfAnArrayWithTheLeastGreaterElementOnItsRightOpti
{
    // Function to insert a specified key in the binary search tree
    // rooted at specified node and also find its successor
    public static Node insert(Node root, int key, AtomicInteger successor)
    {
        // base case: empty tree
        if (root == null) {
            return new Node(key);
        }

        // if the key is less than root
        if (key < root.key) {
            // set successor as current node
            successor.set(root.key);

            // traverse the left subtree
            root.left = insert(root.left, key, successor);
        }

        // if the key is more than root
        else if (key > root.key) {
            // traverse the right subtree
            root.right = insert(root.right, key, successor);
        }

        return root;
    }

    // Replace each element of the specified array with the
    // least greater element on its right
    public static void findInorderSuccessor(int[] arr)
    {
        // root of the binary search tree
        Node root = null;

        // traverse the array from the end
        for (int i = arr.length - 1; i >= 0; i--)
        {
            // insert the current element in the binary search tree
            // and replace it with its in-order successor
            AtomicInteger successor = new AtomicInteger(-1);
            root = insert(root, arr[i], successor);
            arr[i] = successor.get();
        }

        // print the resultant array
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6 };

        findInorderSuccessor(arr);
    }
}