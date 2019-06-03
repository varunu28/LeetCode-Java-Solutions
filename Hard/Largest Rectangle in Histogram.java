class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1)));
            }    
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1)));
        }
        
        return maxArea;
    }
}
