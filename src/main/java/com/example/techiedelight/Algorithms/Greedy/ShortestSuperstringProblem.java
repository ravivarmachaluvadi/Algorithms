package com.example.techiedelight.Algorithms.Greedy;

import java.util.Arrays;
import java.util.List;
 
class ShortestSuperstringProblem
{
    // Function to calculate maximum overlap in two given strings
    private static int findOverlappingPair(String s1, String s2,
                                            StringBuilder sb)
    {
        // max will store maximum overlap i.e maximum length of the
        // matching prefix and suffix
        int max = Integer.MIN_VALUE;
 
        // consider minimum length
        int n = Integer.min(s1.length(), s2.length());
 
        // check suffix of s1 matches with prefix of s2
        for (int i = 1; i <= n; i++)
        {
            // compare last i characters in s1 with first i characters in s2
            if (s1.substring(s1.length() - i).equals(s2.substring(0, i)))
            {
                if (max < i)
                {
                    //update max and str
                    max = i;
                    sb.setLength(0);
                    sb.append(s1).append(s2.substring(i));
                }
            }
        }
 
        // check prefix of s1 matches with suffix of s2
        for (int i = 1; i <= n; i++)
        {
            // compare first i characters in s1 with last i characters in s2
            if (s1.substring(0, i).equals(s2.substring(s2.length() - i)))
            {
                if (max < i)
                {
                    //update max and str
                    max = i;
                    sb.setLength(0);
                    sb.append(s2).append(s1.substring(i));
                }
            }
        }
 
        return max;
    }
 
    // Function to calculate smallest string that contains
    // each string in the given set as substring.
    public static String findShortestSuperstring(List<String> list)
    {
        int n = list.size();
 
        // run n-1 times to consider every pair
        while (n != 1)
        {
            // to store  maximum overlap
            int max = Integer.MIN_VALUE;
 
            // stores index of strings involved in maximum overlap
            int p = -1, q = -1;
 
            // to store resultant string after maximum overlap
            String res_str = "";
 
            for (int i = 0; i < n; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    StringBuilder sb = new StringBuilder();
 
                    // r will store maximum length of the matching prefix
                    // and suffix sb is passed by reference and will store
                    // the resultant string after maximum overlap of
                    // list.get(i) and list.get(j), if any
                    int r = findOverlappingPair(list.get(i),list.get(j),sb);
 
                    // check for maximum overlap
                    if (max < r)
                    {
                        max = r;
                        res_str = sb.toString();
                        p = i;
                        q = j;
                    }
                }
            }
 
            // ignore last element in next cycle
            n--;
 
            // if no overlap, append list.get(n) to list.get(0)
            if (max == Integer.MIN_VALUE) {
                list.set(0, list.get(0) + list.get(n));
            }
            else {
                // copy resultant string to index p
                list.set(p, res_str);
 
                // copy string at last index to index q
                list.set(q, list.get(n));
            }
        }
 
        return list.get(0);
    }
 
    // Shortest Superstring Problem
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("CATGC", "CTAAGT", "GCTA",
                                            "TTCA", "ATGCATC");
 
        System.out.println("The Shortest Superstring is "
                        + findShortestSuperstring(list));
    }
}