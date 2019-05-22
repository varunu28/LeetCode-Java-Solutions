class Solution {
    public int trap(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxWater = 0;
        
        while (i < A.length){
            if (stack.isEmpty() || A[i] <= A[stack.peek()]){
                stack.push(i++);
            }
            else {
                int bot = stack.pop();
                maxWater += stack.isEmpty() ? 0 :
                    (Math.min(A[stack.peek()], A[i]) - A[bot]) * (i - stack.peek() - 1);
            }
        }
        
        return maxWater;
    }
}
