class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> result = new ArrayList<>();
        int n = s1.length();
        int idx = 0;
        while (idx < n) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
                continue;
            }
            int startIdx = idx;
            while (idx < n && s1.charAt(idx) != s2.charAt(idx)) {
                idx++;
            }
            result.add(List.of(s1.substring(startIdx, idx), s2.substring(startIdx, idx)));
        }
        return result;
    }
}
