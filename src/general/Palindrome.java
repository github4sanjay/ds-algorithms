package general;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        int mid = str.length()/2;
        for (int i=0; i <=mid; i++){
            if (str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
