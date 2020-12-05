package com.example.techiedelight.Algorithms.arrays;

public class FindMinimumRangeWithAtLeastOneElementFromEachOfTheGivenArrays
{
    // Function to find the minimum range with at-least one element from
    // each of the given arrays
    public static Pair4 findMinRange(int[] a, int[] b, int[] c)
    {
        // create a pair to store the result
        Pair4 pair = null;
 
        // stores the minimum difference
        int diff = Integer.MAX_VALUE;
 
        // consider all triplets formed by (a[i], b[j], c[k])
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                for (int k = 0; k < c.length; k++)
                {
                    // find minimum and maximum value in current triplet
                    int low = Math.min(Math.min(a[i], b[j]), c[k]);
                    int high = Math.max(Math.max(a[i], b[j]), c[k]);
 
                    // update the minimum difference if current difference is more
                    // and store the range in a pair
                    if (diff > high - low)
                    {
                        pair = Pair4.of(low, high);
                        diff = high - low;
                    }
                }
            }
        }
 
        return pair;
    }
 
    public static void main(String[] args)
    {
        int[] a = { 3, 6, 8, 10, 15 };
        int[] b = { 1, 5, 12 };
        int[] c = { 4, 8, 15, 16 };

        Pair4 pair = findMinRange(a, b, c);
        System.out.print("Minimum Range is " + pair);
    }
}


class Pair4
{
    private final int first;        // first field of a Pair
    private final int second;     // second field of a Pair

    // Constructs a new Pair with specified values
    private Pair4(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    // Factory method for creating a Typed Pair immutable instance
    public static Pair4 of(int a, int b)
    {
        // calls private constructor
        return new Pair4(a, b);
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + ']';
    }
}
