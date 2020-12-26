package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class CreateMirrorOfAnMAryTree
{
    // Traverse and print an m-ary tree using pre-order traversal
    public static void printTree(NodeChild root)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // print the current node
        System.out.print(root.data + " ");
 
        // recur for all children nodes from left to right
        for (NodeChild child: root.child) {
            printTree(child);
        }
    }
 
    // Recursive function to convert an m-ary tree to its mirror image
    public static void convertToMirror(NodeChild root)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // recur for each children
        for (NodeChild child: root.child) {
            convertToMirror(child);
        }
 
        // Reverse the order of the elements in the children
        int n = root.child.size();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            NodeChild temp = root.child.get(i);
            root.child.set(i, root.child.get(j));
            root.child.set(j, temp);
        }
    }
 
    public static void main(String[] args)
    {
        // construct an m-ary tree
        NodeChild root = new NodeChild(1);
 
        (root.child).add(new NodeChild(2));
        (root.child).add(new NodeChild(3));
        (root.child).add(new NodeChild(4));
        (root.child).add(new NodeChild(5));
        (root.child).add(new NodeChild(6));
 
        (root.child.get(0).child).add(new NodeChild(7));
        (root.child.get(0).child).add(new NodeChild(8));
        (root.child.get(0).child).add(new NodeChild(9));
 
        (root.child.get(2).child).add(new NodeChild(10));
        (root.child.get(2).child).add(new NodeChild(11));
        (root.child.get(2).child).add(new NodeChild(12));
 
        (root.child.get(4).child).add(new NodeChild(13));
        (root.child.get(4).child).add(new NodeChild(14));
 
        (root.child.get(0).child.get(1).child).add(new NodeChild(15));
        (root.child.get(0).child.get(1).child).add(new NodeChild(16));
 
        (root.child.get(4).child.get(0).child).add(new NodeChild(17));
        (root.child.get(4).child.get(0).child).add(new NodeChild(18));
        (root.child.get(4).child.get(0).child).add(new NodeChild(19));
        (root.child.get(4).child.get(0).child).add(new NodeChild(20));
 
        convertToMirror(root);
        printTree(root);
    }
}




// Data structure to store m-ary tree nodes
class NodeChild
{
    int data;
    List<NodeChild> child;

    NodeChild(int data) {
        this.data = data;
        child = new ArrayList<>();
    }
}