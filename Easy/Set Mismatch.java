class Solution {
  public int[] findErrorNums(int[] nums) {
    int[] result = new int[2];
    Set<Integer> set = new HashSet<>();
    int n = nums.length;
    for (int num : nums) {
      if (!set.add(num)) {
        result[0] = num;
      }
    }
    for (int i = 1; i <= n; i++) {
      if (!set.contains(i)) {
        result[1] = i;
      }
    }
    return result;
  }
}
