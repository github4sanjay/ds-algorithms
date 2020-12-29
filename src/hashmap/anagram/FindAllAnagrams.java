package hashmap.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static util.MapUtil.isSame;
import static util.MapUtil.stringToFrequencyMap;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1],
 * write a function search(char pat[], char txt[]) that prints all occurrences of pat[] and its permutations (or anagrams) in txt[].
 * You may assume that n > m.
 * Expected time complexity is O(n)
 *
 * Examples:
 *
 * 1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
 *    Output:   Found at Index 0
 *              Found at Index 5
 *              Found at Index 6
 * 2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
 *    Output:   Found at Index 0
 *              Found at Index 1
 *              Found at Index 4
 */
public class FindAllAnagrams {

    public static void main(String[] args) {
        System.out.println(FindAllAnagrams.find("BACDGABCDA", "ABCD"));
        System.out.println(FindAllAnagrams.find("AAABABAA", "AABA"));
    }

    private static List<Integer> find(String str, String pattern) {
        var listOfStartIndex = new ArrayList<Integer>();
        var patternFreqMap = stringToFrequencyMap(pattern);

        var currentFreqMap = new HashMap<Character, Integer>();
        for (int k=0; k<pattern.length(); k++){ // fill first character of same size aa pattern length
            currentFreqMap.put(str.charAt(k), currentFreqMap.getOrDefault(str.charAt(k), 0)+1);
        }

        int i=pattern.length();
        while (i < str.length()){
            if (isSame(currentFreqMap, patternFreqMap)){
                listOfStartIndex.add(i-pattern.length());
            }

            currentFreqMap.put(str.charAt(i), currentFreqMap.getOrDefault(str.charAt(i), 0)+1); // add new character

            char characterOutOfWindow = str.charAt(i - pattern.length());
            currentFreqMap.put(characterOutOfWindow, currentFreqMap.getOrDefault(characterOutOfWindow, 0)-1); // remove new character
            i++;
        }

        if (isSame(currentFreqMap, patternFreqMap)){ // for last window
            listOfStartIndex.add(i-pattern.length());
        }
        return listOfStartIndex;
    }


}
