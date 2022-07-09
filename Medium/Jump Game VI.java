class Solution {
  public int maxResult(int[] nums, int k) {
    int[] score = new int[nums.length];
    score[0] = nums[0];
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    queue.add(new int[]{nums[0], 0});
    for (int i = 1; i < nums.length; i++) {
      while (!queue.isEmpty() && queue.peek()[1] < i - k) {
        queue.remove();
      }
      score[i] = score[queue.peek()[1]] + nums[i];
      queue.add(new int[]{score[i], i});
    }
    return score[nums.length - 1];
  }
}
