class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            end++;
            while (start < end && map.size() > 2) {
                map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
