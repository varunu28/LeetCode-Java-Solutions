class Solution {
  public int removeDuplicates(int[] nums) {
    int slow = 0;
    int fast = 0;
    int n = nums.length;
    while (fast < n) {
      int currNum = nums[fast];
      int count = 0;
      while (fast < n && currNum == nums[fast]) {
        fast++;
        count++;
      }
      int frequency = Math.min(count, 2);
      while (frequency-- > 0) {
        nums[slow++] = currNum;
      }
    }
    return slow;
  }
}
