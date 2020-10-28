class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<>();
    int idx = 0;
    while (idx < nums.length) {
      int start = nums[idx++];
      int end = start;
      while (idx < nums.length && (nums[idx] - end) == 1) {
        end = nums[idx++];
      }
      if (start == end) {
        ranges.add(String.valueOf(start));
      } else {
        ranges.add(String.format("%d->%d", start, end));
      }
    }
    return ranges;
  }
}
