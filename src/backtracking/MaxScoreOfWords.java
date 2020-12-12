package backtracking;

/*
Given a list of words, list of  single letters (might be repeating) and score of every character.
Return the maximum score of any valid set of words formed by using the given letters
(words[i] cannot be used two or more times).
It is not necessary to use all characters in letters and each letter can only be used once.
Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.

    Example 1:
    Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
    Output: 23
    Explanation:
    Score  a=1, c=9, d=5, g=3, o=2
    Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
    Words "dad" and "dog" only get a score of 21.

    Example 2:
    Input: words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
    Output: 27
    Explanation:
    Score  a=4, b=4, c=4, x=5, z=10
    Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" (4+5) with a score of 27.
    Word "xxxz" only get a score of 25.

    Example 3:
    Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
    Output: 0
    Explanation:
    Letter "e" can only be used once.
    Constraints:
        1. 1 <= words.length <= 14
        2. 1 <= words[i].length <= 15
        3. 1 <= letters.length <= 100
        4. letters[i].length == 1
        5. score.length == 26
    0 <= score[i] <= 10
    words[i], letters[i] contains only lower case English letters.
*/
public class MaxScoreOfWords {
    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        String[] letters = {"a","a","c","d","d","d","g","o","o"};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println(MaxScoreOfWords.calculate(words, letters, score));
    }

    private static int calculate(String[] words, String[] letters, int[] score) {
        int[] frequencyOfLetters = new int[26];
        for (String letter : letters) {
            char ch = letter.charAt(0);
            frequencyOfLetters[ch - 'a']++;
        }
        return MaxScoreOfWords.calculate(words, frequencyOfLetters, score, 0);
    }

    private static int calculate(String[] words, int[] frequencyOfLetters, int[] score, int index) {
        if (index == words.length){
            return 0;
        }
        int scoreWhenNotIncluded = 0 + calculate(words, frequencyOfLetters, score, index+1);
        int currentWordScore = 0;
        String currentWord = words[index];
        boolean canBeIncluded = true;
        for (int i=0;i<currentWord.length(); i++){
            char ch = currentWord.charAt(i);
            if (frequencyOfLetters[ch - 'a'] == 0){
                canBeIncluded = false;
                // break;
            }
            frequencyOfLetters[ch - 'a']--;
            currentWordScore = currentWordScore + score[ch-'a'];
        }
        int scoreWhenIncluded = 0;
        if (canBeIncluded){
            scoreWhenIncluded = currentWordScore + calculate(words, frequencyOfLetters, score, index+1);
        }
        for (int i=0;i<currentWord.length(); i++){
            char ch = currentWord.charAt(i);
            frequencyOfLetters[ch - 'a']++;
        }
        return Math.max(scoreWhenIncluded, scoreWhenNotIncluded);
    }
}
