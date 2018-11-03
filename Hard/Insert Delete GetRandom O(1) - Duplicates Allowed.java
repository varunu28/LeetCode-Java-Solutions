class RandomizedCollection {

    /** Initialize your data structure here. */
    List<Integer> list;
    Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean returnVal = map.containsKey(val);

        Set<Integer> indexes = returnVal ? map.get(val) : new HashSet<>();
        indexes.add(list.size());
        list.add(val);
        map.put(val, indexes);

        return !returnVal;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Set<Integer> indexes = map.get(val);
        int index = indexes.iterator().next();
        indexes.remove(index);
        
        if (indexes.size() == 0) {
            map.remove(val);
        }

        if (index != list.size()-1) {
            int lastVal = list.get(list.size()-1);
            Set<Integer> lastValIndexes = map.get(lastVal);
            list.set(index, lastVal);
            lastValIndexes.remove(list.size()-1);
            lastValIndexes.add(index);
        }

        list.remove(list.size()-1);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
