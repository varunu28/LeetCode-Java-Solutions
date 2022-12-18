class Solution {
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int pairCount = 0;
        for (String word : words) {
            String key = buildSortedCharString(word);
            pairCount += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return pairCount;
    }
    
    private static String buildSortedCharString(String s) {
        boolean[] exists = new boolean[26];
        for (char c : s.toCharArray()) {
            exists[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (exists[i]) {
                sb.append((char) (97 + i));
            }
        }
        return sb.toString();
    }
}
