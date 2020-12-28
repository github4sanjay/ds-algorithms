package array;

public class FindElementInArray {

    public static void main(String[] args) {
        System.out.println(FindElementInArray.find(new int[]{15, 30, 40, 4, 11, 9}, 40));
    }

    public static int find(int[] array, int element) {
        for (int i=0; i < array.length; i++){
            if (array[i] == element){
                return i;
            }
        }
        return -1;
    }
}
