class Solution {
  public int[] findErrorNums(int[] nums) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }
    int[] ans = new int[2];
    for (int idx = 1; idx <= nums.length; idx++) {
      if (!frequency.containsKey(idx)) {
        ans[1] = idx;
      } else if (frequency.get(idx) > 1) {
        ans[0] = idx;
      }
    }
    return ans;
  }
}
