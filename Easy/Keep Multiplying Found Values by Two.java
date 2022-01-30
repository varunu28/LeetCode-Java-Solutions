class Solution {
  public int findFinalValue(int[] nums, int original) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    while (set.contains(original)) {
      original *= 2;
    }
    return original;
  }
}
