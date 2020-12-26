package hashmap.structure;

import java.util.*;

public class HashMap<K,V> {

    private static class HashMapNode<K, V> {
        private K key;
        private V value;

        public HashMapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private List<HashMapNode<K,V>>[] buckets;
    private int size;

    public HashMap() {
        this(4);
        this.size = 0;
    }

    public HashMap(int capacity) {
        this.buckets = init(capacity);
        this.size = 0;
    }

    private List<HashMapNode<K, V>>[] init(int capacity) {
        var buckets = new LinkedList[capacity];
        for (int i=0; i< buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
        return buckets;
    }

    public void put(K key, V value) {
        var bucketIndex = getBucketIndex(key);
        var dataIndex = getDataIndex(key, bucketIndex);
        if (dataIndex != -1) {
            var node = buckets[bucketIndex].get(dataIndex);
            node.setValue(value);
        } else {
            buckets[bucketIndex].add(new HashMapNode<>(key, value));
            size++;
        }

        var loadFactor = size * 1.0 / buckets.length; // make double
        if (loadFactor > 2.0){
            rehash();
        }
    }

    public V get(K key){
        var bucketIndex = getBucketIndex(key);
        var dataIndex = getDataIndex(key, bucketIndex);
        if (dataIndex != -1) {
            var node = buckets[bucketIndex].get(dataIndex);
            return node.getValue();
        } else {
            return null;
        }
    }

    public V remove(K key){
        var bucketIndex = getBucketIndex(key);
        var dataIndex = getDataIndex(key, bucketIndex);
        if (dataIndex != -1) {
            var node = buckets[bucketIndex].remove(dataIndex);
            size--;
            return node.getValue();
        } else {
            return null;
        }
    }

    public boolean containsKey(K key){
        var bucketIndex = getBucketIndex(key);
        var dataIndex = getDataIndex(key, bucketIndex);
        if (dataIndex != -1) {
            return true;
        } else {
            return false;
        }
    }

    public Set<K> keySet(){
        var set = new HashSet<K>();
        for (int i=0; i < buckets.length; i++){
            var list = buckets[i];
            for (var node : list) {
                set.add(node.getKey());
            }
        }
        return set;
    }

    public List<V> values(){
        var set = new ArrayList<V>();
        for (int i=0; i < buckets.length; i++){
            var list = buckets[i];
            for (var node : list) {
                set.add(node.getValue());
            }
        }
        return set;
    }

    private void rehash() {
        int newBucketLength = size*2;
        var old = buckets;
        this.buckets = init(newBucketLength);
        this.size = 0;
        for (var bucket : old){
            for (var node : bucket){
                put(node.key, node.value);
            }
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(getHash(key)) % buckets.length;
    }

    private int getDataIndex(K key, int bucketIndex) {
        var list = buckets[bucketIndex];
        for (int i=0; i< list.size(); i++){
            var node = list.get(i);
            if (node.getKey().equals(key)){
                return i;
            }
        }
        return -1;
    }

    private int getHash(K key) {
        return key.hashCode();
    }
}
