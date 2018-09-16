class Solution {
    public static int sumSubarrayMins(int[] A) {
        Stack<List<Integer>> stack = new Stack<>();
        int n = A.length;
        int tempSum = 0;
        int mod = 1000000007;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if((!stack.empty()) && A[i] >= stack.peek().get(0)) {
                tempSum += A[i];
                stack.push(Arrays.asList(A[i], 1));
            }
            else {
                int count = 1;

                while((!stack.empty()) && stack.peek().get(0) > A[i]) {
                    count += stack.peek().get(1);
                    tempSum -= stack.peek().get(1) * stack.peek().get(0);
                    stack.pop();
                }

                stack.push(Arrays.asList(A[i], count));
                tempSum += count * A[i];
            }

            ans = (ans + tempSum)%mod;
        }

        return ans;
    }
}
