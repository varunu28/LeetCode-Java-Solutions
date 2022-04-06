class Solution {
  public int threeSumMulti(int[] nums, int target) {
    Arrays.sort(nums);
    long answer = 0;
    for (int i = 0; i < nums.length; i++) {
      int updatedTarget = target - nums[i];
      int startIdx = i + 1;
      int endIdx = nums.length - 1;
      while (startIdx < endIdx) {
        if (nums[startIdx] + nums[endIdx] < updatedTarget) {
          startIdx++;
        } else if (nums[startIdx] + nums[endIdx] > updatedTarget) {
          endIdx--;
        } else if (nums[startIdx] != nums[endIdx]) {
          int leftIdx = 1;
          int rightIdx = 1;
          while (startIdx + 1 < endIdx && nums[startIdx] == nums[startIdx + 1]) {
              leftIdx++;
              startIdx++;
          }
          while (endIdx - 1 > startIdx && nums[endIdx] == nums[endIdx - 1]) {
              rightIdx++;
              endIdx--;
          }

          answer = (answer + leftIdx * rightIdx) % 1000000007;
          startIdx++;
          endIdx--;
        } else {
          answer = (answer + ((endIdx - startIdx + 1) * (endIdx - startIdx) / 2)) % 1000000007;
          break;
        }
      }
    }
    return (int) answer;
  }
}
