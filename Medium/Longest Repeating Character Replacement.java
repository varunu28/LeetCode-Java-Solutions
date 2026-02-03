class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        int maxLength = 0;
        for (Character c : set) {
            int start = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                }
                while (!isValid(start, i, count, k)) {
                    if (s.charAt(start) == c) {
                        count--;
                    }
                    start++;
                }
                maxLength = Math.max(maxLength, i + 1 - start);
            }
        }
        return maxLength;
    }

    // Valid scenario will be when we have replaced less than or equal to k characters in our window
    private boolean isValid(int start, int end, int count, int k) {
        int windowSize = end - start + 1;
        return windowSize - count <= k;
    }
}
