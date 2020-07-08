class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
      if (i == 0 || nums[i - 1] != nums[i]) {
        twoSumHelper(nums, i, list);
      }
    }
    return list;
  }
  
  private void twoSumHelper(int[] nums, int i, List<List<Integer>> list) {
    int low = i + 1;
    int high = nums.length - 1;
    while (low < high) {
      int sum = nums[i] + nums[low] + nums[high];
      if (sum < 0 || (low > i + 1 && nums[low] == nums[low - 1])) {
        low++;
      }
      else if (sum > 0 || (high < nums.length - 1 && nums[high] == nums[high + 1])) {
        high--;
      }
      else {
        list.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
      }
    }
  }
}
