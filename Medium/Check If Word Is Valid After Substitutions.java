class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.size() >= 2) {
                char first = stack.pop();
                char second = stack.pop();
                if (!(first == 'b' && second == 'a' && c == 'c')) {
                    stack.push(second);
                    stack.push(first);
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
