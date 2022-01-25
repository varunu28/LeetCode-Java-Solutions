class Solution {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> ranges = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < lower) {
        continue;
      }
      if (nums[i] == lower) {
        lower++;
        continue;
      }
      ranges.add(getRange(lower, ( nums[i] - 1)));
      lower = nums[i] + 1;
    }
    if (lower <= upper) {
      ranges.add(getRange(lower, upper));
    }
    return ranges;
  }
  
  private String getRange(int down, int up) {
    return down == up ? String.valueOf(up) : down + "->" + up;
  }
}
