package com.example.techiedelight.Algorithms.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
class FindAllPossibleCombinationsOfWordsFormedFromMobileKeypad
{
    // Top-down Recursive function to find all possible combinations of words formed
    // from mobile keypad
    public static void findCombinations(List<List<Character>> keypad,
                                        int[] input, String res, int index)
    {
        // if we have processed every digit of key, print result
        if (index == -1)
        {
            System.out.print(res + " ");
            return;
        }
 
        // stores current digit
        int digit = input[index];
 
        // one by one replace the digit with each character in the corresponding
        // list and recur for next digit
        for (char c: keypad.get(digit)) {
            findCombinations(keypad, input, c + res, index - 1);
        }
    }
 
    public static void main(String[] args)
    {
        List<List<Character>> keypad = Arrays.asList(
                // 0 and 1 digit don't have any characters associated
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList( 'A', 'B', 'C' ),
                Arrays.asList( 'D', 'E', 'F' ),
                Arrays.asList( 'G', 'H', 'I' ),
                Arrays.asList( 'J', 'K', 'L' ),
                Arrays.asList( 'M', 'N', 'O' ),
                Arrays.asList( 'P', 'Q', 'R', 'S'),
                Arrays.asList( 'T', 'U', 'V' ),
                Arrays.asList( 'W', 'X', 'Y', 'Z')
        );
 
        // input number in the form of an array (number can't start from 0 or 1)
        int[] input = { 2, 3, 4 };
 
        // find all combinations
        findCombinations(keypad, input, "", input.length - 1);
    }
}




class FindAllPossibleCombinationsOfWordsFormedFromMobileKeypadA2
{
    // Iterative function to find all possible combinations of words
    // formed from mobile keypad
    public static void findCombinations(List<List<Character>> keypad,
                                        int[] input)
    {
        // list to store combinations of all possible words
        List<String> outputList = new ArrayList<>();

        // push all character associated with first digit into output list
        for (Character ch: keypad.get(input[0])) {
            outputList.add(String.valueOf(ch));
        }

        // start from second digit
        for (int i = 1; i < input.length; i++)
        {
            // create a temporary list and clear contents of output list
            List<String> prevList = new ArrayList<>(outputList);
            outputList.clear();

            // for each character associated with current digit in the keypad
            for (Character ch: keypad.get(input[i]))
            {
                // append current character to each word in the output list
                for (String s: prevList) {
                    outputList.add(s + ch);
                }
            }

            // list now contains all possible combinations of words
            // until current digit
        }

        // print output list containing all combinations of words possible
        System.out.println(outputList);
    }

    public static void main(String[] args)
    {
        List<List<Character>> keypad = Arrays.asList(
                // 0 and 1 digit don't have any characters associated
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList( 'A', 'B', 'C' ),
                Arrays.asList( 'D', 'E', 'F' ),
                Arrays.asList( 'G', 'H', 'I' ),
                Arrays.asList( 'J', 'K', 'L' ),
                Arrays.asList( 'M', 'N', 'O' ),
                Arrays.asList( 'P', 'Q', 'R', 'S'),
                Arrays.asList( 'T', 'U', 'V' ),
                Arrays.asList( 'W', 'X', 'Y', 'Z')
        );

        // input number in the form of an array
        // (number can't start from 0 or 1)
        int[] input = { 2, 3, 4 };

        // find all combinations
        findCombinations(keypad, input);
    }
}
