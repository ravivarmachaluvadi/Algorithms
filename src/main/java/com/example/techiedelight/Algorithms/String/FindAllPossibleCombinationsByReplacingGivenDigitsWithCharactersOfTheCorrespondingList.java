package com.example.techiedelight.Algorithms.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class FindAllPossibleCombinationsByReplacingGivenDigitsWithCharactersOfTheCorrespondingList
{
    // Top-down recursive function to find all possible combinations by
    // replacing key's digits with characters of the corresponding list
    public static void find(List<List<Character>> list,
                            int[] keys, String res,
                            int index, Map<Integer, Character> map)
    {
        // if we have processed every digit of key, print result
        if (index == -1)
        {
            System.out.print(res + " ");
            return;
        }
 
        // stores current digit
        int digit = keys[index];
 
        // size of the list corresponding to current digit
        int len = list.get(digit).size();
 
        // if digit is seen for the first time
        if (!map.containsKey(digit))
        {
            // one by one replace it with each character in the
            // corresponding list and recur for next digit
            for (int i = 0; i < len; i++)
            {
                // store character that maps to the current digit in a map
                map.put(digit, list.get(digit).get(i));
 
                // recur for next digit
                find(list, keys, list.get(digit).get(i) + res, index-1, map);
 
                // backtrack
                map.remove(digit);
            }
            return;
        }
 
        // if digit is seen before, replace it with same character
        // used in the previous occurrence
        find(list, keys, map.get(digit) + res, index - 1, map);
    }
 
    public static void main(String[] args)
    {
        // N lists of characters
        List<List<Character>> list = Arrays.asList(
                Arrays.asList( 'A', 'B', 'C', 'D' ),
                Arrays.asList( 'E', 'F', 'G', 'H', 'I', 'J', 'K' ),
                Arrays.asList( 'L', 'M', 'N', 'O', 'P', 'Q' ),
                Arrays.asList( 'R', 'S', 'T' ),
                Arrays.asList( 'U', 'V', 'W', 'X', 'Y', 'Z' )
        );
 
        // input number in the form of an array
        int[] keys = {0, 2, 0};
 
        // create an empty map to store the mapping of digits
        Map<Integer, Character> map = new HashMap<>();
 
        // find all combinations
        find(list, keys, "", keys.length - 1, map);
    }
}