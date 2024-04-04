class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == ')') {
                count += c == '(' ? 1 : -1;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
