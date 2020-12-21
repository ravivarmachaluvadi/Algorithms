package com.example.techiedelight.Algorithms.String;

class InPlaceRemoveAllOccurrencesOfABAndCFromTheString
{
    // Function to remove all occurrences of "AB" and "C"
    // from the string
    public static String remove(String str)
    {
        char[] chars = str.toCharArray();
 
        // i maintains the position of current char in the input string
        // k maintains the next free position in output string
        int i = 0, k = 0;
 
        // do till we reach the end of the string
        while (i < str.length())
        {
            // if current char is 'B' and previous char (need not
            // be adjacent) was 'A', increment i and decrement k
            if (chars[i] == 'B' && (k > 0 && chars[k - 1] == 'A')) {
                --k;
                ++i;
            }
            // if current char is 'C', increment i
            else if (chars[i] == 'C') {
                ++i;
            }
            // for any other character, increment both i and k
            else {
                chars[k++] = chars[i++];
            }
        }
 
        return new String(chars).substring(0, k);
    }
 
    public static void main(String[] args)
    {
        String str = "ABCACBCAABB";
 
        str = remove(str);
        System.out.printf("String after removal of \"AB\" and \"C\" is \"%s\"", str);
    }
}