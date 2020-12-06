package com.example.techiedelight.Algorithms.Backtracking;

import java.util.HashMap;
import java.util.Map;
 
class PatternMatching
{
    // Function to determine if given pattern matches with a string or not
    public static boolean match(String str, int i, String pat, int j,
                                Map<Character, String> map)
    {
        int n = str.length(), m = pat.length();
 
        // base condition
        if (n < m) {
            return false;
        }
 
        // if both pattern and the string reaches end
        if (i == n && j == m) {
            return true;
        }
 
        // if either string or pattern reaches end
        if (i == n || j == m) {
            return false;
        }
 
        // consider next character from the pattern
        char curr = pat.charAt(j);
 
        // if the character is seen before
        if (map.containsKey(curr))
        {
            String s = map.get(curr);
            int k = s.length();
 
            // ss stores next k characters of the given string
            String ss;
            if (i + k < str.length()) {
                ss = str.substring(i, i + k);
            } else {
                ss = str.substring(i);
            }
 
            // return false if next k characters doesn't match with s
            if (ss.compareTo(s) != 0) {
                return false;
            }
 
            // recur for remaining characters if next k characters matches
            return match(str, i + k, pat, j + 1, map);
        }
 
        // process all remaining characters in the string if current
        // character is never seen before
        for (int k = 1; k <= n - i; k++)
        {
            // insert substring formed by next k characters of the string
            // into the map
            map.put(curr, str.substring(i, i + k));
 
            // check if it leads to the solution
            if (match(str, i + k, pat, j + 1, map)) {
                return true;
            }
 
            // else backtrack - remove current character from the map
            map.remove(curr);
        }
 
        return false;
    }
 
    public static void main(String[] args)
    {
        // input string and pattern
        String str = "codesleepcode";
        String pat = "XYX";
 
        // create a map to store mappings between the pattern and string
        Map<Character, String> map = new HashMap<>();
 
        // check for solution
        if (match(str, 0, pat, 0, map))
        {
            for (Map.Entry<Character, String> entry: map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        else {
            System.out.println("Solution doesn't exist");
        }
    }
}