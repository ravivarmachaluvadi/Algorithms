package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.*;

//Naive Recursive Solution
class WeightedIntervalSchedulingProblem
{
    // Function to find index of last job which doesn't conflict with the given job
    // It performs a linear search on the given List of jobs
    public static int findLastNonConflictingJob(List<Job> jobs, int n)
    {
        // find index of the last job whose finish time is less than or equal to the
        // start time of the given job
        for (int i = n - 1; i >= 0; i--) {
            if (jobs.get(i).finish <= jobs.get(n).start) {
                return i;
            }
        }
 
        // return negative index if no non-conflicting job is found
        return -1;
    }
 
    // A recursive function to find maximum profit subset of non-overlapping
    // jobs which are sorted according to finish time
    public static int maxProfit(List<Job> jobs, int n)
    {
        // sort jobs in increasing order of their finish times
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));
 
        // base case
        if (n < 0) {
            return 0;
        }
 
        // return if only one item is remaining
        if (n == 0) {
            return jobs.get(0).profit;
        }
 
        // find the index of last non-conflicting job with current job
        int index = findLastNonConflictingJob(jobs, n);
 
        // include the current job and recur for non-conflicting jobs [0, index]
        int incl = jobs.get(n).profit + maxProfit(jobs, index);
 
        // exclude the current job and recur for remaining items [0, n-1]
        int excl = maxProfit(jobs, n-1);
 
        // return the maximum profit by including or excluding current job
        return Math.max(incl, excl);
    }
 
    public static void main(String[] args)
    {
 
        List<Job> jobs = Arrays.asList(
                new Job(0, 6, 60),
                new Job(1, 4, 30),
                new Job(3, 5, 10),
                new Job(5, 7, 30),
                new Job(5, 9, 50),
                new Job(7, 8, 10)
        );
 
        System.out.print("The maximum profit is " + maxProfit(jobs, jobs.size() - 1));
    }
}



// Data structure to store a Job
class Job {
    int start, finish, profit;

    Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
}



class WeightedIntervalSchedulingProblemDP
{
    // Function to find index of last job which doesn't conflict with the given job
    // It performs a linear search on the given List of jobs
    public static int findLastNonConflictingJob(List<Job> jobs, int n)
    {
        // find index of the last job whose finish time is less than or equal to the
        // start time of the given job
        for (int i = n - 1; i >= 0; i--) {
            if (jobs.get(i).finish <= jobs.get(n).start) {
                return i;
            }
        }

        // return negative index if no non-conflicting job is found
        return -1;
    }

    // Function to find the maximum profit of non-overlapping jobs using DP
    public static int maxProfit(List<Job> jobs)
    {
        // sort jobs in increasing order of their finish times
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

        // get number of jobs
        int n = jobs.size();

        // construct a lookup table where the i'th index stores the maximum profit
        // for first i jobs
        int[] maxProfit = new int[n];

        // maximum profit gained by including the first job
        maxProfit[0] = jobs.get(0).profit;

        // fill maxProfit[] table in bottom-up manner from the second index
        for (int i = 1; i < n; i++)
        {
            // find the index of last non-conflicting job with current job
            int index = findLastNonConflictingJob(jobs, i);

            // include the current job with its non-conflicting jobs
            int incl = jobs.get(i).profit;
            if (index != -1) {
                incl += maxProfit[index];
            }

            // store the maximum profit by including or excluding current job
            maxProfit[i] = Math.max(incl, maxProfit[i - 1]);
        }

        // return maximum profit
        return maxProfit[n - 1];
    }

    public static void main(String[] args)
    {
        List<Job> jobs = Arrays.asList(
                new Job( 0, 6, 60 ),
                new Job( 1, 4, 30 ),
                new Job( 3, 5, 10 ),
                new Job( 5, 7, 30 ),
                new Job( 5, 9, 50 ),
                new Job( 7, 8, 10 )
        );

        System.out.print("The maximum profit is " + maxProfit(jobs));
    }
}




class WeightedIntervalSchedulingProblemOptiDP
{
    // Function to perform binary search on the given jobs which are sorted by finish time.
    // The function returns index of the last job which doesn't conflict with the given job
    // i.e. whose finish time is less than or equal to the start time of the given job.
    public static int findLastNonConflictingJob(List<Job> jobs, int n)
    {
        // search space
        int low = 0, high = n;

        // iterate till search space is exhausted
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (jobs.get(mid).finish <= jobs.get(n).start) {
                if (jobs.get(mid + 1).finish <= jobs.get(n).start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            else {
                high = mid - 1;
            }
        }

        // return negative index if no non-conflicting job is found
        return -1;
    }

    // Function to find the maximum profit of non-overlapping jobs using DP
    public static int maxProfit(List<Job> jobs)
    {
        // sort jobs in increasing order of their finish times
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

        // get number of jobs
        int n = jobs.size();

        // construct a lookup table where the i'th index stores the maximum profit
        // for first i jobs
        int[] maxProfit = new int[n];

        // maximum profit gained by including the first job
        maxProfit[0] = jobs.get(0).profit;

        // fill maxProfit[] table in bottom-up manner from the second index
        for (int i = 1; i < n; i++)
        {
            // find the index of last non-conflicting job with current job
            int index = findLastNonConflictingJob(jobs, i);

            // include the current job with its non-conflicting jobs
            int incl = jobs.get(i).profit;
            if (index != -1) {
                incl += maxProfit[index];
            }

            // store the maximum profit by including or excluding current job
            maxProfit[i] = Math.max(incl, maxProfit[i - 1]);
        }

        // return maximum profit
        return maxProfit[n - 1];
    }

    public static void main(String[] args)
    {
        List<Job> jobs = Arrays.asList(
                new Job( 0, 6, 60 ),
                new Job( 1, 4, 30 ),
                new Job( 3, 5, 10 ),
                new Job( 5, 7, 30 ),
                new Job( 5, 9, 50 ),
                new Job( 7, 8, 10 )
        );

        System.out.print("The maximum profit is " + maxProfit(jobs));
    }
}





class PrintingAllJobsInvolvedInTheMaximumProfit
{
    // Function to perform binary search on the given jobs which are sorted by finish time.
    // The function returns index of the last job which doesn't conflict with the given job
    // i.e. whose finish time is less than or equal to the start time of the given job.
    public static int findLastNonConflictingJob(List<Job> jobs, int n)
    {
        // search space
        int low = 0;
        int high = n;

        // iterate till search space is exhausted
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (jobs.get(mid).finish <= jobs.get(n).start) {
                if (jobs.get(mid + 1).finish <= jobs.get(n).start) {
                    low = mid + 1;
                }
                else {
                    return mid;
                }
            }
            else {
                high = mid - 1;
            }
        }

        // return negative index if no non-conflicting job is found
        return -1;
    }

    // Function to print the non-overlapping jobs involved in maximum profit
    // using Dynamic Programming
    public static void findMaxProfitJobs(List<Job> jobs)
    {
        // sort jobs in increasing order of their finish times
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

        // get number of jobs
        int n = jobs.size();

        // maxProfit[i] stores the maximum profit possible for the first i jobs and
        // tasks[i] stores the index of jobs involved in the maximum profit
        int[] maxProfit = new int[n];

        List<List<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new ArrayList<>());
        }

        // initialize maxProfit[0] and tasks[0] with the first job
        maxProfit[0] = jobs.get(0).profit;
        tasks.get(0).add(0);

        // fill tasks[] and maxProfit[] in bottom-up manner
        for (int i = 1; i < n; i++)
        {
            // find the index of last non-conflicting job with current job
            int index = findLastNonConflictingJob(jobs, i);

            // include the current job with its non-conflicting jobs
            int currentProfit = jobs.get(i).profit;
            if (index != -1) {
                currentProfit += maxProfit[index];
            }

            // if including the current job leads to the maximum profit so far
            if (maxProfit[i-1] < currentProfit)
            {
                maxProfit[i] = currentProfit;

                if (index != -1) {
                    tasks.set(i, tasks.get(index));
                }
                tasks.get(i).add(i);
            }

            // excluding the current job leads to the maximum profit so far
            else {
                tasks.set(i, tasks.get(i-1));
                maxProfit[i] = maxProfit[i-1];
            }
        }

        // maxProfit[n-1] stores the maximum profit
        System.out.println("The maximum profit is " + maxProfit[n-1]);

        // tasks[n-1] stores the index of jobs involved in the maximum profit
        System.out.print("The jobs involved in the maximum profit are: ");
        for (int i: tasks.get(n-1)) {
            System.out.print(jobs.get(i));
        }
    }

    public static void main(String[] args)
    {
        List<Job> jobs = Arrays.asList(
                new Job( 0, 6, 60 ),
                new Job( 1, 4, 30 ),
                new Job( 3, 5, 10 ),
                new Job( 5, 7, 30 ),
                new Job( 5, 9, 50 ),
                new Job( 7, 8, 10 ));

        findMaxProfitJobs(jobs);
    }
}