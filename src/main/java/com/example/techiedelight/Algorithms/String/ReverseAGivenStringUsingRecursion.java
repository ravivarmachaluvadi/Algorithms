package com.example.techiedelight.Algorithms.String;

class ReverseAGivenStringUsingRecursion
{
    private static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
 
    // Recursive function to reverse a given String
    public static void reverse(char[] c, int l, int h)
    {
        if (l < h)
        {
            swap(c, l, h);
            reverse(c, l + 1, h - 1);
        }
    }
 
    public static void main(String[] args)
    {
        String str = "Techie Delight";
 
        char[] c = str.toCharArray();
        reverse(c, 0, c.length - 1);
        str = new String(c);
 
        System.out.print("Reverse of the given String is : " + str);
    }
}