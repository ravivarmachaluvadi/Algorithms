package com.example.techiedelight.Algorithms.LinkedList;

class RemoveRedundantNodesFromAPathFormedByALinkedList
{
    // Function to remove redundant nodes from a path formed by a linked list
    public static NodeXY removeNodes(NodeXY head)
    {
        NodeXY curr = head;
 
        while (curr.next != null && curr.next.next != null)
        {
            NodeXY temp = curr.next.next;
 
            // check for a vertical triplet (triplet with same x-value)
            if (curr.x == curr.next.x && curr.x == temp.x)
            {
                // delete middle node
                curr.next = temp;
            }
 
            // check for a horizontal triplet (triplet with same y-value)
            else if (curr.y == curr.next.y && curr.y == temp.y)
            {
                // delete middle node
                curr.next = temp;
            }
            else
            {
                curr = curr.next;
            }
        }
 
        return head;
    }
 
    // Helper function to print given linked list
    public static void printList(NodeXY head)
    {
        for (NodeXY ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr + " -> ");
        }
        System.out.println("null");
    }
 
    public static void main(String[] args)
    {
        // input coordinates
        int[][] keys = { {0, 1}, {0, 5}, {0, 8}, {2, 8},
                {5, 8}, {7, 8}, {7, 10}, {7, 12} };

        NodeXY head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new NodeXY(keys[i][0], keys[i][1], head);
        }
 
        head = removeNodes(head);
        printList(head);
    }
}




// A linked list node
class NodeXY {
    int x, y;
    NodeXY next;

    NodeXY(int x, int y, NodeXY next) {
        this.x = x;
        this.y = y;
        this.next = next;
    }

    @Override
    public String toString() {
        return ("(" + x + ", " + y + ")");
    }
}
