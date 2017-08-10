package sebastin;

import java.util.Arrays;

/**
 * Created by sebastin on 8/9/17.
 *
 * assumptions : not "God" == "dog" "god   " = "dog"
 */
public class checkPermutation {

    public static String sort(String s3) {
        char[] chars = s3.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // o(n log(n)) + o(n log(n)) = o(n log(n))
    private static boolean isValidPermutationBySorting(String s1, String s2) {

        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        return sort(s1).equals(sort(s2));
    }

    // o(n) -- from book
    private static boolean isValidPermutationByCharCount(String s1, String s2) {

        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] s1Chars = new int[128];
        for(int i=0; i<s1.length(); i++) {
            s1Chars[s1.charAt(i)]++;
        }

        for(int i=0; i<s2.length(); i++) {
            s1Chars[s2.charAt(i)]--;
            if (s1Chars[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isValidPermutationByCharCount("God", "dog"));
        System.out.println(isValidPermutationByCharCount("god", "dogg"));
        System.out.println(isValidPermutationByCharCount("aabbccdd", "ddccbbaa"));
        System.out.println(isValidPermutationByCharCount("god", "dog"));
        System.out.println(isValidPermutationByCharCount("god", null));
        System.out.println(isValidPermutationByCharCount("", ""));

        System.out.println("-------------------------------");

        System.out.println(isValidPermutationBySorting("God", "dog"));
        System.out.println(isValidPermutationBySorting("god", "dogg"));
        System.out.println(isValidPermutationBySorting("aabbccdd", "ddccbbaa"));
        System.out.println(isValidPermutationBySorting("god", "dog"));
        System.out.println(isValidPermutationBySorting("god", null));
        System.out.println(isValidPermutationBySorting("", ""));
    }
}
