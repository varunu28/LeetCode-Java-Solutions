class Solution {
  public int findPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (k == 0) {
        if (entry.getValue() >= 2) {
          count++;
        }
      } else {
        if (map.containsKey(entry.getKey() + k)) {
          count++;
        }
      }
    }
    return count;
  }
}
