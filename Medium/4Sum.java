class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int newTarget = target - nums[i] - nums[j];
        int start = j + 1;
        int end = nums.length - 1;
        while (start < end) {
          if ((nums[start] + nums[end]) == newTarget) {
            set.add(Arrays.asList(nums[i], nums[j], nums[start++], nums[end--]));
          }
          else if ((nums[start] + nums[end]) < newTarget) {
            start++;
          }
          else {
            end--;
          }
        }
      }
    }
    return new ArrayList<>(set);
  }
}
