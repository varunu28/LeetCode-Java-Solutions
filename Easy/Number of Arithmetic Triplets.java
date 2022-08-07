class Solution {
  public int arithmeticTriplets(int[] nums, int diff) {
    int count = 0;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num - diff) && set.contains(num - 2 * diff)) {
        count++;
      }
      set.add(num);
    }
    return count;
  }
}
