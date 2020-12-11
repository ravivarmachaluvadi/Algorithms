package com.example.techiedelight.Algorithms.Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindMaximumOccurringWordInGivenSetOfStrings
{
    // Iterative function to insert a String in TrieNode
    public static void insert(TrieNode1 head, String str)
    {
        // start from root node
        TrieNode1 curr = head;
 
        for (char c: str.toCharArray())
        {
            // create a new node if path doesn't exists
            curr.character.putIfAbsent(c, new TrieNode1());
 
            // go to next node
            curr = curr.character.get(c);
        }
 
        // store key and its count in leaf nodes
        curr.key = str;
        curr.count += 1;
    }
 
    // Function to perform pre-order traversal of given TrieNode
    // and find word with maximum frequency
    public static int preOrder(TrieNode1 curr, int maxCount, StringBuilder key)
    {
        // return false if TrieNode is empty
        if (curr == null) {
            return maxCount;
        }
 
        for (Map.Entry<Character,TrieNode1> entry: curr.character.entrySet())
        {
            // leaf node have non-zero count
            if (maxCount < entry.getValue().count) {
                key.replace(0, key.length(), entry.getValue().key);
                maxCount = entry.getValue().count;
            }
 
            // recur for current node children
            maxCount = preOrder(entry.getValue(), maxCount, key);
        }
 
        return maxCount;
    }
 
    public static void main(String[] args) {
        // given set of keys
        List<String> dict = Arrays.asList(
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codec", "codecs", "codependence", "codex", "codify",
                "codependents", "codes", "code", "coder", "codesign", "codec",
                "codeveloper", "codrive", "codec", "codecs", "codiscovered"
        );
 
        // Insert all keys into a trie
        TrieNode1 head = new TrieNode1();
        for (String word : dict) {
            insert(head, word);
        }
 
        int count = 0;
        StringBuilder key = new StringBuilder();
 
        // perform pre-order traversal of given TrieNode and find key
        // with maximum frequency
        count = preOrder(head, count, key);
 
        System.out.println("Word : " + key);
        System.out.println("Count: " + count);
    }
}




// A class representing a Trie node
class TrieNode1
{
    // count and key will be set only for leaf nodes
    // key stores the string and count stores its frequency so far
    String key;
    int count;

    // each node stores a map to its child nodes
    Map<Character, TrieNode1> character = null;

    // Constructor
    TrieNode1() {
        character = new HashMap<>();
    }
}