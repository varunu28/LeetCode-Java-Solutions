class RandomizedSet {

  private List<Integer> randomizedSet;
  private Map<Integer, Integer> indexMap;
  private int currSize;
  
  public RandomizedSet() {
    this.randomizedSet = new ArrayList<>();
    this.indexMap = new HashMap<>();
    this.currSize = 0;
  }

  public boolean insert(int val) {
    if (this.indexMap.containsKey(val)) {
      return false;
    }
    this.randomizedSet.add(val);
    this.indexMap.put(val, this.currSize++);
    return true;
  }

  public boolean remove(int val) {
    if (!this.indexMap.containsKey(val)) {
      return false;
    }
    int valIdx = this.indexMap.get(val);
    this.indexMap.put(this.randomizedSet.get(this.currSize - 1), valIdx);
    this.randomizedSet.set(valIdx, this.randomizedSet.get(this.currSize - 1));
    this.randomizedSet.remove(this.currSize - 1);
    this.indexMap.remove(val);
    this.currSize--;
    return true;
  }

  public int getRandom() {
    return this.randomizedSet.get(new Random().nextInt(this.currSize));
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
