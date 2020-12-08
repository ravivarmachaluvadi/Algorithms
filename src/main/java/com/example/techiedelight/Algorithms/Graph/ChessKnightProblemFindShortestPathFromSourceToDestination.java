package com.example.techiedelight.Algorithms.Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class ChessKnightProblemFindShortestPathFromSourceToDestination
{
    // Below arrays details all 8 possible movements
    // for a knight
    private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };
 
    // Check if (x, y) is valid chess board coordinates
    // Note that a knight cannot go out of the chessboard
    private static boolean valid(int x, int y, int N)
    {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return false;
 
        return true;
    }
 
    // Find minimum number of steps taken by the knight
    // from source to reach destination using BFS
    public static int BFS(NodeOverride src, NodeOverride dest, int N)
    {
        // set to check if matrix cell is visited before or not
        Set<NodeOverride> visited = new HashSet<>();
 
        // create a queue and enqueue first NodeOverride
        Queue<NodeOverride> q = new ArrayDeque<>();
        q.add(src);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // pop front NodeOverride from queue and process it
            NodeOverride NodeOverride = q.poll();
 
            int x = NodeOverride.x;
            int y = NodeOverride.y;
            int dist = NodeOverride.dist;
 
            // if destination is reached, return distance
            if (x == dest.x && y == dest.y)
                return dist;
 
            // Skip if location is visited before
            if (!visited.contains(NodeOverride))
            {
                // mark current NodeOverride as visited
                visited.add(NodeOverride);
 
                // check for all 8 possible movements for a knight
                // and enqueue each valid movement into the queue
                for (int i = 0; i < 8; ++i)
                {
                    // Get the new valid position of Knight from current
                    // position on chessboard and enqueue it with +1 distance
                    int x1 = x + row[i];
                    int y1 = y + col[i];
 
                    if (valid(x1, y1, N))
                        q.add(new NodeOverride(x1, y1, dist + 1));
                }
            }
        }
 
        // return INFINITY if path is not possible
        return Integer.MAX_VALUE;
    }
 
    public static void main(String[] args)
    {
        int N = 8;
 
        // source coordinates
        NodeOverride src = new NodeOverride(0, 7);
 
        // destination coordinates
        NodeOverride dest = new NodeOverride(7, 0);
 
        System.out.println("Minimum number of steps required is " + BFS(src, dest, N));
    }
}



// queue NodeOverride used in BFS
class NodeOverride
{
    // (x, y) represents chess board coordinates
    // dist represent its minimum distance from the source
    int x, y, dist;

    public NodeOverride(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public NodeOverride(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    // As we are using class object as a key in a HashMap
    // we need to implement hashCode() and equals()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeOverride NodeOverride = (NodeOverride) o;

        if (x != NodeOverride.x) return false;
        if (y != NodeOverride.y) return false;
        return dist == NodeOverride.dist;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + dist;
        return result;
    }
}