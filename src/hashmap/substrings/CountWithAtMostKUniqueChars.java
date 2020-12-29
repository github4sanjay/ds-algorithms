package hashmap.substrings;

import java.util.HashMap;

/**
 * 1. You are given a string(str) and a number K.
 * 2. You have to find the count of substrings of the given string that contains at most K unique characters.
 *
 * Sample Input
 * aabcbcdbca
 * 2
 *
 * Sample Output
 * 23
 */
public class CountWithAtMostKUniqueChars {

    public static void main(String[] args) {
        System.out.println(CountWithAtMostKUniqueChars.find("aabcbcdbca", 2)); // 23
        System.out.println(CountWithAtMostKUniqueChars.find("aabcbcdbcaaaaaabbbbb", 2)); // 11
        System.out.println(CountWithAtMostKUniqueChars.find("aabcbcdbcaaaaaabbbbb", 4)); // 20
    }

    private static int find(String str, int k) {
        var hasMap = new HashMap<Character, Integer>();
        int count = 0;
        int i=0, j=-1;
        while (i < str.length()){
            hasMap.put(str.charAt(i), hasMap.getOrDefault(str.charAt(i), 0)+1);
            while (hasMap.size() > k){
                j++;
                var charAtJ = str.charAt(j);
                var frequency = hasMap.getOrDefault(charAtJ, 0);
                if (frequency == 1){
                    hasMap.remove(charAtJ);
                } else {
                    hasMap.put(charAtJ, frequency-1);
                }
            }

            count = count + i-j;
            i++;
        }
        return count;
    }
}
