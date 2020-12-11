package com.example.techiedelight.Algorithms.Trie;

import java.util.Arrays;
import java.util.List;

class LexicographicSortingOfGivenSetOfKeys
{
    // Iterative function to insert a String in Trie
    public static void insert(Trie head, String str)
    {
        // start from root node
        Trie curr = head;
 
        for (char c: str.toCharArray())
        {
            // create a new node if path doesn't exists
            if (curr.character[c - 'a'] == null) {
                curr.character[c - 'a'] = new Trie();
            }
 
            // go to next node
            curr = curr.character[c - 'a'];
        }
 
        // store key in leaf node
        curr.key = str;
    }
 
    // Function to perform pre-order traversal of given Trie
    public static void preorder(Trie curr)
    {
        // return false if Trie is empty
        if (curr == null) {
            return;
        }
 
        for (int i = 0; i < 26; i++)
        {
            // if leaf node, print key
            if (curr.character[i] != null && curr.character[i].key != null) {
                System.out.println(curr.character[i].key);
            }
 
            preorder(curr.character[i]);
        }
    }
 
    public static void main (String[] args)
    {
        // given set of keys
        List<String> dict = Arrays.asList(
                "lexicographic", "sorting", "of", "a", "set", "of", "keys", "can", "be",
                "accomplished", "with", "a", "simple", "trie", "based", "algorithm",
                "we", "insert", "all", "keys", "in", "a", "trie", "output", "all",
                "keys", "in", "the", "trie", "by", "means", "of", "preorder",
                "traversal", "which", "results", "in", "output", "that", "is", "in",
                "lexicographically", "increasing", "order", "preorder", "traversal",
                "is", "a", "kind", "of", "depth", "first", "traversal"
        );
 
        Trie head = new Trie();
 
        // insert all keys of dictionary into trie
        for (String word: dict) {
            insert(head, word);
        }
 
        // print keys in lexicographic order
        preorder(head);
    }
}



// A class representing a Trie node
class Trie
{
    String key;    // non-empty when node is a leaf node
    Trie[] character;

    // Constructor
    Trie()
    {
        // Trie supports lowercase English characters (a - z)
        // so character size is 26
        character = new Trie[26];
    }
}