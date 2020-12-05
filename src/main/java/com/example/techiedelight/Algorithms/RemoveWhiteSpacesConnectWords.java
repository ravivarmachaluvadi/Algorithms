package com.example.techiedelight.Algorithms;

class RemoveWhiteSpacesConnectWords {
  public static void main(String[] args) {

    // create a string
    String message = "Find Minimum and Maximum element in an array using minimum comparisons";

    // stores each characters to a char array
    char[] charArray = message.toCharArray();
    boolean foundSpace = true;

    for(int i = 0; i < charArray.length; i++) {

      // if the array element is a letter
      if(Character.isLetter(charArray[i])) {

        // check space is present before the letter
        if(foundSpace) {

          // change the letter into uppercase
          charArray[i] = Character.toUpperCase(charArray[i]);
          foundSpace = false;
        }
      }

      else {
        // if the new character is not character
        foundSpace = true;
      }
    }

    // convert the char array to the string
    message = String.valueOf(charArray);
    message=message.replaceAll("\\s","");
    System.out.println("Message: " + message);
  }
}