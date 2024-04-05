class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isBad(c, stack.peek())) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static boolean isBad(char c1, char c2) {
        if (c1 == c2) {
            return false;
        }
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }
}
