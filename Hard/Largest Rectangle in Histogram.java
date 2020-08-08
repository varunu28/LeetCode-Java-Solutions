class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    stack.push(-1);
    for (int i = 0; i < heights.length; i++) {
      while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
        maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
      }
      stack.push(i);
    }
    while (stack.peek() != -1) {
      maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
    }
    return maxArea;
  }
}
