class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      int rem = currSum % k;
      if (map.containsKey(rem)) {
        if (i - map.get(rem) >= 2) {
          return true;
        }
      } else {
        map.put(rem, i);
      }
    }
    return false;
  }
}
