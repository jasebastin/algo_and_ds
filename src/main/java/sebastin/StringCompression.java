package sebastin;

/**
 * Created by sebastin on 8/14/17.
 * <p>
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    // o(n) -- string concat is n2? 
    private static String getCompressedString(String s1) {

        String compressed = "";
        char temp = ' ';
        for (char c : s1.toCharArray()) {
            int repeated = 1;
            if (temp == c) {
                repeated++;
                compressed = compressed.substring(0, compressed.length() - 1);
                compressed = compressed.concat(String.valueOf(repeated));
            } else {
                temp = c;
                compressed = compressed.concat(String.valueOf(c)).concat(String.valueOf(repeated));
            }
        }

        return compressed;
    }


    public static void main(String[] args) {

        System.out.println(getCompressedString("sseebbaa"));
        System.out.println(getCompressedString("saa"));
        System.out.println(getCompressedString("ssbaa"));

        System.out.println("-------------");

    }
}
