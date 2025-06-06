class Solution {
    public String robotWithString(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack.push(c);
            counter[c - 'a']--;
            while (!stack.isEmpty() && isSmallest(stack.peek(), counter)) {
                sb.append(stack.pop());
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private boolean isSmallest(char c, int[] counter) {
        int limit = c - 'a';
        for (int i = 0; i < limit; i++) {
            if (counter[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
