class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            while (start < end && map.get(s.charAt(end)) > 1) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            end++;
            result += end - start;
        }
        return result;
    }
}
