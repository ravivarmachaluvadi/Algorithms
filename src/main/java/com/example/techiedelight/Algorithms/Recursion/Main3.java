package com.example.techiedelight.Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Main3 {


    public static void main(String[] args) {
        int[] arr= {1,2,3};
        printPermutations(arr,new ArrayList<>(),0);

    }

    private static void printPermutations(int[] arr, List<Integer> list,int index) {

        if(list.size()==arr.length || index==arr.length){
            System.out.println(list);
            return;
        }

            list.add(arr[index]);
        printPermutations(arr,list,index+1);
            list.remove(list.size()-1);
        printPermutations(arr,list,index+1);

    }
}