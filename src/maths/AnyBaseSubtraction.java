package maths;

import java.util.ArrayList;

public class AnyBaseSubtraction {

    public static void main(String[] args) {
        System.out.println(AnyBaseSubtraction.subtract(8, 1, 100));  // 77
    }

    private static int subtract(int base, int n1, int n2) {
        int dividend1 = n1;
        int dividend2 = n2;
        int carry = 0;

        var list = new ArrayList<Integer>();

        while (dividend2 > 0){
            int quotient1 = dividend1 / 10;
            int remainder1 = dividend1 % 10;

            int quotient2 = dividend2 / 10;
            int remainder2 = dividend2 % 10;

            remainder2 = remainder2 + carry;

            int digitSub = 0;
            if (remainder2 >= remainder1){
                carry = 0;
                digitSub = remainder2 - remainder1;
            } else {
                carry = -1;
                digitSub = remainder2 + base - remainder1;
            }

            list.add(digitSub);
            dividend1 = quotient1;
            dividend2 = quotient2;
        }

        return GetNumberFromList.getNumberFromList(list);
    }
}
