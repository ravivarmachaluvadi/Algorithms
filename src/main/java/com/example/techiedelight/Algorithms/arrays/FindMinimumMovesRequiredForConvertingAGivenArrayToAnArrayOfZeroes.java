package com.example.techiedelight.Algorithms.arrays;

class FindMinimumMovesRequiredForConvertingAGivenArrayToAnArrayOfZeroes
{
    // Find minimum number of moves required for converting a given array
    // to an array of zeroes using only decrement and reduce operation.
    public static int countMoves(int[] arr)
    {
        // stores the count of minimum moves required
        int min_moves = 0;
 
        // loop till all elements of the array are 0
        while (true)
        {
            // stores count of 0's in current array
            int no_of_zeroes = 0;
 
            // traverse the array
            for (int i = 0; i < arr.length; i++)
            {
                // convert all odd numbers to even by reducing their value by 1
                // for each odd value, increment number of moves required
                if (arr[i] % 2 == 1) {
                    --arr[i];
                    ++min_moves;
                }
 
                // increment zeroes count if current element becomes 0
                if (arr[i] == 0) {
                    no_of_zeroes++;
                }
            }
 
            // break the loop if elements in the array becomes 0
            if (no_of_zeroes == arr.length) {
                break;
            }
 
            // Since each element in the array is even at this poInteger,
            // divide each element by 2
            for (int j = 0; j < arr.length; j++) {
                arr[j] = arr[j] / 2;
            }
 
            // increment number of moves by 1 for above divide operation
            min_moves++;
        }
 
        // return count of minimum moves required
        return min_moves;
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 8, 9, 8 };
 
        System.out.print("The minimum moves required is " + countMoves(arr));
    }
}