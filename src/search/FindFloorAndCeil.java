package search;

public class FindFloorAndCeil {
    public static void main(String[] args) {
        System.out.println(FindFloorAndCeil.find(new int[]{5, 10, 15, 22, 33, 40, 42, 55}, 25));
        System.out.println(FindFloorAndCeil.find(new int[]{5, 10, 15, 22, 33, 40, 42, 55}, 22));
    }

    public static Pair find(int[] array, int element) {
        var pair = new Pair();
        search(array, element, pair, 0, array.length-1);
        return pair;
    }

    public static void search(int[] array, int element, Pair pair, int low, int high) {
        while (low<=high){
            int mid = (low+high)/2;
            if (element > array[mid]){
                low = mid + 1;
                pair.floor = array[mid];
            } else if (element < array[mid]){
                high = mid - 1;
                pair.ceil = array[mid];
            } else {
                pair.floor = element;
                pair.ceil = element;
                break;
            }
        }
    }

    public static class Pair {
        int floor;
        int ceil;

        public Pair() {
            this.floor = Integer.MIN_VALUE;
            this.ceil = Integer.MIN_VALUE;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "floor=" + floor +
                    ", ceil=" + ceil +
                    '}';
        }
    }
}
