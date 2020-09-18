class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int[] ans = new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
        stack.pop();
      }
      ans[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
      stack.push(i);
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      if (ans[i] == -1) {
        while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
          stack.pop();
        }
        ans[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
      }
      stack.push(i);
    }
    return ans;
  }
}
