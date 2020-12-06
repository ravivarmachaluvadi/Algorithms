package com.example.techiedelight.Algorithms.Binary;

class FindTheMinimumOrMaximumOfTwoIntegersWithoutUsingBranching
{
    public static int findMin(int x, int y)
    {
        return y ^ ((x ^ y) & -((x < y) ? 1 : 0));
    }
 
    public static int findMax(int x, int y)
    {
        return x ^ ((x ^ y) & -((x < y) ? 1 : 0));
    }
 
    public static void main(String[] args)
    {
        int x = 2, y = 4;
 
        System.out.println("min(" + x + ", " + y + ") is " + findMin(x, y));
        System.out.println("max(" + x + ", " + y + ") is " + findMax(x, y));
    }
}



class FindTheMinimumOrMaximumOfTwoIntegersWithoutUsingBranchingA2
{
    public static int findMin(int x, int y) {
        return y + ((x - y) & ((x - y) >> 31));
    }

    public static int findMax(int x, int y) {
        return x - ((x - y) & ((x - y) >> 31));
    }

    public static void main(String[] args)
    {
        int x = 2, y = 4;

        System.out.println("min(" + x + ", " + y + ") is " + findMin(x, y));
        System.out.println("max(" + x + ", " + y + ") is " + findMax(x, y));
    }
}