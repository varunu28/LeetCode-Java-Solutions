class Solution {
  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, Integer> left = new HashMap<>();
    Map<Integer, Integer> right = new HashMap<>();
    int degree = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (!left.containsKey(num)) {
        left.put(num, i);
      }
      right.put(num, i);
      count.put(num, count.getOrDefault(num, 0) + 1);
      degree = Math.max(degree, count.get(num));
    }
    int ans = nums.length;
    for (int key : count.keySet()) {
      if (count.get(key) == degree) {
        ans = Math.min(ans, right.get(key) - left.get(key) + 1);
      }
    }
    return ans;
  }
}
