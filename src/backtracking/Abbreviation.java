package backtracking;

public class Abbreviation {

    public static void main(String[] args) {
        // Abbreviation.print("ABC");
        // Abbreviation.print("ANKS");

        Abbreviation.printWithoutBinary("ANKS");
    }

    private static void print(String str) {
        print(str, new int[str.length()], str.length());
    }

    private static void print(String str, int[] binary, int n) {
        if (n < 1){
            StringBuilder abbreviation = new StringBuilder();
            int sum = 0;
            for (int i =0;i< binary.length; i++){
                if (binary[i] == 0){
                    if (sum != 0){
                        abbreviation.append(sum);
                    }
                    sum = 0;
                    abbreviation.append(str.charAt(i));
                } else {
                    sum = sum + 1;
                }
            }
            if (sum != 0){
                abbreviation.append(sum);
            }
            System.out.println(abbreviation);
        } else {
            binary[n-1] = 0;
            print(str, binary, n-1);
            binary[n-1] = 1;
            print(str, binary, n-1);
        }
    }

    private static void printWithoutBinary(String str) {
        printWithoutBinary(str, "", 0, 0);
    }

    private static void printWithoutBinary(String question, String answer, int count, int position) {
            if (position == question.length()){
                if (count == 0){
                    System.out.println(answer);
                }else {
                    System.out.println(answer+count);
                }
                return;
            }
            if (count > 0){
                printWithoutBinary(question, answer+count+question.charAt(position), 0, position+1);
            } else {
                printWithoutBinary(question, answer+question.charAt(position), 0, position+1);
            }
            printWithoutBinary(question, answer, count+1, position+1);
    }
}
