package backtracking;

import java.util.HashMap;

public class PalindromicPermutation {

    public static void main(String[] args) {
        String str = "aabbccc";

        /**
         * abcccba
         * acbcbca
         * bacccab
         * bcacacb
         * cabcbac
         * cbacabc
         */
        PalindromicPermutation.execute(str);
    }

    public static void execute(String str) {
        var map = new HashMap<Character, Integer>();
        for (Character ch : str.toCharArray()){
            Integer count = map.get(ch);
            if (count == null){
                map.put(ch, 1);
            } else {
                map.put(ch, count+1);
            }
        }

        Character singleFrequency = null;
        int countSingleFrequency = 0;
        int length = 0;
        for (char ch : map.keySet()){
            int frequency = map.get(ch);
            if (frequency % 2 == 1){
                countSingleFrequency++;
                singleFrequency = ch;
            }
            map.put(ch, frequency/2);
            length+=frequency/2;
        }
        if (countSingleFrequency > 1){
            return;
        }
        execute(1, length, map, singleFrequency, "");
    }

    private static void execute(int index, int length, HashMap<Character, Integer> map,
                                Character singleFrequency, String answer){

        if (index > length){
            String reverse = "";
            for (int i = answer.length() -1; i >=0; i--){
                reverse = reverse + answer.charAt(i);
            }
            if (singleFrequency != null){
                System.out.println(answer + singleFrequency + reverse);
            } else {
                System.out.println(answer + reverse);
            }

            return;
        }
        for (char ch : map.keySet()){
            int frequency = map.get(ch);
            if (frequency > 0){
                map.put(ch, frequency - 1);
                execute(index+1, length, map, singleFrequency, answer+ch);
                map.put(ch, frequency);
            }
        }
    }
}
