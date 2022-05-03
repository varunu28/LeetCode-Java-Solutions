class Solution {
  public int findUnsortedSubarray(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int start = nums.length;
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        start = Math.min(start, stack.pop());
      }
      stack.push(i);
    }
    stack.clear();
    int end = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        end = Math.max(end, stack.pop());
      }
      stack.push(i);
    }
    return end - start > 0 ? end - start + 1 : 0;
  }
}
