package com.example.techiedelight.Algorithms.String;

class RunLengthEncodingRLEDataCompressionAlgorithm
{
    // Perform Run Length Encoding (RLE) data compression algorithm
    // on String str
    public static String encode(String str)
    {
        // stores output String
        String encoding = "";
        int count;
 
        for (int i = 0; i < str.length(); i++)
        {
            // count occurrences of character at index i
            count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i+1))
            {
                count++;
                i++;
            }
 
            // append current character and its count to the result
            encoding += String.valueOf(count) + str.charAt(i);
        }
 
        return encoding;
    }
 
    public static void main(String[] args)
    {
        String str = "ABBCCCD";
 
        System.out.print(encode(str));
    }
}