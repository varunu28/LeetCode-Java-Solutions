class Solution {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> ranges = new ArrayList<>();
    long currLower = (long) lower;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < currLower) {
        continue;
      }
      if (nums[i] == currLower) {
        currLower++;
        continue;
      }
      ranges.add(getRange(currLower, ((long) nums[i] - 1)));
      currLower = ((long) nums[i]) + 1;
    }
    if (currLower <= upper) {
      ranges.add(getRange(currLower, (long) upper));
    }
    return ranges;
  }
  
  private String getRange(long down, long up) {
    return down == up ? String.valueOf(up) : down + "->" + up;
  }
}
