package backtracking;

import util.AlgoUtil;

public class MaxNumberAfterKSwaps {

    private static String MAX = String.valueOf(Integer.MIN_VALUE);
    public static void main(String[] args) {
        MaxNumberAfterKSwaps.find("129814999", 4); // 999984211
        System.out.println(MAX);
    }

    private static void find(String number, int k) {

        if (k == 0){
            return;
        }

        for (int i=0; i < number.length()-1; i++){
            for (int j=i+1; j < number.length(); j++){
                if (number.charAt(j) > number.charAt(i)){
                    number = AlgoUtil.swap(i,j, number);
                    if (Integer.parseInt(number) > Integer.parseInt(MAX)){
                        MAX = number;
                    }
                    find(number, k-1);
                    number = AlgoUtil.swap(i,j, number);
                }
            }
        }
    }
}
