class Solution {
  public int maxNonOverlapping(int[] nums, int target) {
    int sum = 0;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int lastIdx = -1;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - target) && map.get(sum - target) >= lastIdx) {
        count++;
        lastIdx = i;
      }
      map.put(sum, i);
    }
    return count;
  }
}
