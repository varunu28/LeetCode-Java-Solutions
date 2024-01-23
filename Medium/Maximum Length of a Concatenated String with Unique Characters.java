class Solution {
    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, new HashMap<>());
    }

    private int backtrack(List<String> arr, int idx, Map<Character, Integer> map) {
        if (map.values().stream().anyMatch(val -> val > 1)) {
            return 0;
        }
        int result = map.size();
        for (int i = idx; i < arr.size(); i++) {
            char[] chars = arr.get(i).toCharArray();
            for (char c : chars) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            result = Math.max(result, backtrack(arr, i + 1, map));
            for (char c : chars) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return result;
    }
}
