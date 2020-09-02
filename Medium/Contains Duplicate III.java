class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      long num = nums[i];
      Long floor = set.floor(num + t);
      Long ceil = set.ceiling(num - t);
      if ((floor != null && floor >= num) || (ceil != null && ceil <= num)) {
        return true;
      }
      set.add(num);
      if (i >= k) {
        set.remove((long) nums[i - k]);
      }
    }
    return false;
  }
}
