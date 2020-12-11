package com.example.techiedelight.Algorithms.Trie;

import java.util.Arrays;
import java.util.List;

class WordBreakProblemUsingTrie
{
    // Iterative function to insert a string in Trie
    public static void insertTrie(Node head, String str)
    {
        // start from root node
        Node node = head;
 
        // do for each character in the String
        for (char c: str.toCharArray())
        {
            // create a new node if path doesn't exists
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Node();
            }
 
            // go to next node
            node = node.next[c - 'a'];
        }
 
        // mark last node as leaf
        node.exist = true;
    }
 
    // Function to determine if String can be segmented into a space-separated
    // sequence of one or more dictionary words
    public static boolean wordBreak(Node head, String str)
    {
        // good[i] is true if the first i characters of str can be segmented
        boolean[] good = new boolean[str.length() + 1];
        good[0] = true; // base case
 
        for (int i = 0; i < str.length(); i++)
        {
            if (good[i])
            {
                Node node = head;
                for (int j = i; j < str.length(); j++)
                {
                    if (node == null) {
                        break;
                    }
 
                    node = node.next[str.charAt(j) - 'a'];
 
                    // we can make [0, i] using our known decomposition,
                    // and [i+1, j] using this String in trie
                    if (node != null && node.exist) {
                        good[j + 1] = true;
                    }
                }
            }
        }
 
        // good[n] would be true if all characters of str can be segmented
        return good[str.length()];
    }
 
    public static void main (String[] args)
    {
        // List of Strings to represent dictionary
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "prob", "lem");
 
        // use trie to store dictionary
        Node t = new Node();
        for (String word: dict) {
            insertTrie(t, word);
        }
 
        // given String
        String str = "wordbreakproblem";
 
        // check if String can be segmented or not
        if (wordBreak(t, str)) {
            System.out.println("String can be segmented");
        } else {
            System.out.println("String can't be segmented");
        }
    }
}



// A class representing a Trie node
class Node
{
    // Trie supports lowercase english characters
    // so character size is 26 (a - z)
    int CHAR_SIZE = 26;

    boolean exist;        // true when node is a leaf node
    Node[] next;

    // Constructor
    Node() {
        next = new Node[CHAR_SIZE];
        exist = false;
    }
}