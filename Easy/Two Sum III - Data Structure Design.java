class TwoSum {

  /** Initialize your data structure here. */
  Map<Integer, Integer> map;
  public TwoSum() {
    map = new HashMap<>();
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    map.put(number, map.getOrDefault(number, 0) + 1);
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    for (Integer key : map.keySet()) {
      if (map.containsKey(value - key)) {
        if (value - key != key || (value - key == key && map.get(key) > 1)) {
          return true;
        }
      }
    }
    return false;
  }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
