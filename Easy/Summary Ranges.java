class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    int idx = 0;
    int n = nums.length;
    while (idx < n) {
      int start = nums[idx];
      int end = start;
      idx++;
      while (idx < n && nums[idx] == end + 1) {
        end = nums[idx];
        idx++;
      }
      result.add(start == end ? String.valueOf(start) : (start + "->" + end));
    }
    return result;
  }
}
