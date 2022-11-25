class Solution {
    
    private final static int MOD = 1000_000_007;
    
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        for (int i = 0; i <= arr.length; i++) {
            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
                int minValue = stack.pop();
                int countOnLeft = stack.empty() ? -1 : stack.peek();
                int countOnRight = i;
                long totalCount = (minValue - countOnLeft) * (countOnRight - minValue) % MOD;
                sum = (sum + (totalCount * arr[minValue])) % MOD;
            }
            stack.push(i);
        }
        return (int) (sum);
    }
}
