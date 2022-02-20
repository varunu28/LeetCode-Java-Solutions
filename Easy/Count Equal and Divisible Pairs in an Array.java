class Solution {
  public int countPairs(int[] nums, int k) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.computeIfAbsent(nums[i], j -> new ArrayList<>()).add(i);
    }
    int numOfPairs = 0;
    for (List<Integer> indices : map.values()) {
      for (int i = 0; i < indices.size(); i++) {
        for (int j = 0; j < i; j++) {
          if (indices.get(i) * indices.get(j) % k == 0) {
            numOfPairs++;
          }
        }
      }
    }
    return numOfPairs;
  }
}
