class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int idx = 0;
        while (idx < s.length()) {
            int startIdx = idx;
            char c = s.charAt(idx);
            while (idx < s.length() && s.charAt(idx) == c) {
                idx++;
            }
            if (idx - startIdx >= 3) {
                result.add(Arrays.asList(startIdx, idx - 1));
            }
        }
        return result;
    }
}
