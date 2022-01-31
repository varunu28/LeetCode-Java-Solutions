class SparseVector {

  private Map<Integer, Integer> map;

  SparseVector(int[] nums) {
    this.map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        this.map.put(i, nums[i]);
      }
    }
  }

  // Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector vec) {
    return vec.map.size() > this.map.size() ? dotProductHelper(this.map, vec.map)
        : dotProductHelper(vec.map, this.map);
  }

  private int dotProductHelper(Map<Integer, Integer> mapOne, Map<Integer, Integer> mapTwo) {
    int product = 0;
    for (Integer key : mapOne.keySet()) {
      if (mapTwo.containsKey(key)) {
        product += mapOne.get(key) * mapTwo.get(key);
      }
    }
    return product;
  }
}
