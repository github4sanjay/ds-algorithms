package hashmap.substrings;

import java.util.HashMap;

public class LongestWithExactlyKUniqueChars {

    public static void main(String[] args) {
        System.out.println(find("aabcbcdbca", 2)); // 4
        System.out.println(find("aabbcc", 1)); //  2
        System.out.println(find("aabbcc", 2)); // 4
        System.out.println(find("aabbcc", 3)); // 6
        System.out.println(find("aaabbb", 3)); // error
    }

    public static int find(String str, int k) {

        var map = new HashMap<Character, Integer>(); // character and last index
        int i = 0, j = 0;
        int maxLength = Integer.MIN_VALUE;
        while (i < str.length()){
            var currentCharacter = str.charAt(i);
            if (!map.containsKey(currentCharacter) && map.size() == k){
                char chatAtJ = str.charAt(j);
                j = map.get(chatAtJ) + 1; // put j to next of last index
                map.remove(chatAtJ);
            }
            map.put(currentCharacter, i);
            i++;
            if (map.size() == k){
                maxLength = Math.max(maxLength, i-j);
            }
        }
        return maxLength;
    }
}
