package com.learning.ctci.arrays_and_strings;

import java.util.Arrays;

/**
 * Created by veeramuthum on 7/18/17.
 */
public class IsUnique {

    public static boolean hasUniqueChars(String inStr) {
        if(inStr==null || inStr.isEmpty())
            return false;

        int inStrLen = inStr.length();
        for(int i=0; i<inStrLen; i++) {
             for(int j=i+1; j<inStrLen; j++) {
                 if(inStr.charAt(i) == inStr.charAt(j))
                     return false;
             }
        }
        return true;
    }

    public static boolean hasUniqueCharsChkAdjacent(String inStr) {
        if(inStr==null || inStr.isEmpty())
            return false;

        int inStrLen = inStr.length();

        //Sort input string
        char[] temp = inStr.toCharArray();

        //TODO: implement own
        Arrays.sort(temp);
        inStr = new String(temp);

        for(int i=0, j=1; i<inStrLen && j<inStrLen; i++, j++) {
            if(inStr.charAt(i) == inStr.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static  void main(String args[]) {

        System.out.println(hasUniqueChars("abc"));
        System.out.println(hasUniqueChars("abcdedd"));
        System.out.println(hasUniqueChars(""));
        System.out.println(hasUniqueChars(null));
        System.out.println(hasUniqueChars("a"));
        System.out.println(hasUniqueChars("aa"));

        System.out.println("**************************************");

        System.out.println(hasUniqueCharsChkAdjacent("abc"));
        System.out.println(hasUniqueCharsChkAdjacent("abcdedd"));
        System.out.println(hasUniqueCharsChkAdjacent(""));
        System.out.println(hasUniqueCharsChkAdjacent(null));
        System.out.println(hasUniqueCharsChkAdjacent("a"));
        System.out.println(hasUniqueCharsChkAdjacent("aa"));
    }

}
