class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int n = s.length();
        int result = 0;
        while (end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            while (start <= end && map.get(s.charAt(end)) > 2) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            end++;
            result = Math.max(result, end - start);
        }
        return result;
    }
}
