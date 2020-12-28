package string;

/**
 * 1. You are given a string that contains only lowercase and uppercase alphabets.
 * 2. You have to toggle the case of every character of the given string.
 */
public class ToggleCase {

    public static void main(String[] args) {
        System.out.println(ToggleCase.toggle("pepCODinG")); // PEPcodINg
    }

    /**
     * 'p' - 'a' = 'P' - 'A'
     * 'p' = 'P' - 'A' + 'a' and 'P' = 'p' + 'A' - 'a'
     *
     */
    public static String toggle(String s) {
        var toggledString = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch >= 'a' && ch <= 'z'){
                toggledString.append((char) ('A' + ch - 'a'));
            } else {
                toggledString.append((char) ('a' + ch - 'A'));
            }
        }
        return toggledString.toString();
    }
}
