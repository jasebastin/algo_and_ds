package sebastin;

import java.util.Arrays;

/**
 * Created by sebastin on 8/9/17.
 *
 * assumptions : ASCII or extended ASCII or Unicode strings
 *
 */
public class isUnique {
    // o(n square) comparing each char with other chars

    //o(n log(n))
    private static boolean isUniqueBySorting(String s1) {

        if (s1 == null || s1.equals("") || s1.length() > 256) {
            return false;
        }
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        s1 = new String(chars);
        for (int i=0; i<s1.length(); i++) {
            if (((i+1) < s1.length()) && s1.charAt(i) == s1.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    /* o(n) -- from book */
    private static boolean isUniqueByCharArray(String s1) {

        if (s1 == null || s1.equals("") || s1.length() > 256) {
            return false;
        }

        boolean[] array = new boolean[256];
        for (int i=0; i < s1.length(); i++) {
            int c = s1.charAt(i); //saving to integer so char converts to int value
            if (array[c]) {
                return false;
            }
            array[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isUniqueByCharArray("god"));
        System.out.println(isUniqueByCharArray("godd"));
        System.out.println(isUniqueByCharArray(""));
        System.out.println(isUniqueByCharArray(null));
        System.out.println(isUniqueByCharArray("sebastin"));    //abesstin
        System.out.println(isUniqueByCharArray("mohan"));

        System.out.println("--------------------");

        System.out.println(isUniqueBySorting("god"));
        System.out.println(isUniqueBySorting("godd"));
        System.out.println(isUniqueBySorting(""));
        System.out.println(isUniqueBySorting(null));
        System.out.println(isUniqueBySorting("sebastin"));
        System.out.println(isUniqueBySorting("sebatinn"));
        System.out.println(isUniqueBySorting("mohan"));
    }
}
