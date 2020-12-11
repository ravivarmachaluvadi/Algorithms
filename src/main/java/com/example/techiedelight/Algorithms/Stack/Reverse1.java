package com.example.techiedelight.Algorithms.Stack;

import java.lang.StringBuilder;

//ReverseUsingstack a string without using recursion
//Using build-in methods
class Reverse1
{
    public static void main (String[] args)
    {
        String str = "Techie Delight";
        String rev = new StringBuilder(str).reverse().toString();
 
        System.out.println("Reverse1 of the given string is : " + rev);
    }
}