class Solution {
  public int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int num : nums) {
      if (map.getOrDefault(k - num, 0) > 0) {
        count++;
        map.put(k - num, map.getOrDefault(k - num, 0) - 1);
      } else {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
    }
    return count;
  }
}
