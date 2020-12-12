package recurssion;

public class FirstOccurence {

    public static void main(String[] args) {
        var result = FirstOccurence.find(new int[]{
                3, 4, 5, 6, 5, 6, 8, 9, 2
                //0,1,2,3,  4, 5, 6, 7, 8
        }, 0, 5);
        System.out.println(result);
    }

    private static int find(int[] ints, int currentIndex, int n) {
        if (currentIndex > ints.length) {
            return -1;
        }
        if (ints[currentIndex] == n){
            return currentIndex;
        }
        return find(ints, currentIndex+1, n);
    }
}
