class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }
        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!visited.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && lastIndexMap.get(stack.peek()) > i) {
                    visited.remove(stack.pop());
                }
                visited.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
