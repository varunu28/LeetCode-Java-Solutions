class Solution {
  public boolean find132pattern(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    int[] minTillIndex = new int[nums.length];
    minTillIndex[0] = nums[0];
    for (int idx = 1; idx < nums.length; idx++) {
      minTillIndex[idx] = Math.min(minTillIndex[idx - 1], nums[idx]);
    }
    Stack<Integer> stack = new Stack<>();
    for (int idx = nums.length - 1; idx >= 0; idx--) {
      if (nums[idx] > minTillIndex[idx]) {
        while (!stack.isEmpty() && stack.peek() <= minTillIndex[idx]) {
          stack.pop();
        }
        if (!stack.isEmpty() && stack.peek() < nums[idx]) {
          return true;
        }
        stack.push(nums[idx]);
      }
    }
    return false;
  }
}
