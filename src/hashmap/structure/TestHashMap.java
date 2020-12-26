package hashmap.structure;

public class TestHashMap {

    public static void main(String[] args) {
        var map = new HashMap<Integer, Integer>(2);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);

        System.out.println(map.containsKey(4)); // true
        map.remove(4);
        System.out.println(map.containsKey(4)); // false
        System.out.println(map.keySet()); // [1, 2, 3]
        System.out.println(map.values()); // [1, 2, 3]
    }
}
