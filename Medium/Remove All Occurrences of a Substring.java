class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int partLength = part.length();
        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= partLength && check(stack, part, partLength)) {
                for (int j = 0; j < partLength; j++) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private boolean check(Stack<Character> stack, String part, int partLength) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);
        for (int i = partLength - 1; i >= 0; i--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(i)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}
