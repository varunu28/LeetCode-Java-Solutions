class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int[] minRemoved = {Integer.MAX_VALUE};
        backtrack(s, 0, 0, 0, new StringBuilder(), 0, minRemoved, result);
        return new ArrayList<>(result);
    }

    private void backtrack(
        String s, 
        int idx, 
        int leftCount,
        int rightCount, 
        StringBuilder sb, 
        int removedCount, 
        int[] minRemoved,
        Set<String> result) {
        if (idx == s.length()) {
            if (leftCount == rightCount) {
                if (removedCount <= minRemoved[0]) {
                    String currResult = sb.toString();
                    if (removedCount < minRemoved[0]) {
                        result.clear();
                        minRemoved[0] = removedCount;
                    }
                    result.add(currResult);
                }
            }
            return;
        } 
        char c = s.charAt(idx);
        if (c != '(' && c != ')') {
            sb.append(c);
            backtrack(s, idx + 1, leftCount, rightCount, sb, removedCount, minRemoved, result);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            backtrack(s, idx + 1, leftCount, rightCount, sb, removedCount + 1, minRemoved, result);
            sb.append(c);
            if (c == '(') {
                backtrack(s, idx + 1, leftCount + 1, rightCount, sb, removedCount, minRemoved, result);
            } else if (rightCount < leftCount) {
                backtrack(s, idx + 1, leftCount, rightCount + 1, sb, removedCount, minRemoved, result);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
