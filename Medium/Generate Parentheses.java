class Solution { 
    public List<String> generateParenthesis(int A) {
        Set<String> set = new HashSet<>();
        helper(0, 0, A, new StringBuilder(), set);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private void helper(int left, int right, int n, StringBuilder sb, Set<String> set) {
        if (left > n || right > n) {
            return;
        }
        if (left < right) {
            return;
        }

        if (left == right && left == n) {
            set.add(sb.toString());
        }

        helper(left+1, right, n, sb.append("("), set);
        sb.deleteCharAt(sb.length()-1);
        helper(left, right+1, n, sb.append(")"), set);
        sb.deleteCharAt(sb.length()-1);
    }
}
