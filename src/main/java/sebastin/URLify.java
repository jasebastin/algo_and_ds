package sebastin;

/**
 * Created by sebastin on 8/9/17.
 *
 * replace space with %20 with the given space. Assume that it has enough space to replace the spaces. ex: "Mr Dannijo Sebastin" realSpace 19
 */
public class URLify {

    // o(n) -- from book
    private static String urlify(String s1, int realSpace) {

        char[] chars = s1.toCharArray();
        int spaceCount=0, index, i = 0;

        //space count
        for(i=0; i < realSpace; i++) {
            if(chars[i] == ' ') {
                spaceCount++;
            }
        }

        //index - length chars + spaces
        index = realSpace + spaceCount * 2;

        if (realSpace < chars.length) {
            chars[realSpace] = '\0';
        }
        
        for(i = realSpace-1; i >=0; i--) {
            if(chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index = index - 3;
            } else {
                chars[index - 1] = chars[i];
                index--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {

        System.out.println(urlify("Mr Dannijo Sebastin    ", 19));
        System.out.println(urlify("Say Hello Mohan Kumar      ", 21));
    }
}
