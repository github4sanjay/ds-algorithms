package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * if a1 -> 1 1 2 2 2 3 5
 * and a2 -> 1 1 1 2 2 4 5
 * intersection is -> 1 1 2 2 5
 *
 * Note -> Don't assume the arrays to be sorted.
 */
public class GetCommonElements2 {

    public static void main(String[] args) {
        System.out.println(GetCommonElements2.get(new int[]{1, 1, 2, 2, 2, 3, 5}, new int[]{1, 1, 1, 2, 2, 4, 5}));
    }

    private static List<Integer> get(int[] array1, int[] array2) {
        var map = new HashMap<Integer, Integer>();
        for (int i : array1){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }

        }
        var list = new ArrayList<Integer>();
        for (int i : array2){
            var frequency = map.get(i);
            if (frequency != null && frequency > 0){
                list.add(i);
                map.put(i, frequency-1);
            }
        }
        return list;
    }
}
