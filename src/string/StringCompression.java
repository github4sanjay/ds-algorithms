package string;

/**
 * 1. You are given a string.
 * 2. You have to compress the given string in the following two ways -
 *    First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
 *    For "aaabbccdee", the compressed string will be "abcde".
 *    Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
 *    For "aaabbccdee", the compressed string will be "a3b2c2de2".
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(StringCompression.compression1("wwwwaaadexxxxxx")); // wadex
        System.out.println(StringCompression.compression2("wwwwaaadexxxxxx")); // w4a3dex6
    }

    public static String compression1(String str) {
        var finalString = new StringBuilder();
        Character prev = null;
        for (Character ch : str.toCharArray()){
            if (ch != prev ){
                finalString.append(ch);
                prev = ch;
            }
        }
        return finalString.toString();
    }

    public static String compression2(String str) {
        var finalString = new StringBuilder();
        Character prev = str.charAt(0);
        int counter = 0;
        for (Character ch : str.toCharArray()){
            if ( ch != prev ){
                finalString.append(prev);
                finalString.append(counter);
                counter = 1;
                prev = ch;
            } else {
                counter++;
            }
        }
        finalString.append(prev);
        finalString.append(counter);
        return finalString.toString();
    }
}
