class Solution {
  public int[] sortEvenOdd(int[] nums) {
    PriorityQueue<Integer> oddIndices = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> evenIndices = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        evenIndices.add(nums[i]);
      } else {
        oddIndices.add(nums[i]);
      }
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        result[i] = evenIndices.poll();
      } else {
        result[i] = oddIndices.poll();
      }
    }
    return result;
  }
}
