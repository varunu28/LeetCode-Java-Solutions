class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        return backtrack(s, 0, seen);
    }

    private int backtrack(String s, int idx, Set<String> seen) {
        if (idx == s.length()) {
            return 0;
        }
        int count = 0;
        for (int end = idx + 1; end <= s.length(); end++) {
            String substring = s.substring(idx, end);
            if (seen.add(substring)) {
                count = Math.max(count, 1 + backtrack(s, end, seen));
                seen.remove(substring);
            }
        }
        return count;
    }
}
