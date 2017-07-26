package com.learning.ctci.arrays_and_strings;

import java.util.Arrays;

public class IsPermutation {

    public static boolean isPermutation(String str1, String str2) {

        if(str1 ==  null || str1.isEmpty() || str2 == null || str2.isEmpty())
            return false;

        int str1Len = str1.length();
        int str2Len = str2.length();

        if(str1Len != str2Len)
            return false;

        int[] str1Count = new int[256];
        int[] str2Count = new int[256];

        for(int i=0; i<str1Len; i++)
            str1Count[str1.charAt(i)]++;

        for(int i=0; i<str2Len; i++)
            str2Count[str2.charAt(i)]++;

        return Arrays.equals(str1Count, str2Count);
    }

    public static void main(String args[]) {
        System.out.println(isPermutation("abca", "caba"));
        System.out.println(isPermutation("abca", "cdba"));
        System.out.println(isPermutation("abca", ""));
        System.out.println(isPermutation(null, "cdba"));
        System.out.println(isPermutation("abca", "cdbaqwewqe"));
        System.out.println(isPermutation("bbbbbb", "bbbbbb"));
    }
}
