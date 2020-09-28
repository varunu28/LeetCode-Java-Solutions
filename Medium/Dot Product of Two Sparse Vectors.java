class SparseVector {
  Map<Integer, Integer> map;
  int[] nums;
  SparseVector(int[] nums) {
    this.nums = nums;
  }
  
  private Map<Integer, Integer> getMap() {
    if (map != null) {
      return map;
    }
    map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        map.put(i, nums[i]);
      }
    }
    return map;
  }

  // Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector vec) {
    Map<Integer, Integer> vecMap = vec.getMap();
    Map<Integer, Integer> map = getMap();
    return map.size() > vecMap.size() ? helper(vecMap, map) : helper(map, vecMap);
  }
  
  private int helper(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    int val = 0;
    for (Integer key : map1.keySet()) {
      if (map2.containsKey(key)) {
        val += map1.get(key) * map2.get(key);
      }
    }
    return val;
  }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
