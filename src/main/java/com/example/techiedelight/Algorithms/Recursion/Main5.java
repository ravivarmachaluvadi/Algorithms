package com.example.techiedelight.Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Main5 {

    public static void main(String[] args) {
        int[] arr= {2,3,5};
        isTargetSumPossible(arr,8,new ArrayList<>(),0);
    }

    private static void isTargetSumPossible(int[] arr,int targetSum,List<Integer> list,int index) {

        if(targetSum==0 || index==arr.length){
            System.out.println(list); // [2, 2, 2, 2] (only one output)
            return;
        }
        if(targetSum<0 ){
           // System.out.println(list);
            return;
        }

            targetSum=targetSum-arr[index];
            list.add(arr[index]);
        isTargetSumPossible(arr, targetSum,list,index+1);
            targetSum=targetSum+arr[index];
            list.remove(list.size()-1);
        isTargetSumPossible(arr, targetSum,list,index+1);

    }
}
/*
[2, 2, 2, 2]
[2, 2, 2, 2]
[2, 2, 2, 2]
[2, 2, 2, 2]
[2, 3, 3]
[2, 3, 3]
[2, 3, 3]
[3, 5]
[3, 5]
 */
