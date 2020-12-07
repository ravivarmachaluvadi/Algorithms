package com.example.techiedelight.Algorithms.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class FindFirstKNonRepeatingCharactersInAStringInSingleTraversal
{
    // Function to find the first k non-repeating character in
    // the string by doing only one traversal of it
    public static void firstKNonRepeating(String str, int k)
    {
        // map to store character count and the index of its
        // last occurrence in the string
        Map<Character, Pair> map = new HashMap<>();
 
        for (int i = 0 ; i < str.length(); i++)
        {
            Pair pair = map.getOrDefault(str.charAt(i), new Pair());
            pair.setCount(pair.getCount() + 1);
            pair.setIndex(i);
 
            map.put(str.charAt(i), pair);
        }
 
        // create an empty min-heap
        PriorityQueue pq = new PriorityQueue();
 
        // traverse the map and push index of all characters
        // having count of 1 into the min-heap
        for (Pair value: map.values())
        {
            int count = value.getCount();
            int index = value.getIndex();
 
            if (count == 1) {
                pq.add(index);
            }
        }
 
        // pop top k keys from the min-heap
        while (k-- > 0 && !pq.isEmpty())
        {
            // extract the minimum node from the min-heap
            System.out.print(str.charAt(pq.poll()) + " ");
        }
    }
 
    public static void main (String[] args)
    {
        String str = "ABCDBAGHCHFAC";
        int k = 3;
 
        firstKNonRepeating(str, k);
    }
}



class Pair
{
    private int count;
    private int index;

    Pair(int count, int index) {
        this.count = count;
        this.index = index;
    }

    Pair() {}

    public int getCount() {
        return count;
    }

    public int getIndex() {
        return index;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}


