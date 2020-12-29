package backtracking;

import util.MapUtil;

import java.util.*;

public class StringPermutation {

    public static void main(String[] args) {
        System.out.println(StringPermutation.findWithCombination("aabb")); // [aabb, abab, abba, baab, baba, bbaa]
        System.out.println(StringPermutation.findWithPermutation("aabb")); // [aabb, abab, abba, baab, baba, bbaa]
    }

    public static List<String> findWithCombination(String str) {

        var hashmap = MapUtil.stringToFrequencyMap(str);
        var list = new ArrayList<String>();
        findWithCombination(hashmap, str.length(), 1, "", list);
        return list;
    }

    // here box decides which character to choose
    private static void findWithCombination(Map<Character, Integer> frequencyMap, int totalBox, int currentBox, String ans, List<String> list) {
        if (currentBox > totalBox){
            list.add(ans);
            return;
        }
        for (char ch : frequencyMap.keySet()){
            int frequency = frequencyMap.get(ch);
            if (frequency > 0){
                frequencyMap.put(ch, frequency-1);
                findWithCombination(frequencyMap, totalBox, currentBox+1, ans+ch, list);
                frequencyMap.put(ch, frequency);
            }
        }
    }

    public static List<String> findWithPermutation(String str) {

        var lastOccurredAt = new HashMap<Character, Integer>();
        for (char ch : str.toCharArray()) {
            lastOccurredAt.put(ch, -1);
        }
        var list = new ArrayList<String>();
        findWithPermutation(str, lastOccurredAt, 0, new Character[str.length()], list);
        return list;
    }

    // here character decides which box to choose
    private static void findWithPermutation(String str, HashMap<Character, Integer> lastOccurredAt, int currentCharacterPosition, Character[] filledBox, List<String> list) {
        if (currentCharacterPosition == filledBox.length){
            var permutation = new StringBuilder();
            for (char box : filledBox) {
                permutation.append(box);
            }
            list.add(permutation.toString());
            return;
        }

        char currentCharacter = str.charAt(currentCharacterPosition);
        int lastOccurredAtPos = lastOccurredAt.get(currentCharacter);
        for (int i=lastOccurredAtPos+1; i< str.length(); i++){
            if (filledBox[i] == null){
                filledBox[i] = currentCharacter;
                lastOccurredAt.put(currentCharacter, i);
                findWithPermutation(str, lastOccurredAt, currentCharacterPosition + 1, filledBox, list);
                lastOccurredAt.put(currentCharacter, -1);
                filledBox[i] = null;
            }
        }
    }
}
