class Solution {
    public int longestSubstring(String s, int k) {
        char[] letters = s.toCharArray();
        int[] frequency = new int[26];
        int uniqueCount = getUniqueCount(s);
        int result = 0;
        for (int curr = 1; curr <= uniqueCount; curr++) {
            Arrays.fill(frequency, 0);
            int start = 0;
            int end = 0;
            int idx = 0;
            int unique = 0;
            int countWithK = 0;
            while (end < letters.length) {
                if (unique <= curr) {
                    idx = letters[end] - 'a';
                    if (frequency[idx] == 0) {
                        unique++;
                    }
                    frequency[idx]++;
                    if (frequency[idx] == k) {
                        countWithK++;
                    }
                    end++;
                } else {
                    idx = letters[start] - 'a';
                    if (frequency[idx] == k) {
                        countWithK--;
                    }
                    frequency[idx]--;
                    if (frequency[idx] == 0) {
                        unique--;
                    }
                    start++;
                }
                if (unique == curr && unique == countWithK) {
                    result = Math.max(end - start, result);
                }
            }
        }
        return result;
    }

    private int getUniqueCount(String s) {
        boolean[] present = new boolean[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!present[c - 'a']) {
                count++;
            }
            present[c - 'a'] = true;
        }
        return count;
    }
}
