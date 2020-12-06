package com.example.techiedelight.Algorithms.Binary;

class ConditionallyNegateAValueWithoutBranching
{
    // negate only when the flag is true
    public static int negate(int n, int flag) {
        return (n ^ -flag) + flag;
    }
 
    // Conditionally negate a value without branching
    public static void main(String[] args)
    {
        int n = 2;
 
        System.out.println("Don't Negate " + negate(n, 0));
        System.out.println("Negate " + negate(n, 1));
    }
}



class ConditionallyNegateAValueWithoutBranchingA2
{
    // negate only when the flag is false
    public static int negate(int n, int flag) {
        return (flag ^ (flag - 1)) * n;
    }

    // Conditionally negate a value without branching
    public static void main(String[] args)
    {
        int n = 2;

        System.out.println("Don't Negate " + negate(n, 1));
        System.out.println("Negate " + negate(n, 0));
    }
}