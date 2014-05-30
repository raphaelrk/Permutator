package com.raphaelrk.permutator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author RAPHAEL Rouvinov-Kats
 */
public class Permutator {
    
    private static final String DEFAULT_REGEX = " ";
    private static final String DEFAULT_OUTPUT_SPLITTER = " "; // this should work as a delimiter with the regex
    private static String[] input;
    
    /**
     * @param args the command line arguments, which become the input if they exist
     */
    public static void main(String[] args) {
        if(args.length == 0) {
            // input = "Come to my house after for a bonfire".split(DEFAULT_REGEX);
            input = "a b c d".split(DEFAULT_REGEX);
        } else {
            input = args;
        }
        printPermutations(input);
    }
    
    public static void printPermutation(ArrayList<String> stringArr, String splitter) {
        for(int i = 0; i < stringArr.size(); i++) {
            System.out.print(stringArr.get(i));
            if(i < stringArr.size() - 1) {
                System.out.print(splitter);
            }
        }
        System.out.println();
    }
    
    /**
     * prints all permutations of the wholeStringArr
     * recursively goes through every single word in the wholeStringArr, 
     * appending it to currString for the next call if the word isn't already in there
     * @param wholeStringArr an array with every word you want to have in the permutation
     * @param currString this is the "base" of the string - the permutations will be attached to this
     * @param regexp this is what splits your current string array into parts
     */
    public static void printPermutations(String[] wholeStringArr, ArrayList<String> currStringArr, String regexp, String outputSplitter) {
        if(currStringArr == null) {
            currStringArr = new ArrayList<String>();
        }

        if(currStringArr.size() >= wholeStringArr.length) {
            printPermutation(currStringArr, outputSplitter);
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
            if(wholeStrOccurences <= currStrOccurences) continue;
            
            // run this method for the now-checked appension
            ArrayList<String> nextStr = (ArrayList<String>) currStringArr.clone();
            nextStr.add(appension);
            printPermutations(wholeStringArr, nextStr, regexp, outputSplitter);
        }
    };
    
    /**
     * Convenience method for printPermutations(String[] wholeStringArr, String currString, String regexp, String outputSplitter)
     */
    public static void printPermutations(String[] wholeStringArr, String regexp, String outputSplitter) {
        printPermutations(wholeStringArr, new ArrayList<String>(), regexp, outputSplitter);
    }
    
    /**
     * Convenience method for printPermutations(String[] wholeStringArr, String currString, String regexp, String outputSplitter)
     */
    public static void printPermutations(String[] wholeStringArr, String regexp) {
        printPermutations(wholeStringArr, new ArrayList<String>(), regexp, DEFAULT_OUTPUT_SPLITTER);
    }
    
    /**
     * Convenience method for printPermutations(String[] wholeStringArr, String currString, String regexp, String outputSplitter)
     */
    public static void printPermutations(String[] wholeStringArr) {
        printPermutations(wholeStringArr, new ArrayList<String>(), DEFAULT_REGEX, DEFAULT_OUTPUT_SPLITTER);
    }
}
