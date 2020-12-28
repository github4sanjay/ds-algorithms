package maths;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(PrimeNumber.isPrime(11));
        System.out.println(PrimeNumber.isPrime(17));
        System.out.println(PrimeNumber.isPrime(12));
    }

    public static boolean isPrime(int val){
        for (int div=2; div*div<=val; div++){
            if (val % div == 0){
                return false;
            }
        }
        return true;
    }
}
