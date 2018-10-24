class Solution {
    public List<List<String>> partition(String a) {
        List<List<String>> ans = new ArrayList<>();
        helper(ans, new ArrayList<String>(), a, 0);
        return ans;
    }
 
    private void helper(List<List<String>> ans, List<String> temp, String a, int idx) {
        if (idx == a.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=idx; i<a.length(); i++) {
            String sb = a.substring(idx, i+1);
 
            if (isPalindrome(sb)) {
                temp.add(sb);
                helper(ans, temp, a, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
 
    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
