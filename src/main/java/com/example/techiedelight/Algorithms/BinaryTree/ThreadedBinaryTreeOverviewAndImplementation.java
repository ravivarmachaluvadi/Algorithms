package com.example.techiedelight.Algorithms.BinaryTree;

class ThreadedBinaryTreeOverviewAndImplementation
{
    // Utility function to return leftmost NodeThreaded in the given binary tree
    public static NodeThreaded leftMostNode(NodeThreaded root)
    {
        NodeThreaded NodeThreaded = root;
        while (NodeThreaded != null && NodeThreaded.left != null) {
            NodeThreaded = NodeThreaded.left;
        }
        return NodeThreaded;
    }
 
    // Iterative function to perform inorder traversal of a threaded binary tree
    public static void traverse(NodeThreaded root)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // start from the leftmost NodeThreaded
        NodeThreaded curr = leftMostNode(root);
        while (curr != null)
        {
            // print current NodeThreaded
            System.out.print(curr.data + " ");
 
            // go to inorder successor if current NodeThreaded is a threaded
            if (curr.isThreaded)
            {
                curr = curr.right;
            }
            // else visit leftmost child in the right subtree
            else
            {
                curr = leftMostNode(curr.right);
            }
        }
    }
 
    // Function to convert a binary tree to a threaded binary tree
    // using inorder traversal
    public static NodeThreaded populateNext(NodeThreaded curr, NodeThreaded prev)
    {
        // base case: empty tree
        if (curr == null) {
            return prev;
        }
 
        // recur for left subtree
        prev = populateNext(curr.left, prev);
 
        // if current NodeThreaded is not the root NodeThreaded of binary tree
        // and it has null right child
        if (prev != null && prev.right == null)
        {
            // set right child of previous NodeThreaded to point to the current NodeThreaded
            prev.right = curr;
 
            // set thread flag to true
            prev.isThreaded = true;
        }
 
        // update previous NodeThreaded
        prev = curr;
 
        // recur for right subtree
        prev = populateNext(curr.right, prev);
        return prev;
    }
 
    // Convert a binary tree to threaded binary tree
    public static void convertToThreaded(NodeThreaded root)
    {
        // stores previous visited NodeThreaded
        NodeThreaded prev = null;
        populateNext(root, prev);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  5
                /   \
               /     \
              2       7
             / \     / \
            /   \   /   \
            1    4 6     9
                /       / \
               /       /   \
              3       8     10
        */
 
        NodeThreaded root = new NodeThreaded(5);
        root.left = new NodeThreaded(2);
        root.right = new NodeThreaded(7);
        root.left.left = new NodeThreaded(1);
        root.left.right = new NodeThreaded(4);
        root.right.left = new NodeThreaded(6);
        root.right.right = new NodeThreaded(9);
        root.left.right.left = new NodeThreaded(3);
        root.right.right.left = new NodeThreaded(8);
        root.right.right.right = new NodeThreaded(10);
 
        convertToThreaded(root);
        traverse(root);
    }
}




// Data structure to store a threaded binary tree NodeThreaded
class NodeThreaded
{
    int data;
    NodeThreaded left, right;

    // true if right pointer of a NodeThreaded points to its inorder successor
    boolean isThreaded = false;

    NodeThreaded(int data) {
        this.data = data;
    }
}