class Solution {
  public int majorityElement(int[] nums) {
    int majorityElement = nums[0];
    int count = 0;
    for (int num : nums) {
      if (count == 0) {
        majorityElement = num;
      }
      count += num == majorityElement ? 1 : -1;
    }
    return majorityElement;
  }   
}
