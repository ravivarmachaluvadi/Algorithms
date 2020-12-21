package com.example.techiedelight.Algorithms.String;

import java.util.Random;
 
class ConvertNumberIntoCorrespondingExcelColumnName
{
    // Function to convert given number into an excel column
    public static String getColumnName(int n)
    {
        // initialize output String as empty
        StringBuilder res = new StringBuilder();
 
        while (n > 0)
        {
            // find index of next letter and concatenate the letter
            // to the solution
 
            // Here index 0 corresponds to 'A' and 25 corresponds to 'Z'
            int index = (n - 1) % 26;
            res.append((char)(index + 'A'));
            n = (n - 1) / 26;
        }
 
        return res.reverse().toString();
    }
 
    public static void main(String[] args)
    {
        // generate column name for 10 random numbers between 1-1000
        for (int i = 1; i <= 10; i++)
        {
            int r = new Random().nextInt(1000) + 1;
            System.out.println(r + " - " + getColumnName(r));
        }
    }
}