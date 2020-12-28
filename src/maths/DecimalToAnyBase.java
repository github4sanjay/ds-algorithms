package maths;

import java.util.ArrayList;

public class DecimalToAnyBase {

    public static void main(String[] args) {
        System.out.println(DecimalToAnyBase.find(57, 2));
    }

    public static int find(int decimal, int base) {
        int dividend = decimal;
        var remainders = new ArrayList<Integer>();
        while (dividend > 0){
            int quotient = dividend/base;
            remainders.add(dividend % base);
            dividend = quotient;
        }
        int sum =0;
        for (int i=remainders.size()-1; i>=0; i--){
            int h = 1;
            for (int k=0;k<i; k++){
                h = h*10;
            }
            sum = sum + remainders.get(i)*h;
        }
        return sum;
    }
}
