class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> list = new ArrayList<>();
    int idx = 0;
    int n = nums.length;
    while (idx < n) {
      int start = nums[idx];
      int prev = start;
      idx++;
      while (idx < n && nums[idx] - prev == 1) {
        prev = nums[idx];
        idx++;
      }
      list.add(start == prev ? String.valueOf(start) : String.valueOf(start + "->" + prev));
    }
    return list;
  }
}
