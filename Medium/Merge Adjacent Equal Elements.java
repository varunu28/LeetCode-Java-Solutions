class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stack = new Stack<>();
        for (int num : nums) {
            long curr = num;
            while (!stack.isEmpty() && stack.peek() == curr) {
                curr += stack.pop();
            }
            stack.push(curr);
        }
        List<Long> result = new ArrayList<>();
        for (Long num : stack) {
            result.add(num);
        }
        return result;
    }
}
