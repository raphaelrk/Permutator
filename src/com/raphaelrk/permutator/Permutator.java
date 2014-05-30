package com.raphaelrk.permutator;

import java.util.Arrays;

/**
 *
 * @author RAPHAEL Rouvinov-Kats
 */
public class Permutator {
    
    private static String[] input = "Come to my house after for a bonfire".split(" ");

    /**
     * @param args the command line arguments, which become the input if they exist
     */
    public static void main(String[] args) {
        if(args.length != 0) {
            input = args;
        }
        printPermutations(input);
    }
    
    /**
     * prints all permutations of the wholeStringArr
     * recursively goes through every single word in the wholeStringArr, appending it to currString for the next call if the word isn't already in there
     * @param wholeStringArr an array with every word you want to have in the permutation
     * @param currString this is the "base" of the string - the permutations will be attached to this
     */
    public static void printPermutations(String[] wholeStringArr, String currString) {
        if(currString == null) {
            currString = "";
        }

        String[] currStringArr = currString.split(" ");

        if(currStringArr.length > wholeStringArr.length) {
            System.out.println(currString.substring(1)); // substring because the first index in currString is " "
            return;
        }
        for(int i = 0; i < wholeStringArr.length; i++) {
            // this is what will be added to the next 'currString'
            String appension = wholeStringArr[i];
            
            // count occurences of the appension in the wholeString
            int wholeStrOccurences = 0;
            for(String s : wholeStringArr) {
                if(s.equals(appension)) wholeStrOccurences++;
            }
            
            // count occurences of the appension in the currString
            int currStrOccurences = 0;
            for(String s : currStringArr) {
                if(s.equals(appension)) currStrOccurences++;
            }
            
            // make sure that appending won't make this go over the amount of occurences of the appension
            if(wholeStrOccurences == currStrOccurences) continue;
            
            // run this method for the now-checked appension
            String nextStr = currString + " " + appension;
            printPermutations(wholeStringArr, nextStr);
        }
    };
    
    /**
     * Convenience method for printPermutations(String[] wholeStringArr, String currString)
     */
    public static void printPermutations(String[] wholeStringArr) {
        printPermutations(wholeStringArr, "");
    }
}
