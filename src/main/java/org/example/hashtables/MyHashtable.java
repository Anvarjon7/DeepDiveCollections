package org.example.hashtables;

import java.util.LinkedList;

public class MyHashtable<K,V> {
    private class Entry{
        K key;
        V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private LinkedList<Entry>[] buckets;
    private int capacity = 16;

    public MyHashtable() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value){
        int index = getIndex(key);
        for(Entry e : buckets[index]) {
            if (e.key.equals(key)){
                e.value = value;
                return;
            }
        }
        buckets[index].add(new Entry(key,value));
    }

    public V get(K key){
        int index = getIndex(key);
        for (Entry e : buckets[index]){
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }

    public void remove(K key){
        int index = getIndex(key);
        var bucket = buckets[index];
        var iterator = bucket.iterator();
        while (iterator.hasNext()){
            Entry e = iterator.next();
            if (e.key.equals(key)){
                iterator.remove();
                return;
            }
        }
    }

    public void remove(K key, V value){
        int ind = getIndex(key);
        var bucket = buckets[ind];
        var iterator = bucket.iterator();
        while (iterator.hasNext()){
            Entry e = iterator.next();
            if (e.key.equals(key) && e.value.equals(value)){
                iterator.remove();
                return;
            }
        }
    }
}
