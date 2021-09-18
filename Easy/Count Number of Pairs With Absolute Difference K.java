class Solution {
  public int countKDifference(int[] nums, int k) {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      count += map.getOrDefault(num + k, 0);
      count += map.getOrDefault(num - k, 0);
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    return count;
  }
}
