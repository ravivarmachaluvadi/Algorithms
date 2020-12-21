package com.example.techiedelight.Algorithms.Puzzles;

class TowerOfHanoiProblem
{
    public static void move(int disks, int source, int auxiliary, int target)
    {
        if (disks > 0)
        {
            // move N-1 discs from source to auxiliary using target
            // as intermediate pole
            move(disks - 1, source, target, auxiliary);
 
            // move one disc from source to target
            System.out.println("Move disk " + disks + " from " + source + " -> " + target);
 
            // move N-1 discs from auxiliary to target using source
            // as intermediate pole
            move(disks - 1, auxiliary, source, target);
        }
    }
 
    // Tower of Hanoi Problem
    public static void main(String[] args)
    {
        int N = 3;
        move(N, 1, 2, 3);
    }
}