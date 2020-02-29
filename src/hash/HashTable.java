package hash;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class HashTable {

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        System.out.println(table.get(6));
    }

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

//        LinkedList<Entry> bucket = getOrCreateBucket(key);
        getOrCreateBucket(key).add(new Entry(key , value));

//        int index = hash(key);
//        if (entries[index] == null)
//            entries[index] = new LinkedList<>();

//        LinkedList<Entry> bucket = entries[index];
//        for (Entry entry : bucket) {
//            if (entry.key == key) {
//                entry.value = value;
//                return;
//            }
//        }

//        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        Entry entry = getEntry(key);

        return (entry == null) ? null : entry.value;

//        if (entry == null)
//            return null;
//        return entry.value;
//        int index = hash(key);
//        LinkedList<Entry> bucket = entries[index];
//        if (bucket != null) {
//            for (Entry entry : bucket)
//                if (entry.key == key)
//                    return entry.value;
//        }
//        return null;
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);

//        int index = hash(key);
//        LinkedList<Entry> bucket = entries[index];
//        if (bucket == null)
//            throw new IllegalStateException();
//        for (Entry entry : bucket) {
//            if (entry.key == key) {
//                bucket.remove(entry);
//                return;
//            }
//        }
//        throw new IllegalStateException();
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<>();

        return bucket;
    }

    private Entry getEntry (int key) {
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }


    private int hash(int key) {
        return key % entries.length;
    }
}
