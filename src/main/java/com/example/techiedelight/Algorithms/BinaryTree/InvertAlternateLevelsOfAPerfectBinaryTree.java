package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class InvertAlternateLevelsOfAPerfectBinaryTreeUsingLevelOrderTraversal
{
    // Function to print level order traversal of a perfect binary tree
    public static void levelOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node curr = null;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their
            // non-empty left and right child to queue
            curr = queue.poll();
 
            System.out.print(curr.key + " ");
 
            if (curr.left != null) {
                queue.add(curr.left);
            }
 
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
 
    // Iterative function to invert alternate levels of a perfect binary tree
    // using level order traversal
    public static void invertBinaryTree(Node root)
    {
        // base case: if tree is empty
        if (root == null) {
            return;
        }
 
        // maintain a queue and enqueue root node
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
 
        // to store current level information
        boolean level = false;
 
        // queue to store nodes present in an odd level
        Queue<Node> level_nodes = new ArrayDeque<>();
 
        // stack to store node's key in an odd level
        Stack<Integer> level_data = new Stack<>();
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // get size of current level
            int n = q.size();
 
            // process all nodes present in current level
            while (n-- > 0)
            {
                // remove front node from queue
                Node curr = q.poll();
 
                // if level is odd
                if (level)
                {
                    // push current node into the queue
                    level_nodes.add(curr);
 
                    // push key of current node into the stack
                    level_data.add(curr.key);
                }
 
                // if current node is last node of the level
                if (n == 0)
                {
                    // flip the level
                    level = !level;
 
                    // put elements present in the level_data into their correct
                    // position using level_nodes
                    while (!level_nodes.isEmpty()) {
                        Node front = level_nodes.poll();
                        front.key = level_data.pop();
                    }
                }
 
                // push left child of current node to the queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
 
                // push right child of current node to the queue
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                    1
                  /   \
                /       \
              2           3
            /   \       /   \
           4     5     6     7
          / \   / \   / \   / \
         8   9 10 11 12 13 14 15
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
 
        invertBinaryTree(root);
        levelOrderTraversal(root);
    }
}






class InvertAlternateLevelsOfAPerfectBinaryTreeUsingInorderTraversal
{
    // Function to print level order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }

        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // pointer to store current node
        Node curr = null;

        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their
            // non-empty left and right child to queue
            curr = queue.poll();

            System.out.print(curr.key + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    // Recursive function to store nodes of odd levels in a stack using
    // inorder traversal
    public static void pushOddLevelNodes(Node root, Stack<Integer> s, boolean level)
    {
        // Base case
        if (root == null) {
            return;
        }

        // store nodes in the left subtree
        pushOddLevelNodes(root.left, s, !level);

        // push current node's key into the stack only if level is odd
        if (level) {
            s.add(root.key);
        }

        // store nodes in the right subtree
        pushOddLevelNodes(root.right, s, !level);
    }

    // Recursive function to invert alternate levels of a perfect binary tree
    // using inorder traversal
    public static void invertBinaryTree(Node root, Stack<Integer> s, boolean level)
    {
        // Base case
        if (root == null) {
            return;
        }

        // invert nodes in the left subtree
        invertBinaryTree(root.left, s, !level);

        // if level is odd
        if (level) {
            // pop element from the stack and assign it to the current node
            root.key = s.pop();
        }

        // invert nodes in the right subtree
        invertBinaryTree(root.right, s, !level);
    }

    // Invert alternate levels of a perfect binary tree
    public static void invertBinaryTree(Node root)
    {
        // create a stack and push nodes of odd levels in it
        Stack<Integer> s = new Stack<>();
        pushOddLevelNodes(root, s, false);

        // put nodes of odd levels at their correct position using stack
        invertBinaryTree(root, s, false);
    }

    public static void main(String[] args)
    {
        /* Construct below tree
                    1
                  /   \
                /       \
              2           3
            /   \       /   \
           4     5     6     7
          / \   / \   / \   / \
         8   9 10 11 12 13 14 15

        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        invertBinaryTree(root);
        levelOrderTraversal(root);
    }
}






class InvertAlternateLevelsOfAPerfectBinaryTreeA3
{
    // Function to print level order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }

        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // pointer to store current node
        Node curr = null;

        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their
            // non-empty left and right child to queue
            curr = queue.poll();

            System.out.print(curr.key + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    // Recursive function to store nodes of odd levels in a queue
    // using inorder traversal
    public static void pushOddLevelNodes(Node root, Queue<Integer> q, boolean level)
    {
        // Base case
        if (root == null) {
            return;
        }

        // store nodes in the right subtree
        pushOddLevelNodes(root.right, q, !level);

        // push current node's key into the queue only if level is odd
        if (level) {
            q.add(root.key);
        }

        // store nodes in the left subtree
        pushOddLevelNodes(root.left, q, !level);
    }

    // Recursive function to invert alternate levels of a perfect binary tree
    // using inorder traversal
    public static void invertBinaryTree(Node root, Queue<Integer> q, boolean level)
    {
        // Base case
        if (root == null) {
            return;
        }

        // invert nodes in the left subtree
        invertBinaryTree(root.left, q, !level);

        // if level is odd
        if (level)
        {
            // remove front element from the queue and assign it to the current node
            root.key = q.poll();
        }

        // invert nodes in the right subtree
        invertBinaryTree(root.right, q, !level);
    }

    // Invert alternate levels of a perfect binary tree
    public static void invertBinaryTree(Node root)
    {
        // create a queue and push nodes of odd levels in it
        Queue<Integer> q = new ArrayDeque<>();
        pushOddLevelNodes(root, q, false);

        // put nodes of odd levels at their correct position using queue
        invertBinaryTree(root, q, false);
    }

    public static void main(String[] args)
    {
        Node root = null;

        /* Construct below tree
                    1
                  /   \
                /       \
              2           3
            /   \       /   \
           4     5     6     7
          / \   / \   / \   / \
         8   9 10 11 12 13 14 15
        */

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        invertBinaryTree(root);
        levelOrderTraversal(root);
    }
}






class InvertAlternateLevelsOfAPerfectBinaryTreeUsingPreorderTraversal
{
    // Function to print level order traversal of a perfect binary tree
    public static void levelOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }

        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // pointer to store current node
        Node curr = null;

        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their
            // non-empty left and right child to queue
            curr = queue.poll();

            System.out.print(curr.key + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    // Recursive function to invert alternate levels of a perfect binary tree
    // using preorder traversal
    public static void invertBinaryTree(Node first, Node second, boolean level)
    {
        // return if either child is empty
        if (first == null || second == null) {
            return;
        }

        // swap key only if level is odd
        if (level) {
            int temp = first.key;
            first.key = second.key;
            second.key = temp;
        }

        // recur with left child of first and right child of second with updated level
        invertBinaryTree(first.left, second.right, !level);

        // recur with right child of first and left child of second with updated level
        invertBinaryTree(first.right, second.left, !level);
    }

    public static void invertBinaryTree(Node root) {
        invertBinaryTree(root.left, root.right, true);
    }

    public static void main(String[] args)
    {
        Node root = null;

        /* Construct below tree
                    1
                  /   \
                /       \
              2           3
            /   \       /   \
           4     5     6     7
          / \   / \   / \   / \
         8   9 10 11 12 13 14 15

        */

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        invertBinaryTree(root);
        levelOrderTraversal(root);
    }
}