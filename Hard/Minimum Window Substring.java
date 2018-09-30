class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, (map.getOrDefault(c, 0) + 1));
        }

        int start = 0;
        int end = 0;
        int count = map.size();
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                if (map.get(s.charAt(end)) == 0) {
                    count--;
                }
            }

            end++;

            while (count == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    ans = s.substring(start, end);
                }

                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if (map.get(s.charAt(start)) > 0) {
                        count++;
                    }
                }

                start++;
            }
        }

        return ans;
    }
}
