class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (word.length() < k) {
                continue;
            }
            String prefix = word.substring(0, k);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                count++;
            }
        }
        return count;
    }
}
