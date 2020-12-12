package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

    public static void main(String[] args) {

        /**
         *  micro soft hi ring
         *  micro soft hiring
         *  microsoft hi ring
         *  microsoft hiring
         */
        WordBreakProblem.findSentences("microsofthiring",
                new String[]{"micro", "soft", "hi", "ring", "microsoft", "hiring"}
                );


        /**
         *  i like sam sung
         *  i like samsung
         */
        WordBreakProblem.findSentences("ilikesamsung",
                new String[]{ "i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"}
                );
    }

    private static void findSentences(String str, String[] words) {

        var wordSet = new HashSet<>(Arrays.asList(words));
        findSentences(wordSet, str, "");
    }

    private static void findSentences(Set<String> words, String str, String answer) {

        if (str.length() == 0){
            System.out.println(answer);
            return;
        }

        for (int i=0; i< str.length();i++){
            String left = str.substring(0,i+1);
            if (words.contains(left)){
                findSentences(words,  str.substring(i+1),answer+" "+left);
            }
        }
    }
}
