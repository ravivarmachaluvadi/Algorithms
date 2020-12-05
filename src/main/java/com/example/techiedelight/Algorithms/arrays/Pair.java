package com.example.techiedelight.Algorithms.arrays;

import java.util.HashSet;
import java.util.Set;
 
// Data structure to store a pair (or use pair)
class Pair2
{
    public int x, y;

    Pair2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
class FindAllSymmetricPairsInAnArrayOfPairs
{
    // Function to find all pairs that are mirror of each other
    public static void findPairs(Pair2[] pairs)
    {
        // create an empty set of strings
        Set<String> set = new HashSet<>();
 
        // do for each pair
        for (Pair2 curr_pair: pairs)
        {
            // construct a pair (x, y) from curr_pair
            String p = "{" + curr_pair.x + ", " + curr_pair.y + "}";
 
            // insert current pair into the set
            set.add(p);
 
            // construct mirror pair (y, x) of curr_pair
            String rev_pair = "{" + curr_pair.y + ", " + curr_pair.x + "}";
 
            // if mirror pair if seen before, print the pairs
            if (set.contains(rev_pair)) {
                System.out.println(p + " | " + rev_pair);
            }
        }
    }
 
    public static void main(String[] args)
    {
        Pair2[] pairs =
        {
            new Pair2(3, 4), new Pair2(1, 2), new Pair2(5, 2),
            new Pair2(7, 10), new Pair2(4, 3), new Pair2(2, 5)
        };
 
        findPairs(pairs);
    }
}
