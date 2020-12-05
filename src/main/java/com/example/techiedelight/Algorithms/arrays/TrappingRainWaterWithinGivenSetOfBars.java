package com.example.techiedelight.Algorithms.arrays;

class TrappingRainWaterWithinGivenSetOfBars
{
    // Function to find amount of water that can be trapped within
    // given set of bars in linear time and extra space
    public static int trap(int[] bars)
    {
        int n = bars.length;
        int water = 0;
 
        // left[i] stores the maximum height of a bar to the left
        // of current bar
        int[] left = new int[n-1];
        left[0] = Integer.MIN_VALUE;
 
        // process bars from left to right
        for (int i = 1; i < n - 1; i++) {
            left[i] = Integer.max(left[i - 1], bars[i - 1]);
        }
 
        /*
        int[] right = new int[n];
        right[n - 1] = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Integer.max(right[i + 1], bars[i + 1]);
        }
 
        for (int i = 1; i < n - 1; i++) {
            if (Integer.min(left[i], right[i]) > bars[i]) {
                water += Integer.min(left[i], right[i]) - bars[i];
            }
        }
        */
 
        // right stores the maximum height of a bar to the right
        // of current bar
        int right = Integer.MIN_VALUE;
 
        // process bars from right to left
        for (int i = n - 2; i >= 1; i--) {
            right = Integer.max(right, bars[i + 1]);
 
            // check if it is possible to store water in current bar
            if (Integer.min(left[i], right) > bars[i]) {
                water += Integer.min(left[i], right) - bars[i];
            }
        }
 
        return water;
    }
 
    // Trapping Rain Water within given set of bars
    public static void main(String[] args)
    {
        int[] heights = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };
 
        System.out.print("Maximum amount of water that can be trapped is " +
                                trap(heights));
    }
}



class TrappingRainWaterWithinGivenSetOfBarsOpti
{
    // Function to find amount of water that can be trapped within
    // given set of bars in linear time and constant space
    public static int trap(int[] heights)
    {
        // maintain two pointers left and right pointing to leftmost and
        // rightmost index of the input array
        int left = 0, right = heights.length - 1, water = 0;

        int maxLeft = heights[left];
        int maxRight = heights[right];

        while (left < right)
        {
            if (heights[left] <= heights[right])
            {
                left++;
                maxLeft = Integer.max(maxLeft, heights[left]);
                water += (maxLeft - heights[left]);
            }
            else
            {
                right--;
                maxRight = Integer.max(maxRight, heights[right]);
                water += (maxRight - heights[right]);
            }
        }

        return water;
    }

    // Trapping Rain Water within given set of bars
    public static void main(String[] args)
    {
        int[] heights = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };

        System.out.print("Maximum amount of water that can be trapped is " +
                trap(heights));
    }
}

