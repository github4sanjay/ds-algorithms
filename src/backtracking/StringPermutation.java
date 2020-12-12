package backtracking;

import java.util.Arrays;
import java.util.HashMap;

public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation.find("aabb");
    }

    public static void find(String str) {

        /*var hashmap = new HashMap<Character, Integer>();
        for (char ch : str.toCharArray()) {
            hashmap.merge(ch, 1, Integer::sum);
        }

        findWithPermutation(hashmap, str.length(), 1, "");*/


        var lastOccurredAt = new HashMap<Character, Integer>();
        for (char ch : str.toCharArray()) {
            lastOccurredAt.put(ch, -1);
        }

        findWithCombination(str, lastOccurredAt, 0, new Character[str.length()]);
    }

    // with combination
    private static void findWithPermutation(HashMap<Character, Integer> frequencyMap, int totalBox, int currentBox, String ans) {
        if (currentBox > totalBox){
            System.out.println(ans);
            return;
        }
        for (char ch : frequencyMap.keySet()){
            int frequency = frequencyMap.get(ch);
            if (frequency > 0){
                frequencyMap.put(ch, frequency-1);
                findWithPermutation(frequencyMap, totalBox, currentBox+1, ans+ch);
                frequencyMap.put(ch, frequency);
            }
        }
    }

    // with permutation
    private static void findWithCombination(String str, HashMap<Character, Integer> lastOccurredAt, int currentCharacterPosition, Character[] filledBox) {
        if (currentCharacterPosition == filledBox.length){
            System.out.println(Arrays.toString(filledBox));
            return;
        }

        char currentCharacter = str.charAt(currentCharacterPosition);
        int lastOccurredAtPos = lastOccurredAt.get(currentCharacter);
        for (int i=lastOccurredAtPos+1; i< str.length(); i++){
            if (filledBox[i] == null){
                filledBox[i] = currentCharacter;
                lastOccurredAt.put(currentCharacter, i);
                findWithCombination(str, lastOccurredAt, currentCharacterPosition + 1, filledBox);
                lastOccurredAt.put(currentCharacter, -1);
                filledBox[i] = null;
            }
        }
    }
}
