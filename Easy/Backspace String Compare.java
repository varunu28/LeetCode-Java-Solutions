class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildBackspaceString(s).equals(buildBackspaceString(t));
    }

    private static String buildBackspaceString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
