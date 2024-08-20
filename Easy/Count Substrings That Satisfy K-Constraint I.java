class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int n = s.length();
        int result = 0;
        while (end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            end++;
            while (start < end && map.getOrDefault('0', 0) > k && map.getOrDefault('1', 0) > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            if (map.getOrDefault('0', 0) <= k || map.getOrDefault('1', 0) <= k) {
                result += end - start;
            }
        }
        return result;
    }
}
