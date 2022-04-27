package com.example.techiedelight.Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        int[] arr= {2,3,5};
        List<List<Integer>> ansList= new ArrayList<>();
        isTargetSumPossible(arr,8,ansList,new ArrayList<>());


        ansList.forEach(System.out::println);
        }

    private static void isTargetSumPossible(int[] arr,int targetSum,List<List<Integer>> ansList,List<Integer> list) {

        if(targetSum==0){
            ansList.add(new ArrayList<>(list));
        }
        if(targetSum<0){
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            targetSum=targetSum-arr[i];
            list.add(arr[i]);
        isTargetSumPossible(arr, targetSum,ansList,list);
            targetSum=targetSum+arr[i];
            list.remove(list.size()-1);
        }
    }
}


