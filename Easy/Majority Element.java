class Solution {
  public int majorityElement(int[] nums) {
    int count = 0;
    Integer candidate = null;
    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += num == candidate ? 1 : -1;
    }
    return candidate;
  }
}
