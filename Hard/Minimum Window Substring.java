class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int targetSize = map.size();
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = -1;
        int minEnd = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    targetSize--;
                }
            }
            while (start <= i && targetSize == 0) {
                int currLength = i - start;
                if (minLength > currLength) {
                    minLength = currLength;
                    minStart = start;
                    minEnd = i + 1;
                }   
                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if (map.get(s.charAt(start)) == 1) {
                        targetSize++;
                    }
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd);
    }
}
