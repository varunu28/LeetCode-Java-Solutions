class Solution {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int n = A.length;

        for (int i=0; i<n; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.add(i);
            }
        }

        for (int i=n-1; i>=ans; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }

        return ans;
    }
}
