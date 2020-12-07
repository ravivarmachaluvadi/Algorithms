package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LinkNodesPresentInEachLevelOfABinaryTreeInTheFormOfALinkedList
{
    // Function to print a given linked list
    public static void printList(NodeNext head)
    {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    // Function to perform inorder traversal of a binary tree where nodes
    // at the same level are linked together in the form of a linked list
    public static void inorder(NodeNext root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
 
        // print current NodeNext and its next NodeNext
        System.out.print(root.data + " -> ");
        if (root.next != null) {
            System.out.println(root.next.data);
        } else{
            System.out.println("null");
        }
 
        inorder(root.right);
    }
 
    // Recursive function to find the first NodeNext in next level of the root NodeNext
    public static NodeNext findNextNode(NodeNext root)
    {
        // base case
        if (root == null || root.next == null) {
            return null;
        }
 
        // if left child of root's next NodeNext exists, return it
        if (root.next.left != null) {
            return root.next.left;
        }
 
        // if right child of root's next NodeNext exists, return it
        if (root.next.right != null) {
            return root.next.right;
        }
 
        // if root's next NodeNext is a leaf NodeNext, recur for root's next NodeNext
        return findNextNode(root.next);
    }
 
    // Function to traverse the nodes in pre-order fashion and
    // insert all nodes into the map corresponding to their level
    public static void linkNodes(NodeNext root, int level, Map<Integer, List<NodeNext>> map)
    {
        // base case: empty subtree
        if (root == null) {
            return;
        }
 
        // insert the current NodeNext and level information into the map
        if (map.get(level) == null) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root);
 
        // recur for left and right subtree by increasing level by 1
        linkNodes(root.left, level + 1, map);
        linkNodes(root.right, level + 1, map);
    }
 
    // Function to link nodes present in each level of a binary tree
    // using next pointer
    public static void linkNodes(NodeNext root)
    {
        // create an empty map to store nodes present at each level
        // from left to right
        Map<Integer, List<NodeNext>> map = new HashMap<>();
 
        // traverse the tree in pre-order fashion and fill map
        linkNodes(root, 1, map);
 
        // iterate through the map and for each level,
        // set next NodeNext for every NodeNext in it
        for (List<NodeNext> values: map.values())
        {
            NodeNext prev = null;
            for (NodeNext curr: values)
            {
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
            }
            prev.next = null;
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below Tree
               1
             /   \
            2     3
           / \     \
          4   5     6
           \       /
            7     8
        */
 
        NodeNext root = new NodeNext(1);
        root.left = new NodeNext(2);
        root.right = new NodeNext(3);
        root.left.left = new NodeNext(4);
        root.left.right = new NodeNext(5);
        root.right.right = new NodeNext(6);
        root.left.left.right = new NodeNext(7);
        root.right.right.left = new NodeNext(8);
 
        // link nodes at the same level
        linkNodes(root);
 
        // print the nodes
        NodeNext NodeNext = root;
        while (NodeNext != null) {
            // print current level
            printList(NodeNext);
 
            // find leftmost NodeNext of the next level
            if (NodeNext.left != null) {
                NodeNext = NodeNext.left;
            } else if (NodeNext.right != null) {
                NodeNext = NodeNext.right;
            } else {
                NodeNext = findNextNode(NodeNext);
            }
        }
 
        // inorder(root);
    }
}






class LinkNodesPresentInEachLevelOfABinaryTreeInTheFormOfALinkedListA2
{
    // Function to print a given linked list
    public static void printList(NodeNext head)
    {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    // Function to perform inorder traversal of a binary tree where nodes
    // at the same level are linked together in the form of a linked list
    public static void inorder(NodeNext root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);

        // print current NodeNext and its next NodeNext
        System.out.print(root.data + "->");
        if (root.next != null) {
            System.out.println(root.next.data);
        } else {
            System.out.println("null");
        }

        inorder(root.right);
    }

    // Recursive function to find the first NodeNext in next level of the root NodeNext
    public static NodeNext findNextNode(NodeNext root)
    {
        // base case
        if (root == null || root.next == null) {
            return null;
        }

        // if left child of root's next NodeNext exists, return it
        if (root.next.left != null) {
            return root.next.left;
        }

        // if right child of root's next NodeNext exists, return it
        if (root.next.right != null) {
            return root.next.right;
        }

        // if root's next NodeNext is a leaf NodeNext, recur for root's next NodeNext
        return findNextNode(root.next);
    }

    // Recursive function to link nodes present in each level of a binary tree
    // in the form of a linked list
    public static void linkNodes(NodeNext root)
    {
        // base case
        if (root == null) {
            return;
        }

        // ensure that the nodes of the current level is linked before the nodes
        // of the next level
        linkNodes(root.next);

        // update the next pointer of root's left child to root's right child
        // if right child doesn't exist, link it to first NodeNext in the next level
        if (root.left != null) {
            root.left.next = (root.right != null)? root.right: findNextNode(root);
        }

        // update the next pointer of root's right child to first NodeNext
        // in the next level
        if (root.right != null) {
            root.right.next = findNextNode(root);
        }

        // recur for left and right subtree
        linkNodes(root.left);
        linkNodes(root.right);
    }

    public static void main(String[] args)
    {
        /* Construct below Tree
               1
             /   \
            2     3
           / \     \
          4   5     6
           \       /
            7     8
        */

        NodeNext root = new NodeNext(1);
        root.left = new NodeNext(2);
        root.right = new NodeNext(3);
        root.left.left = new NodeNext(4);
        root.left.right = new NodeNext(5);
        root.right.right = new NodeNext(6);
        root.left.left.right = new NodeNext(7);
        root.right.right.left = new NodeNext(8);

        // link nodes at the same level
        linkNodes(root);

        // print the nodes
        NodeNext NodeNext = root;
        while (NodeNext != null)
        {
            // print current level
            printList(NodeNext);

            // find leftmost NodeNext of the next level
            if (NodeNext.left != null)
                NodeNext = NodeNext.left;
            else if (NodeNext.right != null)
                NodeNext = NodeNext.right;
            else
                NodeNext = findNextNode(NodeNext);
        }

        // inorder(root);
    }
}