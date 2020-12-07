package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.HashMap;
import java.util.Map;

class CloneABinaryTreeWithRandomPointers
{
    // Function to print the preorder traversal of a binary tree
    public static void preorder(NodeRandom root)
    {
        if (root == null) {
            return;
        }
 
        // print data
        System.out.print(root.data + " -> (");
 
        // print left child's data
        System.out.print((root.left != null ? root.left.data : "X") + ", ");
 
        // print right child's data
        System.out.print((root.right != null ? root.right.data : "X") + ", ");
 
        // print random child's data
        System.out.println((root.random != null ? root.random.data : "X") + ")");
 
        // recur for the left and right subtree
        preorder(root.left);
        preorder(root.right);
    }
 
    // Recursive function to copy random pointers from the original binary tree
    // into the cloned binary tree using the map
    public static void updateRandomPointers(NodeRandom root, Map<NodeRandom, NodeRandom> map)
    {
        // base case
        if (map.get(root) == null) {
            return;
        }
 
        // update the random pointer of cloned NodeRandom
        map.get(root).random = map.get(root.random);
 
        // recur for left and right subtree
        updateRandomPointers(root.left, map);
        updateRandomPointers(root.right, map);
    }
 
    // Recursive function to clone the data, left and right pointers for
    // each NodeRandom of a binary tree into a given map
    public static NodeRandom cloneLeftRightPointers(NodeRandom root, Map<NodeRandom, NodeRandom> map)
    {
        // base case
        if (root == null) {
            return null;
        }
 
        // clone all fields of the root NodeRandom except the random pointer
 
        // create a new NodeRandom with same data as root NodeRandom
        map.put(root, new NodeRandom(root.data));
 
        // clone the left and right subtree
        map.get(root).left = cloneLeftRightPointers(root.left, map);
        map.get(root).right = cloneLeftRightPointers(root.right, map);
 
        // return cloned root NodeRandom
        return map.get(root);
    }
 
    // CloneABinaryTreeWithRandomPointers function to clone a special binary tree with random pointers
    public static NodeRandom cloneSpecialBinaryTree(NodeRandom root)
    {
        // create a map to store mappings from a NodeRandom to its clone
        Map<NodeRandom, NodeRandom> map = new HashMap<>();
 
        // clone data, left and right pointers for each NodeRandom of the original
        // binary tree and put references into the map
        cloneLeftRightPointers(root, map);
 
        // update random pointers from the original binary tree into the map
        updateRandomPointers(root, map);
 
        // return the cloned root NodeRandom
        return map.get(root);
    }
 
    public static void main(String[] args)
    {
        NodeRandom root = new NodeRandom(1);
        root.left = new NodeRandom(2);
        root.right = new NodeRandom(3);
        root.left.left = new NodeRandom(4);
        root.left.right = new NodeRandom(5);
        root.right.left = new NodeRandom(6);
        root.right.right = new NodeRandom(7);
 
        root.random = root.right.left.random;
        root.left.left.random = root.right;
        root.left.right.random = root;
        root.right.left.random = root.left.left;
        root.random = root.left;
 
        System.out.println("Preorder traversal of the original tree:");
        preorder(root);
 
        NodeRandom clone = cloneSpecialBinaryTree(root);
 
        System.out.println("\nPreorder traversal of the cloned tree:");
        preorder(clone);
    }
}


// Data structure to store the special binary tree NodeRandom
// with random pointer
class NodeRandom
{
    int data;
    NodeRandom left, right;
    NodeRandom random;

    // Constructor
    NodeRandom(int data) {
        this.data = data;
    }
}