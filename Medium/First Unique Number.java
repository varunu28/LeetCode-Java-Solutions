class FirstUnique {
  Map<Integer, Integer> valToCount;
  Map<Integer, Integer> countToVal;
  int count;
  int lowest;
  public FirstUnique(int[] nums) {
    valToCount = new HashMap<>();
    countToVal = new HashMap<>();
    count = 0;
    lowest = 0;
    for (int num : nums) {
      add(num);
    }
  }

  public int showFirstUnique() {
    while (lowest < count && countToVal.get(lowest) == -1) {
      lowest++;
    }
    if (lowest == count) {
      lowest--;
      return -1;
    }
    return countToVal.get(lowest);
  }

  public void add(int value) {
    if (valToCount.containsKey(value)) {
      int idx = valToCount.get(value);
      countToVal.put(idx, -1);
    }
    else {
      valToCount.put(value, count++);
      countToVal.put(valToCount.get(value), value);
    }
  }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
