class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> charToLastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charToLastIndex.put(s.charAt(i), i);
        }
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                while (!stack.isEmpty() && 
                       c < stack.peek() && 
                       charToLastIndex.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                set.add(c);
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
