package com.example.techiedelight.Algorithms.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java Implementation of Trie1 Data Structure
// A class to represent Trie1
class Trie1
{
    // define alphabet size (26 characters for a - z)
    private static final int CHAR_SIZE = 26;
 
    private boolean isLeaf;
    private List<Trie1> children = null;
 
    // Constructor
    Trie1() {
        isLeaf = false;
        children = new ArrayList<>(Collections.nCopies(CHAR_SIZE, null));
    }
 
    // Iterative function to insert a string in Trie1 Data Structure
    public void insert(String key)
    {
        System.out.println("Inserting \"" + key + "\"");
 
        // start from root node
        Trie1 curr = this;
 
        // do for each character of the key
        for (char c: key.toCharArray())
        {
            // create a new Trie1 node if path does not exist
            if (curr.children.get(c - 'a') == null)
                curr.children.set(c - 'a', new Trie1());
 
            // go to the next node
            curr = curr.children.get(c - 'a');
        }
 
        // mark current node as leaf
        curr.isLeaf = true;
    }
 
    // Iterative function to search a key in Trie1. It returns true
    // if the key is found in the Trie1, else it returns false
    public boolean search(String key)
    {
        System.out.print("Searching \"" + key + "\" : ");
 
        Trie1 curr = this;
 
        // do for each character of the key
        for (char c: key.toCharArray())
        {
            // go to the next node
            curr = curr.children.get(c - 'a');
 
            // if string is invalid (reached end of path in Trie1)
            if (curr == null)
                return false;
        }
 
        // return true if current node is a leaf node and we have reached
        // the end of the string
        return curr.isLeaf;
    }
}
 
class Main1
{
    // Memory efficient implementation of Trie1 Data Structure in Java
    public static void main (String[] args)
    {
        // construct a new Trie1 node
        Trie1 head = new Trie1();
 
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