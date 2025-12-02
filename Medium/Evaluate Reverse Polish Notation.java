class Solution {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> VALID_OPERATIONS = Map.of(
            "+", Integer::sum,
            "-", (a, b) -> b - a,
            "*", (a, b) -> b * a,
            "/", (a, b) -> b / a
    );

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (VALID_OPERATIONS.containsKey(token)) {
                stack.push(VALID_OPERATIONS.get(token).apply(stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
