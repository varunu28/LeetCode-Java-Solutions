class Solution {
  public int minMoves(int[] nums) {
    Arrays.sort(nums);
    int moves = 0;
    for (int i = 1; i < nums.length; i++) {
      int diff = (moves + nums[i]) - nums[i - 1];
      nums[i] += moves;
      moves += diff;
    }
    return moves;
  }
}
