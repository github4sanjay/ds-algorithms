package hashmap.anagram;

import util.MapUtil;

/**
 * 1. You are given two strings s1 and s2.
 * 2. You have to determine if s2 is an anagram of s1.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(ValidAnagram.find("pepcoding", "codingpep"));
        System.out.println(ValidAnagram.find("pepcodingt", "codingpeps"));
    }

    private static boolean find(String str1, String str2) {
        var map = MapUtil.stringToFrequencyMap(str1);
        for (char ch : str2.toCharArray()){
            if (!map.containsKey(ch)) return false;
            var frequency = map.get(ch);
            if (frequency == 1){
                map.remove(ch);
            } else {
                map.put(ch, frequency-1);
            }
        }
        return map.size() == 0;
    }
}
