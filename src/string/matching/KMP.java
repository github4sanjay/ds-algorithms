package string.matching;

import hashmap.anagram.FindAnagramsMapping;

import java.util.Arrays;

/**
 * Knuth, morris and prat
 */
public class KMP {
    public static void main(String[] args) {
        System.out.println(find("acbacxabcdabdaxabcdacbacdabcy", "acbacdabcy")); // true
        System.out.println(find("bacbabababacaca", "ababaca")); // true
        System.out.println(find("abcbcfgm", "bcfm")); // false
    }

    /**
     * Consider :-
     *
     * string :  a c b a c |x| a b c d a b d a x a b c d a c b a c d a c y
     * pattern : a c b a c |d| a c y
     *
     * when we start matching in brute force approach at x and d the character wont match
     * so instead of putting j back to index 0 and i to i+1, we take the help of prefix and suffix in pattern
     * for example in acbac -> prefix are a, ac, acb and acba
     *                      -> suffix are c, ac, cab, cabc
     *   between suffix and prefix ac match
     *         ___
     *   a c b a c |x| a b c d a b d a x a b c d a c b a c d a b c y
     *   a c b a c |d| a b c y
     *   ---
     *  so we put j to index just after this prefix in pattern and i to index just after suffix in string as we know these
     *  are already equal so no need to compare again
     */
    public static boolean find(String str, String pattern) {
        var prefixTable = getTable(pattern);
        int i=0,j =0;
        while (i<str.length()){
            if (str.charAt(i) == pattern.charAt(j)){
                if (j == pattern.length()-1){
                    return true;
                } else {
                    i++; j++;
                }
            } else if (j > 0){
                j = prefixTable[j - 1];
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     *   How to create prefix table :-
     *
     *    j  i
     *    0  1  2  3  4  5  6  7  8  9        char at i != char j so put 0 in array
     *    a  c  b  a  c  d  a  b  c  y
     *    0
     *
     *    j     i
     *    0  1  2  3  4  5  6  7  8  9
     *    a  c  b  a  c  d  a  b  c  y        char at i != char j so put 0 in array
     *    0  0  0
     *
     *
     *    j        i
     *    0  1  2  3  4  5  6  7  8  9
     *    a  c  b  a  c  d  a  b  c  y        char at i == char j so put j+1 in array
     *    0  0  0  1
     *
     *       j        i
     *    0  1  2  3  4  5  6  7  8  9
     *    a  c  b  a  c  d  a  b  c  y        char at i == char j so put j+1 in array
     *    0  0  0  1  2
     *
     *          j        i
     *    0  1  2  3  4  5  6  7  8  9
     *    a  c  b  a  c  d  a  b  c  y       char at i != char j and j is not at 0
     *    0  0  0  1  2  0                   so at this time look at j-1 in prefix array which 0 put j to 0
     *
     *
     *
     *     j                 i
     *     0  1  2  3  4  5  6  7  8  9
     *     a  c  b  a  c  d  a  b  c  y       char at i == char j so put j+1 in array
     *     0  0  0  1  2  0  1
     *
     *
     *        j                 i
     *     0  1  2  3  4  5  6  7  8  9
     *     a  c  b  a  c  d  a  b  c  y       char at i != char j and j is not at 0
     *     0  0  0  1  2  0  1  0             so at this time look at j-1 in prefix array which 0 put j to 0
     *
     *
     *
     *     j                       i
     *     0  1  2  3  4  5  6  7  8  9
     *     a  c  b  a  c  d  a  b  c  y       char at i != char j so put 0 in array
     *     0  0  0  1  2  0  1  0  0          so at this time look at j-1 in prefix array which 0 put j to 0
     *
     *
     *     j                          i
     *     0  1  2  3  4  5  6  7  8  9
     *     a  c  b  a  c  d  a  b  c  y       char at i != char j so put 0 in array
     *     0  0  0  1  2  0  1  0  0  0
     *
     */
    public static int[] getTable(String pattern){
        int i=1,j=0;
        var prefixTable = new int[pattern.length()];
        while (i < pattern.length()){
            if (pattern.charAt(i) == pattern.charAt(j)){
                prefixTable[i] = j + 1;
                i++; j++;
            } else if (j > 0){
                j = prefixTable[j-1];
            } else {
                prefixTable[i] = 0;
                i++;
            }
        }
        return prefixTable;
    }
}
