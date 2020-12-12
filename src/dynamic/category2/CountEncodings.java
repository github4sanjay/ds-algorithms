package dynamic.category2;

/**
 * 1. You are given a string str of digits. (will never start with a 0)
 * 2. You are required to encode the str as per following rules
 *     1 -> a
 *     2 -> b
 *     3 -> c
 *     ..
 *     25 -> y
 *     26 -> z
 * 3. You are required to calculate and print the count of encodings for the string str.
 *
 *      For 124 -> there are 3 encodings. abc, aw, lc
 *      For 993 -> there is 1 encoding. iic
 *      For 013 -> This is an invalid input. A string starting with 0 will not be passed.
 *      For 103 -> there is 1 encoding. jc
 *      For 303 -> there are 0 encodings. But such a string maybe passed. In this case
 *      print 0.
 */
public class CountEncodings {

    public static void main(String[] args) {
        System.out.println(CountEncodings.count("124"));
    }

    private static int count(String str) {

        char firstCharacter = str.charAt(0);
        if (firstCharacter == '0') return 0;

        int[] dp = new int[str.length()];
        dp[0] = 1; // always one
        for (int i=1; i<str.length(); i++){
            char currentCharacter = str.charAt(i);
            char lastCharacter = str.charAt(i-1);
            int integer = Integer.parseInt(new String(new char[]{lastCharacter, currentCharacter}));
            if (currentCharacter == '0' && lastCharacter == '0'){
                dp[i] = 0;
            } else if (currentCharacter == '0'){
                if (integer > 26){
                    dp[i] = 0;
                } else {
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 1);
                }
            } else if (lastCharacter == '0'){
                dp[i] = dp[i-1];
            } else {
                if (integer > 26){
                    dp[i] = dp[i-1];
                } else {
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 1) + dp[i-1];
                }
            }
        }

        return dp[str.length()-1];
    }
}
