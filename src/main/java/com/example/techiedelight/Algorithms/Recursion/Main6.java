package com.example.techiedelight.Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;
public class Main6 {

    static  int max=Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        getLengthOfLIS(nums, new ArrayList<>(), 0);
        System.out.println(max);
    }

    private static void getLengthOfLIS(int[] nums, List<Integer> list, int index) {

        if(index==nums.length){
            max=Math.max(max,list.size());
            if(list.size()==4)
            System.out.println(list);
            return;
        }

        if((list.isEmpty()) || list.get(list.size()-1)<nums[index]) {
            list.add(nums[index]);
        }

        getLengthOfLIS(nums, list, index+1);

        if(!list.isEmpty()) {
            list.remove(list.size() - 1);
        }

        getLengthOfLIS(nums, list, index + 1);

    }
}

/*
[2, 5, 7, 101]
[2, 5, 7, 101]
4
 */
