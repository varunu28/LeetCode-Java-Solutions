class Solution {
    Set<String> set;
    public List<String> generateParenthesis(int n) {
        set = new HashSet<>();
        helper(0, 0, new StringBuilder(), n);
        return new ArrayList<>(set);
    }
    
    private void helper(int left, int right, StringBuilder sb, int n) {
        if (left > n || right > n || left < right) {
            return;
        }
        
        if (left == right && left == n) {
            set.add(sb.toString());
        }
        
        helper(left + 1, right, sb.append('('), n);
        sb.deleteCharAt(sb.length() - 1);
        helper(left, right + 1, sb.append(')'), n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
