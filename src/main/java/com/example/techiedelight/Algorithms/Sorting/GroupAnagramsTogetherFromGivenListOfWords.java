package com.example.techiedelight.Algorithms.Sorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GroupAnagramsTogetherFromGivenListOfWords
{
    // Function to group anagrams together from given list of words
    public static void groupAnagrams(String[] words)
    {
        // sort each word in the list
        List<String> list = Arrays.stream(words)
                .map(s -> s.toCharArray())
                .map(chars -> { Arrays.sort(chars); return new String(chars); })
                .collect(Collectors.toList());
 
        // construct a map where key is each sorted word
        // and value is list of indices where it is present
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++)
        {
            map.putIfAbsent(list.get(i), new ArrayList<>());
            map.get(list.get(i)).add(i);
        }
 
        // traverse the map and read indices for each sorted key.
        // The anagrams are present in actual list at those indices
        for (Map.Entry<String, List<Integer>> entry: map.entrySet()) {
            System.out.println(entry.getValue().stream()
                            .map(index -> words[index])
                            .collect(Collectors.toList()));
        }
    }
 
    // Group anagrams together from given list of words
    public static void main(String[] args)
    {
        // list of words
        String[] words = {
                "CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
                "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN"
        };
 
        groupAnagrams(words);
    }
}




class GroupAnagramsTogetherFromGivenListOfWordsA2
{
    // Function to group anagrams together from given
    // list of words
    public static void groupAnagrams(String[] words)
    {
        // sort each word in the list
        List<String> list = Arrays.stream(words)
                .map(s -> Stream.of(s.split("")).sorted()
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());

        // construct a MultiMap where key is each sorted word
        // and value is list of indices where it is present
        Map<String, List<Integer>> multiMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            multiMap.putIfAbsent(list.get(i), new ArrayList<>());
            multiMap.get(list.get(i)).add(i);
        }

        // iterate through the MultiMap and read indices for each sorted
        // key. The anagrams are present in actual list at those indices
        for (String key: multiMap.keySet()) {
            System.out.println(multiMap.get(key).stream()
                    .map(i -> words[i])
                    .collect(Collectors.toList()));
        }
    }

    // Group anagrams together from given list of words
    public static void main(String[] args)
    {
        // list of words
        String[] words = {
                "CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
                "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN"
        };

        groupAnagrams(words);
    }
}