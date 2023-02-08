package com.example.techiedelight.Algorithms.Recursion;

public class Main8 {

    static int max=Integer.MIN_VALUE;

    public static void main(String[] args)
    {
        int price[] = { 1, 5, 8, 11, 10, 17, 17, 20 };

        // rod length
        int n = 4;
        rodCut(price, n,0);
        System.out.println(max);
    }

    private static void rodCut(int[] price, int length,int profit) {

        if(length==0){
            max=Integer.max(max,profit);
            return;
        }
        if(length<0){
            return;
        }

        for (int i = 1; i <= price.length; i++) {

                length = length - i;
                profit = profit + price[i-1];

            rodCut(price, length,profit);

                length = length + i;
                profit = profit - price[i-1];

        }
}
}
