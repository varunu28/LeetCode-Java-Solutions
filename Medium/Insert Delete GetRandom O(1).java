class RandomizedSet {

    private final List<Integer> values;
    private final Map<Integer, Integer> valToIndexMap;

    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.valToIndexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valToIndexMap.containsKey(val)) {
            return false;
        }
        values.add(val);
        valToIndexMap.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndexMap.containsKey(val)) {
            return false;
        }
        int valIdx = valToIndexMap.get(val);
        int valAtLastIdx = values.get(values.size() - 1);
        // update index for last element
        values.set(valIdx, valAtLastIdx);
        valToIndexMap.put(valAtLastIdx, valIdx);
        // remove value
        values.remove(values.size() - 1);
        valToIndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = new Random().nextInt(values.size());
        return values.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
