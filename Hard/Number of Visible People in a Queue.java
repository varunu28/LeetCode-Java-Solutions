class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }
            result[i] = count + (stack.isEmpty() ? 0 : 1);
            stack.push(heights[i]);
        }
        return result;
    }
}
