package com.example.techiedelight.Algorithms.Puzzles;

class FindSquareOfANumberWithoutUsingMultiplicationAndDivisionOperator
{
    public static int findSquare(int num)
    {
        int odd = 1;
        int sq = 0;
 
        // convert number to positive if it is negative
        num = Math.abs(num);
 
        while (num-- > 0) {
            sq = sq + odd;
            odd = odd + 2;
        }
 
        return sq;
    }
 
    public static void main(String[] args)
    {
        System.out.println(findSquare(8));
        System.out.println(findSquare(-4));
    }
}





//Repeatedly adding given number to the result
class FindSquareOfANumberWithoutUsingMultiplicationAndDivisionOperatorA2
{
    public static int findSquare(int num)
    {
        // convert number to positive if it is negative
        num = Math.abs(num);

        // stores square of the number
        int sq = num;

        // repeatedly add num to the result
        for (int i = 1; i < num; i++) {
            sq = sq + num;
        }

        return sq;
    }

    public static void main(String[] args) {
        System.out.print(findSquare(8) + " " + findSquare(-4));
    }
}




//Using Divide and Conquer with bitwise operators
class FindSquareOfANumberWithoutUsingMultiplicationAndDivisionOperatorA3
{
    public static int findSquare(int num)
    {
        // base case
        if (num < 2) {
            return num;
        }

        // convert number to positive if it is negative
        num = Math.abs(num);

        // drop last bit from num (divide it by 2)
        int i = num >> 1;

        // if num is odd
        if ((num & 1) == 1) {
            return ((findSquare(i) << 2) + (i << 2) + 1);
        }
        // if num is even
        else {
            return (findSquare(i) << 2);
        }
    }

    public static void main(String[] args) {
        System.out.print(findSquare(8));
    }
}