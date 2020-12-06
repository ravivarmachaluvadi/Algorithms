package com.example.techiedelight.Algorithms.DynamicProgramming;


import java.util.*;

class ActivitySelectionProblemUsingDynamicProgramming
{
    // Returns the maximum count of non-conflicting jobs that can be performed
    // by a single person
    public static int findNonConflictingJobsLength(List<Pair> jobs)
    {
        // Sort the jobs according to increasing order of their start time
        Collections.sort(jobs, Comparator.comparingInt(job -> job.start));
 
        // L[i] stores the maximum count of non-conflicting jobs ending at i'th job
        int[] L = new int[jobs.size()];
 
        for (int i = 0; i < jobs.size(); i++)
        {
            // consider each j less than i
            for (int j = 0; j < i; j++)
            {
                // L[i] = Math.max(L[j]) where jobs[j].finish is less than jobs[i].start
                if (jobs.get(j).finish < jobs.get(i).start && L[i] < L[j]) {
                    L[i] = L[j];
                }
            }
 
            // increment L[i] since it ends at the i'th job
            L[i]++;
        }
 
        // return maximum job length in the List
        return Arrays.stream(L).max().getAsInt();
    }
 
    public static void main(String[] args)
    {
        // Each pair stores the start and the finish time of a job
        List<Pair> jobs = Arrays.asList(
                Pair.of(1, 4), Pair.of(3, 5), Pair.of(0, 6),
                Pair.of(5, 7), Pair.of(3, 8), Pair.of(5, 9),
                Pair.of(6, 10), Pair.of(8, 11), Pair.of(8, 12),
                Pair.of(2, 13), Pair.of(12, 14)
        );
 
        System.out.println("The maximum number of non-conflicting jobs are "
                + findNonConflictingJobsLength(jobs));
    }
}



// Data structure to store the start and finish time of the jobs
// Pair class
class Pair
{
    public final int start;        // start field of a Pair
    public final int finish;     // finish field of a Pair

    // Constructs a new Pair with specified values
    private Pair(int start, int finish)
    {
        this.start = start;
        this.finish = finish;
    }

    // Factory method for creating a Typed Pair immutable instance
    public static Pair of(int a, int b)
    {
        // calls private constructor
        return new Pair(a, b);
    }
}


