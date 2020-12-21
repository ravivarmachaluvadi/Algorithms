package com.example.techiedelight.Algorithms.String;

//Find all N-digit strictly increasing numbers (Bottom-Up and Top-Down Approach)
class FindAllNDigitStrictlyIncreasingNumbersBottomUpApproach
        {
    // Function to find all N-digit strictly increasing numbers
    // in Bottom-up manner
    public static void strictlyInc(String res, int n, char prev)
    {
        // If the string becomes N-digit, print it
        if (n == 0) {
            System.out.print(res + " ");
            return;
        }
 
        // start from next digit (last digit is prev)
        for (char ch = (char)(prev + 1); ch <= '9'; ch++) {
            strictlyInc(res + ch, n - 1, ch);
        }
    }
 
    public static void main(String[] args)
    {
        int n = 7;
 
        String res = "";
        strictlyInc(res, n, '0');
    }
}



// Top-Down Approach
class FindAllNDigitStrictlyIncreasingNumbers
{
    // Function to find all N-digit strictly increasing
    // numbers in Top-down manner
    public static void strictlyInc(String res, int n, char curr)
    {
        // If the String becomes N-digit, print it
        if (n == 0) {
            System.out.println(res);
            return;
        }

        for (char ch = curr; ch >= '1'; ch--) {
            strictlyInc(ch + res, n - 1, (char) (ch - 1));
        }
    }

    public static void main(String[] args)
    {
        int n = 7;

        String res = "";
        strictlyInc(res, n, '9');
    }
}