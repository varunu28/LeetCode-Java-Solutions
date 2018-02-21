class Solution {
    public int lengthLongestPath(String s) {
        int max = 0, count = 0, level = 1;
        boolean isFile = false;
        Map<Integer, Integer> map = new HashMap<>();

        int length = s.length();
        int i = 0;
        while (i < length) {
            while (s.charAt(i) == '\t') {
                ++level;
                ++i;
            }

            while (i < length && s.charAt(i) != '\n') {
                if (s.charAt(i) == '.') {
                    isFile = true;
                }

                ++count;
                ++i;
            }

            if (isFile) {
                max = Math.max(max, map.getOrDefault(level-1, 0) + count);
            }
            else {
                map.put(level, map.getOrDefault(level-1, 0) + count + 1);
            }

            count = 0;
            level = 1;
            isFile = false;

            ++i;
        }

        return max;
    }
}
