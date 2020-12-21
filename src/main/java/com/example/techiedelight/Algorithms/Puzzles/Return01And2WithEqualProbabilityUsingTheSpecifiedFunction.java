package com.example.techiedelight.Algorithms.Puzzles;

import java.util.Random;
 
class Return01And2WithEqualProbabilityUsingTheSpecifiedFunction
{
    // Return 0 and 1 with equal probability
    public static int random() {
        return new Random().nextInt(2);
    }
 
    // Return 0, 1 and 2 with equal probability using the specified function
    public static int generate()
    {
        int x = random();
        int y = random();
 
        // if x == 1 and y == 0, try again
        return (x == 1 && y == 0)? generate(): (x + y);
    }
 
    public static void main(String[] args)
    {
        int zero = 0, one = 0, two = 0;
 
        for (int i = 0; i < 100000; i++) {
            int val = generate();
            if (val == 0) {
                zero++;
            } else if (val == 1) {
                one++;
            } else {
                two++;
            }
        }
 
        System.out.println("0 ~ " + zero/1000.0 + "%");
        System.out.println("1 ~ " + one/1000.0 + "%");
        System.out.println("2 ~ " + two/1000.0 + "%");
    }
}





class Return01And2WithEqualProbabilityUsingTheSpecifiedFunctionA2
{
    // Return 0 and 1 with equal probability
    public static int random() {
        return new Random().nextInt(2);
    }

    // Return 0, 1 and 2 with equal probability using the specified function
    public static int generate()
    {
        // rand is one of { 0, 1, 2 or 3 } with equal probability (25% each)
        int rand = 2 * random() + random();

        // return rand if it is 0, 1 or 2, else try again
        return (rand <= 2) ? rand : generate();
    }

    public static void main(String[] args)
    {
        int zero = 0, one = 0, two = 0;

        for (int i = 0; i < 100000; i++) {
            int val = generate();
            if (val == 0) {
                zero++;
            } else if (val == 1) {
                one++;
            } else {
                two++;
            }
        }

        System.out.println("0 ~ " + zero/1000.0 + "%");
        System.out.println("1 ~ " + one/1000.0 + "%");
        System.out.println("2 ~ " + two/1000.0 + "%");
    }
}