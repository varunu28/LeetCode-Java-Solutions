class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            if (word.length() < k) {
                continue;
            }
            String prefix = word.substring(0, k);
            map.computeIfAbsent(prefix, _ -> new ArrayList<>()).add(word);
        }
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                count++;
            }
        }
        return count;
    }
}
