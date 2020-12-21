package com.example.techiedelight.Algorithms.String;

import java.util.Arrays;
import java.util.List;
 
class PrintAllCombinationsOfPhrasesFormedByPickingWordsFromEachOfTheGivenLists
{
    // Function to print all combinations of phrases that can be formed
    // by words from each of the given lists
    public static void printAllCombinations(List<List<String>> list,
                                            String res, int n)
    {
        // if we have traversed each list
        if (n == list.size())
        {
            // print phrase after removing trailing space
            System.out.println(res.substring(1));
            return;
        }
 
        // get size of current list
        int m = list.get(n).size();
 
        // do for each word in current list
        for (int i = 0; i < m; i++)
        {
            // append current word to output
            String out = res + " " + list.get(n).get(i);
 
            // recur for next list
            printAllCombinations(list, out, n + 1);
        }
    }
 
    public static void main(String[] args)
    {
        List<List<String>> list = Arrays.asList(
                        Arrays.asList("John", "Emma"),
                        Arrays.asList( "Plays", "Hates", "Watches" ),
                        Arrays.asList( "Cricket", "Soccer", "Chess" )
                    );
 
        printAllCombinations(list, "", 0);
    }
}