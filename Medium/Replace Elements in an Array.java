class Solution {
  public int[] arrayChange(int[] nums, int[][] operations) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      indexMap.put(nums[i], i);
    }
    for (int[] operation : operations) {
      int prevElementIdx = indexMap.get(operation[0]);
      indexMap.put(operation[1], prevElementIdx);
      nums[prevElementIdx] = operation[1];
    }
    return nums;
  }
}
