package com.example.techiedelight.Algorithms.Stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class MergingOverlappingIntervals
{
    // Function to merge overlapping intervals
    public static void mergeIntervals(List<Interval1> intervals)
    {
        // sort the intervals in increasing order of their starting time
        Collections.sort(intervals, Comparator.comparingInt(a -> a.begin));
 
        // create an empty stack
        Stack<Interval1> stack = new Stack();
 
        // do for each interval
        for (Interval1 curr: intervals)
        {
            // if stack is empty or top interval in stack do not overlap
            // with current interval, push it to the stack
            if (stack.empty() || curr.begin > stack.peek().end) {
                stack.push(curr);
            }
 
            // if top interval of stack overlap with current interval,
            // merge two intervals by updating ending of top interval
            // to ending of current interval
            if (stack.peek().end < curr.end) {
                stack.peek().end = curr.end;
            }
        }
 
        // print all non-overlapping intervals
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
 
    public static void main(String[] args)
    {
        List<Interval1> intervals = Arrays.asList(
                new Interval1(1, 5), new Interval1(2, 3),
                new Interval1(4, 6), new Interval1(7, 8),
                new Interval1(8, 10), new Interval1(12, 15)
        );
 
        mergeIntervals(intervals);
    }
}


// Class to represent an interval
class Interval1
{
    int begin, end;

    Interval1(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + begin + "," + end + "}";
    }
}

