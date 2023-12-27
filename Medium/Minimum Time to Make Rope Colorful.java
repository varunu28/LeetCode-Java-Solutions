class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Integer> stack = new Stack<>();
        int cost = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (stack.isEmpty() || colors.charAt(i) != colors.charAt(stack.peek())) {
                stack.push(i);
                continue;
            }
            if (neededTime[i] > neededTime[stack.peek()]) {
                cost += neededTime[stack.pop()];
                stack.push(i);
            } else {
                cost += neededTime[i]; 
            }
        }
        return cost;
    }
}
