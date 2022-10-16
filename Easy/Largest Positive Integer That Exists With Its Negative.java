class Solution {
  public int findMaxK(int[] nums) {
    int largestNumber = -1;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(-1 * num)) {
        largestNumber = Math.max(Math.abs(num), largestNumber);
      }
      set.add(num);
    }
    return largestNumber;
  }
}
