package backtracking;

public class JosephusCircle {
    public static void main(String[] args) {
        System.out.println(JosephusCircle.find(14, 2));
    }

    private static int find(int n, int k) {
        if (n == 1) return 0;
        int survivor = find(n-1, k);
        return (survivor+k)%n;
    }
}
