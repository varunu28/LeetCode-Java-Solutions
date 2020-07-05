class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int idx = binarySearchHelper(nums, j + 1, nums.length - 1, -1 * (nums[i] + nums[j]));
        if (idx != -1) {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[i]);
          temp.add(nums[j]);
          temp.add(nums[idx]);
          set.add(temp);
        }
      }
    }
    return new ArrayList<>(set);
  }
  
  private int binarySearchHelper(int[] nums, int start, int end, int target) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      else if (nums[mid] > target) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
