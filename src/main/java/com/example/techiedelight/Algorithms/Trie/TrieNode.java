package com.example.techiedelight.Algorithms.Trie;

import java.util.*;

// A class representing a Trie node
class TrieNode
{
    boolean isLeaf = false;    // set when node is a leaf node
    Map<Character, TrieNode> character = new HashMap<>();

    Set<String> word = new HashSet<>();
};
 
class LongestCommonPrefixInGivenSetOfStringsUsingTrie
{
    // Iterative function to insert a String in TrieNode
    private static void insert(TrieNode head, String str)
    {
        // start from root node
        TrieNode curr = head;
 
        for (char c: str.toCharArray())
        {
            // create a new node if path doesn't exists
            curr.character.putIfAbsent(c, new TrieNode());
 
            // go to next node
            curr = curr.character.get(c);
        }
 
        curr.isLeaf = true;
    }
 
    // Function to find Longest Common Prefix
    public static String findLCP(List<String> dict)
    {
        // insert all keys into trie
        TrieNode head = new TrieNode();
        for (String s: dict) {
            insert(head, s);
        }
 
        // traverse the trie and find Longest Common Prefix
 
        StringBuilder lcp = new StringBuilder();
        TrieNode curr = head;
 
        // do till we find a leaf node or node has more than 1 children
        while (curr != null && !curr.isLeaf && (curr.character.size() == 1))
        {
            // get child
            for (Map.Entry<Character,TrieNode> entry: curr.character.entrySet())
            {
                // append current char to LCP
                lcp.append(entry.getKey());
 
                // update curr pointer to child node
                curr = entry.getValue();
            }
        }
 
        return lcp.toString();
    }
 
    public static void main (String[] args)
    {
        // given set of keys
        List<String> dict = Arrays.asList(
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codependence", "codependency", "codependent",
                "codependents", "codes", "codesign", "codesigned", "codeveloped",
                "codeveloper", "codex", "codify", "codiscovered", "codrive"
        );
 
        System.out.println("Longest Common Prefix is " + findLCP(dict));
    }
}