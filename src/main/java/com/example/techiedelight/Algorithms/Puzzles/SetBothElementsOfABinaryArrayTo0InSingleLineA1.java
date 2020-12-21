package com.example.techiedelight.Algorithms.Puzzles;

class SetBothElementsOfABinaryArrayTo0InSingleLineA1
{
    public static void convert(int[] arr)
    {
        arr[0] = arr[1] = arr[0] & arr[1];
        // arr[0] = arr[1] -= arr[1];
        // arr[1] = arr[0] -= arr[0];
    }
 
    public static void main(String[] args)
    {
        int[] arr1 = { 0, 1 };
        convert(arr1);
        System.out.println(arr1[0] + " " + arr1[1]);
 
        int[] arr2 = { 1, 0 };
        convert(arr2);
        System.out.println(arr2[0] + " " + arr2[1]);
 
        int[] arr3 = { 0, 0 };
        convert(arr3);
        System.out.println(arr3[0] + " " + arr3[1]);
    }
}




//Method 2: Using negation (logical NOT) operator
class SetBothElementsOfABinaryArrayTo0InSingleLineA2
{
    public static void convert(int[] arr)
    {
        arr[arr[1]] = arr[arr[0]];
        // arr[1 - arr[0]] = arr[1 - arr[1]];
        // arr[arr[1]] = 0;
    }

    public static void main(String[] args)
    {
        int[] arr1 = { 0, 1 };
        convert(arr1);
        System.out.println(arr1[0] + " " + arr1[1]);

        int[] arr2 = { 1, 0 };
        convert(arr2);
        System.out.println(arr2[0] + " " + arr2[1]);

        int[] arr3 = { 0, 0 };
        convert(arr3);
        System.out.println(arr3[0] + " " + arr3[1]);
    }
}





// Using only assignment operator
class SetBothElementsOfABinaryArrayTo0InSingleLineA3
{
    public static void convert(int[] arr)
    {
        arr[arr[1]] = arr[arr[0]];
        // arr[1 - arr[0]] = arr[1 - arr[1]];
        // arr[arr[1]] = 0;
    }

    public static void main(String[] args)
    {
        int[] arr1 = { 0, 1 };
        convert(arr1);
        System.out.println(arr1[0] + " " + arr1[1]);

        int[] arr2 = { 1, 0 };
        convert(arr2);
        System.out.println(arr2[0] + " " + arr2[1]);

        int[] arr3 = { 0, 0 };
        convert(arr3);
        System.out.println(arr3[0] + " " + arr3[1]);
    }
}