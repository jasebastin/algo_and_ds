package sebastin;

/**
 * Created by sebastin on 8/14/17.
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 */
public class OneOrZeroEditAway {
    //o(a)/128 + o(b)  = o(b)
    private static boolean isOneOrZeroEditAway(String s1, String s2) {

        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")) {
            return false;
        }

        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s2Length == (s1Length + 2) || s2Length == (s1Length - 2)) {
            return false;
        }

        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        int match = 0;
        int[] ints = new int[128];
        for (char c1 : chars) {
            ints[c1]++;
        }

        for (char c2 : chars1) {
            if (ints[c2] == 1) {
                match++;
                ints[c2]--;
            }
        }

        return (match == s1Length || match == s1Length + 1 || match == s1Length - 1);
    }

    //from Book o(b) ------ b, length of a shorter string
    private static boolean oneEditAway(String first, String second) {

        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isOneOrZeroEditAway("pale", "ple"));
        System.out.println(isOneOrZeroEditAway("pales", "pale"));
        System.out.println(isOneOrZeroEditAway("pale", "bale"));
        System.out.println(isOneOrZeroEditAway("pale", "ale"));

        System.out.println(isOneOrZeroEditAway("pale", "pale"));
        System.out.println(isOneOrZeroEditAway("pale", "blle"));

        System.out.println(isOneOrZeroEditAway("pale", "ble"));
        System.out.println(isOneOrZeroEditAway("pale", "bae"));
        System.out.println(isOneOrZeroEditAway("paless", "pale"));

        System.out.println("-------------------------------------");

        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pale"));
        System.out.println(oneEditAway("pale", "bale"));
        System.out.println(oneEditAway("pale", "ale"));

        System.out.println(oneEditAway("pale", "pale"));
        System.out.println(oneEditAway("pale", "blle"));

        System.out.println(oneEditAway("pale", "ble"));
        System.out.println(oneEditAway("pale", "bae"));
        System.out.println(oneEditAway("paless", "pale"));
    }
}
