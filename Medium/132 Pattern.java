class Solution {
  public boolean find132pattern(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    Stack<Integer> stack = new Stack<>();
    int[] min = new int[nums.length];
    min[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      min[i] = Math.min(min[i - 1], nums[i]);
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > min[i]) {  // Consider nums[i] as 3 and min[i] as 1
        while (!stack.isEmpty() && stack.peek() <= min[i]) {  // Search for 2  
          stack.pop();
        }
        if (!stack.isEmpty() && stack.peek() < nums[i]) {  // If 2 found
          return true;
        }
        stack.push(nums[i]);
      }
    }
    return false;
  }
}
