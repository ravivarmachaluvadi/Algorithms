package com.example.techiedelight.Algorithms.BinaryTree;

class SetNextPointerToInorderSuccessorOfAllNodesInBinaryTree
{
    // Function to set next pointer of all nodes in a binary tree
    // curr -> current node
    // prev -> previous processed node
    public static NodeNext setNextNode(NodeNext curr, NodeNext prev)
    {
        // return if tree is empty
        if (curr == null) {
            return prev;
        }
 
        // recur for left subtree
        prev = setNextNode(curr.left, prev);
 
        // set previous node next pointer to current node
        if (prev != null) {
            prev.next = curr;
        }
 
        // update previous node to current node
        prev = curr;
 
        // recur for right subtree
        return setNextNode(curr.right, prev);
    }
 
    // Function to print inorder Successor of all nodes of
    // binary tree using next pointer
    public static void inorderSuccessor(NodeNext curr)
    {
        NodeNext prev = null;
 
        // set next pointer of all nodes
        setNextNode(curr, prev);
 
        // go to leftmost node
        curr = curr.left.left;
 
        // print inorder Successor of all nodes
        while (curr.next != null)
        {
            System.out.println("Inorder Successor of " + curr.data + " is "
                                + curr.next.data);
            curr = curr.next;
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             /      /  \
            /      /    \
           4      5      6
                 / \
                /   \
               7     8
        */

        NodeNext root = new NodeNext(1);
        root.left = new NodeNext(2);
        root.right = new NodeNext(3);
        root.left.left = new NodeNext(4);
        root.right.left = new NodeNext(5);
        root.right.right = new NodeNext(6);
        root.right.left.left = new NodeNext(7);
        root.right.left.right = new NodeNext(8);
 
        inorderSuccessor(root);
    }
}


class NodeNext
{
    int data;
    NodeNext left = null, right = null, next = null;

    NodeNext(int data) {
        this.data = data;
    }
}
