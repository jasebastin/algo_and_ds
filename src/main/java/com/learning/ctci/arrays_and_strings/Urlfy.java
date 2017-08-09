package com.learning.ctci.arrays_and_strings;

/**
 * Created by veeramuthum on 7/25/17.
 */
public class Urlfy {

    private void pushValues(char[] arr) {


    }

    public static void urlfy(char[] url, int urlRealLen) {

        if (url == null)
            return;

        int urlLen = url.length;
        int spaceCount = 0;
        for (int i = 0; i < urlLen; i++)
            if (url[i] == ' ')
                spaceCount++;

        int extraCharsToRepSpace = spaceCount * 3;
        int arrLen = urlLen - spaceCount + extraCharsToRepSpace;

        System.out.println("urlRealLen=" + urlRealLen);
        System.out.println("urlLen=" + urlLen);
        System.out.println("spaceCount=" + spaceCount);
        System.out.println("extraCharsToRepSpace=" + extraCharsToRepSpace);
        System.out.println("arrLen=" + arrLen);

        char temp1 = '\0';
        char temp2 = '\0';

        for (int i = 0; i < urlLen; ) {

            char currChar = url[i];

            System.out.println("------------------------------------");
            System.out.println("url["+i+"]=" + url[i]);
            System.out.println("temp1=" + temp1);
            System.out.println("temp2=" + temp2);
            System.out.println("Before: url = " + new String(url));
            //System.out.println("Before: url[" + i + "] = " + url[i]);

            int incrementCount = 0;

            if (temp1 != '\0') {
                char temp3 = url[i];
                url[i] = temp1;
                temp1 = temp3;
                i++;
                incrementCount++;
            }

            if ( (temp2 != '\0') && (i + 1 < urlLen) ) {
                    char temp4 = url[i + 1];
                    url[i + 1] = temp2;
                    temp2 = temp4;
                    i++;
                    incrementCount++;
            }

            //System.out.println("After: url[" + i + "] = " + url[i]);

            System.out.println("after temp1 = " + temp1);
            System.out.println("after temp2 = " + temp2);
            System.out.println("after uel = " + new String(url));
            if (currChar == ' ') {

                url[i] = '%';

                if (i + 1 < urlLen) {
                    temp1 = url[i + 1];
                }

                url[i + 1] = '2';

                if (i + 2 < urlLen) {
                    temp2 = url[i + 2];
                }

                url[i + 2] = '0';
                //System.out.println("url["+i+"+2] = " + url[i+2]);


                incrementCount = incrementCount + 3;
                i=i+3;
            }

            if(incrementCount == 0)
                i++;

            //    incrementCount++;
            //i = i + incrementCount;

            System.out.println("After: url = " + new String(url));
            System.out.println();

        }
    }


    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
                }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length)
            str[trueLength] = '\0';

        for (i = trueLength - 1; i >= 0; i-- ) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                 index = index - 3;
                 } else {
                 str[index - 1] = str[i];
                 index--;
                 }
             }
         }


    public static void replaceSpaces2(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length)
            str[trueLength] = '\0';

        for (i = trueLength - 1; i >= 0; i-- ) {


            System.out.println("Before: " + new String(str));
            System.out.println(str[i]);

            if (str[i] == ' ') {
                System.out.println("This is a space");
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }


            System.out.println("After: " + new String(str));
            System.out.println("----------------------");

        }
    }


    public static void main(String args[]) {

        char[] url = ("Mr John Smith    ").toCharArray();
        //char[] url = ("Mr John").toCharArray();

        System.out.println(new String(url));

        replaceSpaces2(url, 13);
        //urlfy(url, 17);

        System.out.println(new String(url));

    }
}
