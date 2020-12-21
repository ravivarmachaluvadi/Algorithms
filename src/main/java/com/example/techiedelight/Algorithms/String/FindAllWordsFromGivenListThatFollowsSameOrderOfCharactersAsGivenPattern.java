package com.example.techiedelight.Algorithms.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class FindAllWordsFromGivenListThatFollowsSameOrderOfCharactersAsGivenPattern
{
    // Function to print all words that follows same order of
    // characters as given pattern
    public static void patternMatch(List<String> words, String pattern)
    {
        // len stores length of the pattern
        int len = pattern.length();
 
        // check each word in given input list
        for (String word: words)
        {
            // map1 stores mapping from word to pattern
            Map<Character, Character> map1 = new HashMap<>();
 
            // map2 stores mapping from pattern to word
            Map<Character, Character> map2 = new HashMap<>();
 
            // proceed only when length of the pattern and word is same
            if (word.length() == len)
            {
                int i;
 
                // process each character in both word and pattern
                for (i = 0; i < len; i++)
                {
                    // w stores current character of current word
                    char w = word.charAt(i);
 
                    // p stores current character of the pattern
                    char p = pattern.charAt(i);
 
                    /* check mapping from current word to given pattern */
 
                    // if w is seen for the first time, store its mapping to p in map1
                    Character prev = map1.putIfAbsent(w, p);
 
                    // if w is seen before, its mapped character should be p
                    if (prev != null && map1.get(w) != p)
                        break;
 
                    /* check mapping from given pattern to current word */
 
                    // if p is seen for the first time, store its mapping to w in map2
                    prev = map2.putIfAbsent(p, w);
 
                    // if p is seen before, its mapped character should be w
                    if (prev != null && map2.get(p) != w)
                        break;
                }
 
                // if current word matches the pattern, print it
                if (i == len) {
                    System.out.println(word);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        // list of words
        List<String> words = Arrays.asList("leet", "abcd", "loot", "geek",
                "cool", "for", "peer", "dear", "seed",
                "meet", "noon", "otto", "mess", "loss");
 
        // given pattern
        String pattern = "moon";
 
        patternMatch(words, pattern);
    }
}