class Solution {
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    return countHelper(nums, right) - countHelper(nums, left - 1);
  } 
  
  private int countHelper(int[] nums, int bound) {
    int count = 0;
    int curr = 0;
    for (int num : nums) {
      curr = num <= bound ? curr + 1 : 0;
      count += curr;
    }
    return count;
  }
}
