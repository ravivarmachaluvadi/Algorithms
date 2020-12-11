package com.example.techiedelight.Algorithms.Trie;

import java.util.HashMap;
import java.util.Map;
 
// A class to represent Trie2
class Trie2
{
    private boolean isLeaf;
    private Map<Character, Trie2> children;
 
    // Constructor
    Trie2() {
        isLeaf = false;
        children = new HashMap<>();
    }
 
    // Iterative function to insert a string in Trie2 Data Structure
    public void insert(String key)
    {
        System.out.println("Inserting \"" + key + "\"");
 
        // start from root node
        Trie2 curr = this;
 
        // do for each character of the key
        for (char c: key.toCharArray())
        {
            // create a new node if path doesn't exists
            curr.children.putIfAbsent(c, new Trie2());
 
            // go to next node
            curr = curr.children.get(c);
        }
 
        // mark current node as leaf
        curr.isLeaf = true;
    }
 
    // Iterative function to search a key in Trie2. It returns true
    // if the key is found in the Trie2, else it returns false
    public boolean search(String key)
    {
        System.out.print("Searching \"" + key + "\" : ");
 
        Trie2 curr = this;
 
        // do for each character of the key
        for (char c: key.toCharArray())
        {
            // go to the next node
            curr = curr.children.get(c);
 
            // if string is invalid (reached end of path in Trie2)
            if (curr == null)
                return false;
        }
 
        // return true if current node is a leaf node and we have reached
        // the end of the string
        return curr.isLeaf;
    }
}
 
class Main2
{
    // Memory efficient implementation of Trie2 Data Structure in Java
    public static void main (String[] args)
    {
        // construct a new Trie2 node
        Trie2 head = new Trie2();
 
        head.insert("techie");
        head.insert("techi");
        head.insert("tech");
 
        System.out.println(head.search("tech"));            // true
        System.out.println(head.search("techi"));           // true
        System.out.println(head.search("techie"));          // true
        System.out.println(head.search("techiedelight"));   // false
 
        head.insert("techiedelight");
 
        System.out.println(head.search("tech"));            // true
        System.out.println(head.search("techi"));           // true
        System.out.println(head.search("techie"));          // true
        System.out.println(head.search("techiedelight"));   // true
    }
}