package sebastin;

import java.util.ArrayList;

/**
 * Created by sebastin on 8/9/17.
 */
public class PalindromePermutation {

    private static void printPermutations(String s1) {

        //dog - D dog, dgo O odg, ogd G gdo, god
        char[] chars = s1.toCharArray();
        ArrayList<String> strings = new ArrayList<String>();

        char[] chars1 = s1.toCharArray();
        
        for(int j=0; j < chars.length; j++)  {
            String s2 = fixedString(chars1, j);
            System.out.println(s2);
            char[] chars2 = s2.toCharArray();
            strings.add(new String(chars2));
            for (int i=1; i < chars2.length-1; i++) {
                swap(chars2, i+1, i);
                System.out.println(new String(chars2));
            }
            System.out.println("-----------------------------------");
        }
    }

    private static String fixedString(char[] chars1, int index) {
        swap(chars1, index, 0);
        return new String(chars1);
    }

    private static void swap(char[] chars1, int index, int position) {
        if (index < chars1.length) {
            char temp = chars1[position];
            chars1[position] = chars1[index];
            chars1[index] = temp;
        }
    }

    public static void main(String[] args) {

        //print permutations
        printPermutations("sebastin");
        printPermutations("ABC");
        //check palindrome or not
    }
}
