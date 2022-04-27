package com.example.techiedelight.Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        int[] arr= {1,2,3};
        printPermutationsWithRepetitionLogic1(arr,new ArrayList<>());

    }

    private static void printPermutationsWithRepetitionLogic1(int[] arr,List<Integer> list) {

        if(list.size()==arr.length){
            System.out.println(list);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            printPermutationsWithRepetitionLogic1(arr,list);
            list.remove(list.size()-1);
        }
    }
}
