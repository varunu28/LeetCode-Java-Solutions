class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> currentList,
                           String s, int idx) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                currentList.add(s.substring(idx, i + 1));
                backtrack(result, currentList, s, i + 1);
                currentList.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            if (s.charAt(startIdx++) != s.charAt(endIdx--)) {
                return false;
            }
        }
        return true;
    }
}
