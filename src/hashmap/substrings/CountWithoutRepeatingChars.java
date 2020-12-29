package hashmap.substrings;

import java.util.HashMap;

/**
 * Given a string str consisting of lowercase alphabets, the task is to find the number of possible substrings (not necessarily distinct)
 * that consists of distinct characters only.
 * Examples:
 *
 * Input: Str = “gffg”
 * Output: 6
 * Explanation:
 * All possible substrings from the given string are,
 * ( “g“, “gf“, “gff”, “gffg”, “f“, “ff”, “ffg”, “f“, “fg“, “g” )
 * Among them, the highlighted ones consists of distinct characters only.
 *
 * Input: str = “gfg”
 * Output: 5
 * Explanation:
 * All possible substrings from the given string are,
 * ( “g“, “gf“, “gfg”, “f“, “fg“, “g” )
 * Among them, the highlighted consists of distinct characters only.
 */
public class CountWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(find("gffg"));
        System.out.println(find("gfg"));
        System.out.println(find("aabcbcdbca"));
        System.out.println(find("BBBB"));
    }

    public static int find(String str) {
        var map = new HashMap<Character, Integer>(); // character and its last index
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < str.length()){
            var currentChar = str.charAt(i);
            if (!map.containsKey(currentChar)){ ;
                map.put(currentChar, i);
            } else {
                while (str.charAt(j) != currentChar){
                    map.remove(str.charAt(j));
                    j++;
                }
                map.put(currentChar, i);
                j++;
            }
            count = count + i-j+1; // number substring would be equal to length of string at that time
            i++;
        }
        return count;
    }
}
