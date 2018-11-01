class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> list;
    int lastIndex;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        lastIndex = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, lastIndex);
        lastIndex++;

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        map.put(list.get(lastIndex-1), map.get(val));
        swap(map.get(val), lastIndex-1);
        list.remove(lastIndex-1);
        map.remove(val);
        lastIndex--;

        return true;
    }

    private void swap(int id1, int id2) {
        int temp = list.get(id1);
        list.set(id1, list.get(id2));
        list.set(id2, temp);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt(((lastIndex-1) - 0) + 1) + 0;
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
