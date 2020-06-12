class Solution {
  public boolean checkPossibility(int[] nums) {
    Integer probIdx = null;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        if (probIdx != null) {
          return false;
        }
        probIdx = i;
      }
    }
    return (
      probIdx == null || 
      probIdx == 0 || 
      probIdx == (nums.length - 2) || 
      nums[probIdx - 1] <= nums[probIdx + 1] ||
      nums[probIdx] <= nums[probIdx + 2]
    );
  }
}
