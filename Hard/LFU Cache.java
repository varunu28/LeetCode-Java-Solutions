class LFUCache {

    private Map<Integer, Integer> valMap;
    private Map<Integer, Integer> freqMap;
    private Map<Integer, LinkedHashSet<Integer>> freqCountMap;
    private int capacity;
    private int minValue;

    public LFUCache(int capacity) {
        valMap = new HashMap<>();
        freqMap = new HashMap<>();
        freqCountMap = new HashMap<>();
        this.capacity = capacity;
        minValue = 0;
    }

    public int get(int key) {
        if (!valMap.containsKey(key)) {
            return -1;
        }

        // Updating frequency
        int oldFreq = freqMap.get(key);
        freqMap.put(key, oldFreq + 1);
        int newFreq = freqMap.get(key);

        // Removing from old frequency set
        LinkedHashSet<Integer> set = freqCountMap.get(oldFreq);
        set.remove(key);
        if (set.isEmpty()) {
            // As this was the only key with min freq so minimum frequency should be updated
            if (minValue == oldFreq) {
                minValue = oldFreq + 1;
            }
            freqCountMap.remove(oldFreq);
        }
        else {
            freqCountMap.put(oldFreq, set);
        }

        // Updating new frequency set
        freqCountMap.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(key);

        return valMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        if (get(key) != -1) {
            valMap.put(key, value);
            return;
        }

        if (valMap.size() == capacity) {
            LinkedHashSet<Integer> set = freqCountMap.get(minValue);
            int keyToBeDeleted = set.iterator().next();
            valMap.remove(keyToBeDeleted);
            freqMap.remove(keyToBeDeleted);
            set.remove(keyToBeDeleted);

            if (set.isEmpty()) {
                freqCountMap.remove(minValue);
            }
        }

        valMap.put(key, value);
        freqMap.put(key, 1);
        freqCountMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minValue = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
