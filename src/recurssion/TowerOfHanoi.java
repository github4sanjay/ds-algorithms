package recurssion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }

    private static void towerOfHanoi(int n, char from, char aux, char to) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " +  from + " to rod " + to);
            return;
        }
        towerOfHanoi(n-1,from,to, aux);
        System.out.println("Move disk " + n + " from rod " +  from + " to rod " + to);
        towerOfHanoi(n-1, aux, from, to);
    }
}
