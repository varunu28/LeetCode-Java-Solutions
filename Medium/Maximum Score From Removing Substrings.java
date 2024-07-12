class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        String firstPass = removeSubstring(s, x > y ? "ab" : "ba");
        int removeCount = (s.length() - firstPass.length()) / 2;
        score += removeCount * Math.max(x, y);
        String secondPass = removeSubstring(firstPass, x > y ? "ba" : "ab");
        removeCount = (firstPass.length() - secondPass.length()) / 2;
        score += removeCount * Math.min(x, y);
        return score;
    }

    private String removeSubstring(String s, String target) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == target.charAt(1) && !stack.isEmpty() && stack.peek() == target.charAt(0)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
