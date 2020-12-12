package recurssion;

public class PrintPermutations {
    public static void main(String[] args) {
        /**
         * cba
         * bca
         * cbb
         * bcb
         * bac
         * abc
         */
        PrintPermutations.print("abc", "");
    }

    private static void print(String question, String answer){
        if (question.length() == 0){
            System.out.println(answer);
            return;
        }
        for (int i = 0; i< question.length(); i++){
            String choosenChar = question.substring(i,i+1);
            String rightPart = question.substring(i+1);
            String leftPart = question.substring(0, i);
            print(leftPart + rightPart, choosenChar + answer);
        }
    }
}
