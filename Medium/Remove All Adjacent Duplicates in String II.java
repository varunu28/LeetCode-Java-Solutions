class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<CharPair> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                if (stack.peek().count == k - 1) {
                    stack.pop();
                } else {
                    stack.peek().count++;
                }
            } else {
                stack.push(new CharPair(c));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (CharPair cPair : stack) {
            int count = cPair.count;
            while (count-- > 0) {
                sb.append(cPair.c);
            }
        }
        return sb.toString();
    }

    private class CharPair {
        char c;
        int count;
        
        public CharPair(char c) {
            this.c = c;
            this.count = 1;
        }
    }
}
