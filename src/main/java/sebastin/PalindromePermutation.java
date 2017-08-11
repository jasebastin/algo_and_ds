package sebastin;

import java.util.ArrayList;

/**
 * Created by sebastin on 8/9/17.
 */
public class PalindromePermutation {

    //o (n * (n-1))
    private static ArrayList<String> getPermutations(String s1) {

        //dog - D dog, dgo O odg, ogd G gdo, god
        ArrayList<String> strings = new ArrayList<String>();

        char[] chars1 = s1.toCharArray();
        
        for(int j=0; j < chars1.length; j++)  {
            if (chars1[j] == ' ') {
                //skip
            } else {
                String s2 = fixedString(chars1, j);
                strings.add(s2);
                char[] chars2 = s2.toCharArray();
                for (int i = 1; i < chars2.length - 1; i++) {
                    swap(chars2, i + 1, i);
                    strings.add(new String(chars2));
                }
            }
        }

        return strings;
    }

    private static String fixedString(char[] chars1, int index) {
        if(index > 0) {
            swap(chars1, index, 0);
        }
        return new String(chars1);
    }

    private static void swap(char[] chars1, int index, int position) {
        if (index < chars1.length) {
            char temp = chars1[position];
            chars1[position] = chars1[index];
            chars1[index] = temp;
        }
    }
    //o(n)
    private static String getPalindrome(String s1) {

        char[] chars = s1.toCharArray();
        char[] chars1 = new char[chars.length];
        int count = 0;
        for (int i=chars.length-1; i >= 0; i--) {
            chars1[count] = chars[i];
            count++;
        }
        return new String(chars1);
    }

    private static boolean isPermutationPalindrome(String s1) {

         ArrayList<String> permutations = getPermutations(s1);
         String palindrome = getPalindrome(s1);

         if (s1.length() != palindrome.length()) {
             return false;
         }

         for (String permutation: permutations) {
            if (palindrome.equals(permutation)) {
                return true;
            }
         }

        return false;
    }
    //o (n * (n-1)) + o(c)
    private static void printPermutations(String s1) {
        ArrayList<String> permutations = getPermutations(s1);
        System.out.println("-------------------------------");
        for (String permutation: permutations) {
            System.out.println(permutation);
        }
        System.out.println("-------------------------------");
    }

    private static boolean isPalindrome(String s1) {

        char[] chars = s1.toCharArray();
        int[] letters = new int[128];
        for (char c: chars) {
            if (c != ' ') {
                letters[c]++;
            }
        }

        boolean odd = false;
        for (int i: letters) {
            if (i % 2 == 1) {
                if (odd) {
                    return false;
                }
                odd = true;
            }
        }

        return true;
    }

    // o(n2) ?
    public static void main(String[] args) {

        //get permutations
        printPermutations("tact cao");
        //get palindrome
        System.out.println(getPalindrome("tact cao"));
        //check palindrome is a permutation or not
        System.out.println(isPermutationPalindrome("madam"));
        System.out.println(isPermutationPalindrome("sebas"));
        System.out.println(isPermutationPalindrome("dog"));
        System.out.println(isPermutationPalindrome("tact cao"));


        System.out.println("isPalindrome:" + isPalindrome("madam"));
        System.out.println("isPalindrome:" + isPalindrome("dog"));
        System.out.println("isPalindrome:" + isPalindrome("tact cao"));
    }
}
