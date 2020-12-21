package com.example.techiedelight.Algorithms.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
class IsomorphicStrings
{
    // Find if String X and Y are Isomorphic or not
    public static boolean isIsomorphic(String X, String Y)
    {
        // if X and Y have different lengths, they cannot be Isomorphic
        if (X.length() != Y.length()) {
            return false;
        }
 
        // use map to store mapping from characters of String X to String Y
        Map<Character, Character> map = new HashMap<>();
 
        // use set to store pool of already mapped characters
        Set<Character> set = new HashSet<>();
 
        for (int i = 0; i < X.length(); i++)
        {
            char x = X.charAt(i), y = Y.charAt(i);
 
            // if x is seen before
            if (map.containsKey(x))
            {
                // return false if first occurrence of x is mapped to
                // different character
                if (map.get(x) != y)
                    return false;
            }
 
            // if x is seen for the first time (i.e. it is not mapped yet)
            else
            {
                // return false if y is already mapped to some other char in X
                if (set.contains(y))
                    return false;
 
                // map y to x and mark it mapped
                map.put(x, y);
                set.add(y);
            }
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
        String X = "ACAB";
        String Y = "XCXY";
 
        if (isIsomorphic(X, Y)) {
            System.out.print(X + " and " + Y + " are Isomorphic");
        }
        else {
            System.out.print(X + " and " + Y + " are not Isomorphic");
        }
    }
}