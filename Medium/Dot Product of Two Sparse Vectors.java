class SparseVector {
  
  private Map<Integer, Integer> nonZeroRowMap;

  SparseVector(int[] nums) {
    this.nonZeroRowMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nonZeroRowMap.put(i, nums[i]);
      }
    }
  }

// Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector vec) {
    Map<Integer, Integer> vecNonZeroRowMap = vec.getNonZeroRowMap();
    return this.nonZeroRowMap.size() < vecNonZeroRowMap.size() ? dotProductHelper(this.nonZeroRowMap, vecNonZeroRowMap) : dotProductHelper(vecNonZeroRowMap, this.nonZeroRowMap);
  }
  
  private int dotProductHelper(Map<Integer, Integer> mapOne, Map<Integer, Integer> mapTwo) {
    int product = 0;
    for (Integer key : mapOne.keySet()) {
      product += mapOne.get(key) * mapTwo.getOrDefault(key, 0);
    }
    return product;
  }
  
  public Map<Integer, Integer> getNonZeroRowMap() {
    return new HashMap<>(nonZeroRowMap);
  }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
