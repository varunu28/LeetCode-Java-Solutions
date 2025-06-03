class Solution {
    public String resultingString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isAdjacent(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    private static boolean isAdjacent(char first, char second) {
        return Math.abs(first - second) == 1 || (first == 'a' && second == 'z') || (first == 'z' && second == 'a');
    }
}
