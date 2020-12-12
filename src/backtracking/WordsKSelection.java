package backtracking;

import java.util.HashSet;

public class WordsKSelection {

    public static void main(String[] args) {
        WordsKSelection.find("aabbbccdde", 4);
    }

    private static void find(String str, int k) {

        var alreadyUsed = new HashSet<Character>();
        var unique = "";
        for (char ch : str.toCharArray()) {
            if (!alreadyUsed.contains(ch)){
                alreadyUsed.add(ch);
                unique = unique + ch;
            }

        }
        // find(unique, k, 0, 0, "");
        findAsPermutation(unique, k, 1, "", -1);
    }

    // combination
    private static void find(String str, int k, int currentItemIndex, int placedSoFar, String answer) {

        if (currentItemIndex == str.length()){
            if (placedSoFar == k){
                System.out.println(answer);
            }
            return;
        }

        find(str, k, currentItemIndex+1, placedSoFar, answer);

        char currentCharacter = str.charAt(currentItemIndex);
        find(str, k, currentItemIndex+1, placedSoFar+1, answer+currentCharacter);
    }

    // permutation
    private static void findAsPermutation(String str, int k, int currentSelection, String answer, int lastOccurredAt) {

        if (currentSelection > k){
            System.out.println(answer);
            return;
        }

        for (int i=lastOccurredAt+1; i < str.length(); i++){
            char currentCharacter = str.charAt(i);
            findAsPermutation(str, k, currentSelection+1, answer+currentCharacter, i);
        }
    }
}
