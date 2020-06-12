class RandomizedSet {

  /** Initialize your data structure here. */
  Map<Integer, Integer> map;
  List<Integer> list;
  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }
    list.add(val);
    map.put(val, list.size() - 1);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }
    int idx = map.get(val);
    int lastIdx = list.size() - 1;
    list.set(idx, list.get(lastIdx));
    map.put(list.get(lastIdx), idx);
    map.remove(val);
    list.remove(lastIdx);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int idx = new Random().nextInt(list.size());
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
