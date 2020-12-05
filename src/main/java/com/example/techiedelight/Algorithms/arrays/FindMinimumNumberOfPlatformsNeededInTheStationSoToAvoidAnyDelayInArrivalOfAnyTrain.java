package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class FindMinimumNumberOfPlatformsNeededInTheStationSoToAvoidAnyDelayInArrivalOfAnyTrain
{
    // Function to find the minimum number of platforms needed in the
    // station so as to avoid any delay in the arrival of any train.
    public static int minPlatforms(double[] arrival, double[] departure)
    {
        // maintains the count of trains
        int count = 0;
 
        // stores minimum platforms needed
        int platforms = 0;
 
        // take two indices for arrival and departure time
        int i = 0, j = 0;
 
        // run till train is scheduled to arrive
        while (i < arrival.length)
        {
            // if train is scheduled to arrive next
            if (arrival[i] < departure[j])
            {
                // increase the count of trains and update minimum
                // platforms if required
                platforms = Integer.max(platforms, ++count);
 
                // move the pointer to next arrival
                i++;
            }
 
            // if train is scheduled to depart next i.e.
            // (departure[j] < arrival[i]), decrease the count of trains
            // and move pointer j to next departure
 
            // If two trains are arriving and departing at the same time,
            // i.e. (arrival[i] == departure[j]) depart the train first
            else {
                count--;
                j++;
            }
        }
 
        return platforms;
    }
 
    // Find minimum number of platforms needed in the station to avoid any
    // delay in arrival of any train
    public static void main(String[] args)
    {
        double[] arrival = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 };
        double[] departure = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 };
 
        // sort arrival time of trains
        Arrays.sort(arrival);
 
        // sort departure time of trains
        Arrays.sort(departure);
 
        System.out.print("Minimum platforms needed is "
                    + minPlatforms(arrival, departure));
    }
}