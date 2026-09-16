import java.util.*;

class LFUCache {

    int capacity;
    int minFreq;

    HashMap<Integer, Integer> values;
    HashMap<Integer, Integer> freq;
    HashMap<Integer, LinkedHashSet<Integer>> groups;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.minFreq = 0;

        values = new HashMap<>();
        freq = new HashMap<>();
        groups = new HashMap<>();
    }

    public int get(int key) {

        if (!values.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);

        return values.get(key);
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (values.containsKey(key)) {

            values.put(key, value);

            increaseFreq(key);

            return;
        }

        // Cache is full
        if (values.size() == capacity) {

            LinkedHashSet<Integer> set = groups.get(minFreq);

            int removeKey = set.iterator().next();

            set.remove(removeKey);

            values.remove(removeKey);
            freq.remove(removeKey);
        }

        // Add new key
        values.put(key, value);
        freq.put(key, 1);

        groups.putIfAbsent(1, new LinkedHashSet<>());
        groups.get(1).add(key);

        minFreq = 1;
    }

    private void increaseFreq(int key) {

        int oldFreq = freq.get(key);
        int newFreq = oldFreq + 1;

        freq.put(key, newFreq);

        // Remove from old frequency group
        groups.get(oldFreq).remove(key);

        // If old group becomes empty
        if (groups.get(oldFreq).isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }

        // Add to new frequency group
        groups.putIfAbsent(newFreq, new LinkedHashSet<>());
        groups.get(newFreq).add(key);
    }
}