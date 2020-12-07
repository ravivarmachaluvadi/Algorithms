package com.example.techiedelight.Algorithms.BST;


class FloorCeil
{
    private Node floor, ceil;

    FloorCeil() {
        floor = new Node(-1);
        ceil = new Node(-1);
    }

    public void setCeil(Node ceil) {
        this.ceil = ceil;
    }

    public void setFloor(Node floor) {
        this.floor = floor;
    }

    public int getCeilData() {
        return ceil.data;
    }

    public int getFloorData() {
        return floor.data;
    }
}


class FloorAndCeilInABinarySearchTree
{
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Recursive function to find floor and ceil of a given key in a BST
    public static void findFloorCeil(Node root, FloorCeil obj, int key)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // if node with key's value is found, both floor and ceil is equal
        // to the current node
        if (root.data == key)
        {
            obj.setFloor(root);
            obj.setCeil(root);
        }
 
        // if given key is less than the root node, recur for left subtree
        else if (key < root.data)
        {
            // update ceil to current node before visiting left subtree
            obj.setCeil(root);
            findFloorCeil(root.left, obj, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else
        {
            // update floor to current node before visiting right subtree
            obj.setFloor(root);
            findFloorCeil(root.right, obj, key);
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                   8
                 /   \
                /     \
               4       10
              / \     /  \
             /   \   /    \
            2     6 9     12
        */
 
        int[] keys = { 2, 4, 6, 8, 9, 10, 12 };
 
        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // calculate ceil and floor for each key
        for (int i = 0; i < 15; i++)
        {
            FloorCeil ob = new FloorCeil();
 
            findFloorCeil(root, ob, i);
            System.out.println(i + " -> Floor is " + ob.getFloorData() +
                            ", Ceil is " + ob.getCeilData());
        }
    }
}




class FloorAndCeilInABinarySearchTreeIterative
{
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }

        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Recursive function to find floor and ceil of a given key in a BST
    // Note that floor and ceil is passed by reference to the function
    public static void findFloorCeil(Node root, FloorCeil obj, int key)
    {
        while (root != null)
        {
            // if node with key's value is found, both floor and ceil is equal
            // to the current node
            if (root.data == key)
            {
                obj.setFloor(root);
                obj.setCeil(root);
                break;
            }

            // if given key is less than the root node, visit left subtree
            else if (key < root.data)
            {
                // update ceil to current node before visiting left subtree
                obj.setCeil(root);
                root = root.left;
            }

            // if given key is more than the root node, visit right subtree
            else
            {
                // update floor to current node before visiting right subtree
                obj.setFloor(root);
                root = root.right;
            }
        }
    }

    public static void main(String[] args)
    {
        /* Construct below tree
                   8
                 /   \
                /     \
               4       10
              / \     /  \
             /   \   /    \
            2     6 9      12
        */

        int[] keys = { 2, 4, 6, 8, 9, 10, 12 };

        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }

        // find Ceil and Floor for each key
        for (int i = 0; i < 15; i++)
        {
            FloorCeil ob = new FloorCeil();

            findFloorCeil(root, ob, i);
            System.out.println(i + " -> Floor is " + ob.getFloorData() + ", Ceil is " + ob.getCeilData());
        }

    }
}